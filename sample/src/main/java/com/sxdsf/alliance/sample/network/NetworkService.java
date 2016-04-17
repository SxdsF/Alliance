package com.sxdsf.alliance.sample.network;

import android.net.Uri;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.sxdsf.alliance.general.Call;
import com.sxdsf.alliance.general.GeneralAlliance;
import com.sxdsf.alliance.impl.Request;
import com.sxdsf.alliance.impl.Response;
import com.sxdsf.alliance.sample.MyApplication;

/**
 * NetworkService
 *
 * @author sunbowen
 * @date 2016/4/1-15:26
 * @desc 网络服务组件实现类
 */
public class NetworkService extends GeneralAlliance<NetworkData> {

	private final RequestQueue mQueue = Volley.newRequestQueue(MyApplication.getContext());

	Call<Response> sendRequest(NetworkData requestUrl) {
		Call<Response> call = null;
		if (requestUrl != null) {
			call = new NetworkCall(mQueue, requestUrl);
		}
		return call;
	}

	@Override
	protected void onCreate() {
		// do nothing
	}

	@Override
	protected NetworkData onParse(Request request) {
		NetworkData url = new NetworkData();
		if (request != null) {
			Uri uri = request.getUri();
			if (uri != null) {
				url.url = uri.getAuthority();
			}
		}
		return url;
	}

	@Override
	protected Call<Response> onPerform(NetworkData s) {
		return sendRequest(s);
	}
}
