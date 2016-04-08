package com.sxdsf.alliance.sample;

import android.app.Application;
import android.content.Context;

import com.sxdsf.alliance.AllianceLeader;
import com.sxdsf.alliance.rxjava.RxAllianceLeader;
import com.sxdsf.alliance.sample.rxjava.RxNetworkService;
import com.sxdsf.alliance.sample.rxjava.RxRedirectService;
import com.sxdsf.alliance.sample.rxjava.RxWhateverService;

/**
 * MyApplication
 *
 * @author Administrator
 * @date 2016/3/31-10:31
 * @desc ${描述类实现的功能}
 */
public class MyApplication extends Application {

	public static final AllianceLeader SERVICE_MANAGER = AllianceLeader.getInstance();

	public static final RxAllianceLeader RX_SERVICE_MANAGER = RxAllianceLeader.getInstance();
	private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
		SERVICE_MANAGER.addAlliance("redirect", RedirectService.class);
		SERVICE_MANAGER.addAlliance("network", NetworkService.class);
		SERVICE_MANAGER.addAlliance("whatever", WhateverService.class);

		RX_SERVICE_MANAGER.addAlliance("redirect", RxRedirectService.class);
		RX_SERVICE_MANAGER.addAlliance("network", RxNetworkService.class);
		RX_SERVICE_MANAGER.addAlliance("whatever", RxWhateverService.class);
	}

	public static Context getContext() {
		return context;
	}
}
