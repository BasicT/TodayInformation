package com.example.todayinformation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by shixi on 2019/6/14.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if(mainlayoutid > 0){
                setContentView(mainlayoutid);
                ButterKnife.bind(this);
            }else {
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else {
            throw new RuntimeException("annotation = null");
        }

    }
}
