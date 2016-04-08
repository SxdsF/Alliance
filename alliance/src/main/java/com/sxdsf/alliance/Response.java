package com.sxdsf.alliance;

/**
 * Response
 *
 * @author sunbowen
 * @date 2016/4/7-10:26
 * @desc 请求的回调返回类型
 */
// public class Response<T> {
// private String className;
// private T data;
//
// public String getClassName() {
// return className;
// }
//
// public void setClassName(String className) {
// this.className = className;
// }
//
// public T getData() {
// return data;
// }
//
// public void setData(T data) {
// this.data = data;
// }
// }

public interface Response {
	<T> T checkAndGet(Class<T> cls);
}
