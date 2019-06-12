package com.example.todayinformation;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class SplashActivity extends AppCompatActivity {

    private View mFullScreenVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mFullScreenVideoView = (FullScreenVideoView)findViewById(R.id.fsvv_play);
        ((FullScreenVideoView) mFullScreenVideoView).setVideoURI(Uri.parse("android.resource://" + getPackageName() +
                File.separator + R.raw.splash));
        ((FullScreenVideoView) mFullScreenVideoView).setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0f,0f);
                mp.start();
            }
        });

        ((FullScreenVideoView) mFullScreenVideoView).setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.setVolume(0f,0f);
                mp.start();
            }
        });
    }
}
