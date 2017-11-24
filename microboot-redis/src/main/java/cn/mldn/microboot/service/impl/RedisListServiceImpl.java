/**
 * Project Name microboot-redis
 * File Name RedisListServiceImpl.java
 * Package Name cn.mldn.microboot.service.impl
 * Date 2017年11月21日下午7:36:30
 * Copyright (c) 2017, izbk@163.com All Rights Reserved.
 *
*/
/**
 * 
 * @Title  RedisListServiceImpl.java   
 * @Package cn.mldn.microboot.service.impl   
 * @Description      
 * @author Binke Zhang    
 * @date   2017年11月21日 下午7:36:30   
 * @version V1.0 
 * @Copyright: 2017 izbk@163.com All rights reserved. 
 *
 */

package cn.mldn.microboot.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import cn.mldn.microboot.service.RedisListService;

/**
 * 
 * @ClassName  RedisListServiceImpl   
 * @Description
 * @author Binke Zhang
 * @date  2017年11月21日 下午7:36:30     
 * @Copyright: 2017  izbk@163.com All rights reserved. 
 */
public class RedisListServiceImpl implements RedisListService {

	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	@Override
	public Object leftPop(String key) throws Exception {
		return redisTemplate.opsForList().leftPop(key);
	}
	@Override
	public Object leftPop(String key,Long timeout,TimeUnit unit) throws Exception {
		return redisTemplate.opsForList().leftPop(key, timeout, unit);
	}
	@Override
	public Long leftPush(String key,Object value) throws Exception {
		return redisTemplate.opsForList().leftPush(key, value);
	}
	@Override
	public Long leftPush(String key,Object pivot,Object value) throws Exception {
		return redisTemplate.opsForList().leftPush(key, pivot, value);
	}
	@Override
	public Long leftPushAll(String key,List<Object> values) throws Exception {
		return redisTemplate.opsForList().leftPushAll(key, values);
	}
	@Override
	public Long leftPushAll(String key,Object... values) throws Exception {
		return redisTemplate.opsForList().leftPushAll(key, values);
	}
	@Override
	public Long leftPushIfPresent(String key,Object value) throws Exception {
		return redisTemplate.opsForList().leftPushIfPresent(key, value);
	}
	@Override
	public List<Object> range(String key,Long start,Long end) throws Exception {
		return redisTemplate.opsForList().range(key, start, end);
	}
	@Override
	public Long remove(String key,Long count,Object value) throws Exception {
		return redisTemplate.opsForList().remove(key, count, value);
	}
	@Override
	public void trim(String key,Long start,Long end) throws Exception {
		redisTemplate.opsForList().trim(key, start, end);
	}
	@Override
	public Object rightPop(String key) throws Exception {
		return redisTemplate.opsForList().rightPop(key);
	}
	@Override
	public Object rightPop(String key,Long timeout,TimeUnit unit) throws Exception {
		return redisTemplate.opsForList().rightPop(key, timeout, unit);
	}
	@Override
	public Long rightPush(String key,Object value) throws Exception {
		return redisTemplate.opsForList().rightPush(key, value);
	}
	@Override
	public Long rightPush(String key,Object pivot,Object value) throws Exception {
		return redisTemplate.opsForList().rightPush(key, pivot, value);
	}
	@Override
	public Object rightPopAndLeftPush(String sourceKey, String destinationKey) throws Exception {
		return redisTemplate.opsForList().rightPopAndLeftPush(sourceKey, destinationKey);
	}
	@Override
	public Object rightPopAndLeftPush(String sourceKey, String destinationKey,Long timeout,TimeUnit unit) throws Exception {
		return redisTemplate.opsForList().rightPopAndLeftPush(sourceKey, destinationKey, timeout, unit);
	}
	@Override
	public Long rightPushAll(String key,List<Object> values) throws Exception {
		return redisTemplate.opsForList().rightPushAll(key, values);
	}
	@Override
	public Long rightPushAll(String key,Object... values) throws Exception {
		return redisTemplate.opsForList().rightPushAll(key, values);
	}
	@Override
	public Long rightPushIfPresent(String key,Object value) throws Exception {
		return redisTemplate.opsForList().rightPushIfPresent(key, value);
	}
	@Override
	public void set(String key,Long index,Object value) throws Exception {
		redisTemplate.opsForList().set(key,index,value);
	}
	@Override
	public Long size(String key) throws Exception {
		return redisTemplate.opsForList().size(key);
	}
	
}

