/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.rabbitMQ;

import org.junit.Test;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lidai
 * @date 2019/7/16 16:36
 * @since
 */
public class AmqpAdminTest {

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * AmqpAdmin 可以对交换器，队列，以及绑定路由键操作
     */
    @Test
    public void test_1() {
        amqpAdmin.declareExchange(new FanoutExchange(""));
        amqpAdmin.declareQueue(new Queue(""));
        amqpAdmin.declareBinding(BindingBuilder.bind(new Queue("")).to(new TopicExchange("")).with(""));
        amqpAdmin.declareBinding(BindingBuilder.bind(new Queue("")).to(new DirectExchange("")).with(""));
        amqpAdmin.declareBinding(BindingBuilder.bind(new Queue("")).to(new FanoutExchange("")));
        amqpAdmin.deleteQueue("");
        amqpAdmin.deleteExchange("");
        amqpAdmin.removeBinding(BindingBuilder.bind(new Queue("")).to(new FanoutExchange("")));
    }
}

