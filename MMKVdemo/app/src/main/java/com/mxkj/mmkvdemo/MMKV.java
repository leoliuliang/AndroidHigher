package com.mxkj.mmkvdemo;

import android.content.Context;
import android.os.Environment;

public class MMKV {
    static {
        System.loadLibrary("native-lib");
    }

//    java层  没有用， 时不时的传给底层
    private long nativeHandle;

    private MMKV(long handle) {
        nativeHandle = handle;
    }

    static private String rootDir = null;

    public static String initialize(Context context) {
        String root = Environment.getExternalStorageDirectory() + "/mmkv";
//        初始化 mmkv框架
        return initialize(root);
    }

    public static String initialize(String rootDir) {
        MMKV.rootDir = rootDir;
//        mmkv   C++层   初始化了文件夹 并没有做什么
        jniInitialize(MMKV.rootDir);
        return rootDir;
    }

// 实例化    物理产生映射
    public static MMKV defaultMMKV() {
//java  long地址
        long handle = getDefaultMMKV();
        return new MMKV(handle);
    }


    public void putInt(String key, int value) {
        putInt(nativeHandle, key, value);
    }

    private static native void jniInitialize(String rootDir);

    private native static long getDefaultMMKV();

    private native void putInt(long handle, String key, int value);

    private native int getInt(long handle, String key, int defaultValue);

    public int getInt(String key, int defaultValue) {
        return getInt(nativeHandle, key, defaultValue);
    }

}
