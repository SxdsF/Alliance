package com.sxdsf.alliance.rx.router;

import com.sxdsf.alliance.Information;
import com.sxdsf.alliance.rx.RxAlliance;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AllianceMap
 *
 * @author sunbowen
 * @date 2016/4/1-13:25
 * @desc 模块映射保存的类
 */
class RxAllianceMap {
	final Map<String, Class<? extends RxAlliance<Information>>> allianceClassMap = new ConcurrentHashMap<>();
	final Map<String, RxAlliance<Information>> allianceMap = new ConcurrentHashMap<>();

	RxAlliance<Information> getAlliance(String scheme) {
		RxAlliance<Information> alliance = null;
		if (scheme != null && !"".equals(scheme)) {
			synchronized (this) {
				alliance = this.allianceMap.get(scheme);
				if (alliance == null) {
					Class<? extends RxAlliance<Information>> cls = this.allianceClassMap.get(scheme);
					if (cls != null) {
						alliance = this.create(cls);
					}
				}
			}
		}
		return alliance;
	}

	private RxAlliance<Information> create(Class<? extends RxAlliance<Information>> cls) {
		RxAlliance<Information> alliance = null;
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
