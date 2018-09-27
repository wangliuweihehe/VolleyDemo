package com.wlw.admin.myapplication.httpProcessor;

import com.wlw.admin.myapplication.http.ICallback;

import java.util.HashMap;
import java.util.Map;

public class HttpHelper implements IHttpProcessor{
    private static IHttpProcessor mHttpProcessor = null;
    private static HttpHelper instance;


    public static void init(IHttpProcessor httpProcessor) {
        mHttpProcessor = httpProcessor;
    }


    private HttpHelper() {
    }
    public static HttpHelper obtain(){
        if(instance==null) {
            synchronized (HttpHelper.class) {
                if (instance == null) {
                    instance = new HttpHelper();
                }
            }
        }
        return instance;
    }

    @Override
    public void Post(String url, Map<String, Object> params, ICallback callback) {
        mHttpProcessor.Post(url,params,callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        mHttpProcessor.get(url,params,callback);
    }

}
