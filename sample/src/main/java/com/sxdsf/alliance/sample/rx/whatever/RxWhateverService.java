package com.sxdsf.alliance.sample.rx.whatever;

import com.sxdsf.alliance.impl.Request;
import com.sxdsf.alliance.impl.Response;
import com.sxdsf.alliance.impl.generic.GenericResponse;
import com.sxdsf.alliance.rx.RxAlliance;

import rx.Observable;
import rx.Subscriber;

/**
 * RxWhateverService
 *
 * @author sunbowen
 * @date 2016/4/8-14:47
 * @desc whatever服务组件实现类
 */
public class RxWhateverService extends RxAlliance<RxWhateverData> {

	@Override
	protected void onCreate() {
		// do nothing
	}

	@Override
	protected RxWhateverData onParse(Request request) {
		RxWhateverData data = new RxWhateverData();
		data.message = "whatever";
		return data;
	}

	@Override
	protected Observable<Response> onPerform(RxWhateverData rxWhateverData) {
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
