package com.sxdsf.alliance.sample.rxjava.whatever;

import com.sxdsf.alliance.core.impl.Response;
import com.sxdsf.alliance.core.impl.generic.GenericResponse;
import com.sxdsf.alliance.rxjava.RxBaseAlliance;
import com.sxdsf.alliance.rxjava.RxBaseEnforcer;
import com.sxdsf.alliance.rxjava.RxBaseLaw;
import com.sxdsf.alliance.sample.rxjava.network.RxNetworkLaw;

import rx.Observable;
import rx.Subscriber;

/**
 * RxWhateverService
 *
 * @author Administrator
 * @date 2016/4/8-14:47
 * @desc ${描述类实现的功能}
 */
public class RxWhateverService extends RxBaseAlliance<String> {

	@Override
	protected RxBaseEnforcer<String> createEnforcer() {
		return new RxBaseEnforcer<String>() {
			@Override
			public Observable<Response> enforce(String s) {
				return Observable.create(new Observable.OnSubscribe<Response>() {
					@Override
					public void call(Subscriber<? super Response> subscriber) {
						GenericResponse<String> response = new GenericResponse<>();
						response.setData("RxWhateverService");
						subscriber.onNext(response);
						subscriber.onCompleted();
					}
				});
			}
		};
	}

	@Override
	protected RxBaseLaw<String> createLaw() {
		return new RxNetworkLaw();
	}
}
