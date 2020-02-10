package com.example.todayinformation.mvp;

import com.example.todayinformation.mvp.presenter.MvpControler;

/**
 * Created by shixi on 2020/2/10.
 */
public interface ISplashActivityContract {

    interface IView extends IMvpView{
        void setTimerText(String s);
    }

    interface IPresenter extends ILifeCircle{
        void initTimer();
    }

    IView emptyView = new IView() {
        @Override
        public void setTimerText(String s) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
