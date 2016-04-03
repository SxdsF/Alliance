package com.sxdsf.alliance.rxjava;

import android.net.Uri;

import rx.Observable;

/**
 * AllianceLeader
 *
 * @author sunbowen
 * @date 2016/3/30-20:34
 * @desc 路由跳转入口总管类
 */
public class RxJavaAllianceLeader implements RxJavaAlliance {
	private RxJavaAllianceLeader() {
	}

	@Override
	public <T> Observable<T> request(Uri uri) {
		Observable<T> observable = null;
		if (uri != null) {
			String scheme = uri.getScheme();
			RxJavaAlliance alliance = this.allianceMap.getAlliance(scheme);
			if (alliance != null) {
				observable = alliance.request(uri);
			}
		}
		return observable;
	}

	@Override
	public <T> Observable<T> request(Uri uri, Class<T> callbackCls) {
		Observable<T> observable = null;
		if (uri != null) {
			String scheme = uri.getScheme();
			RxJavaAlliance alliance = this.allianceMap.getAlliance(scheme);
			if (alliance != null) {
				observable = alliance.request(uri, callbackCls);
			}
		}
		return observable;
	}

	private static class InstanceHolder {
		private static RxJavaAllianceLeader INSTANCE = new RxJavaAllianceLeader();
	}

	public static RxJavaAllianceLeader getInstance() {
		return InstanceHolder.INSTANCE;
	}

	private final RxJavaAllianceMap allianceMap = new RxJavaAllianceMap();

	public void addAlliance(String scheme, Class<? extends RxJavaAlliance> cls) {
		this.allianceMap.addAlliance(scheme, cls);
	}
}
