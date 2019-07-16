/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.rabbitMQ;

import com.mall.market.entity.ProductBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lidai
 * @date 2019/7/16 15:49
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMessageTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 测试点对点direct
     */
    @Test
    public void test_1() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "消息测试");
        map.put("data", new ProductBrand(1l, "name", "131", "fsd", "ddd", "logo", "0", 1));
        rabbitTemplate.convertAndSend("Exchange.direct", "lidai", map);

    }

    @Test
    public void test_2() {
        Object obj = rabbitTemplate.receiveAndConvert("lidai.news");
        HashMap map = (HashMap) obj;
        System.out.println(map);
    }


    /**
     * 测试广播fanout
     */
    @Test
    public void test_3() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "广播测试");
        map.put("data", new ProductBrand(1l, "name", "131", "fsd", "ddd", "logo", "0", 1));
        rabbitTemplate.convertAndSend("Exchange.fanout", "", map);
    }

    @Test
    public void test_4() {
        rabbitTemplate.convertAndSend("direct_order_exchange", "order.create", "this is order test !");
    }

}

