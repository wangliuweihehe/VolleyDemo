package com.wlw.admin.myapplication.httpProcessor;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wlw.admin.myapplication.http.ICallback;

import java.util.Map;

public class VolleyProcessor implements IHttpProcessor {
    private static RequestQueue mQueue=null;
    public VolleyProcessor(Context context){
        mQueue=Volley.newRequestQueue(context);
    }
    @Override
    public void Post(String url, Map<String, Object> params, final ICallback callback) {
        onResult(url ,callback);

    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        onResult(url ,callback);
    }
    private void  onResult(String url, final ICallback callback){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, callback::onSuccess, error -> callback.onFailure(error.toString()));
        mQueue.add(stringRequest);
    }

}
