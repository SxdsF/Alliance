package com.sxdsf.alliance;

import android.net.Uri;

/**
 * AllianceLeader
 *
 * @author sunbowen
 * @date 2016/3/30-20:34
 * @desc 路由跳转入口总管类
 */
public class AllianceLeader implements FoundationAlliance<Uri, String> {
	private AllianceLeader() {
	}

	@Override
	public <Y> Call<Response> request(Request<Y> request) {
		Call<Response> call = null;
		if (request != null) {
			Uri uri = request.getUri();
			if (uri != null) {
				Alliance<Response> alliance = this.allianceMap.getAlliance(uri.getScheme());
				if (alliance != null) {
					call = alliance.request(request);
				}
			}
		}
		return call;
	}

	@Override
	public String parse(Uri value) {
		return null;
	}

	private static class InstanceHolder {
		private static AllianceLeader INSTANCE = new AllianceLeader();
	}

	public static AllianceLeader getInstance() {
		return InstanceHolder.INSTANCE;
	}

	private final AllianceMap allianceMap = new AllianceMap();

	public void addAlliance(String scheme, Class<? extends Alliance<Response>> cls) {
		this.allianceMap.addAlliance(scheme, cls);
	}

	public void init() {
		// 服务管理器初始化
	}
}
