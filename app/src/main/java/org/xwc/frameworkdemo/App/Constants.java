package org.xwc.frameworkdemo.App;

import java.io.File;

/**
 * Created by xuwc on 2016/11/24.
 */
public class Constants {

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final int NUM_OF_PAGE = 20;


    //================= KEY ==================== //

    public static final String KEY_API = "56706566e1c318d932fd755e80d6776a";

    //TechFragment budle 传值key
    public static final String KEY_BUNDLE_TECH_FRAGMENT = "tech";

}
