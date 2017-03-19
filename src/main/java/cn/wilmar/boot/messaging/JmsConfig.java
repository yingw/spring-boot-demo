package cn.wilmar.boot.messaging;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JmsConfig {

	public static final String DEMO_QUEUE_NAME = "spring.boot.demo.queue";

	@Bean
	public Queue queue() {
		return new ActiveMQQueue(DEMO_QUEUE_NAME);
	}

}
