/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.rabbitMQ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lidai
 * @date 2019/7/16 16:36
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpAdminTest {

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * AmqpAdmin 可以对交换器，队列，以及绑定路由键操作
     */
    @Test
    public void test_1() {
        /**
         * 声明交换器
         */
        amqpAdmin.declareExchange(new FanoutExchange(""));

        /**
         * 声明队列
         */
        amqpAdmin.declareQueue(new Queue(""));

        /**
         * 绑定路由键
         */
        amqpAdmin.declareBinding(BindingBuilder.bind(new Queue("")).to(new TopicExchange("")).with(""));
        amqpAdmin.declareBinding(BindingBuilder.bind(new Queue("")).to(new DirectExchange("")).with(""));
        amqpAdmin.declareBinding(BindingBuilder.bind(new Queue("")).to(new FanoutExchange("")));

        /**
         * 删除队列
         */
        amqpAdmin.deleteQueue("");

        /**
         * 删除交换器
         */
        amqpAdmin.deleteExchange("");

        /**
         * 解绑
         */
        amqpAdmin.removeBinding(BindingBuilder.bind(new Queue("")).to(new FanoutExchange("")));
    }
}

