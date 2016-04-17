package com.sxdsf.alliance.general.impl;

import com.sxdsf.alliance.general.Adapter;
import com.sxdsf.alliance.general.Call;

import rx.Observable;

/**
 * ResultAdapter
 *
 * @author sunbowen
 * @date 2016/4/11-22:52
 * @desc alliance模块返回值的适配，将Call适配成Observable
 */
public interface ResultAdapter<T> extends Adapter<Call<T>, Observable<T>> {
}
