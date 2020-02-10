package com.example.todayinformation.mvp.presenter;

import android.util.Log;

import com.example.todayinformation.CustomCountDown;
import com.example.todayinformation.SplashActivity;
import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.ISplashActivityContract;
import com.example.todayinformation.mvp.base.BaseMvpPresenter;

/**
 * Created by shixi on 2020/2/9.
 */
public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.IView > implements ISplashActivityContract.IPresenter {


    private CustomCountDown timer;

    public SplashTimerPresenter(ISplashActivityContract.IView view) {
        super(view);
    }


    public void initTimer() {
        timer = new CustomCountDown(5, new CustomCountDown.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTimerText(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTimerText("跳过");
            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
        Log.e("SplashTimerPresenter","onDestroy");
    }

    @Override
    protected ISplashActivityContract.IView getEmptyView() {
        return ISplashActivityContract.emptyView;
    }
}
