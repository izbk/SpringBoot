package cn.mldn.microboot.producer.impl;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import cn.mldn.microboot.config.ProducerConfig;
import cn.mldn.microboot.producer.IMessageProducerService;
import cn.mldn.microboot.vo.Dept;
@Service("topicMessageProducerService")
public class TopicMessageProducerServiceImpl implements IMessageProducerService {
	@Resource
	private RabbitTemplate rabbitTemplate;
	@Override
	public void sendMessage(String msg) {
		this.rabbitTemplate.convertAndSend(ProducerConfig.TOPICEXCHANGE,
				ProducerConfig.TOPICROUTINGKEY, msg);
		this.rabbitTemplate.convertAndSend(ProducerConfig.TOPICEXCHANGE,
				ProducerConfig.TOPICROUTINGKEYS, msg);
	}
	@Override
	public void sendMessage(Dept dept) {
		this.rabbitTemplate.convertAndSend(ProducerConfig.TOPICEXCHANGE,
				ProducerConfig.TOPICROUTINGKEY, dept);
		this.rabbitTemplate.convertAndSend(ProducerConfig.TOPICEXCHANGE,
				ProducerConfig.TOPICROUTINGKEYS, dept);
	}

}
