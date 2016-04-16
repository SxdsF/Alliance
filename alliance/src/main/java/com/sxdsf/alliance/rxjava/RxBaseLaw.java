package com.sxdsf.alliance.rxjava;

import com.sxdsf.alliance.core.Law;
import com.sxdsf.alliance.core.impl.RequestParser;

/**
 * RxBaseLaw
 *
 * @author Administrator
 * @date 2016/4/16-23:32
 * @desc ${描述类实现的功能}
 */
public abstract class RxBaseLaw<T> implements Law {

	/**
	 * 请求解析模块
	 */
	protected final RequestParser<T> parser;

	public RxBaseLaw() {
		this.parser = this.createRequestParser();
	}

	/**
	 * 请求解析模块的创建方法
	 *
	 * @return
	 */
	protected abstract RequestParser<T> createRequestParser();
}
