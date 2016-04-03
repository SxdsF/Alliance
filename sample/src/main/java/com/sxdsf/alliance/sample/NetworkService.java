package com.sxdsf.alliance.sample;

import android.net.Uri;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.sxdsf.alliance.Alliance;
import com.sxdsf.alliance.Call;
import com.sxdsf.alliance.CallAdapter;
import com.sxdsf.alliance.Callback;

/**
 * NetworkService
 *
 * @author sunbowen
 * @date 2016/4/1-15:26
 * @desc 网络服务组件实现类
 */
public class NetworkService implements Alliance {

	RequestQueue mQueue = Volley.newRequestQueue(MyApplication.getContext());

	@Override
	public <T> Call<T> request(Uri uri) {
		Call<T> call = null;
		if (uri != null) {
			call = this.sendRequest(uri);
		}
		return call;
	}

	<T> Call<T> sendRequest(Uri uri) {
		Call<T> call = null;
		if (uri != null) {
			call = new CallAdapter<T>() {
				@Override
				public void execute(final Callback<T> callback, Class<T> cls) {
					AllianceRequest<T> request = new AllianceRequest<>(Request.Method.GET, "http://www.baidu.com", cls,
							new Response.Listener<T>() {
								@Override
								public void onResponse(T response) {
									callback.onSuccess(response);
								}
							}, new Response.ErrorListener() {
								@Override
								public void onErrorResponse(VolleyError error) {
									callback.onError(error);
								}
							});
					mQueue.add(request);
				}
			};
		}
		return call;
	}
}
