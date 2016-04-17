package com.sxdsf.alliance.sample.rx;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * NetworkServiceImpl
 *
 * @author Administrator
 * @date 2016/4/6-10:41
 * @desc ${描述类实现的功能}
 */
public class NetworkServiceImpl implements NetworkService {

	private static final String ROOT = "www.baidu.com";
	private final NetworkService service;

	private NetworkServiceImpl() {
		Retrofit rest = new Retrofit.Builder().baseUrl(ROOT).addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
		this.service = rest.create(NetworkService.class);
	}

	private static class InstanceHolder {
		private static final NetworkService INSTANCE = new NetworkServiceImpl();
	}

	public static NetworkService getInstance() {
		return InstanceHolder.INSTANCE;
	}

	@Override
	public Observable<String> getBaiduHost() {
		return this.service.getBaiduHost();
	}

	@Override
	public Call<String> getBaidu() {
		return null;
	}
}
