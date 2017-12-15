package cn.mldn.microboot.consumer.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import cn.mldn.microboot.config.ConsumerConfig;
import cn.mldn.microboot.consumer.IMessageConsumerService;
import cn.mldn.microboot.vo.Dept;

@Service("messageConsumerService")

public class MessageConsumerServiceImpl implements IMessageConsumerService{
	
	@Override
	@RabbitListener(queues=ConsumerConfig.STRING_QUEUE)
	@RabbitHandler
	public void receiveMessage(String text) {
		System.err.println("reciiver1:" + text);
	}

	@Override
	@RabbitListener(queues=ConsumerConfig.OBJECT_QUEUE)
	@RabbitHandler
	public void receiveMessage(Dept dept) {
		System.err.println("reciiver1:" + dept);
	}
}
