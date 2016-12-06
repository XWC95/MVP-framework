package org.xwc.frameworkdemo.UI.Home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.xwc.frameworkdemo.Base.BaseRecyclerAdapter;
import org.xwc.frameworkdemo.Model.bean.WxItemBean;
import org.xwc.frameworkdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xuwc on 2016/11/25.
 */
public class Aadapter  extends BaseRecyclerAdapter<WxItemBean> {


    public Aadapter(Context context) {
        super(context,ONLY_FOOTER);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_wechat, parent, false));
    }

    @Override
    protected void onBindDefaultViewHolder(RecyclerView.ViewHolder holder, WxItemBean item, int position) {

        ViewHolder h = (ViewHolder)holder;
        Glide.with(mContext)
                .load(item.getPicUrl())
                .asBitmap()
                .into(h.ivImage);
        h.tvTitle.setText(item.getTitle());
        h.tvFrom.setText(item.getDescription());
        h.tvTime.setText(item.getCtime());
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_wechat_item_title)
        TextView tvTitle;
        @BindView(R.id.tv_wechat_item_time)
        TextView tvTime;
        @BindView(R.id.tv_wechat_item_from)
        TextView tvFrom;
        @BindView(R.id.iv_wechat_item_image)
        ImageView ivImage;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
