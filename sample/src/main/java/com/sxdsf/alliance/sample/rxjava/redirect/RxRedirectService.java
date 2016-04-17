package com.sxdsf.alliance.sample.rxjava.redirect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.sxdsf.alliance.core.impl.Request;
import com.sxdsf.alliance.core.impl.RequestParser;
import com.sxdsf.alliance.core.impl.Response;
import com.sxdsf.alliance.rxjava.RxBaseAlliance;
import com.sxdsf.alliance.rxjava.RxBaseEnforcer;
import com.sxdsf.alliance.rxjava.RxBaseLaw;
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
public class RxRedirectService extends RxBaseAlliance<Data> {

	private final Context context = MyApplication.getContext();

	@Override
	protected RxBaseEnforcer<Data> createEnforcer() {
		return new RxBaseEnforcer<Data>() {
			@Override
			public Observable<Response> enforce(final Data data) {
				Observable<Response> call = null;
				if (data != null) {
					call = Observable.create(new Observable.OnSubscribe<Response>() {
						@Override
						public void call(Subscriber<? super Response> subscriber) {
							Intent intent = new Intent();
							intent.setClassName(context, data.className);
							if (data.data != null) {
								intent.putExtras(data.data);
							}
							intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							context.startActivity(intent);
						}
					});
				}
				return call;
			}
		};
	}

	@Override
	protected RxBaseLaw<Data> createLaw() {
		return new RxBaseLaw<Data>() {
			@Override
			protected RequestParser<Data> createRequestParser() {
				return new RequestParser<Data>() {
					@Override
					public Data parse(Request value) {
						Data data = null;
						if (value != null) {
							data = new Data();
							data.data = value.checkAndGet(Bundle.class);
							Uri uri = value.getUri();
							if (uri != null) {
								data.className = uri.getAuthority();
							}
						}
						return data;
					}
				};
			}
		};
	}
}
