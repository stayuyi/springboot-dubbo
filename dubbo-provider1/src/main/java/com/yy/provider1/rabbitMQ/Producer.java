package com.yy.provider1.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static  final String QUEUE_NAME="rabbitMQ.test";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接connection工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();

        //设置rabbitMQ相关信息
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("1P");
        connectionFactory.setPassword("");
        connectionFactory.setPort(2088);

        //创建一个新连接
        Connection connection = connectionFactory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        //声明一个队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
    /* @param queue the name of the queue
              表示队列名称
     * @param durable true if we are declaring a durable queue (the queue will survive a server restart)
     *        是否持久化（true表示是，队列将在服务器重启时生存）
     * @param exclusive true if we are declaring an exclusive queue (restricted to this connection)
     *        是否是独占队列（创建者可以使用的私有队列，断开后自动删除）
     * @param autoDelete true if we are declaring an autodelete queue (server will delete it when no longer in use)
     *        当所有消费者客户端连接断开时是否自动删除队列
     * @param arguments other properties (construction arguments) for the queue
     *        队列的其他参数
     * */


        String message="Hellw RabbitMQ";

        channel.basicPublish("",QUEUE_NAME,null,message.getBytes("UTF-8"));
  /* * @param exchange the exchange to publish the message to
              交换机名称
     * @param routingKey the routing key
     *        队列映射的路由key
     * @param props other properties for the message - routing headers etc
     *        消息的其他属性
     * @param body the message body
     *        发送信息的主体
     * */

        System.out.println("Producer send:"+message);

        channel.close();
        connection.close();
    }
}
