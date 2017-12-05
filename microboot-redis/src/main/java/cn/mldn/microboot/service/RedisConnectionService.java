/**
 * Project Name microboot-redis
 * File Name RedisConnectionService.java
 * Package Name cn.mldn.microboot.service
 * Date 2017年12月5日下午2:55:57
 * Copyright (c) 2017, izbk@163.com All Rights Reserved.
 *
*/
/**
 * 
 * @Title  RedisConnectionService.java   
 * @Package cn.mldn.microboot.service   
 * @Description      
 * @author Binke Zhang    
 * @date   2017年12月5日 下午2:55:57   
 * @version V1.0 
 * @Copyright: 2017 izbk@163.com All rights reserved. 
 *
 */

package cn.mldn.microboot.service;

/**
 * 
 * @ClassName  RedisConnectionService   
 * @Description
 * @author Binke Zhang
 * @date  2017年12月5日 下午2:55:57     
 * @Copyright: 2017  izbk@163.com All rights reserved. 
 */
public interface RedisConnectionService {
	/**
	 * 打印信息
	 *
	 * @Title echo   
	 * @Description   
	 * @param msg
	 * @return
	 *
	 */
	public String echo(String msg); 
    /**
     * 检验连接
     *
     * @Title ping   
     * @Description   
     * @return
     * @throws
     *
     */
    public String ping(); 
    /**
     * 选择数据库
     *
     * @Title select   
     * @Description
     * @param dbIndex
     * @return
     * @throws
     *
     */
    public void select(Integer dbIndex); 
}

