package com.deer.activemq;

import javax.jms.JMSException;
import javax.jms.Message;

public class TopiceProduct extends  BaseObject {
    public static void main(String[] args) throws JMSException {
        destination = session.createTopic("Topice001");
        //创建消息生产者
        messageProducer = session.createProducer(destination);
        Message message = session.createTextMessage("Hello World TocipMessage");
        messageProducer.send(message);
        session.commit();
        session.close();
        connection.close();
    }
}
