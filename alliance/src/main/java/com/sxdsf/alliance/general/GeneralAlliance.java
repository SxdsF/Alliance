package com.sxdsf.alliance.general;

import com.sxdsf.alliance.Information;
import com.sxdsf.alliance.impl.Request;
import com.sxdsf.alliance.impl.Response;
import com.sxdsf.alliance.impl.UniversalAlliance;

/**
 * GeneralAlliance
 *
 * @author sunbowen
 * @date 2016/4/17-22:11
 * @desc 普通的Alliance接口，区别于RxAlliance
 */
public abstract class GeneralAlliance<T extends Information> extends UniversalAlliance<T, Request, Call<Response>> {
}
