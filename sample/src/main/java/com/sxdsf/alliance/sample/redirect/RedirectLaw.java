package com.sxdsf.alliance.sample.redirect;

import android.net.Uri;
import android.os.Bundle;

import com.sxdsf.alliance.core.impl.BaseLaw;
import com.sxdsf.alliance.core.impl.Request;
import com.sxdsf.alliance.core.impl.RequestParser;

/**
 * RedirectLaw
 *
 * @author Administrator
 * @date 2016/4/15-17:32
 * @desc ${描述类实现的功能}
 */
public class RedirectLaw extends BaseLaw<Data> {

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
