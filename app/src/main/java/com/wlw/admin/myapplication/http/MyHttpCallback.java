package com.wlw.admin.myapplication.http;

import com.google.gson.Gson;
import com.wlw.admin.myapplication.module.BaseResponse;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class MyHttpCallback<T> implements ICallback {
    @Override
    public void onSuccess(String result) {
        BaseResponse objResult = fromJson(result, analysisClassInfo(this));
        onSuccess((T) objResult.getJsondata());
    }

    public abstract void onSuccess(T result);

    public abstract void onFailure(String error);

    public void onRelogin() {
    }

    public void onComplete() {
    }

    private static Class<?> analysisClassInfo(Object object) {
        //当前对象的直接超类的 Type
        Type genericSuperclass = object.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            //参数化类型
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            //返回表示此类型实际类型参数的 Type 对象的数组
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            return (Class<?>) actualTypeArguments[0];
        } else {
            return (Class<?>) genericSuperclass;
        }
    }

    private static BaseResponse fromJson(String json, Class clazz) {
        Gson gson = new Gson();
        Type objectType = type(BaseResponse.class, clazz);
        return gson.fromJson(json, objectType);
    }

    public String toJson(Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(BaseResponse.class, clazz);
        return gson.toJson(this, objectType);
    }

    static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }
}
