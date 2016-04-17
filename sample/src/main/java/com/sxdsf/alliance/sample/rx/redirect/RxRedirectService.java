package com.sxdsf.alliance.sample.rx.redirect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.sxdsf.alliance.impl.Request;
import com.sxdsf.alliance.impl.Response;
import com.sxdsf.alliance.rx.RxAlliance;
import com.sxdsf.alliance.sample.MyApplication;

import rx.Observable;
import rx.Subscriber;

/**
 * RxRedirectService
 *
 * @author sunbowen
 * @date 2016/4/3-11:10
 * @desc 跳转服务
 */
public class RxRedirectService extends RxAlliance<RxRedirectData> {

	private final Context context = MyApplication.getContext();

	@Override
	protected void onCreate() {
		// do nothing
	}

	@Override
	protected RxRedirectData onParse(Request request) {
		RxRedirectData rxRedirectData = null;
		if (request != null) {
			rxRedirectData = new RxRedirectData();
			rxRedirectData.data = request.checkAndGet(Bundle.class);
			Uri uri = request.getUri();
			if (uri != null) {
				rxRedirectData.className = uri.getAuthority();
			}
		}
		return rxRedirectData;
	}

	@Override
	protected Observable<Response> onPerform(final RxRedirectData rxRedirectData) {
		Observable<Response> call = null;
		if (rxRedirectData != null) {
			call = Observable.create(new Observable.OnSubscribe<Response>() {
				@Override
				public void call(Subscriber<? super Response> subscriber) {
					Intent intent = new Intent();
					intent.setClassName(context, rxRedirectData.className);
					if (rxRedirectData.data != null) {
						intent.putExtras(rxRedirectData.data);
					}
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent);
				}
			});
		}
		return call;
	}
}
