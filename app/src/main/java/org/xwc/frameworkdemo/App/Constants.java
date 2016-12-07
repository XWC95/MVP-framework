package org.xwc.frameworkdemo.App;

import java.io.File;

/**
 * Created by xuwc on 2016/11/24.
 */
public class Constants {

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final int NUM_OF_PAGE = 20;

    //================= TYPE ====================
    public static final int TYPE_A = 101;
    public static final int TYPE_B = 102;
    public static final int TYPE_C = 103;

    //================= KEY ==================== //

    public static final String KEY_API = "f95283476506aa756559dd28a56f0c0b"; //需要APIKEY请去 http://apistore.baidu.com/ 申请,复用会减少访问可用次数

    //TechFragment budle 传值key
    public static final String KEY_BUNDLE_TECH_FRAGMENT = "tech";

}
