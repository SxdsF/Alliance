package com.sxdsf.alliance.core.impl;

import com.sxdsf.alliance.core.Callback;
import com.sxdsf.alliance.core.Call;

/**
 * CallAdapter
 *
 * @author sunbowen
 * @date 2016/3/31-10:26
 * @desc 返回同一结果的缺省适配
 */
public abstract class CallAdapter<T> implements Call<T> {

    @Override
    public void execute(Callback<T> callback) {
        // do nothing
    }

    @Override
    public T execute() {
        //do nothing
        return null;
    }

    @Override
    public boolean isExecuted() {
        //do nothing
        return false;
    }

    @Override
    public void cancel() {
        // do nothing
    }

    @Override
    public boolean isCanceled() {
        //do nothing
        return false;
    }
}
