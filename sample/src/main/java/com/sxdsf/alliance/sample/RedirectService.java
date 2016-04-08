package com.sxdsf.alliance.sample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.sxdsf.alliance.Call;
import com.sxdsf.alliance.CallAdapter;
import com.sxdsf.alliance.FoundationAlliance;
import com.sxdsf.alliance.Request;
import com.sxdsf.alliance.Response;

/**
 * RedirectService
 *
 * @author sunbowen
 * @date 2016/4/1-14:08
 * @desc 跳转服务
 */
public class RedirectService implements FoundationAlliance<Uri,String> {

	private final Context context = MyApplication.getContext();

	@Override
	public <Y> Call<Response> request(final Request<Y> request) {
		Call<Response> call = null;
		if (request != null) {
			call = new CallAdapter<Response>() {
				@Override
				public Response execute() {
					// 还有一种策略是用Action
					Uri uri = request.getUri();
					if (uri != null) {
						String clsName = uri.getHost();
						Intent intent = new Intent();
						intent.setClassName(context, clsName);
						if (request.getData() != null && request.getData() instanceof Bundle) {
							intent.putExtras((Bundle) request.getData());
						}
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						context.startActivity(intent);
					}
					return super.execute();
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
