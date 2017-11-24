/**
 * Project Name microboot-redis
 * File Name RedisListService.java
 * Package Name cn.mldn.microboot.service
 * Date 2017年11月21日下午6:31:27
 * Copyright (c) 2017, izbk@163.com All Rights Reserved.
 *
*/
/**
 * 
 * @Title  RedisListService.java   
 * @Package cn.mldn.microboot.service   
 * @Description      
 * @author Binke Zhang    
 * @date   2017年11月21日 下午6:31:27   
 * @version V1.0 
 * @Copyright: 2017 izbk@163.com All rights reserved. 
 *
 */

package cn.mldn.microboot.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @ClassName  RedisListService   
 * @Description
 * @author Binke Zhang
 * @date  2017年11月21日 下午6:31:27     
 * @Copyright: 2017  izbk@163.com All rights reserved. 
 */
public interface RedisListService {
	/**
	 * 移除并且返回 key 对应的 list 的第一个元素。
	 *
	 * @Title leftPop   
	 * @Description   
	 * @param key
	 * @return
	 * @throws Exception
	 *
	 */
	public Object leftPop(String key) throws Exception;
	/**
	 * 移除并且返回 key 对应的 list 的第一个元素,它是leftPop的阻塞版本，
	 * 连接将被阻塞直到有元素可用或达到 timeout 时限。
	 *
	 * @Title leftPop   
	 * @Description   
	 * @param key
	 * @param timeout
	 * @param unit
	 * @return
	 * @throws Exception
	 *
	 */
	public Object leftPop(String key,Long timeout,TimeUnit unit) throws Exception;
	/**
	 * 将所有指定的值插入到存于 key 的列表的头部。如果 key 不存在，那么在进行 push 操作前会创建一个空列表。
	 *
	 * @Title leftPush   
	 * @Description   
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 *
	 */
	public Long leftPush(String key,Object value) throws Exception;
	/**
	 * 把 value 插入存于 key 的列表中在基准值 pivot 的前面。当 key 不存在时，这个list会被看作是空list，任何操作都不会发生。
	 *
	 * @Title leftPush   
	 * @Description   
	 * @param key
	 * @param pivot
	 * @param value
	 * @return
	 * @throws Exception
	 *
	 */
	public Long leftPush(String key,Object pivot,Object value) throws Exception;
	/**
	 * 将所有指定的值插入到存于 key 的列表的头部
	 *
	 * @Title leftPushAll   
	 * @Description   
	 * @param key
	 * @param values
	 * @return
	 * @throws Exception
	 *
	 */
	public Long leftPushAll(String key,List<Object> values) throws Exception;
	/**
	 * 将所有指定的值插入到存于 key 的列表的头部
	 *
	 * @Title leftPushAll   
	 * @Description   
	 * @param key
	 * @param values
	 * @return
	 * @throws Exception
	 *
	 */
	public Long leftPushAll(String key,Object... values) throws Exception;
	/**
	 * 只有当key已经存在并且存着一个list的时候，在这个key下面的list的头部插value。 
	 * 当key不存在的时候不会进行任何操作。
	 *
	 * @Title leftPushIfPresent   
	 * @Description   
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 *
	 */
	public Long leftPushIfPresent(String key,Object value) throws Exception;
	/**
	 * 返回存储在 key 的列表里指定范围内的元素。 start 和 end 偏移量都是基于0的下标，即list的第一个元素下标是0（list的表头），
	 * 第二个元素下标是1，以此类推。偏移量也可以是负数，表示偏移量是从list尾部开始计数。 例如， -1 表示列表的最后一个元素，-2 是倒数第二个，以此类推。
	 *
	 * @Title range   
	 * @Description   
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 *
	 */
	public List<Object> range(String key,Long start,Long end) throws Exception;
	/**
	 * 从存于 key 的列表里移除前 count 次出现的值为 value 的元素。 这个 count 参数通过下面几种方式影响这个操作：
	 * count > 0: 从头往尾移除值为 value 的元素。
     * count < 0: 从尾往头移除值为 value 的元素。
     * count = 0: 移除所有值为 value 的元素。
     * 比如， LREM list -2 “hello” 会从存于 list 的列表里移除最后两个出现的 “hello”。
     * 需要注意的是，如果list里没有存在key就会被当作空list处理，所以当 key 不存在的时候，这个命令会返回 0。
	 *
	 * @Title remove   
	 * @Description   
	 * @param key
	 * @param count
	 * @param value
	 * @return
	 * @throws Exception
	 *
	 */
	public Long remove(String key,Long count,Object value) throws Exception;
	/**
	 * 修剪(trim)一个已存在的 list，这样 list 就会只包含指定范围的指定元素。start 和 stop 都是由0开始计数的， 这里的 0 是列表里的第一个元素（表头），1 是第二个元素，以此类推。
	 * start 和 end 也可以用负数来表示与表尾的偏移量，比如 -1 表示列表里的最后一个元素， -2 表示倒数第二个，等等。
	 *
	 * @Title trim   
	 * @Description   
	 * @param key
	 * @param start
	 * @param end
	 * @throws Exception
	 *
	 */
	public void trim(String key,Long start,Long end) throws Exception;
	/**
	 * 移除并返回存于 key 的 list 的最后一个元素。
	 *
	 * @Title rightPop   
	 * @Description   
	 * @param key
	 * @return
	 * @throws Exception
	 *
	 */
	public Object rightPop(String key) throws Exception;
	/**
	 * 移除并返回存于 key 的 list 的最后一个元素,它是rightPop的阻塞版本，
	 * 连接将被阻塞直到有元素可用或达到 timeout 时限。
	 *
	 * @Title rightPop   
	 * @Description   
	 * @param key
	 * @param timeout
	 * @param unit
	 * @return
	 * @throws Exception
	 *
	 */
	public Object rightPop(String key,Long timeout,TimeUnit unit) throws Exception;
	/**
	 * 向存于 key 的列表的尾部插入所有指定的值。如果 key 不存在，那么会创建一个空的列表然后再进行 push 操作。
	 *
	 * @Title rightPush   
	 * @Description   
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 *
	 */
	public Long rightPush(String key,Object value) throws Exception;
	/**
	 * 把 value 插入存于 key 的列表中在基准值 pivot 的后面。当 key 不存在时，这个list会被看作是空list，任何操作都不会发生。
	 *
	 * @Title rightPush   
	 * @Description   
	 * @param key
	 * @param pivot
	 * @param value
	 * @return
	 * @throws Exception
	 *
	 */
	public Long rightPush(String key,Object pivot,Object value) throws Exception;
	/**
	 * 原子性地返回并移除存储在 source 的列表的最后一个元素（列表尾部元素）， 并把该元素放入存储在 destination 的列表的第一个元素位置（列表头部）。
	 * 例如：假设 source 存储着列表 a,b,c， destination存储着列表 x,y,z。 执行 RPOPLPUSH 得到的结果是 source 保存着列表 a,b ，而 destination 保存着列表 c,x,y,z。
	 * 如果 source 不存在，那么会返回 nil 值，并且不会执行任何操作。 如果 source 和 destination 是同样的，那么这个操作等同于移除列表最后一个元素并且把该元素放在列表头部， 所以这个命令也可以当作是一个旋转列表的命令。
	 *
	 * @Title rightPopAndLeftPush   
	 * @Description   
	 * @param sourceKey
	 * @param destinationKey
	 * @return
	 * @throws Exception
	 *
	 */
	public Object rightPopAndLeftPush(String sourceKey, String destinationKey) throws Exception;
	/**
	 * rightPopAndLeftPush的阻塞版本。 当 source 包含元素的时候，这个方法表现得跟rightPopAndLeftPush一模一样。
	 * 当 source 是空的时候，Redis将会阻塞这个连接，直到另一个客户端 push 元素进入或者达到 timeout 时限。 timeout 为 0 能用于无限期阻塞客户端。
	 *
	 * @Title rightPopAndLeftPush   
	 * @Description   
	 * @param sourceKey
	 * @param destinationKey
	 * @param timeout
	 * @param unit
	 * @return
	 * @throws Exception
	 *
	 */
	public Object rightPopAndLeftPush(String sourceKey, String destinationKey,Long timeout,TimeUnit unit) throws Exception;
	/**
	 * 向存于 key 的列表的尾部插入所有指定的值。
	 *
	 * @Title rightPushAll   
	 * @Description   
	 * @param key
	 * @param values
	 * @return
	 * @throws Exception
	 *
	 */
	public Long rightPushAll(String key,List<Object> values) throws Exception;
	/**
	 * 向存于 key 的列表的尾部插入所有指定的值。
	 *
	 * @Title rightPushAll   
	 * @Description   
	 * @param key
	 * @param values
	 * @return
	 * @throws Exception
	 *
	 */
	public Long rightPushAll(String key,Object... values) throws Exception;
	/**
	 * 将值 value 插入到列表 key 的表尾, 当且仅当 key 存在并且是一个列表。 当 key 不存在时，什么也不做。
	 *
	 * @Title rightPushIfPresent   
	 * @Description   
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 *
	 */
	public Long rightPushIfPresent(String key,Object value) throws Exception;
	/**
	 * 设置 index 位置的list元素的值为 value
	 *
	 * @Title set   
	 * @Description   
	 * @param key
	 * @param index
	 * @param value
	 * @throws Exception
	 *
	 */
	public void set(String key,Long index,Object value) throws Exception;
	/**
	 * 返回存储在key里的list的长度。 如果 key 不存在，那么就被看作是空list，并且返回长度为 0。 
	 *
	 * @Title size   
	 * @Description   
	 * @param key
	 * @return
	 * @throws Exception
	 *
	 */
	public Long size(String key) throws Exception;

}

