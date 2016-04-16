package com.sxdsf.alliance.sample.rxjava.network;

import com.sxdsf.alliance.core.impl.generic.GenericRequestBuilder;

import java.util.Map;

/**
 * RxNetworkRequestBuilder
 *
 * @author Administrator
 * @date 2016/4/16-23:52
 * @desc ${描述类实现的功能}
 */
public class RxNetworkRequestBuilder extends GenericRequestBuilder<Map>{
    public RxNetworkRequestBuilder(String scheme) {
        super(scheme);
    }
}
