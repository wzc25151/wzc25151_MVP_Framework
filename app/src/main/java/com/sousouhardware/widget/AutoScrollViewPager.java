package com.sousouhardware.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.sousouhardware.R;
import com.sousouhardware.base.MyApplication;
import com.sousouhardware.bean.HomeRefreshBean;
import com.sousouhardware.config.ApiConfig;
import com.sousouhardware.util.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class AutoScrollViewPager extends ViewPager {
    private Context context;
    private RelativeLayout indicator;
    private ArrayList<ImageView> ringList;
    private List<ImageView> imgList;

    //    间隔时间，默认间隔4.5s
    private long INTERVAL_TIME = 4000L;
    private int pageCount;
    private boolean isAuto;
    private boolean isDragging;
    private Message mMsg;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (!isDragging) {
                        autoScroll();
                    }
                    if (isAuto) {
                        mMsg = new Message();
                        mMsg.what = 0;
                        sendMessageDelayed(mMsg, INTERVAL_TIME);
                    }
                    break;
                default:
                    break;
            }
        }
    };

    public AutoScrollViewPager(Context context) {
        super(context);
    }

    public AutoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        addOnPageChangeListener(myPageChangeListener);
    }


    /**
     * @param _imgList
     * @param bannerBeanList 有值表示首页轮播图
     * @param indicator      传null表示没有不显示指示器
     */
    public void setupData(List<ImageView> _imgList, List<HomeRefreshBean.SlideadsBean> bannerBeanList, RelativeLayout indicator) {
        this.context = getContext();
        this.indicator = indicator;
        if (_imgList == null) {
            imgList = new ArrayList<ImageView>();
            for (HomeRefreshBean.SlideadsBean bean : bannerBeanList) {
                ImageView iv = new ImageView(context);
                Glide.with(context).load(ApiConfig.BASE_URL_ + bean.getImageUrl()).centerCrop().into(iv);
                imgList.add(iv);
            }
        } else {
            this.imgList = _imgList;
        }
        this.pageCount = imgList.size();
        setAdapter(new AutoScrollViewPagerAdapter(imgList, bannerBeanList));
        if (indicator != null) {
            initIndicatorBar();
        }
        if (pageCount > 1) {
            setCurrentItem(400, false);
            setAutoScroll(true);
        }
    }

    private void initIndicatorBar() {
        ringList = new ArrayList<ImageView>();
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        LinearLayout ll = new LinearLayout(context);
        ll.setLayoutParams(lp);
        indicator.addView(ll);
        LinearLayout.LayoutParams lpp = new LinearLayout.LayoutParams(DisplayUtil.dp2px(getContext(), 7), DisplayUtil.dp2px(getContext(), 7));
        for (int i = 0; i < pageCount; i++) {
            ImageView iv = new ImageView(context);
            iv.setLayoutParams(lpp);
            Glide.with(context).load(R.drawable.ring_imageview_default).into(iv);
//            iv.setBackgroundResource(R.drawable.ring_imageview_default);
            if (i > 0) {
                lpp.leftMargin = DisplayUtil.dp2px(getContext(), 3);
            }
            ringList.add(iv);
            ll.addView(iv);
        }
    }


    public void setAutoScroll(boolean isAuto) {
        this.isAuto = isAuto;
        if (isAuto) {
            mMsg = new Message();
            mMsg.what = 0;
            mHandler.sendMessageDelayed(mMsg, INTERVAL_TIME);
        }
    }

    private void autoScroll() {
        int count = getAdapter().getCount();
        int cur = getCurrentItem();
        if (count < 2) {
            isAuto = false;
            return;
        }
        if (cur < count - 1) {
            setCurrentItem(++cur);
            return;
        }
        if (cur == count) {
            setCurrentItem(getAdapter().getCount() / 2);
        }
    }

    private OnPageChangeListener myPageChangeListener = new OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            int cur = position % pageCount;
            for (ImageView iv : ringList) {
                if (iv.equals(ringList.get(cur))) {
                    iv.setBackgroundResource(R.drawable.ring_imageview_select);
                } else {
                    iv.setBackgroundResource(R.drawable.ring_imageview_default);
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_IDLE) {
                isDragging = false;
            } else {
                isDragging = true;
            }
        }
    };

    private class AutoScrollViewPagerAdapter extends PagerAdapter {
        private List<ImageView> imgList;
        private List<HomeRefreshBean.SlideadsBean> bannerBeanList;

        public AutoScrollViewPagerAdapter(List<ImageView> imgList, List<HomeRefreshBean.SlideadsBean> bannerBeanList) {
            this.imgList = imgList;
            this.bannerBeanList = bannerBeanList;
        }

        @Override
        public int getCount() {
            if (imgList.size() == 1) {
                return 1;
            }
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            position = position % bannerMap.size() == 0 ? bannerMap.size() - 1 : position % bannerMap.size() - 1;
            position %= imgList.size();
            ImageView iv = imgList.get(position);
            ViewParent vp = iv.getParent();
            if (vp != null) {
                ViewGroup parent = (ViewGroup) vp;
                parent.removeView(iv);
            }
            if (bannerBeanList != null) {
                iv.setOnClickListener(new MyOnClickListener(bannerBeanList.get(position)));
            }
            container.addView(iv);
            return iv;
        }
    }

    private class MyOnClickListener implements OnClickListener {
        HomeRefreshBean.SlideadsBean bean;

        public MyOnClickListener(HomeRefreshBean.SlideadsBean bean) {
            this.bean = bean;
        }

        @Override
        public void onClick(View view) {
            MyApplication.showToast("id:" + bean.getId());
        }
    }
}

