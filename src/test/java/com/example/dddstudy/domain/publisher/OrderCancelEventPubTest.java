package com.example.dddstudy.domain.publisher;

import com.example.dddstudy.domain.entity.Order;
import com.example.dddstudy.domain.id.OrderNo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderCancelEventPubTest {

    @Autowired
    OrderCancelEventPub pub;

    @Test
    void cancle() {
        OrderNo orderNo = new OrderNo("11");
        Order order = new Order(orderNo);

        order.cancel(pub);


    }

}