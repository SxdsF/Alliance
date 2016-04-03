package com.sxdsf.alliance;

/**
 * Call
 *
 * @author sunbowen
 * @date 2016/3/31-10:12
 * @desc 调用模块统一返回结果
 */
public interface Call<T> {
	void execute(Callback<T> callback, Class<T> cls);

	void execute();
}
