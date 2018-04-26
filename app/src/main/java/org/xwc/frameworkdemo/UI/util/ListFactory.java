package org.xwc.frameworkdemo.UI.util;

import org.xwc.frameworkdemo.Base.BaseRecyclerAdapter;
import org.xwc.frameworkdemo.Widget.RecyclerRefreshLayout;

/**
 * Created by xwc on 2018/4/18.
 */

public class ListFactory<T> {


    public IBaseShowItemList<T> createShowItemList(BaseRecyclerAdapter<T> adapter, RecyclerRefreshLayout refresh) {
        return new ShowItemList<T>(adapter, refresh);
    }
}
