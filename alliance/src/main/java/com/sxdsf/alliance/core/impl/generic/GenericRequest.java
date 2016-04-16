package com.sxdsf.alliance.core.impl.generic;

import com.sxdsf.alliance.core.impl.Request;

/**
 * GenericRequest
 *
 * @author sunbowen
 * @date 2016/4/11-11:04
 * @desc Request的泛型实现
 */
public class GenericRequest<R> extends Request {

    private final InnerInformation<R> data = new InnerInformation<>();

    public void setData(R data) {
        this.data.setData(data);
    }

    @Override
    public <T> T checkAndGet(Class<T> cls) {
        return this.data.checkAndGet(cls);
    }
}
