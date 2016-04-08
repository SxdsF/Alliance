package com.sxdsf.alliance.rxjava;

import com.sxdsf.alliance.Parser;
import com.sxdsf.alliance.Response;

/**
 * FoundationRxAlliance
 *
 * @author sunbowen
 * @date 2016/4/6-20:49
 * @desc 带类型转换的模块接口
 */
public interface FoundationRxAlliance<K, V> extends RxAlliance<Response>, Parser<K, V> {
}
