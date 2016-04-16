package com.sxdsf.alliance.sample.redirect;

import com.sxdsf.alliance.core.impl.BaseAlliance;
import com.sxdsf.alliance.core.impl.BaseEnforcer;
import com.sxdsf.alliance.core.impl.BaseLaw;

/**
 * RedirectService
 *
 * @author sunbowen
 * @date 2016/4/1-14:08
 * @desc 跳转服务
 */
public class RedirectService extends BaseAlliance<Data> {

	@Override
	protected BaseEnforcer<Data> createEnforcer() {
		return new RedirectEnforcer();
	}

	@Override
	protected BaseLaw<Data> createLaw() {
		return new RedirectLaw();
	}

}
