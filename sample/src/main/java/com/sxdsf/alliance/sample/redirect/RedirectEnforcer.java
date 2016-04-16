package com.sxdsf.alliance.sample.redirect;

import android.content.Context;
import android.content.Intent;

import com.sxdsf.alliance.core.Call;
import com.sxdsf.alliance.core.impl.BaseEnforcer;
import com.sxdsf.alliance.core.impl.CallAdapter;
import com.sxdsf.alliance.core.impl.Response;
import com.sxdsf.alliance.sample.MyApplication;

/**
 * RedirectEnforcer
 *
 * @author Administrator
 * @date 2016/4/15-17:32
 * @desc ${描述类实现的功能}
 */
public class RedirectEnforcer extends BaseEnforcer<Data> {

	private final Context context = MyApplication.getContext();

	@Override
	public Call<Response> enforce(final Data request) {
		Call<Response> call = null;
		if (request != null) {
			call = new CallAdapter<Response>() {
				@Override
				public Response execute() {
					// 还有一种策略是用Action
					Intent intent = new Intent();
					intent.setClassName(context, request.className);
					if (request.data != null) {
						intent.putExtras(request.data);
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
