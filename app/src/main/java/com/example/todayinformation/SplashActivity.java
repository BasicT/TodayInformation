package com.example.todayinformation;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class SplashActivity extends AppCompatActivity {

    private FullScreenVideoView mFullScreenVideoView;
    private TextView mTvTimer;
    private CustomCountDown timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mTvTimer = findViewById(R.id.tv_splash_timer);

        mFullScreenVideoView = findViewById(R.id.fsvv_play);
        mFullScreenVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +
                File.separator + R.raw.splash));
        mFullScreenVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0f,0f);
                mp.start();
            }
        });

         mFullScreenVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.setVolume(0f,0f);
                mp.start();
            }
        });
         timer = new CustomCountDown(5, new CustomCountDown.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                mTvTimer.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                mTvTimer.setText("跳过");
            }
        });
        timer.start();
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }
}
