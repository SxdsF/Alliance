package com.sxdsf.alliance.sample;

import android.app.Application;
import android.content.Context;

import com.sxdsf.alliance.AllianceLeader;

/**
 * MyApplication
 *
 * @author Administrator
 * @date 2016/3/31-10:31
 * @desc ${描述类实现的功能}
 */
public class MyApplication extends Application {

	public static final AllianceLeader SERVICE_MANAGER = AllianceLeader.getInstance();
	private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
		SERVICE_MANAGER.addAlliance("redirect", RedirectService.class);
	}

	public static Context getContext() {
		return context;
	}
}
