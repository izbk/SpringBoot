/**
 * Project Name microboot-redis
 * File Name RedisConnectionService.java
 * Package Name cn.mldn.microboot.service
 * Date 2017年12月5日下午2:55:57
 * Copyright (c) 2017, izbk@163.com All Rights Reserved.
 *
*/
/**
 * 
 * @Title  RedisConnectionService.java   
 * @Package cn.mldn.microboot.service   
 * @Description      
 * @author Binke Zhang    
 * @date   2017年12月5日 下午2:55:57   
 * @version V1.0 
 * @Copyright: 2017 izbk@163.com All rights reserved. 
 *
 */

package cn.mldn.microboot.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @ClassName  RedisHashService   
 * @Description
 * @author Binke Zhang
 * @date  2017年12月5日 下午2:55:57     
 * @Copyright: 2017  izbk@163.com All rights reserved. 
 */
public interface RedisHashService {
	/**
	 * 从 key 指定的哈希集中移除指定的域
	 *
	 * @param key must not be {@literal null}.
	 * @param hashKeys must not be {@literal null}.
	 * @return
	 */
	Long delete(String key, Object... hashKeys);

	/**
	 * 返回key指定的哈希集里面hashKey是否存在
	 *
	 * @param key must not be {@literal null}.
	 * @param hashKey must not be {@literal null}.
	 * @return
	 */
	Boolean hasKey(String key, String hashKey);

	/**
	 * 返回 key 指定的哈希集中字段hashKey所关联的值
	 *
	 * @param key must not be {@literal null}.
	 * @param hashKey must not be {@literal null}.
	 * @return
	 */
	Object get(String key, String hashKey);

	/**
	 * 返回 key 指定的哈希集中指定字段hashKeys的值
	 *
	 * @param key must not be {@literal null}.
	 * @param hashKeys must not be {@literal null}.
	 * @return
	 */
	List<Object> multiGet(String key, Collection<Object> hashKeys);

	/**
	 * 增加 key 指定的哈希集中指定字段hashKey的数值
	 *
	 * @param key must not be {@literal null}.
	 * @param hashKey must not be {@literal null}.
	 * @param delta
	 * @return
	 */
	Long increment(String key, String hashKey, long delta);

	/**
	 * 增加 key 指定的哈希集中指定字段hashKey的浮点数值
	 *
	 * @param key must not be {@literal null}.
	 * @param hashKey must not be {@literal null}.
	 * @param delta
	 * @return
	 */
	Double increment(String key, String hashKey, double delta);

	/**
	 * 返回 key 指定的哈希集中所有字段的名字
	 *
	 * @param key must not be {@literal null}.
	 * @return
	 */
	Set<Object> keys(String key);

	/**
	 * 返回 key 指定的哈希集包含的字段的数量
	 *
	 * @param key must not be {@literal null}.
	 * @return
	 */
	Long size(String key);

	/**
	 * 设置 key 指定的哈希集中指定map 的值
	 *
	 * @param key must not be {@literal null}.
	 * @param m must not be {@literal null}.
	 */
	void putAll(String key, Map<String, Object> m);

	/**
	 * 设置 key 指定的哈希集中指定字段hashKey的值
	 *
	 * @param key must not be {@literal null}.
	 * @param hashKey must not be {@literal null}.
	 * @param value
	 */
	void put(String key, String hashKey, Object value);

	/**
	 * 只在 key 指定的哈希集中不存在指定的字段hashKey时，设置字段的值
	 *
	 * @param key must not be {@literal null}.
	 * @param hashKey must not be {@literal null}.
	 * @param value
	 * @return
	 */
	Boolean putIfAbsent(String key, String hashKey, Object value);

	/**
	 * 返回 key 指定的哈希集中所有字段的值
	 *
	 * @param key must not be {@literal null}.
	 * @return
	 */
	List<Object> values(String key);

	/**
	 * 返回 key 指定的哈希集中所有的字段和值
	 *
	 * @param key must not be {@literal null}.
	 * @return
	 */
	Map<Object, Object> entries(String key);
}

