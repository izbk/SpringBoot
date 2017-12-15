package cn.mldn.microboot.consumer.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import cn.mldn.microboot.consumer.IMessageConsumerService;
import cn.mldn.microboot.vo.Dept;

@Service("messageConsumerService2")
public class MessageConsumerServiceImpl2 implements IMessageConsumerService{
	
	@Override
	@RabbitListener(queues="mldn.microboot.queue")
	@RabbitHandler
	public void receiveMessage(String text) {
		System.err.println("receiver2" + text);
	}

	@Override
	public void receiveMessage(Dept dept) {
		// TODO Auto-generated method stub
		
	}
}
