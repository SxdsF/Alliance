package com.sxdsf.alliance;

/**
 * Performer
 * 
 * 每个联盟都有法律的执法者，这个就是用来执法的
 *
 * @author sunbowen
 * @date 2016/4/15-11:34
 * @desc 执行接口
 */
public interface Performer<T, R> {

	R perform(T t);

}
