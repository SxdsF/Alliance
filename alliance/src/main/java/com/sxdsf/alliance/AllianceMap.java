package com.sxdsf.alliance;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AllianceMap
 *
 * @author sunbowen
 * @date 2016/4/1-13:25
 * @desc 模块映射保存的类
 */
class AllianceMap {
	final Map<String, Class<? extends Alliance>> allianceClassMap = new ConcurrentHashMap<>();
	final Map<String, Alliance> allianceMap = new ConcurrentHashMap<>();

	void addAlliance(String scheme, Class<? extends Alliance> cls) {
		if (scheme != null && !"".equals(scheme) && cls != null) {
			this.allianceClassMap.put(scheme, cls);
		}
	}

	Alliance getAlliance(String scheme) {
		Alliance alliance = null;
		if (scheme != null && !"".equals(scheme)) {
			synchronized (this) {
				alliance = this.allianceMap.get(scheme);
				if (alliance == null) {
					Class<? extends Alliance> cls = this.allianceClassMap.get(scheme);
					if (cls != null) {
						alliance = this.create(cls);
					}
				}
			}
		}
		return alliance;
	}

	private Alliance create(Class<? extends Alliance> cls) {
		Alliance alliance = null;
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
