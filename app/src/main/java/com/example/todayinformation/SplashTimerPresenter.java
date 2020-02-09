package com.example.todayinformation;

/**
 * Created by shixi on 2020/2/9.
 */
public class SplashTimerPresenter {


    private final SplashActivity mActivity;
    private CustomCountDown timer;

    public SplashTimerPresenter(SplashActivity activity) {
        this.mActivity = activity;
    }

    public void initTimer() {
        timer = new CustomCountDown(5, new CustomCountDown.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                mActivity.setTimerText(time + "秒");
            }

            @Override
            public void onFinish() {
                mActivity.setTimerText("跳过");
            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }
}
