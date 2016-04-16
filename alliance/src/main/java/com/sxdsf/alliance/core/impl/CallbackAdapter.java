package com.sxdsf.alliance.core.impl;

import com.sxdsf.alliance.core.Callback;

/**
 * CallbackAdapter
 *
 * @author sunbowen
 * @date 2016/4/1-16:16
 * @desc 统一回调接口的缺省适配
 */
public abstract class CallbackAdapter<T> implements Callback<T> {

    @Override
    public void onCompleted() {
        //do nothing
    }

    @Override
    public void onError(Throwable t) {
        //do nothing
    }

    @Override
    public void onNext(T result) {
        //do nothing
    }
}
