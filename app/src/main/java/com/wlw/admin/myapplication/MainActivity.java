package com.wlw.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wlw.admin.myapplication.http.MyHttpCallback;
import com.wlw.admin.myapplication.httpProcessor.HttpHelper;
import com.wlw.admin.myapplication.module.HomeBean2;

public class MainActivity extends AppCompatActivity {
    public static String url="http://www.hongjimeng.net/AppV2/public/IndexReturn1212";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvResult=findViewById(R.id.tv_result);
        findViewById(R.id.btn_request).setOnClickListener((view)->
//            HttpHelper.obtain().get(url, null, new HttpCallback<HomeBean>() {
//                @Override
//                public void onSuccess(HomeBean bean) {
//                        tvResult.setText(bean.getJsondata().getBannerList().get(0).getBannerName());
//                }
//                @Override
//                public void onFailure(String e) {
//                    tvResult.setText(e);
//                }
//            })
            HttpHelper.obtain().get(url, null, new MyHttpCallback<HomeBean2>() {
                @Override
                public void onFailure(String e) {

                }

                @Override
                public void onSuccess(HomeBean2 result) {
                    tvResult.setText(result.getBannerList().get(0).getBannerName());
                }
            })
        );
    }
}
