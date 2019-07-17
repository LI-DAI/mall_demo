/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lidai
 * @date 2019/7/16 15:44
 * @since
 */
@Configuration
public class RabbitConfiguration {

    /**
     * 自动转化对象为json
     *
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * direct 模式
     */
    @Bean
    public Queue queue() {
        return new Queue("order");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_order_exchange");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with("order.create");
    }

    /**
     * fanout 模式
     */
    @Bean
    public Queue fanout() {
        return new Queue("fanout_queue");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout_test_exchange");
    }

    @Bean
    public Binding fanoutBinding() {
        return BindingBuilder.bind(fanout()).to(fanoutExchange());
    }

    /**
     * topic 模式
     */
    @Bean
    public Queue topicQueue() {
        return new Queue("topic_queue");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic_test_exchange");
    }

    @Bean
    public Binding topicBinding() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("test.#");
    }

    /**
     * 注：exchange 和 queue 之间的绑定关系是 多对多关系
     */
}

