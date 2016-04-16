package com.sxdsf.alliance.core;

/**
 * Enforcer
 * 
 * 每个联盟都有法律的执法者，这个就是用来执法的
 *
 * @author sunbowen
 * @date 2016/4/15-11:34
 * @desc 每个alliance的enforcer
 */
public interface Enforcer<T, R> extends Function<T, R> {
}
