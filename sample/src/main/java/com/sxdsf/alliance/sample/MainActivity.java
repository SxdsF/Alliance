package com.sxdsf.alliance.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sxdsf.alliance.general.impl.CallbackAdapter;
import com.sxdsf.alliance.impl.Request;
import com.sxdsf.alliance.impl.Response;
import com.sxdsf.alliance.sample.network.NetworkRequestBuilder;
import com.sxdsf.alliance.sample.redirect.RedirectRequestBuilder;
import com.sxdsf.alliance.sample.whatever.WhateverRequestBuilder;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

	private TextView redirect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.redirect = (TextView) this.findViewById(R.id.redirect);
		this.redirect.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				// 有数据的情况
				Request rd = new RedirectRequestBuilder("redirect")
						.setTargetClassName("com.sxdsf.alliance.sample.Main2Activity").setData(new Bundle()).build();

				// 没数据的情况
				Request rn = new NetworkRequestBuilder("network").setUrl("www.baidu.com").build();

				Request rw = new WhateverRequestBuilder("whatever").setMessage("whatever").build();

				// 普通版的
				MyApplication.SERVICE_MANAGER.call(rd).execute();
				MyApplication.SERVICE_MANAGER.call(rn).execute(new CallbackAdapter<Response>() {
					@Override
					public void onCompleted() {
						super.onCompleted();
					}

					@Override
					public void onError(Throwable t) {
						super.onError(t);
					}

					@Override
					public void onNext(Response result) {
						super.onNext(result);
					}
				});

				MyApplication.SERVICE_MANAGER.call(rw).execute(new CallbackAdapter<Response>() {
					@Override
					public void onCompleted() {
						super.onCompleted();
					}

					@Override
					public void onError(Throwable t) {
						super.onError(t);
					}

					@Override
					public void onNext(Response result) {
						super.onNext(result);
						if (result != null) {
							String text = result.checkAndGet(String.class);
							System.out.println(text);
						}
					}
				});
				Response response = MyApplication.SERVICE_MANAGER.call(rw).execute();
				System.out.println(response.checkAndGet(String.class));

				// RxJava版的
				MyApplication.RX_SERVICE_MANAGER.call(rd).subscribe();
				MyApplication.RX_SERVICE_MANAGER.call(rn).subscribe(new Subscriber<Response>() {
					@Override
					public void onCompleted() {
						System.out.println("调用完成");
					}

					@Override
					public void onError(Throwable e) {
						System.out.println(e);
					}

					@Override
					public void onNext(Response s) {
						System.out.println(s);
					}
				});
				MyApplication.RX_SERVICE_MANAGER.call(rw).subscribe(new Subscriber<Response>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onNext(Response response) {
						String str = response.checkAndGet(String.class);
						System.out.println(str);
					}
				});
			}
		});
	}
}
