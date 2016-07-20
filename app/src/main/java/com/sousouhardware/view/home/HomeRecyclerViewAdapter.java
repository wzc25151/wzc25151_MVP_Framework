package com.sousouhardware.view.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sousouhardware.R;
import com.sousouhardware.base.MyApplication;
import com.sousouhardware.bean.HomeRefreshBean;
import com.sousouhardware.config.ApiConfig;

import java.util.List;

/**
 * Created by wangxiangbo on 2016/7/16.
 */
public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<HomeRefreshBean.ShopsBean.RowsBean> popStoreList;
    private List<HomeRefreshBean.BrandBean> popBrandList;
    private List<HomeRefreshBean.MessageBean.RowsBean> discountSaleList;
    private List<HomeRefreshBean.ProTypeBean.RowsBean> hotProductList;
    private List unDeCodeList;

    public HomeRecyclerViewAdapter(Context context, List list) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.unDeCodeList = list;
        deCodeList(list);
    }

    private void deCodeList(List list) {
        if (list != null && list.size() > 0) {
            Object obj = list.get(0);
            if (obj instanceof HomeRefreshBean.ShopsBean.RowsBean) {
                popStoreList = list;
            } else if (obj instanceof HomeRefreshBean.BrandBean) {
                popBrandList = list;
            } else if (obj instanceof HomeRefreshBean.MessageBean.RowsBean) {
                discountSaleList = list;
            } else if (obj instanceof HomeRefreshBean.ProTypeBean.RowsBean) {
                hotProductList = list;
            }
        }
    }

    /**
     *
     * 为了适配低版本文字排版
     * @param s
     * @return
     */
    private String fixString(String s){
        if (!TextUtils.isEmpty(s)){
            int i = s.length();
            if (i>7){
                return s.substring(0,6)+"...";
            }
        }
        return s;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }

        View rootView;
        ImageView iv;
        TextView tv;
    }

    @Override
    public int getItemCount() {
        return unDeCodeList.size();
    }

    @Override
    public HomeRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;
        View view = null;
        if (popStoreList != null || popBrandList != null) {
            view = inflater.inflate(R.layout.rv_item_home_1, parent, false);
        } else {
            view = inflater.inflate(R.layout.rv_item_home_2, parent, false);
        }
        viewHolder = new ViewHolder(view);
        viewHolder.rootView = (LinearLayout) view.findViewById(R.id.item_home_rv_gv_root);
        viewHolder.iv = (ImageView) view.findViewById(R.id.item_home_rv_gv_image);
        viewHolder.tv = (TextView) view.findViewById(R.id.item_home_rv_gv_text);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final HomeRecyclerViewAdapter.ViewHolder holder, final int position) {
        if (popStoreList != null && position < popStoreList.size()) {
            Glide.with(context).load(ApiConfig.BASE_URL + popStoreList.get(position).getLogo()).into(holder.iv);
            holder.tv.setText(popStoreList.get(position).getShopName().trim());
        } else if (popBrandList != null && position < popBrandList.size()) {
            Glide.with(context).load(ApiConfig.BASE_URL + popBrandList.get(position).getLogo()).into(holder.iv);
            holder.tv.setText(popBrandList.get(position).getValue().trim());
        } else if (discountSaleList != null && position < discountSaleList.size()) {
            Glide.with(context).load(ApiConfig.BASE_URL + discountSaleList.get(position).getImgUrl()).into(holder.iv);
           holder.tv.setText(fixString(discountSaleList.get(position).getProductName().trim()));
        } else if (hotProductList != null && position < hotProductList.size()) {
            Glide.with(context).load(ApiConfig.BASE_URL + hotProductList.get(position).getImgUrl()).into(holder.iv);
            holder.tv.setText(fixString(hotProductList.get(position).getProductName().trim()));
        } else {
        }
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.showToast(""+holder.tv.getText());
            }
        });
    }

}
