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

import java.util.Date;
import java.util.Collection;
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
	 * 返回key的value
	 *
	 * @Title get   
	 * @Description 
	 * @param key
	 * @return
	 * @throws Exception
	 *
	 */
    public String get(String key);
    /**
     * 自动将key对应到value并且返回原来key对应的value
     *
     * @Title getAndSet   
     * @Description   
     * @param key
     * @param value
     * @return
     * @throws Exception
     *
     */
    public String getAndSet(String key,String value); 
    
    /**
     * 返回key对应的字符串value的子串，这个子串是由start和end位移决定的（两者都在string内）。
     * 可以用负的位移来表示从string尾部开始数的下标。所以-1就是最后一个字符，-2就是倒数第二个，以此类推
     *
     * @Title getRange   
     * @Description   
     * @param key
     * @param start
     * @param end
     * @return
     * @throws Exception
     *
     */
    public String getRange(String key,Long start,Long end); 

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
    public void set(String key, String value);  
  
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
    public void set(String key, String value, long timeout,TimeUnit unit);
    
    /**
     * 将key设置值为value，如果key不存在，这种情况下等同set。 当key存在时，什么也不做
     *
     * @Title setIfAbsent   
     * @Description   
     * @param key
     * @param value
     * @return
     * @throws Exception
     *
     */
    public Boolean setIfAbsent(String key, String value);
    
    /**
     * 覆盖key对应的string的一部分，从指定的offset处开始，覆盖value的长度。
     * 如果offset比当前key对应string还要长，那这个string后面就补0以达到offset。
     * 不存在的keys被认为是空字符串，所以这个命令可以确保key有一个足够大的字符串，能在offset处设置value。
     *
     * @Title setRange   
     * @Description
     * @param key
     * @param value
     * @throws Exception
     *
     */
    public void setRange(String key, String value,long offset);
    
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
    public Collection<String> multiGet(Collection<String> keys);
    
    /**
     * 对应给定的keys到他们相应的values上。MSET会用新的value替换已经存在的value，就像普通的SET命令一样。
     *
     * @Title mset   
     * @Description   
     * @param map
     * @throws Exception
     *
     */
    public void multiSet(Map<String,String> map);
    
    /**
     * 对应给定的keys到他们相应的values上。只要有一个key已经存在，multiSetIfAbsent一个操作都不会执行。 
     * 由于这种特性，multiSetIfAbsent可以实现要么所有的操作都成功，要么一个都不执行，
     * 这样可以用来设置不同的key，来表示一个唯一的对象的不同字段。
     *
     * @Title multiSetIfAbsent   
     * @Description   
     * @param map
     * @return Boolean
     * @throws Exception
     * 
     *
     */
    
    public Boolean multiSetIfAbsent(Map<String,String> map);
    
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
    public Integer append(String key,String value);
    
    /**
     * 将key对应的数字加decrement。如果key不存在，操作之前，key就会被置为0。
     * 如果key的value类型错误或者是个不能表示成数字的字符串，就返回错误。
     * 这个操作最多支持64位有符号的正型数字。
     *
     * @Title increment   
     * @Description   
     * @param key
     * @param incrBy
     * @return
     * @throws Exception
     *
     */
    public long increment(String key,Long incrBy);  
    
    /**
     * 通过指定浮点数key来增长浮点数(存放于string中)的值. 当键不存在时,先将其值设为0再操作.下面任一情况都会返回错误:
     * key 包含非法值(不是一个string).当前的key或者相加后的值不能解析为一个双精度的浮点值.(超出精度范围了)
     *
     * @Title increment   
     * @Description   
     * @param key
     * @param incrBy
     * @return
     * @throws Exception
     *
     */
    public Double increment(String key,Double incrBy);  
  
    /**
     * 删除key
     *
     * @Title deleteKey   
     * @Description   
     * @param keys
     * @throws Exception
     *
     */
    public void delete(String key);  
    /**
     * 删除keys
     *
     * @Title deleteKey   
     * @Description   
     * @param keys
     * @throws Exception
     *
     */
    public void delete(Collection<String> keys);  
  
    /**
     * 验证key是否存在
     *
     * @Title hasKey   
     * @Description   
     * @param key
     * @return
     * @throws Exception
     *
     */
    public Boolean hasKey(String key);  
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
    public Boolean expire(String key,Long timeout,TimeUnit unit);
    /**
     * 设置key的过期时间，超过时间后，将会自动删除该key。
     *
     * @Title expireAt   
     * @Description   
     * @param key
     * @param date
     * @return
     * @throws Exception
     *
     */
    public Boolean expireAt(String key, Date date);  
    /**
     * 返回 key的剩余生存时间（秒）
     *
     * @Title getExpire   
     * @Description   
     * @param key
     * @param timeUnit
     * @return
     * @throws Exception
     *
     */
    public Long getExpire(String key);
    /**
     * 返回 key的剩余给定单位的生存时间
     *
     * @Title getExpire   
     * @Description   
     * @param key
     * @param timeUnit
     * @return
     * @throws Exception
     *
     */
    public Long getExpire(String key,TimeUnit timeUnit);
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
    public Set<String> keys(String pattern);  
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
    public Boolean persist(String key);
    /**
     * 将当前数据库的 key 移动到给定的数据库 db 当中.如果当前数据库(源数据库)和给定数据库(目标数据库)有相同名字的给定 key ，或者 key 不存在于当前数据库，那么 MOVE 没有任何效果
     *
     * @Title move   
     * @Description   
     * @param key
     * @param dbIndex
     * @return
     * @throws Exception
     *
     */
    public Boolean move(String key,int dbIndex);
    /**
     * 从当前数据库返回一个随机的key
     *
     * @Title randomKey   
     * @Description   
     * @return
     * @throws Exception
     *
     */
    public String randomKey();
    /**
     * 将oldKey重命名为newkey
     *
     * @Title rename   
     * @Description   
     * @param oldKey
     * @param newKey
     * @throws Exception
     *
     */
    public void rename(String oldKey, String newKey);
    /**
     * 当且仅当 newkey 不存在时，将 oldKey 改名为 newkey
     *
     * @Title renameIfAbsent   
     * @Description   
     * @param oldKey
     * @param newKey
     * @return
     * @throws Exception
     *
     */
    public Boolean renameIfAbsent(String oldKey, String newKey);
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
    public String type(String key);
    /**
     * 序列化给定 key ，并返回被序列化的值
     *
     * @Title dump   
     * @Description   
     * @param key
     * @return
     *
     */
    public byte[] dump(String key);
    /**
     * 反序列化给定的序列化值，并将它和给定的 key 关联,并设置key的生存时间
     *
     * @Title restore   
     * @Description   
     * @param key
     * @param value
     * @param timeToLive
     * @param unit
     *
     */
    public void restore(String key, byte[] value, long timeToLive, TimeUnit unit);
    
    /**
     * 返回key的string类型value的长度
     *
     * @Title size   
     * @Description   
     * @return
     * @throws Exception
     *
     */
    public long size(String key); 
  
    /**
     * 刷新缓存
     *
     * @Title flushDB   
     * @Description   
     * @return
     * @throws Exception
     *
     */
    public String flushDB();  
  
    /**
     * 查看db数量
     *
     * @Title dbSize   
     * @Description   
     * @return
     * @throws Exception
     *
     */
    public long dbSize();  
  
    /**
     * 检验连接
     *
     * @Title ping   
     * @Description   
     * @return
     * @throws Exception
     *
     */
    public String ping();  
}

