package com.example.todayinformation;

import android.os.Handler;

/**
 * created by qibuc on 2019/6/13
 */
public class CustomCountDown implements Runnable{

    private int time;//总时间
    private int countDownTimer;//倒计时时间
    private ICountDownHandler countDownHandler;
    private Handler handler;
    private boolean isRun;

    //构造函数，参数里包含一个回调接口，接口可以帮助实现方法
    public CustomCountDown(int time,ICountDownHandler countDownHandler) {
        handler = new Handler();//利用handler来每秒传入倒计时消息
        this.time = time;
        this.countDownTimer = time;
        this.countDownHandler = countDownHandler;
    }

    //倒计时具体实现方法 用的是post和postDelayed来实现循环
    @Override
    public void run() {
        if (isRun){
            if (countDownHandler != null){
                countDownHandler.onTicker(countDownTimer);
            }
            if (countDownTimer == 0){
                countDownHandler.onFinish();
            }else {
                countDownTimer = time--;
                handler.postDelayed(this,1000);
            }
        }

    }

    //构造接口，实现倒计时方法和结束方法
    public interface ICountDownHandler{

        void onTicker(int time);

        void onFinish();
    }

    //启动倒计时
    public void start(){
        isRun = true;
        handler.post(this);
    }

    //结束倒计时并回收内存
    public void cancel(){
        isRun = false;
        handler.removeCallbacks(this);
    }
}
