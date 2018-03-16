package com.deer.activemq.producer.impI;

import com.deer.activemq.producer.TestProducerable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 测试生产者
 */
@Component
public class TestProducer implements TestProducerable {

    /**
     * JmsTemplate内部发送消息默认为持久化(Topics)的
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    //目的地名
    private static final String destinationName = "testProducer";

    @Override
    public void testSendMessage(final String text) {
        jmsTemplate.send(destinationName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message textMessage = session.createTextMessage(text);
                System.out.println("TestProducer 发送的消息为："+text);
                return textMessage;
            }
        });
    }
}
