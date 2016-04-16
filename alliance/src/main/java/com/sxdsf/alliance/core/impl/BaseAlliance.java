package com.sxdsf.alliance.core.impl;

import com.sxdsf.alliance.core.Alliance;
import com.sxdsf.alliance.core.Call;

/**
 * BaseAlliance
 *
 * @author sunbowen
 * @date 2016/4/13-21:08
 * @desc alliance的base实现
 */
public abstract class BaseAlliance<T> implements Alliance<Request, Response> {

	/**
	 * 执行者模块
	 */
	protected final BaseEnforcer<T> enforcer;
	/**
	 * 协议模块
	 */
	protected final BaseLaw<T> law;

	public BaseAlliance() {
		this.enforcer = this.createEnforcer();
		this.law = this.createLaw();
	}

	@Override
	public Call<Response> enforce(Request request) {
		return this.enforcer.enforce(this.law.parser.parse(request));
	}

	/**
	 * 执行者模块的创建方法
	 * 
	 * @return
	 */
	protected abstract BaseEnforcer<T> createEnforcer();

	/**
	 * 协议模块的创建方法
	 * 
	 * @return
	 */
	protected abstract BaseLaw<T> createLaw();
}
