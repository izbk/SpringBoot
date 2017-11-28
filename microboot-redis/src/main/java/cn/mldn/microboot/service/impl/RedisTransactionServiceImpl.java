/**
 * Project Name microboot-redis
 * File Name RedisTransactionService.java
 * Package Name cn.mldn.microboot.service.impl
 * Date 2017年11月28日下午1:20:33
 * Copyright (c) 2017, izbk@163.com All Rights Reserved.
 *
*/
/**
 * 
 * @Title  RedisTransactionService.java   
 * @Package cn.mldn.microboot.service.impl   
 * @Description      
 * @author Binke Zhang    
 * @date   2017年11月28日 下午1:20:33   
 * @version V1.0 
 * @Copyright: 2017 izbk@163.com All rights reserved. 
 *
 */

package cn.mldn.microboot.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 
 * @ClassName  RedisTransactionService   
 * @Description
 * @author Binke Zhang
 * @date  2017年11月28日 下午1:20:33     
 * @Copyright: 2017  izbk@163.com All rights reserved. 
 */
public class RedisTransactionServiceImpl implements cn.mldn.microboot.service.RedisTransactionService {

	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public List<Object> exec() {
		return redisTemplate.exec();
	}

	@Override
	public void multi() {
		redisTemplate.multi();
	}

	@Override
	public void discard() {
		redisTemplate.discard();
	}

	@Override
	public void watch(String key) {
		redisTemplate.watch(key);
	}

	@Override
	public void watch(Collection<String> keys) {
		redisTemplate.watch(keys);
	}

	@Override
	public void unwatch() {
		redisTemplate.unwatch();
	}

}

