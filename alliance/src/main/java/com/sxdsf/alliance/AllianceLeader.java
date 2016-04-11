package com.sxdsf.alliance;

import android.content.res.XmlResourceParser;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * AllianceLeader
 *
 * @author sunbowen
 * @date 2016/3/30-20:34
 * @desc 请求的入口类，所有的请求调用此类发出，此类中有路由服务，会跳转到相应的服务去执行
 */
public final class AllianceLeader implements Alliance<Request, Response> {

    private final RouteService router;
    private final AtomicBoolean initialized = new AtomicBoolean(false);

    private AllianceLeader() {
        this.router = new RouteService();
    }

    private static class InstanceHolder {
        private static AllianceLeader INSTANCE = new AllianceLeader();
    }

    public static AllianceLeader getInstance() {
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

    @Override
    public Call<Response> call(Request request) {
        return this.router.call(request);
    }
}
