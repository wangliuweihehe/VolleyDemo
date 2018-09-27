package com.wlw.admin.myapplication;

import android.app.Application;

import com.wlw.admin.myapplication.httpProcessor.HttpHelper;
import com.wlw.admin.myapplication.httpProcessor.OkHttpProcessor;
import com.wlw.admin.myapplication.httpProcessor.VolleyProcessor;
import com.wlw.admin.myapplication.httpProcessor.XUtilsProcessor;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        HttpHelper.init(new VolleyProcessor(this));
//        HttpHelper.init(new OkHttpProcessor());
        HttpHelper.init(new XUtilsProcessor(this));
    }

}
