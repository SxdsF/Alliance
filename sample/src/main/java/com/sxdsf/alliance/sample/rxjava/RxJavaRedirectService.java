package com.sxdsf.alliance.sample.rxjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.sxdsf.alliance.rxjava.RxJavaAllianceAdapter;
import com.sxdsf.alliance.sample.MyApplication;

import rx.Observable;
import rx.Subscriber;

/**
 * RxJavaRedirectService
 *
 * @author sunbowen
 * @date 2016/4/3-11:10
 * @desc 跳转服务
 */
public class RxJavaRedirectService extends RxJavaAllianceAdapter {

	private final Context context = MyApplication.getContext();

	@Override
	public <T> Observable<T> request(final Uri uri) {
		Observable<T> call = null;
		if (uri != null) {
			call = Observable.create(new Observable.OnSubscribe<T>() {
				@Override
				public void call(Subscriber<? super T> subscriber) {
					String clsName = uri.getHost();
					Intent intent = new Intent();
					intent.setClassName(context, clsName);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent);
				}
			});
		}
		return call;
	}
}
