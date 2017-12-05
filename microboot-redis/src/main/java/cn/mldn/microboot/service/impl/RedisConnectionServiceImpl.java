/**
 * Project Name microboot-redis
 * File Name RedisConnectionServiceImpl.java
 * Package Name cn.mldn.microboot.service.impl
 * Date 2017年12月5日下午3:01:15
 * Copyright (c) 2017, izbk@163.com All Rights Reserved.
 *
*/
/**
 * 
 * @Title  RedisConnectionServiceImpl.java   
 * @Package cn.mldn.microboot.service.impl   
 * @Description      
 * @author Binke Zhang    
 * @date   2017年12月5日 下午3:01:15   
 * @version V1.0 
 * @Copyright: 2017 izbk@163.com All rights reserved. 
 *
 */

package cn.mldn.microboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import cn.mldn.microboot.service.RedisConnectionService;

/**
 * 
 * @ClassName  RedisConnectionServiceImpl   
 * @Description
 * @author Binke Zhang
 * @date  2017年12月5日 下午3:01:15     
 * @Copyright: 2017  izbk@163.com All rights reserved. 
 */
public class RedisConnectionServiceImpl implements RedisConnectionService {

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	private RedisSerializer<String> stringSerializer = new StringRedisSerializer();

	@Override
	public String echo(String msg) {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				return stringSerializer.deserialize(connection.echo(stringSerializer.serialize(msg)));
			}
		});
	}

	@Override
	public String ping() {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.ping();
			}
		});
	}

	@Override
	public void select(Integer dbIndex) {
		redisTemplate.execute(new RedisCallback<Object>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				connection.select(dbIndex);
				return null;
			}
		});
	}

}

