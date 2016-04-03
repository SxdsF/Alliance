package com.sxdsf.alliance.sample.rxjava;

import android.net.Uri;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.sxdsf.alliance.rxjava.RxJavaAllianceAdapter;
import com.sxdsf.alliance.sample.AllianceRequest;
import com.sxdsf.alliance.sample.MyApplication;

import rx.Observable;
import rx.Subscriber;

/**
 * RxJavaNetworkService
 *
 * @author sunbowen
 * @date 2016/4/3-11:11
 * @desc 网络服务
 */
public class RxJavaNetworkService extends RxJavaAllianceAdapter {

	RequestQueue mQueue = Volley.newRequestQueue(MyApplication.getContext());

	@Override
	public <T> Observable<T> request(Uri uri, Class<T> callbackCls) {
		Observable<T> call = null;
		if (uri != null) {
			call = this.sendRequest(uri, callbackCls);
		}
		return call;
	}

	<T> Observable<T> sendRequest(Uri uri, final Class<T> cls) {
		Observable<T> call = null;
		if (uri != null) {
			call = Observable.create(new Observable.OnSubscribe<T>() {
				@Override
				public void call(final Subscriber<? super T> subscriber) {
					AllianceRequest<T> request = new AllianceRequest<>(Request.Method.GET, "http://www.baidu.com", cls,
							new Response.Listener<T>() {
								@Override
								public void onResponse(T response) {
									subscriber.onNext(response);
									subscriber.onCompleted();
								}
							}, new Response.ErrorListener() {
								@Override
								public void onErrorResponse(VolleyError error) {
									subscriber.onError(error);
								}
							});
					mQueue.add(request);
				}
			});
		}
		return call;
	}
}
