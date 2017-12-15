package cn.mldn.microboot.consumer.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import cn.mldn.microboot.config.ConsumerConfig;
import cn.mldn.microboot.consumer.IMessageConsumerService;
import cn.mldn.microboot.vo.Dept;

@Service("topicMessageConsumerService")
public class TopicMessageConsumerServiceImpl implements IMessageConsumerService{
	
	@Override
	@RabbitListener(queues=ConsumerConfig.TOPIC_QUEUE)
	@RabbitHandler
	public void receiveMessage(String text) {
		System.err.println("topic reciiver1:" + text);
	}

	@Override
//	@RabbitListener(queues=ConsumerConfig.TOPIC_QUEUE)
//	@RabbitHandler
	public void receiveMessage(Dept dept) {
		System.err.println("topic reciiver1:" + dept);
	}
}
