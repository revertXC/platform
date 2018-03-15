package com.deer.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class BaseObject {

    //默认连接用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    //连接工厂
    protected static ConnectionFactory connectionFactory = null;
    //连接
    protected static Connection connection = null;
    //会话 接受或者发送消息的线程
    protected static Session session;
    //消息的目的地
    protected static Destination destination;
    //消息生产者
    protected static MessageProducer messageProducer; //生产者

    protected static MessageConsumer messageConsumer;//消息的消费者

    static {
        try{
            //实例化连接工厂
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
