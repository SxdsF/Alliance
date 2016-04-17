package com.sxdsf.alliance.sample.rx;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * NetworkService
 *
 * @author Administrator
 * @date 2016/4/6-10:39
 * @desc ${描述类实现的功能}
 */
public interface NetworkService {
	@GET("www.baidu.com")
	Observable<String> getBaiduHost();

	@GET("www.baidu.com")
	Call<String> getBaidu();
}
