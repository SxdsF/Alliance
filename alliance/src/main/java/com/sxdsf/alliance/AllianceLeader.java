package com.sxdsf.alliance;

import android.net.Uri;

/**
 * AllianceLeader
 *
 * @author sunbowen
 * @date 2016/3/30-20:34
 * @desc 路由跳转入口总管类
 */
public class AllianceLeader implements Alliance {
	private AllianceLeader() {
	}

	@Override
	public <T> Call<T> request(Uri uri) {
		Call<T> call = null;
		if (uri != null) {
			String scheme = uri.getScheme();
			Alliance alliance = this.allianceMap.getAlliance(scheme);
			if (alliance != null) {
				call = alliance.request(uri);
			}
		}
		return call;
	}

	private static class InstanceHolder {
		private static AllianceLeader INSTANCE = new AllianceLeader();
	}

	public static AllianceLeader getInstance() {
		return InstanceHolder.INSTANCE;
	}

	private final AllianceMap allianceMap = new AllianceMap();

	public void addAlliance(String scheme, Class<? extends Alliance> cls) {
		this.allianceMap.addAlliance(scheme, cls);
	}
}
