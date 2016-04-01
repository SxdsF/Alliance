package com.sxdsf.alliance;

import android.net.Uri;

/**
 * Alliance
 *
 * @author sunbowen
 * @date 2016/3/30-20:31
 * @desc 模块接口
 */
public interface Alliance {
	<T> Call<T> request(Uri uri);
}
