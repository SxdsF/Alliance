package com.sxdsf.alliance.sample.rxjava.redirect;

import com.sxdsf.alliance.rxjava.RxBaseAlliance;
import com.sxdsf.alliance.rxjava.RxBaseEnforcer;
import com.sxdsf.alliance.rxjava.RxBaseLaw;

/**
 * RxRedirectService
 *
 * @author sunbowen
 * @date 2016/4/3-11:10
 * @desc 跳转服务
 */
public class RxRedirectService extends RxBaseAlliance<Data> {

	@Override
	protected RxBaseEnforcer<Data> createEnforcer() {
		return new RxRedirectEnforcer();
	}

	@Override
	protected RxBaseLaw<Data> createLaw() {
		return new RxRedirectLaw();
	}
}
