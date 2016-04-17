package com.sxdsf.alliance.rx;

import android.content.res.XmlResourceParser;

import com.sxdsf.alliance.Alliance;
import com.sxdsf.alliance.impl.Request;
import com.sxdsf.alliance.impl.Response;
import com.sxdsf.alliance.rx.router.RxRouteService;

import java.util.concurrent.atomic.AtomicBoolean;

import rx.Observable;

/**
 * AllianceLeader
 *
 * @author sunbowen
 * @date 2016/3/30-20:34
 * @desc 路由跳转入口总管类
 */
public class RxAllianceLeader implements Alliance<Request, Observable<Response>> {

	private final RxRouteService router;
	private final AtomicBoolean initialized = new AtomicBoolean(false);

	private RxAllianceLeader() {
		this.router = new RxRouteService();
	}

	@Override
	public Observable<Response> call(Request request) {
		return this.router.call(request);
	}

	private static class InstanceHolder {
		private static RxAllianceLeader INSTANCE = new RxAllianceLeader();
	}

	public static RxAllianceLeader getInstance() {
		return InstanceHolder.INSTANCE;
	}

	public void initialize(XmlResourceParser xrp) {
		// 服务管理器初始化，实际上是调用RouteService的初始化去加载服务配置文件
		if (this.initialized.compareAndSet(false, true)) {
			this.router.initialize(xrp);
		}
	}

	public boolean isInitialized() {
		return this.initialized.get();
	}
}
