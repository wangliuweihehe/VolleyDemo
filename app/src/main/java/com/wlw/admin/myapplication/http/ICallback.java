package com.wlw.admin.myapplication.http;

public interface ICallback {
    void onSuccess(String result);

    void onFailure(String e);
}
