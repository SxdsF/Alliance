package com.sxdsf.alliance;

/**
 * CallbackAdapter
 *
 * @author sunbowen
 * @date 2016/4/1-16:16
 * @desc 回调类的缺省适配
 */
public abstract class CallbackAdapter<T> implements Callback<T> {
	@Override
	public void onSuccess(T result) {
		// do nothing
	}

	@Override
	public void onError(Throwable t) {
		// do nothing
	}

	@Override
	public void onFinish() {
		// do nothing
	}

	@Override
	public void onProgress(int progress, int total) {
		// do nothing
	}
}
