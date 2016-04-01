package com.sxdsf.alliance.sample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
				MyApplication.SERVICE_MANAGER.request(uri).execute();
//				Intent intent = new Intent();
//				intent.setClass(MainActivity.this, Main2Activity.class);
//				MainActivity.this.startActivity(intent);
			}
		});
	}
}
