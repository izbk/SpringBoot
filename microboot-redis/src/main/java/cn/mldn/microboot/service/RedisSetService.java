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
import java.util.Set;

import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;

/**
 * 
 * @ClassName  RedisSetService   
 * @Description
 * @author Binke Zhang
 * @date  2017年11月23日 下午1:23:13     
 * @Copyright: 2017  izbk@163.com All rights reserved. 
 */
public interface RedisSetService {

	/**
	 * 添加一个或多个指定的member元素到集合的 key中.指定的一个或者多个元素member 如果已经在集合key中存在则忽略.如果集合key 不存在，则新建集合key,并添加member元素到集合key中.
	 *
	 * @Title add   
	 * @Description   
	 * @param key
	 * @param values
	 * @return 返回新成功添加到集合里元素的数量，不包括已经存在于集合中的元素.
	 *
	 */
	Long add(String key, Object... values);

	/**
	 * 在key集合中移除指定的元素. 如果指定的元素不是key集合中的元素则忽略 如果key集合不存在则被视为一个空的集合，该命令返回0
	 *
	 * @Title remove   
	 * @Description   
	 * @param key
	 * @param values
	 * @return 从集合中移除元素的个数，不包括不存在的成员.
	 *
	 */
	Long remove(String key, Object... values);

	/**
	 * 移除并返回集合中的一个随机元素。
	 *
	 * @Title pop   
	 * @Description   
	 * @param key
	 * @return 被移除的随机元素。
	 * 
	 */
	Object pop(String key);

	/**
	 * 将value从key的集合移动到destKey的集合中. 
	 * 如果key的集合不存在或者不包含指定的元素,不执行任何操作并且返回0.否则对象将会从key的集合中移除，并添加到destKey的集合中去，
	 * 如果destKey的集合已经存在该元素，则仅将该元素从key的集合中移除. 
	 * @Title move   
	 * @Description   
	 * @param key
	 * @param value
	 * @param destKey
	 * @return 如果该元素成功移除返回1,否则返回0
	 *
	 */
	Boolean move(String key, Object value, String destKey);

	/**
	 * 返回集合存储的key的基数 (集合元素的数量).
	 *
	 * @Title size   
	 * @Description   
	 * @param key
	 * @return
	 *
	 */
	Long size(String key);

	/**
	 * 返回成员 o 是否是存储的集合 key的成员.
	 *
	 * @Title isMember   
	 * @Description   
	 * @param key
	 * @param o
	 * @return 
	 *
	 */
	Boolean isMember(String key, Object o);

	/**
	 * 返回指定key 和 otherKey的集合的成员的交集.
	 *
	 * @Title intersect   
	 * @Description   
	 * @param key
	 * @param otherKey
	 * @return 结果集成员的列表.
	 *
	 */
	Set<Object> intersect(String key, String otherKey);

	/**
	 * 返回key的集合和指定所有的集合otherKeys的成员的交集.
	 *
	 * @Title intersect   
	 * @Description   
	 * @param key
	 * @param otherKeys
	 * @return 结果集成员的列表.
	 *
	 */
	Set<Object> intersect(String key, Collection<String> otherKeys);

	/**
	 * 将指定key 和 otherKey的集合的成员的交集保存在 destKey的集合中.如果destKey的集合存在, 则会被重写.
	 *
	 * @Title intersectAndStore   
	 * @Description   
	 * @param key
	 * @param otherKey
	 * @param destKey
	 * @return 结果集中成员的个数.
	 *
	 */
	Long intersectAndStore(String key, String otherKey, String destKey);

	/**
	 * 将key的集合和所有集合otherKeys的成员的交集保存在 destKey的集合中.如果destKey的集合存在, 则会被重写.
	 *
	 * @Title intersectAndStore   
	 * @Description   
	 * @param key
	 * @param otherKeys
	 * @param destKey
	 * @return 结果集中成员的个数.
	 *
	 */
	Long intersectAndStore(String key, Collection<String> otherKeys, String destKey);

	/**
	 * 返回指定key 和 otherKey的集合的成员的并集.
	 *
	 * @Title union   
	 * @Description   
	 * @param key
	 * @param otherKey
	 * @return
	 *
	 */
	Set<Object> union(String key, String otherKey);

