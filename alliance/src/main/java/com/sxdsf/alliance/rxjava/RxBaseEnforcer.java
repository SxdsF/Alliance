package com.sxdsf.alliance.rxjava;

import com.sxdsf.alliance.core.Enforcer;
import com.sxdsf.alliance.core.impl.Response;

import rx.Observable;

/**
 * RxBaseEnforcer
 *
 * @author Administrator
 * @date 2016/4/16-23:29
 * @desc ${描述类实现的功能}
 */
public abstract class RxBaseEnforcer<T> implements Enforcer<T, Observable<Response>> {
}
