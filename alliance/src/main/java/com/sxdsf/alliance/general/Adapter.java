package com.sxdsf.alliance.general;

/**
 * Adapter
 *
 * @author sunbowen
 * @date 2016/4/11-22:50
 * @desc 适配器接口，可以将一种结果适配成另一种结果
 */
public interface Adapter<T, R> {

    /**
     * 适配方法
     *
     * @param t
     * @return
     */
    R adapt(T t);
}
