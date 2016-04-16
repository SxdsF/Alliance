package com.sxdsf.alliance.core;

/**
 * Function
 *
 * @author sunbowen
 * @date 2016/4/11-0:38
 * @desc 提高抽象层次，所有的请求应该都是传进来一个参数，返回另一个
 */
public interface Function<T, R> {

    R enforce(T t);
}
