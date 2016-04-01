package com.sxdsf.alliance.sample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.sxdsf.alliance.Alliance;
import com.sxdsf.alliance.Call;
import com.sxdsf.alliance.CallAdapter;

/**
 * RedirectService
 *
 * @author sunbowen
 * @date 2016/4/1-14:08
 * @desc 跳转服务
 */
public class RedirectService implements Alliance {

	private final Context context = MyApplication.getContext();

	@Override
	public <T> Call<T> request(final Uri uri) {
		Call<T> call = null;
		if (uri != null) {
			call = new CallAdapter<T>() {
				@Override
				public void execute() {
					String clsName = uri.getHost();
					Intent intent = new Intent();
					intent.setClassName(context, clsName);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent);
				}
			};
		}
		return call;
	}
}
