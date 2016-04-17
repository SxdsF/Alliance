package com.sxdsf.alliance.rx;

import com.sxdsf.alliance.Information;
import com.sxdsf.alliance.impl.Request;
import com.sxdsf.alliance.impl.Response;
import com.sxdsf.alliance.impl.UniversalAlliance;

import rx.Observable;

/**
 * RxAlliance
 *
 * @author sunbowen
 * @date 2016/4/3-11:01
 * @desc rxjava版的实现
 */
public abstract class RxAlliance<T extends Information> extends UniversalAlliance<T, Request, Observable<Response>> {
}
