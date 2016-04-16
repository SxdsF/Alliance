package com.sxdsf.alliance.core;

/**
 * Call
 *
 * @author sunbowen
 * @date 2016/3/31-10:12
 * @desc 调用模块统一返回结果
 */
public interface Call<T> {

    /**
     * 有回调的执行方法
     *
     * @param callback
     */
    void execute(Callback<T> callback);

    /**
     * 直接返回的执行方法
     *
     * @return
     */
    T execute();

    /**
     * 判断任务是否执行
     *
     * @return
     */
    boolean isExecuted();

    /**
     * 取消任务
     */
    void cancel();

    /**
     * 判断任务是否取消
     *
     * @return
     */
    boolean isCanceled();
}
