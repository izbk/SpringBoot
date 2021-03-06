package cn.mldn.microboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {
	/**
	 * 消息交换机名称
	 */
	public static final String DIRECTEXCHANGE = "mldn.microboot.direct.exchange";
	/**
	 * 消息交换机名称
	 */
	public static final String TOPICEXCHANGE = "mldn.microboot.topic.exchange";
	/**
	 * string路由关键字，exchange根据这个关键字进行消息投递
	 */
	public static final String ROUTINGKEY = "mldn.microboot.string.routingkey";
	/**
	 * object路由关键字，exchange根据这个关键字进行消息投递
	 */
	public static final String OBJECTROUTINGKEY = "mldn.microboot.object.routingkey";
	/**
	 * topic路由关键字，exchange根据这个关键字进行消息投递
	 */
	public static final String TOPICROUTINGKEY = "mldn.microboot.topic.routingkey";
	/**
	 * topic路由关键字，exchange根据这个关键字进行消息投递
	 */
	public static final String TOPICROUTINGKEYS = "mldn.microboot.topic.#";
	/**
	 * 消息队列名称
	 */
	public static final String STRING_QUEUE = "mldn.microboot.string.queue";
	/**
	 * 消息队列名称
	 */
	public static final String OBJECT_QUEUE = "mldn.microboot.object.queue";
	/**
	 * 消息队列名称
	 */
	public static final String TOPIC_QUEUE = "mldn.microboot.topic.queue";
	/**
	 * 消息队列名称
	 */
	public static final String TOPIC_QUEUES = "mldn.microboot.topic.queues";
	/**
	 * queue消息队列载体，每个消息都会被投入到一个或多个队列。
	 * @return
	 */
	@Bean
	public Queue queue() {
		return new Queue(STRING_QUEUE);
	}
	/**
	 * objectQueue消息队列载体，每个消息都会被投入到一个或多个队列。
	 * @return
	 */
	@Bean
	public Queue objectQueue() {
		return new Queue(OBJECT_QUEUE);
	}
	/**
	 * topicQueue消息队列载体，每个消息都会被投入到一个或多个队列。
	 * @return
	 */
    @Bean
    public Queue topicQueue() {
        return new Queue(TOPIC_QUEUE);
    }
    /**
     * topicQueues消息队列载体，每个消息都会被投入到一个或多个队列。
     * @return
     */
    @Bean
    public Queue topicQueues() {
    	return new Queue(TOPIC_QUEUES);
    }
	/**
	 * 消息交换机，它指定消息按什么规则，路由到哪个队列。
	 * FanoutExchange:将消息分发到所有的绑定队列，无routingkey的概念
	 * HeadersExchange:通过添加属性key-value匹配
	 * DirectExchange:按照routingkey分发到指定队列
	 * TopicExchange:多关键字匹配
	 * @return
	 */
	@Bean
	public DirectExchange getDirectExchange() {
		return new DirectExchange(DIRECTEXCHANGE, true, true);
	}
	
    @Bean
    public TopicExchange getTopicExchange() {
        return new TopicExchange(TOPICEXCHANGE);
    }
	/**
	 * 绑定，它的作用就是把exchange和queue按照路由规则绑定起来。
	 * @param exchange
	 * @param queue
	 * @return
	 */
	@Bean
	public Binding bindingExchangeStringQueue(DirectExchange exchange,Queue queue) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY) ;
	}
	/**
	 * 绑定，它的作用就是把exchange和queue按照路由规则绑定起来。
	 * @param exchange
	 * @param queue
	 * @return
	 */
	@Bean
	public Binding bindingExchangeObjectQueue(DirectExchange exchange,Queue objectQueue) {
		return BindingBuilder.bind(objectQueue).to(exchange).with(OBJECTROUTINGKEY) ;
	}
	
    /**
     * 将队列topic.messages与exchange绑定，binding_key为mldn.microboot.topic.routingkey
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeTopicQueue(Queue topicQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue).to(topicExchange).with(TOPICROUTINGKEY);
    }
    /**
     * 将队列topic.messages与exchange绑定，binding_key为mldn.microboot.topic.#,模糊匹配
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeTopicQueues(Queue topicQueues, TopicExchange topicExchange) {
    	return BindingBuilder.bind(topicQueues).to(topicExchange).with(TOPICROUTINGKEYS);
    }

}
