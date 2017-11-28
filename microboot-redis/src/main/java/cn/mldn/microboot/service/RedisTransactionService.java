/**
 * Project Name microboot-redis
 * File Name RedisSetService.java
 * Package Name cn.mldn.microboot.service
 * Date 2017年11月23日下午1:23:13
 * Copyright (c) 2017, izbk@163.com All Rights Reserved.
 *
*/
/**
 * 
 * @Title  RedisSetService.java   
 * @Package cn.mldn.microboot.service   
 * @Description      
 * @author Binke Zhang    
 * @date   2017年11月23日 下午1:23:13   
 * @version Object1.0 
 * @Copyright: 2017 izbk@163.com All rights reserved. 
 *
 */

package cn.mldn.microboot.service;

import java.util.Collection;
import java.util.List;

/**
 * 
 * 
 * @ClassName  RedisTransactionService   
 * @Description
 * @author Binke Zhang
 * @date  2017年11月28日 下午12:54:19     
 * @Copyright: 2017  izbk@163.com All rights reserved.
 */
public interface RedisTransactionService {

	/**
	 * 执行事务中所有在排队等待的指令并将链接状态恢复到正常
	 *
	 * @Title exec   
	 * @Description   
	 * @return
	 *
	 */
	public List<Object> exec();
	/**
	 * 标记一个事务块的开始
	 *
	 * @Title multi   
	 * @Description   
	 *
	 */
	public void multi();
	/**
	 * 丢弃一个事务中所有在排队等待的指令，并且将连接状态恢复到正常
	 *
	 * @Title discard   
	 * @Description   
	 *
	 */
	public void discard();
	/**
	 * 标记指定的key 被监视起来，在事务中有条件的执行
	 *
	 * @Title watch   
	 * @Description   
	 * @param key
	 *
	 */
	public void watch(String key);
	/**
	 * 标记所有指定的key 被监视起来，在事务中有条件的执行
	 *
	 * @Title watch   
	 * @Description   
	 * @param keys
	 *
	 */
	public void watch(Collection<String> keys);
	/**
	 * 取消监视一个事务中已被监视的所有key。如果执行exec() 或者discard()， 则不需要手动执行unwatch()
	 *
	 * @Title unwatch   
	 * @Description   
	 *
	 */
	public void unwatch();
}

