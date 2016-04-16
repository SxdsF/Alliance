package com.sxdsf.alliance.rxjava;

import com.sxdsf.alliance.core.Function;

import rx.Observable;

/**
 * RxAlliance
 *
 * @author sunbowen
 * @date 2016/4/3-11:01
 * @desc rxjava版的实现
 */
public interface RxAlliance<T, R> extends Function<T, Observable<R>> {
}
