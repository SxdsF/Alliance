package com.sxdsf.alliance.sample.network;

import android.net.Uri;

import com.sxdsf.alliance.core.impl.BaseLaw;
import com.sxdsf.alliance.core.impl.Request;
import com.sxdsf.alliance.core.impl.RequestParser;

/**
 * NetworkLaw
 *
 * @author Administrator
 * @date 2016/4/16-0:17
 * @desc ${描述类实现的功能}
 */
public class NetworkLaw extends BaseLaw<String> {

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
