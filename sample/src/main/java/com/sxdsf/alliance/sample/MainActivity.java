package com.sxdsf.alliance.sample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sxdsf.alliance.CallbackAdapter;
import com.sxdsf.alliance.GenericRequest;
import com.sxdsf.alliance.Request;
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

                //有数据的情况
                GenericRequest<Bundle> rd = new GenericRequest<>();
                rd.setUri(Uri.parse("redirect://com.sxdsf.alliance.sample.Main2Activity"));
                rd.setData(new Bundle());

                //没数据的情况
                Request rn = new GenericRequest();
                rn.setUri(Uri.parse("network://index"));

                Request rw = new GenericRequest();
                rw.setUri(Uri.parse("whatever://index"));

                // 普通版的
                MyApplication.SERVICE_MANAGER.request(rd).execute();
                MyApplication.SERVICE_MANAGER.request(rn).execute(new CallbackAdapter<Response>() {
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

                MyApplication.SERVICE_MANAGER.request(rw).execute(new CallbackAdapter<Response>() {
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
