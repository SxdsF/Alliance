package com.sxdsf.alliance.sample.rxjava.network;

import android.net.Uri;

import com.sxdsf.alliance.core.impl.Request;
import com.sxdsf.alliance.core.impl.RequestParser;
import com.sxdsf.alliance.rxjava.RxBaseLaw;

/**
 * RxNetworkLaw
 *
 * @author Administrator
 * @date 2016/4/16-23:51
 * @desc ${描述类实现的功能}
 */
public class RxNetworkLaw extends RxBaseLaw<String> {

	@Override
	protected RequestParser<String> createRequestParser() {
		return new RequestParser<String>() {
			@Override
			public String parse(Request value) {
				String url = null;
				if (value != null) {
					Uri uri = value.getUri();
					if (uri != null) {
						url = uri.getAuthority();
					}
				}
				return url;
			}
		};
	}
}
