/**
 * Project Name:microboot-redis
 * File Name:RedisServiceImpl.java
 * Package Name:cn.mldn.microboot.service.impl
 * Date:2017年11月20日下午2:40:03
 * Copyright (c) 2017, izbk@163.com All Rights Reserved.
 *
*/
/**
 * 
 * @Title:  RedisServiceImpl.java   
 * @Package cn.mldn.microboot.service.impl   
 * @Description:       
 * @author: Binke Zhang    
 * @date:   2017年11月20日 下午2:40:03   
 * @version V1.0 
 * @Copyright: 2017 izbk@163.com All rights reserved. 
 *
 */

package cn.mldn.microboot.service.impl;

import java.util.Date;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

import cn.mldn.microboot.service.RedisKVService;

/**
 * 
 * @ClassName: RedisServiceImpl
 * @Description:
 * @author: Binke Zhang
 * @param <V>
 * @param <K>
 * @date: 2017年11月20日 下午2:40:03
 * @Copyright: 2017 izbk@163.com All rights reserved.
 */
public class RedisKVServiceImpl implements RedisKVService {
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Override
	public String get(String key){
		return stringRedisTemplate.opsForValue().get(key);
	}
	
	@Override
	public String getAndSet(String key, String value){
		return stringRedisTemplate.opsForValue().getAndSet(key, value);
	}
	
	@Override
	public String getRange(String key,Long start,Long end){
		return stringRedisTemplate.opsForValue().get(key, start, end);
	}

	@Override
	public void set(String key, String value){
		stringRedisTemplate.opsForValue().set(key, value);
	}

	@Override
	public void set(String key, String value, long timeout, TimeUnit unit){
		stringRedisTemplate.opsForValue().set(key, value, timeout, unit);
	}

	@Override
	public Boolean setIfAbsent(String key, String value){
		return stringRedisTemplate.opsForValue().setIfAbsent(key, value);
	}
	
	@Override
	public void setRange(String key, String value,long offset){
		stringRedisTemplate.opsForValue().set(key, value, offset);
	}

	@Override
	public long increment(String key, Long incrBy){
		return stringRedisTemplate.opsForValue().increment(key, incrBy);
	}
	
	@Override
	public Collection<String> multiGet(Collection<String> keys){
		return stringRedisTemplate.opsForValue().multiGet(keys);
	}

	@Override
	public void multiSet(Map<String, String> map){
		stringRedisTemplate.opsForValue().multiSet(map);
	}

	@Override
	public Integer append(String key, String value){
		return stringRedisTemplate.opsForValue().append(key, value);
	}

	@Override
	public Double increment(String key, Double incrBy){
		return stringRedisTemplate.opsForValue().increment(key, incrBy);
	}

	@Override
	public Boolean multiSetIfAbsent(Map<String, String> map){
		return stringRedisTemplate.opsForValue().multiSetIfAbsent(map);
	}
	
	@Override
	public long size(String key){
		return stringRedisTemplate.opsForValue().size(key);
	}
	
	@Override
	public Boolean hasKey(String key){
		return stringRedisTemplate.hasKey(key);
	}

	@Override
	public Boolean expire(String key, Long timeout, TimeUnit unit){
		return stringRedisTemplate.expire(key, timeout, unit);
	}

	@Override
	public Boolean expireAt(String key, Date date){
		return stringRedisTemplate.expireAt(key, date);
	}
	
	@Override
	public Set<String> keys(String pattern){
		return stringRedisTemplate.keys(pattern);
	}

	@Override
	public Boolean persist(String key){
		return stringRedisTemplate.persist(key);
	}

	@Override
	public Long getExpire(String key, TimeUnit timeUnit){
		return stringRedisTemplate.getExpire(key, timeUnit);
	}
	@Override
	public String type(String key){
		return stringRedisTemplate.type(key).code();
	}

	@Override
	public void delete(String key){
		stringRedisTemplate.delete(key);
	}
	@Override
	public void delete(Collection<String> keys){
		stringRedisTemplate.delete(keys);
	}

	@Override
	public Long getExpire(String key){
		return stringRedisTemplate.getExpire(key);
	}

	@Override
	public Boolean move(String key, int dbIndex) {
		return stringRedisTemplate.move(key, dbIndex);
	}

	@Override
	public String randomKey() {
		return stringRedisTemplate.randomKey();
	}

	@Override
	public void rename(String oldKey, String newKey) {
		stringRedisTemplate.rename(oldKey, newKey);		
	}

	@Override
	public Boolean renameIfAbsent(String oldKey, String newKey) {
		return stringRedisTemplate.renameIfAbsent(oldKey, newKey);
	}

	@Override
	public byte[] dump(String key) {
		return stringRedisTemplate.dump(key);
	}

	@Override
	public void restore(String key, byte[] value, long timeToLive, TimeUnit unit) {
		stringRedisTemplate.restore(key, value, timeToLive, unit);		
	}
	@Override
	public String flushDB(){
		return stringRedisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				connection.flushDb();
				return "ok";
			}
		});
	}

	@Override
	public long dbSize(){
		return stringRedisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.dbSize();
			}
		});
	}

}
