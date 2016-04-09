package com.sxdsf.alliance;

/**
 * Parser
 *
 * @author sunbowen
 * @date 2016/4/6-20:14
 * @desc 数据解析接口
 */
public interface Parser<T, R> {

    /**
     * 解析方法
     *
     * @param value
     * @return
     */
    R parse(T value);
}
