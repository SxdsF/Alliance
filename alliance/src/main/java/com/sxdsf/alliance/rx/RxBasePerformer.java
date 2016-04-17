package com.sxdsf.alliance.rx;

import com.sxdsf.alliance.Performer;
import com.sxdsf.alliance.impl.Response;

import rx.Observable;

/**
 * RxBasePerformer
 *
 * @author sunbowen
 * @date 2016/4/16-23:29
 * @desc 默认的performer实现
 */
public abstract class RxBasePerformer<T> implements Performer<T, Observable<Response>> {
}
