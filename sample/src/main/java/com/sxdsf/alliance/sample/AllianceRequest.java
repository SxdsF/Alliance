package com.sxdsf.alliance.sample;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;

/**
 * AllianceRequest
 *
 * @author sunbowen
 * @date 2016/4/3-10:18
 * @desc Request的默认实现
 */
public class AllianceRequest<T> extends Request<T> {

	private final Response.Listener<T> mListener;

	public AllianceRequest(int method, String url, Response.Listener<T> listener, Response.ErrorListener error) {
		super(method, url, error);
		mListener = listener;
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		String str;
		try {
			str = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
		} catch (UnsupportedEncodingException e) {
			str = new String(response.data);
		}
		return Response.success(parse(str), HttpHeaderParser.parseCacheHeaders(response));
	}

	@Override
	protected void deliverResponse(T response) {
		mListener.onResponse(response);
	}

	private T parse(String result) {
		T t = null;
		if (result != null) {
			Gson gson = new Gson();
			t = gson.fromJson(result, new TypeToken<T>() {
			}.getType());
		}
		return t;
	}
}
