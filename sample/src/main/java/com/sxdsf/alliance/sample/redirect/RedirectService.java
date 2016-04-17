package com.sxdsf.alliance.sample.redirect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.sxdsf.alliance.core.Call;
import com.sxdsf.alliance.core.impl.BaseAlliance;
import com.sxdsf.alliance.core.impl.BaseEnforcer;
import com.sxdsf.alliance.core.impl.BaseLaw;
import com.sxdsf.alliance.core.impl.CallAdapter;
import com.sxdsf.alliance.core.impl.Request;
import com.sxdsf.alliance.core.impl.RequestParser;
import com.sxdsf.alliance.core.impl.Response;
import com.sxdsf.alliance.sample.MyApplication;

/**
 * RedirectService
 *
 * @author sunbowen
 * @date 2016/4/1-14:08
 * @desc 跳转服务
 */
public class RedirectService extends BaseAlliance<Data> {

	private final Context context = MyApplication.getContext();

	@Override
	protected BaseEnforcer<Data> createEnforcer() {
		return new BaseEnforcer<Data>() {
			@Override
			public Call<Response> enforce(final Data data) {
				Call<Response> call = null;
				if (data != null) {
					call = new CallAdapter<Response>() {
						@Override
						public Response execute() {
							// 还有一种策略是用Action
							Intent intent = new Intent();
							intent.setClassName(context, data.className);
							if (data.data != null) {
								intent.putExtras(data.data);
							}
							intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							context.startActivity(intent);
							return super.execute();
						}
					};
				}
				return call;
			}
		};
	}

	@Override
	protected BaseLaw<Data> createLaw() {
		return new BaseLaw<Data>() {
			@Override
			protected RequestParser<Data> createRequestParser() {
				return new RequestParser<Data>() {
					@Override
					public Data parse(Request value) {
						Data data = null;
						if (value != null) {
							data = new Data();
							data.data = value.checkAndGet(Bundle.class);
							Uri uri = value.getUri();
							if (uri != null) {
								data.className = uri.getAuthority();
							}
						}
						return data;
					}
				};
			}
		};
	}
}
