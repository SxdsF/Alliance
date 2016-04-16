package com.sxdsf.alliance.sample.rxjava.redirect;

import android.net.Uri;
import android.os.Bundle;

import com.sxdsf.alliance.core.impl.Request;
import com.sxdsf.alliance.core.impl.RequestParser;
import com.sxdsf.alliance.rxjava.RxBaseLaw;

/**
 * RxRedirectLaw
 *
 * @author Administrator
 * @date 2016/4/16-23:47
 * @desc ${描述类实现的功能}
 */
public class RxRedirectLaw extends RxBaseLaw<Data> {

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
}
