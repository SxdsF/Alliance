package com.sxdsf.alliance.rxjava;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AllianceMap
 *
 * @author sunbowen
 * @date 2016/4/1-13:25
 * @desc 模块映射保存的类
 */
class RxJavaAllianceMap {
	final Map<String, Class<? extends RxJavaAlliance>> allianceClassMap = new ConcurrentHashMap<>();
	final Map<String, RxJavaAlliance> allianceMap = new ConcurrentHashMap<>();

	void addAlliance(String scheme, Class<? extends RxJavaAlliance> cls) {
		if (scheme != null && !"".equals(scheme) && cls != null) {
			this.allianceClassMap.put(scheme, cls);
		}
	}

	RxJavaAlliance getAlliance(String scheme) {
		RxJavaAlliance alliance = null;
		if (scheme != null && !"".equals(scheme)) {
			synchronized (this) {
				alliance = this.allianceMap.get(scheme);
				if (alliance == null) {
					Class<? extends RxJavaAlliance> cls = this.allianceClassMap.get(scheme);
					if (cls != null) {
						alliance = this.create(cls);
					}
				}
			}
		}
		return alliance;
	}

	private RxJavaAlliance create(Class<? extends RxJavaAlliance> cls) {
		RxJavaAlliance alliance = null;
		if (cls != null) {
			try {
				alliance = cls.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return alliance;
	}
}
