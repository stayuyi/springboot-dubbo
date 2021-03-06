package com.yy.provider1.rabbitMQ;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer {
    private final static String QUEUE_NAME="rabbit.test";

    public static void main(String[] args) throws IOException, TimeoutException {
        /**创建连接工厂*/
        ConnectionFactory connectionFactory=new ConnectionFactory();

        /**设置RabbitMQ地址*/
        connectionFactory.setHost("lockahost");

        /**创建一个新连接 */
        Connection connection = connectionFactory.newConnection();

        /** 穿件一个频道*/
        Channel channel = connection.createChannel();

        /**声明需要关注的队列*/
        channel.queueDeclare(QUEUE_NAME, false, false, true, null);
        System.out.println("Customer Waiting Received messages");


        /**
         * DefaultConsumer类实现了Consumer接口，通过传入一个频道，
         * 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
         */
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message=new String(body,"UTF-8");
                System.out.println("Customer Received:"+message);
            }
        };
        /**自动回复队列应答,RabbitMQ中消息确认机制*/
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
