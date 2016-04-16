package com.sxdsf.alliance.sample.rxjava.redirect;

import android.content.Context;
import android.content.Intent;

import com.sxdsf.alliance.core.impl.Response;
import com.sxdsf.alliance.rxjava.RxBaseEnforcer;
import com.sxdsf.alliance.sample.MyApplication;

import rx.Observable;
import rx.Subscriber;

/**
 * RxRedirectEnforcer
 *
 * @author Administrator
 * @date 2016/4/16-23:43
 * @desc ${描述类实现的功能}
 */
public class RxRedirectEnforcer extends RxBaseEnforcer<Data> {

	private final Context context = MyApplication.getContext();

	@Override
	public Observable<Response> enforce(final Data request) {
		Observable<Response> call = null;
		if (request != null) {
			call = Observable.create(new Observable.OnSubscribe<Response>() {
				@Override
				public void call(Subscriber<? super Response> subscriber) {
					Intent intent = new Intent();
					intent.setClassName(context, request.className);
					if (request.data != null) {
						intent.putExtras(request.data);
					}
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent);
				}
			});
		}
		return call;
	}
}
