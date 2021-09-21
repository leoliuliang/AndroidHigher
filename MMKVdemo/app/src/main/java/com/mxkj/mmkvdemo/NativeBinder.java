package com.mxkj.mmkvdemo;

public class NativeBinder {
    static {
        System.loadLibrary("native-lib");
    }
    public native void write();

    public native void readTest();
}
