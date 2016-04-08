package com.sxdsf.alliance;

/**
 * Parser
 *
 * @author sunbowen
 * @date 2016/4/6-20:14
 * @desc 类型解析接口
 */
public interface Parser<T, R> {
	R parse(T value);
}
