package com.run.rshare.common;

import com.run.rshare.entity.gw_request_logs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class MessageSender {

    @Value("${spring.activemq.topic}")
    String topic;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void sendMessage() {
        System.out.println("sendMessage");
        gw_request_logs aLog = new gw_request_logs();
        aLog.setAppId("111");
        aLog.setId("sendMessage");
        jmsTemplate.convertAndSend(topic, aLog);
    }

    @Test
    public void receiveMessage() {
        System.out.println("receiveMessage");
        Object obj = jmsTemplate.receiveAndConvert(topic);
    }
}
