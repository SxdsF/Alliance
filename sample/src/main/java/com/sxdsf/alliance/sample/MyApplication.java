package com.sxdsf.alliance.sample;

import android.app.Application;
import android.content.Context;
import android.content.res.XmlResourceParser;

import com.sxdsf.alliance.general.AllianceLeader;
import com.sxdsf.alliance.rx.RxAllianceLeader;

/**
 * MyApplication
 *
 * @author Administrator
 * @date 2016/3/31-10:31
 * @desc ${描述类实现的功能}
 */
public class MyApplication extends Application {

    public static final AllianceLeader SERVICE_MANAGER = AllianceLeader.getInstance();

    public static final RxAllianceLeader RX_SERVICE_MANAGER = RxAllianceLeader.getInstance();
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        if (!SERVICE_MANAGER.isInitialized()) {
            XmlResourceParser xrp = this.getResources().getXml(R.xml.alliance);
            SERVICE_MANAGER.initialize(xrp);
        }

        if (!RX_SERVICE_MANAGER.isInitialized()) {
            XmlResourceParser xrp = this.getResources().getXml(R.xml.rx_alliance);
            RX_SERVICE_MANAGER.initialize(xrp);
        }
    }

    public static Context getContext() {
        return context;
    }
}
