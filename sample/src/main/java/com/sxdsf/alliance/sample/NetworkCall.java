package com.sxdsf.alliance.sample;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sxdsf.alliance.CallAdapter;
import com.sxdsf.alliance.Callback;
import com.sxdsf.alliance.GenericResponse;

import java.util.UUID;

/**
 * NetworkCall
 *
 * @author Administrator
 * @date 2016/4/6-11:01
 * @desc ${描述类实现的功能}
 */
public class NetworkCall extends CallAdapter<com.sxdsf.alliance.Response> {

    private final RequestQueue mQueue;
    private final com.sxdsf.alliance.Request mRequest;

    private final UUID id = UUID.randomUUID();

    private volatile boolean canceled;
    private boolean executed;

    public NetworkCall(RequestQueue queue, com.sxdsf.alliance.Request request) {
        mQueue = queue;
        mRequest = request;
    }

    @Override
    public void execute(final Callback<com.sxdsf.alliance.Response> callback) {
        AllianceRequest<String> request = new AllianceRequest<>(Request.Method.GET, mRequest.getUri().toString(),
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
