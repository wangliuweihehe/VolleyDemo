package com.wlw.admin.myapplication.module;


public class BaseResponse<T> {

    private boolean success;
    private int code;
    private String msg;
    private T jsondata;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getJsondata() {
        return jsondata;
    }

    public void setJsondata(T jsondata) {
        this.jsondata = jsondata;
    }
}
