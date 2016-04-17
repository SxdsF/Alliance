package com.sxdsf.alliance;

/**
 * Alliance
 *
 * 将每个模块看成一个一个的联盟，这个是每个联盟需要实现的接口
 *
 * @author sunbowen
 * @date 2016/3/30-20:31
 * @desc 各个模块需要继承的接口，只接收一个request的对象，并返回一个Call对象
 */
public interface Alliance<T, R> {

	R call(T t);

}
