package com.sxdsf.alliance;

/**
 * GenericRequest
 *
 * @author sunbowen
 * @date 2016/4/9-1:08
 * @desc 通用的泛型数据Request
 */
public class GenericRequest<R> extends Request {

    private R data;

    public void setData(R data) {
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
