package com.sxdsf.alliance;

/**
 * Callback
 *
 * @author sunbowen
 * @date 2016/3/31-10:17
 * @desc 需要回调的回调接口
 */
public interface Callback<T> {
	void onSuccess(T result);

	void onError(Throwable t);

	void onFinish();

	void onProgress(int progress);
}
