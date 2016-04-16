package com.sxdsf.alliance.rxjava;

import com.sxdsf.alliance.core.impl.Request;
import com.sxdsf.alliance.core.impl.Response;

import rx.Observable;

/**
 * RxBaseAlliance
 *
 * @author Administrator
 * @date 2016/4/16-23:28
 * @desc ${描述类实现的功能}
 */
public abstract class RxBaseAlliance<T> implements RxAlliance<Request,Response> {

    /**
     * 执行者模块
     */
    protected final RxBaseEnforcer<T> enforcer;
    /**
     * 协议模块
     */
    protected final RxBaseLaw<T> law;

    public RxBaseAlliance() {
        this.enforcer = this.createEnforcer();
        this.law = this.createLaw();
    }

    @Override
    public Observable<Response> enforce(Request request) {
        return this.enforcer.enforce(this.law.parser.parse(request));
    }

    /**
     * 执行者模块的创建方法
     *
     * @return
     */
    protected abstract RxBaseEnforcer<T> createEnforcer();

    /**
     * 协议模块的创建方法
     *
     * @return
     */
    protected abstract RxBaseLaw<T> createLaw();

}
