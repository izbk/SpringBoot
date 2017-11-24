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

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;

import cn.mldn.microboot.service.RedisSetService;

/**
 * 
 * @ClassName  RedisSetServiceImpl   
 * @Description
 * @author Binke Zhang
 * @date  2017年11月21日 下午7:36:30     
 * @Copyright: 2017  izbk@163.com All rights reserved. 
 */
public class RedisSetServiceImpl implements RedisSetService {

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Override
	public Long add(String key, Object... values) {
		return redisTemplate.opsForSet().add(key, values);
	}

	@Override
	public Long remove(String key, Object... values) {
		return redisTemplate.opsForSet().remove(key, values);
	}

	@Override
	public Object pop(String key) {
		return redisTemplate.opsForSet().pop(key);
	}

	@Override
	public Boolean move(String key, Object value, String destKey) {
		return redisTemplate.opsForSet().move(key, value, destKey);
	}

	@Override
	public Long size(String key) {
		return redisTemplate.opsForSet().size(key);
	}

	@Override
	public Boolean isMember(String key, Object o) {
		return redisTemplate.opsForSet().isMember(key, o);
	}

	@Override
	public Set<Object> intersect(String key, String otherKey) {
		return redisTemplate.opsForSet().intersect(key, otherKey);
	}

	@Override
	public Set<Object> intersect(String key, Collection<String> otherKeys) {
		return redisTemplate.opsForSet().intersect(key, otherKeys);
	}

	@Override
	public Long intersectAndStore(String key, String otherKey, String destKey) {
		return redisTemplate.opsForSet().intersectAndStore(key, otherKey, destKey);
	}

	@Override
	public Long intersectAndStore(String key, Collection<String> otherKeys, String destKey) {
		return redisTemplate.opsForSet().intersectAndStore(key, otherKeys, destKey);
	}

	@Override
	public Set<Object> union(String key, String otherKey) {
		return redisTemplate.opsForSet().union(key, otherKey);
	}

	@Override
	public Set<Object> union(String key, Collection<String> otherKeys) {
		return redisTemplate.opsForSet().union(key, otherKeys);
	}

	@Override
	public Long unionAndStore(String key, String otherKey, String destKey) {
		return redisTemplate.opsForSet().unionAndStore(key, otherKey, destKey);
	}

	@Override
	public Long unionAndStore(String key, Collection<String> otherKeys, String destKey) {
		return redisTemplate.opsForSet().unionAndStore(key, otherKeys, destKey);
	}

	@Override
	public Set<Object> difference(String key, String otherKey) {
		return redisTemplate.opsForSet().difference(key, otherKey);
	}

	@Override
	public Set<Object> difference(String key, Collection<String> otherKeys) {
		return redisTemplate.opsForSet().difference(key, otherKeys);
	}

	@Override
	public Long differenceAndStore(String key, String otherKey, String destKey) {
		return redisTemplate.opsForSet().differenceAndStore(key, otherKey, destKey);
	}

	@Override
	public Long differenceAndStore(String key, Collection<String> otherKeys, String destKey) {
		return redisTemplate.opsForSet().differenceAndStore(key, otherKeys, destKey);
	}

	@Override
	public Set<Object> members(String key) {
		return redisTemplate.opsForSet().members(key);
	}

	@Override
	public Object randomMember(String key) {
		return redisTemplate.opsForSet().randomMember(key);
	}

	@Override
	public Set<Object> distinctRandomMembers(String key, long count) {
		return redisTemplate.opsForSet().distinctRandomMembers(key, count);
	}

	@Override
	public List<Object> randomMembers(String key, long count) {
		return redisTemplate.opsForSet().randomMembers(key, count);
	}

	@Override
	public Cursor<Object> scan(String key, ScanOptions options) {
		return redisTemplate.opsForSet().scan(key, options);
	}
	
}

