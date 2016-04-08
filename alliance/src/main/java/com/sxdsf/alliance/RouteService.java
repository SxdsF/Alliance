package com.sxdsf.alliance;

import android.net.Uri;

/**
 * RouteService
 *
 * @author sunbowen
 * @date 2016/4/8-17:21
 * @desc 路由服务，负责转发Uri到相应的服务
 */
public class RouteService implements FoundationAlliance<Request, String> {

	private final AllianceMap allianceMap = new AllianceMap();

	@Override
	public <Y> Call<Response> request(Request<Y> request) {
		Call<Response> call = null;
		if (request != null) {
			Alliance<Response> alliance = this.allianceMap.getAlliance(this.parse(request));
			if (alliance != null) {
				call = alliance.request(request);
			}
		}
		return call;
	}

	@Override
	public String parse(Request value) {
		String scheme = null;
		if (value != null) {
			Uri uri = value.getUri();
			if (uri != null) {
				scheme = uri.getScheme();
			}
		}
		return scheme;
	}

	void init() {
		// 读取配置文件
	}
}
