package org.xwc.frameworkdemo.Utils;

import android.content.Context;
import android.net.ConnectivityManager;

import org.xwc.frameworkdemo.App.App;

/**
 * 系统工具类
 * Created by xuwc on 2016/11/24.
 */
public class SystemUtil {


    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }

}
