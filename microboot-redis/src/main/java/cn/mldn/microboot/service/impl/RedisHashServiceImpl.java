/**
 * Project Name microboot-redis
 * File Name RedisHashServiceImpl.java
 * Package Name cn.mldn.microboot.service.impl
 * Date 2017年12月5日下午3:26:42
 * Copyright (c) 2017, izbk@163.com All Rights Reserved.
 *
*/
/**
 * 
 * @Title  RedisHashServiceImpl.java   
 * @Package cn.mldn.microboot.service.impl   
 * @Description      
 * @author Binke Zhang    
 * @date   2017年12月5日 下午3:26:42   
 * @version V1.0 
 * @Copyright: 2017 izbk@163.com All rights reserved. 
 *
 */

package cn.mldn.microboot.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import cn.mldn.microboot.service.RedisHashService;

/**
 * 
 * @ClassName  RedisHashServiceImpl   
 * @Description
 * @author Binke Zhang
 * @param <H>
 * @date  2017年12月5日 下午3:26:42     
 * @Copyright: 2017  izbk@163.com All rights reserved. 
 */
public class RedisHashServiceImpl implements RedisHashService {
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;

	@Override
	public Long delete(String key, Object... hashKeys) {
		return redisTemplate.opsForHash().delete(key, hashKeys);
	}

	@Override
	public Boolean hasKey(String key, String hashKey) {
		return redisTemplate.opsForHash().hasKey(key, hashKey);
	}

	@Override
	public Object get(String key, String hashKey) {
		return redisTemplate.opsForHash().get(key, hashKey);
	}

	@Override
	public List<Object> multiGet(String key, Collection<Object> hashKeys) {
		return redisTemplate.opsForHash().multiGet(key, hashKeys);
	}

	@Override
	public Long increment(String key, String hashKey, long delta) {
		return redisTemplate.opsForHash().increment(key, hashKey, delta);
	}

	@Override
	public Double increment(String key, String hashKey, double delta) {
		return redisTemplate.opsForHash().increment(key, hashKey, delta);
	}

	@Override
	public Set<Object> keys(String key) {
		return redisTemplate.opsForHash().keys(key);
	}

	@Override
	public Long size(String key) {
		return redisTemplate.opsForHash().size(key);
	}

	@Override
	public void putAll(String key, Map<String, Object> m) {
		redisTemplate.opsForHash().putAll(key, m);
	}

	@Override
	public void put(String key, String hashKey, Object value) {
		redisTemplate.opsForHash().put(key, hashKey, value);
	}

	@Override
	public Boolean putIfAbsent(String key, String hashKey, Object value) {
		return redisTemplate.opsForHash().putIfAbsent(key, hashKey, value);
	}

	@Override
	public List<Object> values(String key) {
		return redisTemplate.opsForHash().values(key);
	}

	@Override
	public Map<Object, Object> entries(String key) {
		return redisTemplate.opsForHash().entries(key);
	}
}

