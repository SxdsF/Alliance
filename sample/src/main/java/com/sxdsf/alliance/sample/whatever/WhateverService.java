package com.sxdsf.alliance.sample.whatever;

import com.sxdsf.alliance.general.Call;
import com.sxdsf.alliance.general.Callback;
import com.sxdsf.alliance.general.GeneralAlliance;
import com.sxdsf.alliance.general.impl.CallAdapter;
import com.sxdsf.alliance.impl.Request;
import com.sxdsf.alliance.impl.Response;
import com.sxdsf.alliance.impl.generic.GenericResponse;

/**
 * WhateverService
 *
 * @author sunbowen
 * @date 2016/4/7-16:17
 * @desc whatever服务组件的实现类
 */
public class WhateverService extends GeneralAlliance<WhateverData> {

	@Override
	protected void onCreate() {
		// do nothing
	}

	@Override
	protected WhateverData onParse(Request request) {
		WhateverData data = new WhateverData();
		data.message = "whatever";
		return data;
	}

	@Override
	protected Call<Response> onPerform(WhateverData s) {
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
}
