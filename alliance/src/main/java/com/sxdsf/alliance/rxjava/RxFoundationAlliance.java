package com.sxdsf.alliance.rxjava;

import com.sxdsf.alliance.Parser;
import com.sxdsf.alliance.Request;
import com.sxdsf.alliance.Response;

/**
 * RxFoundationAlliance
 *
 * @author sunbowen
 * @date 2016/4/6-20:49
 * @desc 带类型转换的模块接口
 */
public interface RxFoundationAlliance<K, V> extends RxAlliance<Request, Response>, Parser<K, V> {
}
