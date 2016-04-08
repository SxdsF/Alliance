package com.sxdsf.alliance;

/**
 * Converter
 *
 * @author sunbowen
 * @date 2016/4/7-10:32
 * @desc 类型装换接口
 */
public interface Converter<T, R> {
	R convert(T value);
}
