package com.sxdsf.alliance.sample.rxjava.network;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.sxdsf.alliance.core.impl.Response;
import com.sxdsf.alliance.core.impl.generic.GenericResponse;
import com.sxdsf.alliance.rxjava.RxBaseAlliance;
import com.sxdsf.alliance.rxjava.RxBaseEnforcer;
import com.sxdsf.alliance.rxjava.RxBaseLaw;
import com.sxdsf.alliance.sample.AllianceRequest;
import com.sxdsf.alliance.sample.MyApplication;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * RxNetworkService
 *
 * @author sunbowen
 * @date 2016/4/3-11:11
 * @desc 网络服务
 */
public class RxNetworkService extends RxBaseAlliance<String> {

	RequestQueue mQueue = Volley.newRequestQueue(MyApplication.getContext());

	@Override
	protected RxBaseEnforcer<String> createEnforcer() {
		return new RxBaseEnforcer<String>() {
			@Override
			public Observable<Response> enforce(String s) {
				Observable<Response> call = null;
				if (s != null) {
					call = sendRequest(s);
				}
				return call;
			}
		};
	}

	@Override
	protected RxBaseLaw<String> createLaw() {
		return new RxNetworkLaw();
	}

	Observable<Response> sendRequest(final String request) {
		Observable<Response> call = null;
		if (request != null) {
			Observable<Response> memory = Observable.create(new Observable.OnSubscribe<Response>() {
				@Override
				public void call(Subscriber<? super Response> subscriber) {
					subscriber.onNext(null);
					subscriber.onCompleted();
				}
			});
			Observable<Response> disk = Observable.create(new Observable.OnSubscribe<Response>() {
				@Override
				public void call(Subscriber<? super Response> subscriber) {
					subscriber.onNext(null);
					subscriber.onCompleted();
				}
			});

			Observable<Response> network = Observable.create(new Observable.OnSubscribe<Response>() {
				@Override
				public void call(final Subscriber<? super Response> subscriber) {
					AllianceRequest<String> allianceRequest = new AllianceRequest<>(Request.Method.GET, request,
							new com.android.volley.Response.Listener<String>() {
								@Override
								public void onResponse(String response) {
									GenericResponse<String> result = new GenericResponse<>();
									result.setData(response);
									subscriber.onNext(result);
									subscriber.onCompleted();
								}
							}, new com.android.volley.Response.ErrorListener() {
								@Override
								public void onErrorResponse(VolleyError error) {
									subscriber.onError(error);
								}
							});
					mQueue.add(allianceRequest);
				}
			});

			call = Observable.concat(memory, disk, network).first(new Func1<Response, Boolean>() {
				@Override
				public Boolean call(Response s) {
					if (!"memory".equals(s) && !"disk".equals(s)) {
						return true;
					}
					return false;
				}
			}).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
		}
		return call;
	}
}
