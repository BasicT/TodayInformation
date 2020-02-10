package com.example.todayinformation.mvp.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.presenter.LifeCirclePresenter;

/**
 * Created by shixi on 2020/2/10.
 */
public abstract class BaseMvpPresenter<T extends IMvpView> extends LifeCirclePresenter<T> {

    public BaseMvpPresenter (T view){
        super(view);
    }


    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void destroyView() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }
}
