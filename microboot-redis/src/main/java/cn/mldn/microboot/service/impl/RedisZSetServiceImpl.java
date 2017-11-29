/**
 * Project Name microboot-redis
 * File Name RedisZSetServiceImpl.java
 * Package Name cn.mldn.microboot.service.impl
 * Date 2017年11月29日上午9:04:49
 * Copyright (c) 2017, izbk@163.com All Rights Reserved.
 *
*/
/**
 * 
 * @Title  RedisZSetServiceImpl.java   
 * @Package cn.mldn.microboot.service.impl   
 * @Description      
 * @author Binke Zhang    
 * @date   2017年11月29日 上午9:04:49   
 * @version V1.0 
 * @Copyright: 2017 izbk@163.com All rights reserved. 
 *
 */

package cn.mldn.microboot.service.impl;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands.Limit;
import org.springframework.data.redis.connection.RedisZSetCommands.Range;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

import cn.mldn.microboot.service.RedisZSetService;

/**
 * 
 * @ClassName  RedisZSetServiceImpl   
 * @Description
 * @author Binke Zhang
 * @date  2017年11月29日 上午9:04:49     
 * @Copyright: 2017  izbk@163.com All rights reserved. 
 */
public class RedisZSetServiceImpl implements RedisZSetService {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public Boolean add(String key, Object value, double score) {
		return redisTemplate.opsForZSet().add(key, value, score);
	}

	@Override
	public Long add(String key, Set<TypedTuple<Object>> tuples) {
		return redisTemplate.opsForZSet().add(key, tuples);
	}

	@Override
	public Long remove(String key, Object... values) {
		return redisTemplate.opsForZSet().remove(key, values);
	}

	@Override
	public Double incrementScore(String key, Object value, double delta) {
		return redisTemplate.opsForZSet().incrementScore(key, value, delta);
	}

	@Override
	public Long rank(String key, Object o) {
		return redisTemplate.opsForZSet().rank(key, o);
	}

	@Override
	public Long reverseRank(String key, Object o) {
		return redisTemplate.opsForZSet().reverseRank(key, o);
	}

	@Override
	public Set<Object> range(String key, long start, long end) {
		return redisTemplate.opsForZSet().range(key, start, end);
	}

	@Override
	public Set<TypedTuple<Object>> rangeWithScores(String key, long start, long end) {
		return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
	}

	@Override
	public Set<Object> rangeByScore(String key, double min, double max) {
		return redisTemplate.opsForZSet().rangeByScore(key, min, max);
	}

	@Override
	public Set<TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max) {
		return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
	}

	@Override
	public Set<Object> rangeByScore(String key, double min, double max, long offset, long count) {
		return redisTemplate.opsForZSet().rangeByScore(key, min, max, offset, count);
	}

	@Override
	public Set<TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max, long offset, long count) {
		return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max, offset, count);
	}

	@Override
	public Set<Object> reverseRange(String key, long start, long end) {
		return redisTemplate.opsForZSet().reverseRange(key, start, end);
	}

	@Override
	public Set<TypedTuple<Object>> reverseRangeWithScores(String key, long start, long end) {
		return redisTemplate.opsForZSet().reverseRangeWithScores(key, start, end);
	}

	@Override
	public Set<Object> reverseRangeByScore(String key, double min, double max) {
		return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max);
	}

	@Override
	public Set<TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max) {
		return redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key, min, max);
	}

	@Override
	public Set<Object> reverseRangeByScore(String key, double min, double max, long offset, long count) {
		return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max, offset, count);
	}

	@Override
	public Set<TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max, long offset,
			long count) {
		return redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key, min, max, offset, count);
	}

	@Override
	public Long count(String key, double min, double max) {
		return redisTemplate.opsForZSet().count(key, min, max);
	}

	@Override
	public Long size(String key) {
		return redisTemplate.opsForZSet().size(key);
	}

	@Override
	public Double score(String key, Object o) {
		return redisTemplate.opsForZSet().score(key, o);
	}

	@Override
	public Long removeRange(String key, long start, long end) {
		return redisTemplate.opsForZSet().removeRange(key, start, end);
	}

	@Override
	public Long removeRangeByScore(String key, double min, double max) {
		return redisTemplate.opsForZSet().removeRangeByScore(key, min, max);
	}

	@Override
	public Long unionAndStore(String key, String otherKey, String destKey) {
		return redisTemplate.opsForZSet().unionAndStore(key, otherKey, destKey);
	}

	@Override
	public Long unionAndStore(String key, Collection<String> otherStringeys, String destStringey) {
		return redisTemplate.opsForZSet().unionAndStore(key, otherStringeys, destStringey);
	}

	@Override
	public Long intersectAndStore(String key, String otherKey, String destKey) {
		return redisTemplate.opsForZSet().intersectAndStore(key, otherKey, destKey);
	}

	@Override
	public Long intersectAndStore(String key, Collection<String> otherStringeys, String destStringey) {
		return redisTemplate.opsForZSet().intersectAndStore(key, otherStringeys, destStringey);
	}

	@Override
	public Set<Object> rangeByLex(String key, Range range) {
		return redisTemplate.opsForZSet().rangeByLex(key, range);
	}

	@Override
	public Set<Object> rangeByLex(String key, Range range, Limit limit) {
		return redisTemplate.opsForZSet().rangeByLex(key, range, limit);
	}

}

