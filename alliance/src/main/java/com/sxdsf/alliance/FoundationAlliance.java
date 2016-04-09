package com.sxdsf.alliance;

/**
 * FoundationAlliance
 *
 * @author sunbowen
 * @date 2016/4/7-17:00
 * @desc 继承自模块接口和解析接口，可作为模块接口的base接口，这样每个模块都会有parse方法
 * 用来解析传入的request
 */
public interface FoundationAlliance<K, V> extends Alliance<Request, Response>, Parser<K, V> {
}
