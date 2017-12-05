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
import java.util.Set;

import org.springframework.data.redis.connection.RedisZSetCommands.Limit;
import org.springframework.data.redis.connection.RedisZSetCommands.Range;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

/**
 * 
 * @ClassName  RedisSetService   
 * @Description
 * @author Binke Zhang
 * @date  2017年11月23日 下午1:23:13     
 * @Copyright: 2017  izbk@163.com All rights reserved. 
 */
public interface RedisZSetService {

	/**
	 * 将所有指定成员添加到键为key有序集合（sorted set）里面。 如果指定添加的成员已经是有序集合里面的成员，则会更新改成员的分数（scrore）
	 * 并更新到正确的排序位置。如果key不存在，将会创建一个新的有序集合（sorted set）并将分数/成员（score/member）对添加到有序集合
	 *
	 * @param key must not be {@literal null}.
	 * @param score the score.
	 * @param value the value.
	 * @return
	 */
	Boolean add(String key, Object value, double score);

	/**
	 * 将所有指定分数/成员（score/member）对添加到键为key有序集合（sorted set）里面。 如果指定添加的成员已经是有序集合里面的成员，则会更新改成员的分数（scrore）并更新到正确的排序位置。如果key不存在，将会创建一个新的有序集合（sorted set）并将分数/成员（score/member）对添加到有序集合
	 *
	 * @param key must not be {@literal null}.
	 * @param tuples must not be {@literal null}.
	 * @return
	 */
	Long add(String key, Set<TypedTuple<Object>> tuples);

	/**
	 * 在key集合中移除指定的元素
	 *
	 * @param key must not be {@literal null}.
	 * @param values must not be {@literal null}.
	 * @return
	 */
	Long remove(String key, Object... values);

	/**
	 * 为有序集key的成员value的score值加上增量delta。如果key中不存在value，就在key中添加一个value，score是delta。如果key不存在，就创建一个只含有指定value成员的有序集合。
	 *
	 * @param key must not be {@literal null}.
	 * @param delta
	 * @param value the value.
	 * @return
	 */
	Double incrementScore(String key, Object value, double delta);

	/**
	 * 返回有序集key中成员o的排名。其中有序集成员按score值递增(从小到大)顺序排列
	 *
	 * @param key must not be {@literal null}.
	 * @param o the value.
	 * @return
	 */
	Long rank(String key, Object o);

	/**
	 * 返回有序集key中成员o的排名，其中有序集成员按score值从大到小排列
	 *
	 * @param key must not be {@literal null}.
	 * @param o the value.
	 * @return
	 */
	Long reverseRank(String key, Object o);

	/**
	 * 返回有序集 key 中，指定区间内的成员。其中成员的位置按 score 值递增(从小到大)来排序。
	 *
	 * @param key must not be {@literal null}.
	 * @param start
	 * @param end
	 * @return
	 */
	Set<Object> range(String key, long start, long end);

	/**
	 * 返回有序集 key 中，指定区间内的元素和其分数。其中成员的位置按 score 值递增(从小到大)来排序.
	 *
	 * @param key must not be {@literal null}.
	 * @param start
	 * @param end
	 * @return
	 */
	Set<TypedTuple<Object>> rangeWithScores(String key, long start, long end);

	/**
	 * 返回key的有序集合中的分数在min和max之间的所有元素（包括分数等于max或者min的元素）。元素被认为是从低分到高分排序的
	 *
	 * @param key must not be {@literal null}.
	 * @param min
	 * @param max
	 * @return
	 */
	Set<Object> rangeByScore(String key, double min, double max);

