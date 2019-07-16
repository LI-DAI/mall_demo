/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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

    @Bean
    public Queue queue() {
        return new Queue("order");
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("direct_order_exchange");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with("order.create");
    }
}

