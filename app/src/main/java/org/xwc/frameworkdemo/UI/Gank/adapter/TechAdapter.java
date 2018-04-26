package org.xwc.frameworkdemo.UI.Gank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.xwc.frameworkdemo.Base.BaseRecyclerAdapter;
import org.xwc.frameworkdemo.R;
import org.xwc.frameworkdemo.Utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xuwc on 2016/11/30.
 */
public class TechAdapter extends BaseRecyclerAdapter<org.xwc.frameworkdemo.Model.bean.GankItemBean>{

    public TechAdapter(Context context ) {
        super(context, ONLY_FOOTER);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_tech, parent, false));

    }

    @Override
    protected void onBindDefaultViewHolder(RecyclerView.ViewHolder holder, org.xwc.frameworkdemo.Model.bean.GankItemBean item, int position) {

        ViewHolder h = (ViewHolder)holder;
        h.tvContent.setText(item.getDesc());
        h.tvAuthor.setText(item.getWho());
        String date =item.getPublishedAt();
        int idx = date.indexOf(".");
        date = date.substring(0,idx).replace("T"," ");
        h.tvTime.setText(StringUtils.formatDateTime(date,true));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_tech_title)
        TextView tvContent;
        @BindView(R.id.tv_tech_author)
        TextView tvAuthor;
        @BindView(R.id.tv_tech_time)
        TextView tvTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
