package com.sxdsf.alliance.impl.generic;

import com.sxdsf.alliance.impl.Request;

/**
 * GenericRequest
 *
 * @author sunbowen
 * @date 2016/4/11-11:04
 * @desc Request的泛型实现
 */
public class GenericRequest<R> extends Request {

    private final InnerDataInformation<R> data = new InnerDataInformation<>();

    public void setData(R data) {
        this.data.setData(data);
    }

    @Override
    public <T> T checkAndGet(Class<T> cls) {
        return this.data.checkAndGet(cls);
    }
}
