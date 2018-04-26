package org.xwc.frameworkdemo.UI.Gank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.xwc.frameworkdemo.Base.BaseRecyclerAdapter;
import org.xwc.frameworkdemo.Model.bean.GankItemBean;
import org.xwc.frameworkdemo.R;
import org.xwc.frameworkdemo.Utils.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xuwc on 2016/12/6.
 */
public class GirlAdapter extends BaseRecyclerAdapter<GankItemBean> {


    public GirlAdapter(Context context) {
        super(context, ONLY_FOOTER);
    }
    /**
     * 在StaggeredGridLayoutManager瀑布流中,当需要依据图片实际相对高度,不断动态设置ImageView的LayoutParams时,
     * 会导致快速滑动状态下产生重新排列,重写getItemViewType并设置StaggeredGridLayoutManager.GAP_HANDLING_NONE解决了这个问题，原因目前未知
     * https://github.com/oxoooo/mr-mantou-android/blob/master/app/src/main/java/ooo/oxo/mr/MainAdapter.java
     * @param
     * @return
     */
//    @Override
//    public int getItemViewType(int position) {
//        return Math.round((float) App.SCREEN_WIDTH / (float) getItems().get(position).getHeight() * 10f);
//    }


    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_girl, parent, false));
    }

    @Override
    protected void onBindDefaultViewHolder(RecyclerView.ViewHolder holder, GankItemBean item, int position) {
        ViewHolder h = (ViewHolder)holder;

        ImageLoader.loadImage(mContext,h.ivGirl,item.getUrl());

//        //存在记录的高度时先Layout再异步加载图片
//        if (getItems().get(h.getAdapterPosition()).getHeight() > 0) {
//            ViewGroup.LayoutParams layoutParams = h.ivGirl.getLayoutParams();
//            layoutParams.height = getItems().get(h.getAdapterPosition()).getHeight();
//        }
//
//        Glide.with(mContext).load(getItems().get(position).getUrl()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(new SimpleTarget<Bitmap>(App.SCREEN_WIDTH / 2, App.SCREEN_WIDTH / 2) {
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                        if(h.getAdapterPosition() != RecyclerView.NO_POSITION) {
//                            if (getItems().get(h.getAdapterPosition()).getHeight() <= 0) {
//                                int width = resource.getWidth();
//                                int height = resource.getHeight();
//                                int realHeight = (App.SCREEN_WIDTH / 2) * height / width;
//                                getItems().get(h.getAdapterPosition()).setHeight(realHeight);
//                                ViewGroup.LayoutParams lp = h.ivGirl.getLayoutParams();
//                                lp.height = realHeight;
//                            }
//                            h.ivGirl.setImageBitmap(resource);
//                        }
//                    }
//                });
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_girl)
        ImageView ivGirl;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}
