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

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
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
	private static final Logger log = LoggerFactory.getLogger(RedisKVServiceImpl.class);
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Override
	public String get(String key) throws Exception {
		return stringRedisTemplate.opsForValue().get(key);
	}

	@Override
	public void set(String key, String value) throws Exception {
		stringRedisTemplate.opsForValue().set(key, value);
	}

	@Override
	public void set(String key, String value, long timeout, TimeUnit unit) throws Exception {
		stringRedisTemplate.opsForValue().set(key, value, timeout, unit);
	}

	@Override
	public void deleteKey(List<String> keys) throws Exception {
		stringRedisTemplate.delete(keys);
	}

	@Override
	public void clear() throws Exception {
		stringRedisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					Set<byte[]> keys = connection.keys("*".getBytes());
					connection.multi();
					for (byte[] key : keys) {
						connection.del(key);
					}
					connection.exec();
				} catch (Exception e) {
					log.error("com.utils.redis.impl.RedisCommonDaoImpl clear " + e);
					throw (DataAccessException) e;
				}
				return null;
			}
		});
	}

	@Override
	public long incrBy(String key, Long incrBy) throws Exception {
		return stringRedisTemplate.opsForValue().increment(key, incrBy);
	}

	@Override
	public boolean exists(String key) throws Exception {
		return stringRedisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.exists(key.getBytes());
			}
		});
	}

	@Override
	public String flushDB() throws Exception {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				connection.flushDb();
				return "ok";
			}
		});
	}

	@Override
	public long dbSize() throws Exception {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.dbSize();
			}
		});
	}

	@Override
	public String ping() throws Exception {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.ping();
			}
		});
	}

	@Override
	public List<String> mget(List<String> keys) throws Exception {
		return stringRedisTemplate.opsForValue().multiGet(keys);
	}

	@Override
	public void mset(Map<String, String> map) throws Exception {
		stringRedisTemplate.opsForValue().multiSet(map);
	}

	@Override
	public Integer append(String key, String value) throws Exception {
		return stringRedisTemplate.opsForValue().append(key, value);
	}

	@Override
	public Double incrByFloat(String key, Double incrBy) throws Exception {
		return stringRedisTemplate.opsForValue().increment(key, incrBy);
	}

	@Override
	public boolean msetnx(Map<String, String> map) throws Exception {
		return stringRedisTemplate.opsForValue().multiSetIfAbsent(map);
	}

	@Override
	public boolean expire(String key, Long timeout, TimeUnit unit) throws Exception {
		return redisTemplate.expire(key, timeout, unit);
	}

	@Override
	public Set<String> keys(String pattern) throws Exception {
		return redisTemplate.keys(pattern);
	}

	@Override
	public boolean persist(String key) throws Exception {
		return redisTemplate.persist(key);
	}

	@Override
	public Long getExpire(String key, TimeUnit timeUnit) throws Exception {
		return redisTemplate.getExpire(key, timeUnit);
	}
	@Override
	public String type(String key) throws Exception {
		return redisTemplate.type(key).code();
	}

}
