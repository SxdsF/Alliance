package com.sxdsf.alliance;

/**
 * Builder
 *
 * @author sunbowen
 * @date 2016/4/11-22:37
 * @desc 创建接口
 */
public interface Builder<T> extends Law {

	/**
	 * 创建方法
	 * 
	 * @return
	 */
	T build();
}
