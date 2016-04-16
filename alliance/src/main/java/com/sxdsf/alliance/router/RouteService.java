package com.sxdsf.alliance.router;

import android.content.res.XmlResourceParser;
import android.net.Uri;

import com.sxdsf.alliance.core.Alliance;
import com.sxdsf.alliance.core.Call;
import com.sxdsf.alliance.core.impl.BaseAlliance;
import com.sxdsf.alliance.core.impl.BaseEnforcer;
import com.sxdsf.alliance.core.impl.BaseLaw;
import com.sxdsf.alliance.core.impl.Request;
import com.sxdsf.alliance.core.impl.RequestParser;
import com.sxdsf.alliance.core.impl.Response;

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
public class RouteService extends BaseAlliance<Data> {

	/**
	 * 存放各种组件的map
	 */
	private final AllianceMap allianceMap = new AllianceMap();

	@Override
	protected BaseEnforcer<Data> createEnforcer() {
		return new BaseEnforcer<Data>() {
			@Override
			public Call<Response> enforce(Data data) {
				Call<Response> call = null;
				if (data != null) {
					Alliance<Request, Response> alliance = allianceMap.getAlliance(data.scheme);
					if (alliance != null) {
						call = alliance.enforce(data.request);
					}
				}
				return call;
			}
		};
	}

	@Override
	protected BaseLaw<Data> createLaw() {
		return new BaseLaw<Data>() {
			@Override
			protected RequestParser<Data> createRequestParser() {
				return new RequestParser<Data>() {
					@Override
					public Data parse(Request value) {
						Data data = null;
						if (value != null) {
							data = new Data();
							data.request = value;
							Uri uri = value.getUri();
							if (uri != null) {
								data.scheme = uri.getScheme();
							}
						}
						return data;
					}
				};
			}
		};
	}

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
										(Class<? extends Alliance<Request, Response>>) Class.forName(className));
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
