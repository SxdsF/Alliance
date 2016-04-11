package com.sxdsf.alliance;

import android.content.res.XmlResourceParser;
import android.net.Uri;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * RouteService
 *
 * @author sunbowen
 * @date 2016/4/8-17:21
 * @desc 路由服务，负责转发Uri到相应的服务
 */
public class RouteService implements FoundationAlliance<Request, String> {

    /**
     * 存放各种组件的map
     */
    private final AllianceMap allianceMap = new AllianceMap();

    @Override
    public Call<Response> call(Request request) {
        Call<Response> call = null;
        if (request != null) {
            Alliance<Request, Response> alliance = this.allianceMap.getAlliance(this.parse(request));
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
                                    this.allianceMap.allianceClassMap.put(scheme, (Class<? extends Alliance<Request, Response>>) Class.forName(className));
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
