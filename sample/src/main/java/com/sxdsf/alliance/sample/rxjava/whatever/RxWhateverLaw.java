package com.sxdsf.alliance.sample.rxjava.whatever;

import com.sxdsf.alliance.core.impl.Request;
import com.sxdsf.alliance.core.impl.RequestParser;
import com.sxdsf.alliance.rxjava.RxBaseLaw;

/**
 * RxWhateverLaw
 *
 * @author Administrator
 * @date 2016/4/17-0:01
 * @desc ${描述类实现的功能}
 */
public class RxWhateverLaw extends RxBaseLaw<String> {

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
