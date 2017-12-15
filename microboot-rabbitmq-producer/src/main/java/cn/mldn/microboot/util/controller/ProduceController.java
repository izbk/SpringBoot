package cn.mldn.microboot.util.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mldn.microboot.producer.IMessageProducerService;
import cn.mldn.microboot.vo.Dept;

@RestController
@RequestMapping("/rabbit")
public class ProduceController {
	@Resource
	private IMessageProducerService messageProducerService;
	@Resource
	private IMessageProducerService messageProducerService2;
	@Resource
	private IMessageProducerService topicMessageProducerService;

	/**
	 * 单生产者-单消费者
	 * @param msg
	 */
	@GetMapping("/oneToOne")
	public void send(String msg) {
		messageProducerService.sendMessage(msg);
	}
	
    /**
     * 单生产者-多消费者
     */
    @GetMapping("/oneToMany")
    public void oneToMany(String msg) {
        for(int i=0;i<10;i++){
        	messageProducerService.sendMessage(msg+i);
        }
    }
    
    /**
     * 多生产者-多消费者
     */
    @GetMapping("/manyToMany")
    public void manyToMany(String msg) {
        for(int i=0;i<10;i++){
        	messageProducerService.sendMessage("sender1:"+msg+i);
        	messageProducerService2.sendMessage("sender2:"+msg+i);
        }
    }
    
	/**
	 * 发送实体
	 * @param msg
	 */
	@GetMapping("/sendObject")
	public void send(Long deptno,String dname) {
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		dept.setDname(dname);
		messageProducerService.sendMessage(dept);
	}
	
	/**
	 * 发送Topic
	 * @param msg
	 */
	@GetMapping("/sendTopic")
	public void sendTopic(String msg) {
		topicMessageProducerService.sendMessage(msg);
	}
}
