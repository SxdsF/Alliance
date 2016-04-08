package com.sxdsf.alliance.rxjava;

import android.net.Uri;

import com.sxdsf.alliance.Request;
import com.sxdsf.alliance.Response;

import rx.Observable;

/**
 * AllianceLeader
 *
 * @author sunbowen
 * @date 2016/3/30-20:34
 * @desc 路由跳转入口总管类
 */
public class RxAllianceLeader implements FoundationRxAlliance<Uri, String> {
	private RxAllianceLeader() {
	}

	@Override
	public <Y> Observable<Response> request(Request<Y> request) {
		Observable<Response> observable = null;
		if (request != null) {
			Uri uri = request.getUri();
			if (uri != null) {
				RxAlliance<Response> alliance = this.allianceMap.getAlliance(this.parse(uri));
				if (alliance != null) {
					observable = alliance.request(request);
				}
			}
		}
		return observable;
	}

	@Override
	public String parse(Uri value) {
		String result = null;
		if (value != null) {
			result = value.getScheme();
		}
		return result;
	}

	private static class InstanceHolder {
		private static RxAllianceLeader INSTANCE = new RxAllianceLeader();
	}

	public static RxAllianceLeader getInstance() {
		return InstanceHolder.INSTANCE;
	}

	private final RxAllianceMap allianceMap = new RxAllianceMap();

	public void addAlliance(String scheme, Class<? extends RxAlliance<Response>> cls) {
		this.allianceMap.addAlliance(scheme, cls);
	}
}
