/**
 * 
 * @Title:  RedisService.java   
 * @Package cn.mldn.microboot.service   
 * @Description:       
 * @author: Binke Zhang    
 * @date:   2017年11月20日 下午2:38:21   
 * @version V1.0 
 * @Copyright: 2017 izbk@163.com All rights reserved. 
 *
 */

package cn.mldn.microboot.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis 通用类
 * 
 * @ClassName  RedisService   
 * @Description
 * @author Binke Zhang
 * @date   2017年11月20日 下午2:38:21     
 * @Copyright 2017  izbk@163.com All rights reserved. 
 */
public interface RedisKVService {

	/**
	 * 返回key的value。如果key不存在，返回特殊值nil。
	 *
	 * @Title get   
	 * @Description 
	 * @param key
	 * @return
	 * @throws Exception
	 *
	 */
    public String get(String key) throws Exception;  

    /**
     * 将键key设定为指定的“字符串”值。如果	key	已经保存了一个值，那么这个操作会直接覆盖原来的值，并且忽略原始类型。
     * 当set命令执行成功之后，之前设置的过期时间都将失效
     *
     * @Title set   
     * @Description
     * @param key
     * @param value
     * @throws Exception
     *
     */
    public void set(String key, String value) throws Exception;  
  
    /**
     * 将键key设定为指定的“字符串”值，并设置过期时间。
     *
     * @Title set   
     * @Description   
     * @param key
     * @param value
     * @param timeout
     * @param unit
     * @throws Exception
     *
     */
    public void set(String key, String value, long timeout,TimeUnit unit) throws Exception;
    
    /**
     * 返回所有指定的key的value。对于每个不对应string或者不存在的key，都返回特殊值nil。正因为此，这个操作从来不会失败。
     *
     * @Title mget   
     * @Description   
     * @param keys
     * @return
     * @throws Exception
     *
     */
    public List<String> mget(List<String> keys) throws Exception;
    
    /**
     * 对应给定的keys到他们相应的values上。MSET会用新的value替换已经存在的value，就像普通的SET命令一样。
     *
     * @Title mset   
     * @Description   
     * @param map
     * @throws Exception
     *
     */
    public void mset(Map<String,String> map) throws Exception;
    
    /**
     * 对应给定的keys到他们相应的values上。只要有一个key已经存在，MSETNX一个操作都不会执行。 
     * 由于这种特性，MSETNX可以实现要么所有的操作都成功，要么一个都不执行，
     * 这样可以用来设置不同的key，来表示一个唯一的对象的不同字段。
     *
     * @Title msetnx   
     * @Description   
     * @param map
     * @return boolean
     * @throws Exception
     * 
     *
     */
    
    public boolean msetnx(Map<String,String> map) throws Exception;
    
    /**
     * 如果 key 已经存在，并且值为字符串，那么这个命令会把 value 追加到原来值（value）的结尾。 
     * 如果 key 不存在，那么它将首先创建一个空字符串的key，再执行追加操作，这种情况 APPEND 将类似于 SET 操作
     *
     * @Title append   
     * @Description   
     * @param key
     * @param value
     * @return 返回append后字符串值（value）的长度
     * @throws Exception
     *
     */
    public Integer append(String key,String value) throws Exception;
    
    /**
     * 将key对应的数字加decrement。如果key不存在，操作之前，key就会被置为0。
     * 如果key的value类型错误或者是个不能表示成数字的字符串，就返回错误。
     * 这个操作最多支持64位有符号的正型数字。
     *
     * @Title incrBy   
     * @Description   
     * @param key
     * @param incrBy
     * @return
     * @throws Exception
     *
     */
    public long incrBy(String key,Long incrBy) throws Exception;  
    
    /**
     * 通过指定浮点数key来增长浮点数(存放于string中)的值. 当键不存在时,先将其值设为0再操作.下面任一情况都会返回错误:
     * key 包含非法值(不是一个string).当前的key或者相加后的值不能解析为一个双精度的浮点值.(超出精度范围了)
     *
     * @Title incrBy   
     * @Description   
     * @param key
     * @param incrBy
     * @return
     * @throws Exception
     *
     */
    public Double incrByFloat(String key,Double incrBy) throws Exception;  
  
    /**
     * 删除key
     *
     * @Title deleteKey   
     * @Description   
     * @param keys
     * @throws Exception
     *
     */
    public void deleteKey(List<String> keys) throws Exception;  
  
    /**
     * 清除缓存
     *
     * @Title clear   
     * @Description   
     * @throws Exception
     *
     */
    public void clear() throws Exception;  
  
    /**
     * 验证key是否存在
     *
     * @Title exists   
     * @Description   
     * @param key
     * @return
     * @throws Exception
     *
     */
    public boolean exists(String key) throws Exception;  
    /**
     * 设置key的过期时间，超过时间后，将会自动删除该key。
     *
     * @Title expire   
     * @Description   
     * @param key
     * @param timeout
     * @param unit
     * @return
     * @throws Exception
     *
     */
    public boolean expire(String key,Long timeout,TimeUnit unit) throws Exception;  
    /**
     * 查找所有符合给定模式pattern（正则表达式）的 key 
     *
     * @Title keys   
     * @Description   
     * @param pattern
     * @return Set<String>
     * @throws Exception
     *
     */
    public Set<String> keys(String pattern) throws Exception;  
    /**
     * 移除给定key的生存时间
     *
     * @Title persist   
     * @Description   
     * @param key
     * @return
     * @throws Exception
     *
     */
    public boolean persist(String key) throws Exception;  
    
    /**
     * 返回 key的剩余生存时间
     *
     * @Title getExpire   
     * @Description   
     * @param key
     * @param timeUnit
     * @return
     * @throws Exception
     *
     */
    public Long getExpire(String key,TimeUnit timeUnit) throws Exception;
    
    /**
     * 返回key所存储的value的数据结构类型，它可以返回string, list, set, zset 和 hash等不同的类型
     *
     * @Title type   
     * @Description   
     * @param key
     * @return
     * @throws Exception
     *
     */
    public String type(String key) throws Exception;
  
    /**
     * 刷新缓存
     *
     * @Title flushDB   
     * @Description   
     * @return
     * @throws Exception
     *
     */
    public String flushDB() throws Exception;  
  
    /**
     * 查看db数量
     *
     * @Title dbSize   
     * @Description   
     * @return
     * @throws Exception
     *
     */
    public long dbSize() throws Exception;  
  
    /**
     * 检验连接
     *
     * @Title ping   
     * @Description   
     * @return
     * @throws Exception
     *
     */
    public String ping() throws Exception;  
}

