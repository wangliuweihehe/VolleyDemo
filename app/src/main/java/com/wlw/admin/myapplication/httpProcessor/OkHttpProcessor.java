package com.wlw.admin.myapplication.httpProcessor;


import android.os.Handler;
import com.wlw.admin.myapplication.http.ICallback;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class OkHttpProcessor implements IHttpProcessor {
    private OkHttpClient okHttpClient;
    private Handler mHandler;

    public OkHttpProcessor() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        mHandler = new Handler();
    }

    @Override
    public void Post(String url, Map<String, Object> params, ICallback callback) {
        RequestBody requestBody = appendBody(params);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mHandler.post(() -> callback.onFailure(e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    mHandler.post(() ->
                            callback.onSuccess(result));
                } else {
                    mHandler.post(() -> callback.onFailure(response.message()));
                }

            }
        });
    }

    private RequestBody appendBody(Map<String, Object> params) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null)
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                builder.add(entry.getKey(), entry.getValue().toString());
            }
        return builder.build();
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mHandler.post(() -> callback.onFailure(e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    mHandler.post(() ->
                            callback.onSuccess(result)
                    );
                } else {
                    mHandler.post(() -> callback.onFailure(response.message()));
                }

            }
        });
    }

}
