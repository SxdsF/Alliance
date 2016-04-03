package com.sxdsf.alliance.rxjava;

import android.net.Uri;

import rx.Observable;

/**
 * RxJavaAllianceAdapter
 *
 * @author sunbowen
 * @date 2016/4/3-11:35
 * @desc Alliance的缺省适配
 */
public class RxJavaAllianceAdapter implements RxJavaAlliance{
    @Override
    public <T> Observable<T> request(Uri uri) {
		return null;
    }

    @Override
    public <T> Observable<T> request(Uri uri, Class<T> callbackCls) {
        return null;
    }
}
