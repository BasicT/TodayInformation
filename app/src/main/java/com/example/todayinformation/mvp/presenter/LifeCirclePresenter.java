package com.example.todayinformation.mvp.presenter;

import com.example.todayinformation.mvp.ILifeCircle;
import com.example.todayinformation.mvp.IMvpView;

import java.lang.ref.WeakReference;

/**
 * created by qibuc on 2020/2/10
 */
public abstract class LifeCirclePresenter<T extends IMvpView> implements ILifeCircle {

    protected WeakReference<T> weakReference;

    public LifeCirclePresenter() {
        super();
    }

    public LifeCirclePresenter(IMvpView iMvpView) {
        super();
        attachView(iMvpView);
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        if (weakReference == null){
            weakReference = new WeakReference(iMvpView);
        }else {
            if ()
        }
        WeakReference weakReference =
    }
}
