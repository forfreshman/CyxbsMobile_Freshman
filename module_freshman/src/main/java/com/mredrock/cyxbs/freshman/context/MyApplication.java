package com.mredrock.cyxbs.freshman.context;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static MyApplication mInstance;

    public static Context getInstance(){
        if (mInstance==null){
            mInstance=new MyApplication();
        }
        return mInstance;
    }
}