	/**
	 * 返回key的集合和指定所有的集合otherKeys的成员的并集.
	 *
	 * @Title union   
	 * @Description   
	 * @param key
	 * @param otherKeys
	 * @return
	 *
	 */
	Set<Object> union(String key, Collection<String> otherKeys);

	/**
	 * 将key的集合和 otherKey的集合的成员的并集保存在 destKey的集合中.如果destKey的集合存在, 则会被重写.
	 *
	 * @Title unionAndStore   
	 * @Description   
	 * @param key
	 * @param otherKey
	 * @param destKey
	 * @return
	 *
	 */
	Long unionAndStore(String key, String otherKey, String destKey);

	/**
	 * 将key的集合和指定所有集合otherKeys的成员的并集保存在 destKey的集合中.如果destKey的集合存在, 则会被重写.
	 *
	 * @Title unionAndStore
	 * @Description   
	 * @param key
	 * @param otherKeys
	 * @param destKey
	 * @return
	 *
	 */
	Long unionAndStore(String key, Collection<String> otherKeys, String destKey);

	/**
	 * 返回指定key 和 otherKey的集合的成员的差集.
	 *
	 * @Title difference   
	 * @Description   
	 * @param key
	 * @param otherKey
	 * @return
	 *
	 */
	Set<Object> difference(String key, String otherKey);

	/**
	 * 返回key的集合和指定所有的集合otherKeys的成员的差集.
	 *
	 * @Title difference   
	 * @Description   
	 * @param key
	 * @param otherKeys
	 * @return
	 *
	 */
	Set<Object> difference(String key, Collection<String> otherKeys);

	/**
	 * 将key的集合和 otherKey的集合的成员的差集保存在 destKey的集合中.如果destKey的集合存在, 则会被重写.
	 *
	 * @Title differenceAndStore   
	 * @Description   
	 * @param key
	 * @param otherKey
	 * @param destKey
	 * @return
	 *
	 */
	Long differenceAndStore(String key, String otherKey, String destKey);

	/**
	 * 将key的集合和指定所有集合otherKeys的成员的差集保存在 destKey的集合中.如果destKey的集合存在, 则会被重写.
	 *
	 * @Title differenceAndStore   
	 * @Description   
	 * @param key
	 * @param otherKeys
	 * @param destKey
	 * @return
	 *
	 */
	Long differenceAndStore(String key, Collection<String> otherKeys, String destKey);

	/**
	 * 返回key集合所有的元素.
	 *
	 * @Title members   
	 * @Description   
	 * @param key
	 * @return
	 *
	 */
	Set<Object> members(String key);

	/**
	 * 随机返回key集合中的一个元素
	 *
	 * @Title randomMember   
	 * @Description   
	 * @param key
	 * @return
	 *
	 */
	Object randomMember(String key);

	/**
	 * 随机返回key集合中指定数据count个元素
	 * 如果count是整数且小于元素的个数，返回含有 count 个不同的元素的集合,如果count是个整数且大于集合中元素的个数时,仅返回整个集合的所有元素,
	 * 当count是负数,则会返回一个包含count的绝对值的个数元素的集合，如果count的绝对值大于元素的个数,则返回整个集合的所有元素.
	 *
	 * @Title distinctRandomMembers   
	 * @Description   
	 * @param key
	 * @param count
	 * @return
	 *
	 */
	Set<Object> distinctRandomMembers(String key, long count);

	/**
	 * 随机返回key集合中指定数据count个元素
	 * 如果count是整数且小于元素的个数，返回含有 count 个不同的元素的集合,如果count是个整数且大于集合中元素的个数时,仅返回整个集合的所有元素,
	 * 当count是负数,则会返回一个包含count的绝对值的个数元素的集合，如果count的绝对值大于元素的个数,则返回的结果集里会出现一个元素出现多次的情况.
	 *
	 * @Title randomMembers   
	 * @Description   
	 * @param key
	 * @param count
	 * @return
	 *
	 */
	List<Object> randomMembers(String key, long count);

	/**
	 * scan方法是一个基于游标的迭代器
	 *
	 * @Title scan   
	 * @Description   
	 * @param key
	 * @param options
	 * @return
	 *
	 */
	Cursor<Object> scan(String key, ScanOptions options);
}

