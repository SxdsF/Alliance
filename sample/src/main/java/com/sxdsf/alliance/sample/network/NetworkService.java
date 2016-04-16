package com.sxdsf.alliance.sample.network;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.sxdsf.alliance.core.Call;
import com.sxdsf.alliance.core.impl.BaseAlliance;
import com.sxdsf.alliance.core.impl.BaseEnforcer;
import com.sxdsf.alliance.core.impl.BaseLaw;
import com.sxdsf.alliance.core.impl.Response;
import com.sxdsf.alliance.sample.MyApplication;

/**
 * NetworkService
 *
 * @author sunbowen
 * @date 2016/4/1-15:26
 * @desc 网络服务组件实现类
 */
public class NetworkService extends BaseAlliance<String> {

	private final RequestQueue mQueue = Volley.newRequestQueue(MyApplication.getContext());

	@Override
	protected BaseEnforcer<String> createEnforcer() {
		return new BaseEnforcer<String>() {
			@Override
			public Call<Response> enforce(String s) {
				return sendRequest(s);
			}
		};
	}

	@Override
	protected BaseLaw<String> createLaw() {
		return new NetworkLaw();
	}

	Call<Response> sendRequest(String requestUrl) {
		Call<Response> call = null;
		if (requestUrl != null) {
			call = new NetworkCall(mQueue, requestUrl);
		}
		return call;
	}
}
