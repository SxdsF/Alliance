package com.sxdsf.alliance;

/**
 * DefaultConverter
 *
 * @author sunbowen
 * @date 2016/4/7-11:26
 * @desc 默认的converter
 */
public class DefaultConverter<T> implements Converter<T, Object> {
	@Override
	public Object convert(T value) {
		return value;
	}
}
