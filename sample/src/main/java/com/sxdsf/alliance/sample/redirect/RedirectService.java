package com.sxdsf.alliance.sample.redirect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.sxdsf.alliance.general.Call;
import com.sxdsf.alliance.general.GeneralAlliance;
import com.sxdsf.alliance.general.impl.CallAdapter;
import com.sxdsf.alliance.impl.Request;
import com.sxdsf.alliance.impl.Response;
import com.sxdsf.alliance.sample.MyApplication;

/**
 * RedirectService
 *
 * @author sunbowen
 * @date 2016/4/1-14:08
 * @desc 跳转服务
 */
public class RedirectService extends GeneralAlliance<RedirectData> {

	private final Context context = MyApplication.getContext();

	@Override
	protected void onCreate() {
		// do nothing
	}

	@Override
	protected RedirectData onParse(Request request) {
		RedirectData redirectData = null;
		if (request != null) {
			redirectData = new RedirectData();
			redirectData.data = request.checkAndGet(Bundle.class);
			Uri uri = request.getUri();
			if (uri != null) {
				redirectData.className = uri.getAuthority();
			}
		}
		return redirectData;
	}

	@Override
	protected Call<Response> onPerform(final RedirectData redirectData) {
		Call<Response> call = null;
		if (redirectData != null) {
			call = new CallAdapter<Response>() {
				@Override
				public Response execute() {
					// 还有一种策略是用Action
					Intent intent = new Intent();
					intent.setClassName(context, redirectData.className);
					if (redirectData.data != null) {
						intent.putExtras(redirectData.data);
					}
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent);
					return super.execute();
				}
			};
		}
		return call;
	}
}
