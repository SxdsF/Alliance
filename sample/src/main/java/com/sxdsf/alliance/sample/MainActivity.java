package com.sxdsf.alliance.sample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sxdsf.alliance.CallbackAdapter;

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
				Uri uri = Uri.parse("redirect://com.sxdsf.alliance.sample.Main2Activity");
				Uri net = Uri.parse("network://index");

				// 普通版的
				MyApplication.SERVICE_MANAGER.request(uri).execute();
				MyApplication.SERVICE_MANAGER.<String> request(net).execute(new CallbackAdapter<String>() {
					@Override
					public void onSuccess(String result) {
						System.out.println(result);
					}

					@Override
					public void onFinish() {
						System.out.println("调用完成");
					}

					@Override
					public void onError(Throwable t) {
						System.out.println("调用失败" + t);
					}
				}, String.class);

				// RxJava版的
				MyApplication.RX_SERVICE_MANAGER.request(uri).subscribe();
				MyApplication.RX_SERVICE_MANAGER.request(uri, String.class).subscribe(new Subscriber<String>() {
					@Override
					public void onCompleted() {
						System.out.println("调用完成");
					}

					@Override
					public void onError(Throwable e) {
						System.out.println(e);
					}

					@Override
					public void onNext(String s) {
						System.out.println(s);
					}
				});
			}
		});
	}
}
