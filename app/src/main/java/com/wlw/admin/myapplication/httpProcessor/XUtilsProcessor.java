package com.wlw.admin.myapplication.httpProcessor;

import android.app.Application;
import android.widget.Toast;

import com.wlw.admin.myapplication.BuildConfig;
import com.wlw.admin.myapplication.http.ICallback;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

public class XUtilsProcessor implements IHttpProcessor {

    public XUtilsProcessor(Application application) {
        x.Ext.init(application);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }

    @Override
    public void Post(String url, Map<String, Object> params, ICallback callback) {
        RequestParams requestParams = new RequestParams(url);
        params.putAll(params);

        x.http().post(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        RequestParams requestParams = new RequestParams(url);
//        requestParams.addBodyParameter(key,value);

        x.http().get(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onFailure(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
}
