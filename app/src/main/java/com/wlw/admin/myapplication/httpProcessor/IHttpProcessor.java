package com.wlw.admin.myapplication.httpProcessor;

import com.wlw.admin.myapplication.http.ICallback;

import java.util.Map;

public interface IHttpProcessor {
    void Post(String url, Map<String, Object> params, ICallback callback);

    void get(String url, Map<String, Object> params, ICallback callback);
}
