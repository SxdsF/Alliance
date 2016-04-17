package com.sxdsf.alliance.sample.whatever;

import com.sxdsf.alliance.core.Call;
import com.sxdsf.alliance.core.Callback;
import com.sxdsf.alliance.core.impl.BaseAlliance;
import com.sxdsf.alliance.core.impl.BaseEnforcer;
import com.sxdsf.alliance.core.impl.BaseLaw;
import com.sxdsf.alliance.core.impl.CallAdapter;
import com.sxdsf.alliance.core.impl.Request;
import com.sxdsf.alliance.core.impl.RequestParser;
import com.sxdsf.alliance.core.impl.Response;
import com.sxdsf.alliance.core.impl.generic.GenericResponse;

/**
 * WhateverService
 *
 * @author Administrator
 * @date 2016/4/7-16:17
 * @desc ${描述类实现的功能}
 */
public class WhateverService extends BaseAlliance<String> {

	@Override
	protected BaseEnforcer<String> createEnforcer() {
		return new BaseEnforcer<String>() {
			@Override
			public Call<Response> enforce(String s) {
				Call<Response> call = null;
				if (s != null) {
					call = new CallAdapter<Response>() {
						@Override
						public void execute(Callback<Response> callback) {
							GenericResponse<String> response = new GenericResponse<>();
							response.setData("WhateverService");
							callback.onNext(response);
						}

						@Override
						public Response execute() {
							GenericResponse<String> response = new GenericResponse<>();
							response.setData("WhateverService");
							return response;
						}
					};
				}
				return call;
			}
		};
	}

	@Override
	protected BaseLaw<String> createLaw() {
		return new BaseLaw<String>() {
			@Override
			protected RequestParser<String> createRequestParser() {
				return new RequestParser<String>() {
					@Override
					public String parse(Request value) {
						return "whatever";
					}
				};
			}
		};
	}
}
