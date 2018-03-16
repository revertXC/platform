package com.deer.activemq.demo;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class TopiceConsum extends BaseObject {

    public static void main(String[] args) throws JMSException {
        //创建一个连接HelloWorld的消息队列
        destination = session.createTopic("Topice001");
        //创建消息消费者
        messageConsumer = session.createConsumer(destination);
        while (true) {
            TextMessage message = (TextMessage) messageConsumer.receive(10000);
            if(message != null){
                System.out.println("收到的消息:" + message.getText());
            }
        }
    }

}
