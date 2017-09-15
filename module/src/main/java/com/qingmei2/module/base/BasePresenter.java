package com.qingmei2.module.base;


import com.qingmei2.module.util.RxUtils;
import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public class BasePresenter<V extends IView, M extends IModel> implements IPresenter {

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
        if (mModel != null) {
            mModel.onDestroy();
            this.mModel = null;
        }
        this.mRootView = null;
    }

    protected  <T> LifecycleTransformer<T> bindView(IView view) {
        return RxUtils.bindToLifecycle(view);
    }

}
