package com.sxdsf.alliance;

/**
 * Information
 *
 * @author sunbowen
 * @date 2016/4/9-1:04
 * @desc 信息接口，Request和Response的父接口
 */
public interface Information {

    /**
     * 检查并返回数据
     *
     * @param cls
     * @param <T>
     * @return
     */
    <T> T checkAndGet(Class<T> cls);
}
