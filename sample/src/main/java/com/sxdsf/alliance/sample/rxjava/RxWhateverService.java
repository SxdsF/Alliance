package com.sxdsf.alliance.sample.rxjava;

import android.net.Uri;

import com.sxdsf.alliance.GenericResponse;
import com.sxdsf.alliance.Request;
import com.sxdsf.alliance.Response;
import com.sxdsf.alliance.rxjava.RxFoundationAlliance;

import rx.Observable;
import rx.Subscriber;

/**
 * RxWhateverService
 *
 * @author Administrator
 * @date 2016/4/8-14:47
 * @desc ${描述类实现的功能}
 */
public class RxWhateverService implements RxFoundationAlliance<Uri, String> {
	@Override
	public String parse(Uri value) {
		return null;
	}

	@Override
	public Observable<Response> call(Request request) {
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
}
