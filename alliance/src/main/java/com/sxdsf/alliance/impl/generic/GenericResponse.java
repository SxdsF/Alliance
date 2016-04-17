package com.sxdsf.alliance.impl.generic;

import com.sxdsf.alliance.impl.Response;

/**
 * GenericResponse
 *
 * @author sunbowen
 * @date 2016/4/11-11:05
 * @desc Response的泛型实现
 */
public class GenericResponse<R> extends Response {

    private final InnerDataInformation<R> data = new InnerDataInformation<>();

    public void setData(R data) {
        this.data.setData(data);
    }

    @Override
    public <T> T checkAndGet(Class<T> cls) {
        return this.data.checkAndGet(cls);
    }
}
