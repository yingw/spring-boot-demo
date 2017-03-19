package cn.wilmar.boot.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = JmsConfig.DEMO_QUEUE_NAME)
    public void receiveQueue(String text) {
        System.out.println("Received: " + text);
    }
}
