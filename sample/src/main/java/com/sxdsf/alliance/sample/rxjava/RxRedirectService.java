package com.sxdsf.alliance.sample.rxjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.sxdsf.alliance.Request;
import com.sxdsf.alliance.Response;
import com.sxdsf.alliance.rxjava.RxFoundationAlliance;
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
public class RxRedirectService implements RxFoundationAlliance<Uri, String> {

	private final Context context = MyApplication.getContext();

	@Override
	public Observable<Response> request(final Request request) {
		Observable<Response> call = null;
		if (request != null && request.getUri() != null) {
			final Uri uri = request.getUri();
			call = Observable.create(new Observable.OnSubscribe<Response>() {
				@Override
				public void call(Subscriber<? super Response> subscriber) {
					String clsName = parse(uri);
					Intent intent = new Intent();
					intent.setClassName(context, clsName);
					Bundle bundle = request.checkAndGet(Bundle.class);
					if (bundle != null) {
						intent.putExtras(bundle);
					}
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent);
				}
			});
		}
		return call;
	}

	@Override
	public String parse(Uri value) {
		String result = null;
		if (value != null) {
			result = value.getHost();
		}
		return result;
	}
}
