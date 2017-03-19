package cn.wilmar.boot.messaging;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Producer {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

//	@Autowired
//	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue queue;

//	@Scheduled(fixedDelay = 5000)
	public void send() {
//		this.jmsTemplate.convertAndSend(this.queue, "Sample Message");
		this.jmsMessagingTemplate.convertAndSend(this.queue, "Sample Message");
		System.out.println("Producer.send()");
	}
}
