/**
 * Project Name:microboot-redis
 * File Name:ClusterConfigurationProperties.java
 * Package Name:cn.mldn.microboot.config
 * Date:2017年11月21日上午9:33:04
 * Copyright (c) 2017, izbk@163.com All Rights Reserved.
 *
*/
/**
 * 
 * @Title:  ClusterConfigurationProperties.java   
 * @Package cn.mldn.microboot.config   
 * @Description:       
 * @author: Binke Zhang    
 * @date:   2017年11月21日 上午9:33:04   
 * @version V1.0 
 * @Copyright: 2017 izbk@163.com All rights reserved. 
 *
 */

package cn.mldn.microboot.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: ClusterConfigurationProperties
 * @Description:
 * @author: Binke Zhang
 * @date: 2017年11月21日 上午9:33:04
 * @Copyright: 2017 izbk@163.com All rights reserved.
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class ClusterConfigurationProperties {

	/*
	 * spring.redis.cluster.nodes[0] = 127.0.0.1:7379
	 * spring.redis.cluster.nodes[1] = 127.0.0.1:7380 ...
	 */
	List<String> nodes;

	/**
	 * Get initial collection of known cluster nodes in format {@code host:port}
	 * 
	 * @return
	 */
	public List<String> getNodes() {
		return nodes;
	}

	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}
}
