package com.sxdsf.alliance.sample;

import android.app.Application;
import android.content.Context;

import com.sxdsf.alliance.AllianceLeader;
import com.sxdsf.alliance.rxjava.RxJavaAllianceLeader;
import com.sxdsf.alliance.sample.rxjava.RxJavaNetworkService;
import com.sxdsf.alliance.sample.rxjava.RxJavaRedirectService;

/**
 * MyApplication
 *
 * @author Administrator
 * @date 2016/3/31-10:31
 * @desc ${描述类实现的功能}
 */
public class MyApplication extends Application {

	public static final AllianceLeader SERVICE_MANAGER = AllianceLeader.getInstance();

	public static final RxJavaAllianceLeader RX_SERVICE_MANAGER = RxJavaAllianceLeader.getInstance();
	private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
		SERVICE_MANAGER.addAlliance("redirect", RedirectService.class);
		SERVICE_MANAGER.addAlliance("network", NetworkService.class);

		RX_SERVICE_MANAGER.addAlliance("redirect", RxJavaRedirectService.class);
		RX_SERVICE_MANAGER.addAlliance("network", RxJavaNetworkService.class);
	}

	public static Context getContext() {
		return context;
	}
}
