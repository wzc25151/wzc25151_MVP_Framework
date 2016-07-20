package com.sousouhardware.view.stack;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;

import com.sousouhardware.R;
import com.sousouhardware.base.BaseActivity;
import com.sousouhardware.base.BaseFragment;
import com.sousouhardware.base.ObjViewManager;
import com.sousouhardware.config.Constants;
import com.sousouhardware.event.MsgEvent;
import com.sousouhardware.view.home.HomeView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * 用来显示那些停留时间较短的fragment页面
 * Created by wangxiangbo on 2016/7/18.
 */
public class StackActivity extends BaseActivity {
    private ArrayList<BaseFragment> stack = new ArrayList<BaseFragment>();
    private BaseFragment fg;
    private FragmentTransaction fgt;

    @Override
    protected void init() {
        setContentView(R.layout.act_stack);

    }

    @Override
    protected void initLayout() {
        showView(getIntent());
    }

    public void showView(Intent intent) {
        fgt = getSupportFragmentManager().beginTransaction();
        fgt.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        if (fg != null && stack.size() > 0) {
            fgt.remove(fg);
        }
        String className = intent.getStringExtra(Constants.INTENT_EXTRA_VIEW_CLASSNAME);
        fg = ObjViewManager.setupContract(className);
        fgt.add(R.id.stack_fg, fg);
        fgt.commit();
        fixStack(fg);
    }

    private void fixStack(BaseFragment fg){
        if (!stack.contains(fg)){
            stack.add(fg);
        }else if(stack.indexOf(fg)<stack.size()-1){
            for(int i= stack.size()-1;i>stack.indexOf(fg);i--){
                stack.remove(i);
            }
        }
    }

    private void backStack() {
        fgt = getSupportFragmentManager().beginTransaction();
        fgt.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        if (fg != null && stack.size() > 0) {
            fgt.remove(fg);
            fg.onClear();
            stack.remove(stack.get(stack.size() - 1));
        }
        fg = stack.get(stack.size() - 1);
        fgt.add(R.id.stack_fg, fg);
        fgt.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (stack.size() >= 2) {
                backStack();
                return true;
            } else if (fg instanceof HomeView) {
                EventBus.getDefault().post(new MsgEvent(MsgEvent.MSG_LOGOUT,""));
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
