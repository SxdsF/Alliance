package com.sxdsf.alliance.general.router;

import com.sxdsf.alliance.Information;
import com.sxdsf.alliance.general.GeneralAlliance;

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
	final Map<String, Class<? extends GeneralAlliance<Information>>> allianceClassMap = new ConcurrentHashMap<>();
	final Map<String, GeneralAlliance<Information>> allianceMap = new ConcurrentHashMap<>();

	GeneralAlliance<Information> getAlliance(String scheme) {
		GeneralAlliance<Information> alliance = null;
		if (scheme != null && !"".equals(scheme)) {
			synchronized (this) {
				alliance = this.allianceMap.get(scheme);
				if (alliance == null) {
					Class<? extends GeneralAlliance<Information>> cls = this.allianceClassMap.get(scheme);
					if (cls != null) {
						alliance = this.create(cls);
					}
				}
			}
		}
		return alliance;
	}

	private GeneralAlliance<Information> create(Class<? extends GeneralAlliance<Information>> cls) {
		GeneralAlliance<Information> alliance = null;
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
