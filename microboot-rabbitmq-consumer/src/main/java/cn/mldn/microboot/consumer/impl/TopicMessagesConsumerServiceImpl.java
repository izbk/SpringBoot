package cn.mldn.microboot.consumer.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import cn.mldn.microboot.config.ConsumerConfig;
import cn.mldn.microboot.consumer.IMessageConsumerService;
import cn.mldn.microboot.vo.Dept;

@Service("topicMessagesConsumerService")
public class TopicMessagesConsumerServiceImpl implements IMessageConsumerService{
	
	@Override
	@RabbitListener(queues=ConsumerConfig.TOPIC_QUEUES)
	@RabbitHandler
	public void receiveMessage(String text) {
		System.err.println("topic reciiver2:" + text);
	}

	@Override
//	@RabbitListener(queues=ConsumerConfig.TOPIC_QUEUES)
//	@RabbitHandler
	public void receiveMessage(Dept dept) {
		System.err.println("topic reciiver2:" + dept);
	}
}
