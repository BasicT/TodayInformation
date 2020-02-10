package com.example.todayinformation.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * created by qibuc on 2020/2/10
 */
public interface ILifeCircle {

    void onCreat(Bundle savedInstanceState,Intent intent, Bundle getArguments);

    void onActivityCreat(Bundle savedInstanceState,Intent intent, Bundle getArguments);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void destroyView();

    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);

    void onSaveInstanceState(Bundle bundle);

    void attachView(IMvpView iMvpView);
}
