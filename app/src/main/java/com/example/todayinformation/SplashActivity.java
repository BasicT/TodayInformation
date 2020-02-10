package com.example.todayinformation;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.todayinformation.mvp.ISplashActivityContract;
import com.example.todayinformation.mvp.presenter.SplashTimerPresenter;

import java.io.File;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.IView {

    @BindView(R.id.fsvv_play)
    FullScreenVideoView mFullScreenVideoView;
    @BindView(R.id.tv_splash_timer)
    TextView mTvTimer;
    private ISplashActivityContract.IPresenter timerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    //模板设计模式
    @Override
    public void afterBindView() {
        initListener();
        initVideo();
        initTimerPresenter();
    }

    private void initTimerPresenter() {
        if (timerPresenter == null){
            timerPresenter = new SplashTimerPresenter(this);
        }
        timerPresenter.initTimer();
    }

    private void initVideo() {
        mFullScreenVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +
                File.separator + R.raw.splash));
        mFullScreenVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0f, 0f);
                mp.start();
            }
        });

        mFullScreenVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.setVolume(0f, 0f);
                mp.start();
            }
        });
    }



    private void initListener() {
        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void setTimerText(String s) {
        mTvTimer.setText(s);
    }
}
