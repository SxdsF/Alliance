package com.sxdsf.alliance.sample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sxdsf.alliance.CallbackAdapter;
import com.sxdsf.alliance.Request;
import com.sxdsf.alliance.RequestBuilder;
import com.sxdsf.alliance.Response;

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
				RequestBuilder<Bundle> rbr = new RequestBuilder<>();
				Request<Bundle> rd = rbr.setUri(Uri.parse("redirect://com.sxdsf.alliance.sample.Main2Activity"))
						.setData(new Bundle()).build();

				RequestBuilder<Object> rbn = new RequestBuilder<>();
				Request<Object> rn = rbn.setUri(Uri.parse("network://index")).build();

				RequestBuilder<Object> rbw = new RequestBuilder<>();
				Request<Object> rw = rbw.setUri(Uri.parse("whatever://index")).build();

				// 普通版的
				MyApplication.SERVICE_MANAGER.request(rd).execute();
				MyApplication.SERVICE_MANAGER.request(rn).execute(new CallbackAdapter<Response>() {
					@Override
					public void onSuccess(Response result) {
						String str = result.checkAndGet(String.class);
					}

					@Override
					public void onFinish() {
						System.out.println("调用完成");
					}

					@Override
					public void onError(Throwable t) {
						System.out.println("调用失败" + t);
					}
				});

				MyApplication.SERVICE_MANAGER.request(rw).execute(new CallbackAdapter<Response>() {
					@Override
					public void onSuccess(Response result) {
						String str = result.checkAndGet(String.class);
						System.out.println(str);
					}

					@Override
					public void onError(Throwable t) {
						super.onError(t);
					}

					@Override
					public void onFinish() {
						super.onFinish();
					}

					@Override
					public void onProgress(int progress, int total) {
						super.onProgress(progress, total);
					}
				});
				Response response = MyApplication.SERVICE_MANAGER.request(rw).execute();
				System.out.println(response.checkAndGet(String.class));

				// RxJava版的
				MyApplication.RX_SERVICE_MANAGER.request(rd).subscribe();
				MyApplication.RX_SERVICE_MANAGER.request(rn).subscribe(new Subscriber<Response>() {
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
				MyApplication.RX_SERVICE_MANAGER.request(rw).subscribe(new Subscriber<Response>() {
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
