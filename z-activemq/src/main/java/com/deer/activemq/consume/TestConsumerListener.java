package com.deer.activemq.consume;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class TestConsumerListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try{
            TextMessage textMessage = ((TextMessage)message);
            System.out.println("TestConsumer 接受到消息："+ textMessage.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
