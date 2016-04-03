package com.sxdsf.alliance.rxjava;

import android.net.Uri;

import rx.Observable;

/**
 * RxJavaAlliance
 *
 * @author sunbowen
 * @date 2016/4/3-11:01
 * @desc rxjava版的实现
 */
public interface RxJavaAlliance {

	<T> Observable<T> request(Uri uri);

	<T> Observable<T> request(Uri uri, Class<T> callbackCls);
}
