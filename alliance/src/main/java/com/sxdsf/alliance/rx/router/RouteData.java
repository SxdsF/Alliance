package com.sxdsf.alliance.rx.router;

import com.sxdsf.alliance.Information;
import com.sxdsf.alliance.impl.Request;

/**
 * RouteData
 *
 * @author sunbowen
 * @date 2016/4/16-23:35
 * @desc 路由服务的中间信息类
 */
public class RouteData implements Information {
	String scheme;
	Request request;
}
