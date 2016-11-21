package org.xwc.frameworkdemo.MVP.Entity;

import org.xwc.frameworkdemo.MVP.Home.A;
import org.xwc.frameworkdemo.MVP.Home.B;
import org.xwc.frameworkdemo.MVP.Home.C;
import org.xwc.frameworkdemo.MVP.Home.D;
import org.xwc.frameworkdemo.R;

public enum MainTabs {

    LIVE(0, R.string.A, R.drawable.a,
            A.class),

    RES(1, R.string.B, R.drawable.a,
            B.class),

    LEARN(2, R.string.C, R.drawable.a,
            C.class),

    ME(3, R.string.D, R.drawable.a,
        D.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;

     MainTabs(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}