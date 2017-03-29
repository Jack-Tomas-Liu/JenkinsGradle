package com.sj.ndk;

/**
 * Created by liuxinxian on 2017/3/29.
 */

public class SoWrapper {
    static {
        System.loadLibrary("demo");
    }

    public native void printf();

    public native String getString();
}