	/**
	 * 返回key的有序集合中的分数在min和max之间的所有元素和其分数（包括分数等于max或者min的元素）。元素被认为是从低分到高分排序的
	 *
	 * @param key must not be {@literal null}.
	 * @param min
	 * @param max
	 * @return
	 */
	Set<TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max);

	/**
	 * 返回key的有序集合中的分数在min和max之间的所有元素（包括分数等于max或者min的元素）。指定返回结果的数量及区间（类似SQL中SELECT LIMIT offset, count）
	 *
	 * @param key must not be {@literal null}.
	 * @param min
	 * @param max
	 * @param offset
	 * @param count
	 * @return
	 */
	Set<Object> rangeByScore(String key, double min, double max, long offset, long count);

	/**
	 * 返回key的有序集合中的分数在min和max之间的所有元素和其分数（包括分数等于max或者min的元素）。指定返回结果的数量及区间（类似SQL中SELECT LIMIT offset, count）
	 *
	 * @param key
	 * @param min
	 * @param max
	 * @param offset
	 * @param count
	 * @return
	 */
	Set<TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max, long offset, long count);

	/**
	 * 返回有序集key中，指定区间内的成员。其中成员的位置按score值递减(从大到小)来排列.
	 *
	 * @param key must not be {@literal null}.
	 * @param start
	 * @param end
	 * @return
	 */
	Set<Object> reverseRange(String key, long start, long end);

	/**
	 * 返回有序集 key 中，指定区间内的元素和其分数。其中成员的位置按 score 值递减(从大到小)来排列.
	 *
	 * @param key must not be {@literal null}.
	 * @param start
	 * @param end
	 * @return
	 */
	Set<TypedTuple<Object>> reverseRangeWithScores(String key, long start, long end);

	/**
	 * 返回key的有序集合中的分数在min和max之间的所有元素（包括分数等于max或者min的元素）。其中成员的位置按 score 值递减(从大到小)来排列
	 *
	 * @param key must not be {@literal null}.
	 * @param min
	 * @param max
	 * @return
	 */
	Set<Object> reverseRangeByScore(String key, double min, double max);

	/**
	 * 返回key的有序集合中的分数在min和max之间的所有元素和其分数（包括分数等于max或者min的元素）。其中成员的位置按 score 值递减(从大到小)来排列
	 *
	 * @param key must not be {@literal null}.
	 * @param min
	 * @param max
	 * @return
	 */
	Set<TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max);

	/**
	 * 返回key的有序集合中的分数在min和max之间的所有元素（包括分数等于max或者min的元素）。指定返回结果的数量及区间（类似SQL中SELECT LIMIT offset, count），其中成员的位置按 score 值递减(从大到小)来排列
	 *
	 * @param key must not be {@literal null}.
	 * @param min
	 * @param max
	 * @param offset
	 * @param count
	 * @return
	 */
	Set<Object> reverseRangeByScore(String key, double min, double max, long offset, long count);

	/**
	 * 返回key的有序集合中的分数在min和max之间的所有元素和其分数（包括分数等于max或者min的元素）。指定返回结果的数量及区间（类似SQL中SELECT LIMIT offset, count）,其中成员的位置按 score 值递减(从大到小)来排列
	 *
	 * @param key must not be {@literal null}.
	 * @param min
	 * @param max
	 * @param offset
	 * @param count
	 * @return
	 */
	Set<TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max, long offset, long count);

	/**
	 * 返回有序集key中，score值在min和max之间(默认包括score值等于min或max)的成员
	 *
	 * @param key must not be {@literal null}.
	 * @param min
	 * @param max
	 * @return
	 */
	Long count(String key, double min, double max);

	/**
	 * 返回key的有序集元素个数
	 *
	 * @param key
	 * @return
	 */
	Long size(String key);

	/**
	 * 返回有序集key中，成员o的score值
	 *
	 * @param key must not be {@literal null}.
	 * @param o the value.
	 * @return
	 */
	Double score(String key, Object o);

	/**
	 * 返回有序集key中，指定区间内的成员。其中成员的位置按score值递减(从大到小)来排列
	 *
	 * @param key must not be {@literal null}.
	 * @param start
	 * @param end
	 * @return
	 */
	Long removeRange(String key, long start, long end);

	/**
	 * 移除有序集key中，所有score值介于min和max之间(包括等于min或max)的成员
	 *
	 * @param key must not be {@literal null}.
	 * @param min
	 * @param max
	 * @return
	 */
	Long removeRangeByScore(String key, double min, double max);

	/**
	 * 计算key和给定otherKey的有序集合的并集，并且把结果放到destKey的有序集合中.
	 *
	 * @param key must not be {@literal null}.
	 * @param otherStringey must not be {@literal null}.
	 * @param destStringey must not be {@literal null}.
	 * @return
	 */
	Long unionAndStore(String key, String otherKey, String destKey);

	/**
	 * 计算key和给定otherStringey的所有有序集合的并集，并且把结果放到destStringey的有序集合中.
	 *
	 * @param key must not be {@literal null}.
	 * @param otherStringeys must not be {@literal null}.
	 * @param destStringey must not be {@literal null}.
	 * @return
	 */
	Long unionAndStore(String key, Collection<String> otherStringeys, String destStringey);

	/**
	 * 计算key和给定otherKey的有序集合的交集，并且把结果放到destKey的有序集合中.
	 *
	 * @param key must not be {@literal null}.
	 * @param otherStringey must not be {@literal null}.
	 * @param destStringey must not be {@literal null}.
	 * @return
	 */
	Long intersectAndStore(String key, String otherKey, String destKey);

	/**
	 * 计算key和给定otherStringey的所有有序集合的交集，并且把结果放到destStringey的有序集合中.
	 *
	 * @param key must not be {@literal null}.
	 * @param otherStringeys must not be {@literal null}.
	 * @param destStringey must not be {@literal null}.
	 * @return
	 */
	Long intersectAndStore(String key, Collection<String> otherStringeys, String destStringey);

	/**
	 * 返回指定成员区间内的成员，按成员字典正序排序, 分数必须相同
	 *
	 * @param key must not be {@literal null}.
	 * @param range must not be {@literal null}.
	 * @since 1.7
	 */
	Set<Object> rangeByLex(String key, Range range);

	/**
	 * 返回指定成员区间内的成员，按成员字典正序排序, 分数必须相同，返回limit个成员
	 *
	 * @param key must not be {@literal null}
	 * @param range must not be {@literal null}.
	 * @param limit can be {@literal null}.
	 * @return
	 * @since 1.7
	 */
	Set<Object> rangeByLex(String key, Range range, Limit limit);
}

