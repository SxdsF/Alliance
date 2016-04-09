package com.sxdsf.alliance.sample;

import android.net.Uri;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.sxdsf.alliance.Call;
import com.sxdsf.alliance.FoundationAlliance;
import com.sxdsf.alliance.Request;
import com.sxdsf.alliance.Response;

/**
 * NetworkService
 *
 * @author sunbowen
 * @date 2016/4/1-15:26
 * @desc 网络服务组件实现类
 */
public class NetworkService implements FoundationAlliance<Uri,String> {

	private final RequestQueue mQueue = Volley.newRequestQueue(MyApplication.getContext());

	@Override
	public Call<Response> request(Request request) {
		Call<Response> call = null;
		if (request != null) {
			call = this.sendRequest(request);
		}
		return call;
	}

	Call<Response> sendRequest(Request request) {
		Call<Response> call = null;
		if (request != null) {
			call = new NetworkCall(mQueue, request);
		}
		return call;
	}

	@Override
	public String parse(Uri value) {
		return null;
	}
}
