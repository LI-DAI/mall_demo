/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author lidai
 * @date 2019/7/16 16:18
 * @since
 */
@Component
public class RabbitMQConsumer {

    //    @RabbitHandler
    @RabbitListener(queues = "fanout_queue")
    public void receive(Map<String, Object> map) {
        System.out.println("收到消息：" + map);
    }

    @RabbitListener(queues = "topic_queue")
    public void receive(Message message) {
        System.out.println(message.getBody().toString());
        System.out.println(message.getMessageProperties().toString());
    }

    @RabbitListener(queues = "order")
    public void receive(String msg) {
        System.out.println("创建了订单：" + msg);
    }
}

