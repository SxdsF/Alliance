package com.sxdsf.alliance.sample;

import android.net.Uri;

import com.sxdsf.alliance.Call;
import com.sxdsf.alliance.CallAdapter;
import com.sxdsf.alliance.Callback;
import com.sxdsf.alliance.FoundationAlliance;
import com.sxdsf.alliance.GenericResponse;
import com.sxdsf.alliance.Request;
import com.sxdsf.alliance.Response;

/**
 * WhateverService
 *
 * @author Administrator
 * @date 2016/4/7-16:17
 * @desc ${描述类实现的功能}
 */
public class WhateverService implements FoundationAlliance<Uri, String> {
    @Override
    public Call<Response> request(final Request request) {
        Call<Response> call = null;
        if (request != null) {
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

    @Override
    public String parse(Uri value) {
        return null;
    }
}
