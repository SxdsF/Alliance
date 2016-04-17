package com.sxdsf.alliance.general;

/**
 * Callback
 *
 * @author sunbowen
 * @date 2016/3/31-10:17
 * @desc 需要回调的统一回调接口，觉得以后会用起来RxJava，所以此处将函数名改为和RxJava一样
 */
public interface Callback<T> {

    /**
     * 最后用onNext都发完数据后会回调此接口，表示已全部发完
     * 和onError互斥
     */
    void onCompleted();

    /**
     * 一旦发生错误就会回调此接口，和onCompleted互斥
     *
     * @param t
     */
    void onError(Throwable t);

    /**
     * 有数据产生，发射数据的时候会回调此接口
     *
     * @param result
     */
    void onNext(T result);
}
