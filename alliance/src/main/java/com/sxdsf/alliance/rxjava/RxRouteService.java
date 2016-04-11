package com.sxdsf.alliance.rxjava;

import android.content.res.XmlResourceParser;
import android.net.Uri;

import com.sxdsf.alliance.Request;
import com.sxdsf.alliance.Response;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import rx.Observable;

/**
 * RxRouteService
 *
 * @author sunbowen
 * @date 2016/4/9-9:52
 * @desc 路由服务，负责将Uri转发到相应的服务
 */
public class RxRouteService implements RxFoundationAlliance<Request, String> {

    /**
     * 存放各种组件的map
     */
    private final RxAllianceMap allianceMap = new RxAllianceMap();

    @Override
    public Observable<Response> call(Request request) {
        Observable<Response> call = null;
        if (request != null) {
            RxAlliance<Request, Response> alliance = this.allianceMap.getAlliance(this.parse(request));
            if (alliance != null) {
                call = alliance.call(request);
            }
        }
        return call;
    }

    @Override
    public String parse(Request value) {
        String scheme = null;
        if (value != null) {
            Uri uri = value.getUri();
            if (uri != null) {
                scheme = uri.getScheme();
            }
        }
        return scheme;
    }

    /**
     * 初始化方法，负责将配置文件中的所有类读取到map中
     */
    void initialize(XmlResourceParser parser) {
        if (parser != null) {
            // 读取配置文件
            try {
                int eventType = parser.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {
                        case XmlPullParser.START_DOCUMENT:
                            break;
                        case XmlPullParser.START_TAG:
                            if (parser.getName().equals("alliance")) {
                                String scheme = null;
                                String className = null;
                                int count = parser.getAttributeCount();
                                for (int i = 0; i < count; i++) {
                                    if ("scheme".equals(parser.getAttributeName(i))) {
                                        scheme = parser.getAttributeValue(i);
                                    } else if ("name".equals(parser.getAttributeName(i))) {
                                        className = parser.getAttributeValue(i);
                                    }
                                }
                                if (scheme != null && !"".equals(scheme)
                                        && className != null && !"".equals(className)) {
                                    this.allianceMap.allianceClassMap.put(scheme, (Class<? extends RxAlliance<Request, Response>>) Class.forName(className));
                                }
                            }
                            break;
                        case XmlPullParser.END_TAG:
                            break;
                    }
                    eventType = parser.next();
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                parser.close();
            }
        }
    }
}
