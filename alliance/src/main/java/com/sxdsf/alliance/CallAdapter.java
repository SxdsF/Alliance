package com.sxdsf.alliance;

/**
 * CallAdapter
 *
 * @author sunbowen
 * @date 2016/3/31-10:26
 * @desc 返回同一结果的缺省适配
 */
public class CallAdapter<T> implements Call<T> {

	@Override
	public void execute(Callback<T> callback) {
		// do nothing
	}

	@Override
	public void execute() {
		// do nothing
	}
}
