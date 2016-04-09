package com.sxdsf.alliance.rxjava;

import com.sxdsf.alliance.Request;
import com.sxdsf.alliance.Response;

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
    final Map<String, Class<? extends RxAlliance<Request, Response>>> allianceClassMap = new ConcurrentHashMap<>();
    final Map<String, RxAlliance<Request, Response>> allianceMap = new ConcurrentHashMap<>();

    RxAlliance<Request, Response> getAlliance(String scheme) {
        RxAlliance<Request, Response> alliance = null;
        if (scheme != null && !"".equals(scheme)) {
            synchronized (this) {
                alliance = this.allianceMap.get(scheme);
                if (alliance == null) {
                    Class<? extends RxAlliance<Request, Response>> cls = this.allianceClassMap.get(scheme);
                    if (cls != null) {
                        alliance = this.create(cls);
                    }
                }
            }
        }
        return alliance;
    }

    private RxAlliance<Request, Response> create(Class<? extends RxAlliance<Request, Response>> cls) {
        RxAlliance<Request, Response> alliance = null;
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
