package com.qingmei2.module.http.error;

import rx.Subscriber;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    public abstract void onError(ExceptionHandle.ResponeThrowable responeThrowable);

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof Exception) {
            onError(ExceptionHandle.handleException(e));
        } else {
            onError(new ExceptionHandle.ResponeThrowable(e, ExceptionHandle.ERROR.UNKNOWN, ""));
        }
    }

    public void onError(Error error) {
        onError(ExceptionHandle.handleError(error));
    }
}
