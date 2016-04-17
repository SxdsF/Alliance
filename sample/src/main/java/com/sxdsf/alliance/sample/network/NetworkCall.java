package com.sxdsf.alliance.sample.network;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sxdsf.alliance.general.Callback;
import com.sxdsf.alliance.general.impl.CallAdapter;
import com.sxdsf.alliance.impl.generic.GenericResponse;
import com.sxdsf.alliance.sample.AllianceRequest;

import java.util.UUID;

/**
 * NetworkCall
 *
 * @author sunbowen
 * @date 2016/4/6-11:01
 * @desc 网络服务对应的call
 */
public class NetworkCall extends CallAdapter<com.sxdsf.alliance.impl.Response> {

	private final RequestQueue mQueue;
	private final NetworkData mRequest;

	private final UUID id = UUID.randomUUID();

	private volatile boolean canceled;
	private boolean executed;

	public NetworkCall(RequestQueue queue, NetworkData request) {
		mQueue = queue;
		mRequest = request;
	}

	@Override
	public void execute(final Callback<com.sxdsf.alliance.impl.Response> callback) {
		AllianceRequest<String> request = new AllianceRequest<>(Request.Method.GET, mRequest.url,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						GenericResponse<String> result = new GenericResponse<>();
						result.setData(response);
						callback.onNext(result);
						callback.onCompleted();
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						callback.onError(error);
					}
				});
		request.setTag(id);
		synchronized (this) {
			if (executed) {
				return;
			}
			executed = true;
		}
		if (!canceled) {
			synchronized (this) {
				if (!canceled) {
					mQueue.add(request);
				}
			}
		}
	}

	@Override
	public boolean isExecuted() {
		return executed;
	}

	@Override
	public void cancel() {
		canceled = true;
		synchronized (this) {
			mQueue.cancelAll(id);
		}
	}

	@Override
	public boolean isCanceled() {
		return canceled;
	}
}
