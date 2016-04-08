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
	final Map<String, Class<? extends Alliance<Response>>> allianceClassMap = new ConcurrentHashMap<>();
	final Map<String, Alliance<Response>> allianceMap = new ConcurrentHashMap<>();

	void addAlliance(String scheme, Class<? extends Alliance<Response>> cls) {
		if (scheme != null && !"".equals(scheme) && cls != null) {
			this.allianceClassMap.put(scheme, cls);
		}
	}

	Alliance<Response> getAlliance(String scheme) {
		Alliance<Response> alliance = null;
		if (scheme != null && !"".equals(scheme)) {
			synchronized (this) {
				alliance = this.allianceMap.get(scheme);
				if (alliance == null) {
					Class<? extends Alliance<Response>> cls = this.allianceClassMap.get(scheme);
					if (cls != null) {
						alliance = this.create(cls);
					}
				}
			}
		}
		return alliance;
	}

	private Alliance<Response> create(Class<? extends Alliance<Response>> cls) {
		Alliance<Response> alliance = null;
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
