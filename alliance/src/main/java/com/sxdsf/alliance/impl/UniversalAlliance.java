package com.sxdsf.alliance.impl;

import com.sxdsf.alliance.Alliance;

/**
 * UniversalAlliance
 *
 * @author sunbowen
 * @date 2016/4/17-22:48
 * @desc 普通和rx共同继承的Alliance
 */
public abstract class UniversalAlliance<K, T, R> implements Alliance<T, R> {

	public UniversalAlliance() {
		this.onCreate();
	}

	@Override
	public R call(T t) {
		return this.onPerform(this.onParse(t));
	}

	/**
	 * 在创建时回调的方法
	 */
	protected abstract void onCreate();

	/**
	 * 在解析时回调的方法
	 * 
	 * @param t
	 * @return
	 */
	protected abstract K onParse(T t);

	/**
	 * 在执行时回调的方法
	 * 
	 * @param k
	 * @return
	 */
	protected abstract R onPerform(K k);
}
