package com.sxdsf.alliance.impl;

import android.net.Uri;

import com.sxdsf.alliance.DataInformation;

/**
 * Request
 *
 * @author sunbowen
 * @date 2016/4/6-16:56
 * @desc 请求参数的实体类
 */
public abstract class Request implements DataInformation {

    private Uri uri;

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
