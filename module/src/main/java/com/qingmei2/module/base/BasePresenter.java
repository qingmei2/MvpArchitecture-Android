package com.qingmei2.module.base;


import org.reactivestreams.Subscription;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public class BasePresenter<V extends IView, M extends IModel> implements IPresenter {
//    protected CompositeSubscription mCompositeSubscription;

    protected V mRootView;
    protected M mModel;

    public BasePresenter(V rootView, M model) {
        this.mRootView = rootView;
        this.mModel = model;
    }

    public BasePresenter(V rootView) {
        this.mRootView = rootView;
    }

    @Override
    public void onDestroy() {
        unSubscribe();
        if (mModel != null) {
            mModel.onDestroy();
            this.mModel = null;
        }
        this.mRootView = null;
//        this.mCompositeSubscription = null;
    }

    protected void addSubscription(Subscription subscription) {
//        if (mCompositeSubscription == null) {
//            mCompositeSubscription = new CompositeSubscription();
//        }
//        mCompositeSubscription.add(subscription);
    }

    protected void unSubscribe() {
//        if (mCompositeSubscription != null) {
//            mCompositeSubscription.unsubscribe();
//        }
    }
}
