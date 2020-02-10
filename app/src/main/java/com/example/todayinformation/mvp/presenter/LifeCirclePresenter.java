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
        MvpControler mvpControler = iMvpView.getMvpControler();
        mvpControler.savePresenter(this);
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        if (weakReference == null){
            weakReference = new WeakReference(iMvpView);
        }else {
            T  view = weakReference.get();
            if (view != iMvpView){
                weakReference = new WeakReference(iMvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        weakReference = null;
    }

    protected T getView(){
        T view = weakReference != null ? weakReference.get():null;
        if (view == null){
            return getEmptyView();
        }
        return view;

    }

    protected abstract T getEmptyView();


}
