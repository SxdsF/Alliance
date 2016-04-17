package com.sxdsf.alliance.rx.router;

import android.content.res.XmlResourceParser;
import android.net.Uri;

import com.sxdsf.alliance.Information;
import com.sxdsf.alliance.impl.Request;
import com.sxdsf.alliance.impl.Response;
import com.sxdsf.alliance.rx.RxAlliance;

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
public class RxRouteService extends RxAlliance<RouteData> {

	/**
	 * 存放各种组件的map
	 */
	private final RxAllianceMap allianceMap = new RxAllianceMap();

	/**
	 * 初始化方法，负责将配置文件中的所有类读取到map中
	 */
	public void initialize(XmlResourceParser parser) {
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
							if (scheme != null && !"".equals(scheme) && className != null && !"".equals(className)) {
								this.allianceMap.allianceClassMap.put(scheme,
										(Class<? extends RxAlliance<Information>>) Class.forName(className));
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

	@Override
	protected void onCreate() {
		// do nothing
	}

	@Override
	protected RouteData onParse(Request request) {
		RouteData routeData = null;
		if (request != null) {
			routeData = new RouteData();
			routeData.request = request;
			Uri uri = request.getUri();
			if (uri != null) {
				routeData.scheme = uri.getScheme();
			}
		}
		return routeData;
	}

	@Override
	protected Observable<Response> onPerform(RouteData routeData) {
		Observable<Response> call = null;
		if (routeData != null) {
			RxAlliance<Information> alliance = allianceMap.getAlliance(routeData.scheme);
			if (alliance != null) {
				call = alliance.call(routeData.request);
			}
		}
		return call;
	}
}
