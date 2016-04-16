package com.sxdsf.alliance.sample.whatever;

import com.sxdsf.alliance.core.impl.BaseLaw;
import com.sxdsf.alliance.core.impl.Request;
import com.sxdsf.alliance.core.impl.RequestParser;

/**
 * WhateverLaw
 *
 * @author Administrator
 * @date 2016/4/16-0:27
 * @desc ${描述类实现的功能}
 */
public class WhateverLaw extends BaseLaw<String> {

	@Override
	protected RequestParser<String> createRequestParser() {
		return new RequestParser<String>() {
			@Override
			public String parse(Request value) {
				return "whatever";
			}
		};
	}
}
