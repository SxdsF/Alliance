package com.sxdsf.alliance;

/**
 * GenericResponse
 *
 * @author sunbowen
 * @date 2016/4/8-15:01
 * @desc 通用的泛型数据Response
 */
public class GenericResponse<Y> implements Response {

	private Y data;

	public void setData(Y data) {
		this.data = data;
	}

	@Override
	public <T> T checkAndGet(Class<T> cls) {
		T t = null;
		if (cls != null && this.data != null && cls == this.data.getClass()) {
			t = cls.cast(this.data);
		}
		return t;
	}
}
