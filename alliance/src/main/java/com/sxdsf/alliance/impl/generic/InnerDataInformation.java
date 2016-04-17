package com.sxdsf.alliance.impl.generic;

import com.sxdsf.alliance.DataInformation;

/**
 * InnerDataInformation
 *
 * @author sunbowen
 * @date 2016/4/11-11:12
 * @desc information的inner实现
 */
class InnerDataInformation<R> implements DataInformation {

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
