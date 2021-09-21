package com.mxkj.mmkvdemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * mmap 可跨进程
 * */
public class SecondActivity extends Activity {
    NativeBinder nativeBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        nativeBinder = new NativeBinder();
    }


    //mmap 可跨进程
    public void read(View view) {
        nativeBinder.readTest();
    }

}