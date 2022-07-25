package com.example.dddstudy.domain.handler;

import com.example.dddstudy.domain.event.OrderCanceledEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderCanceledHandler {

    @EventListener(OrderCanceledEvent.class)
    public void handle(OrderCanceledEvent orderCanceledEvent) throws InterruptedException {
        log.info("환불 처리 로직 실행 ={}", orderCanceledEvent);
        Thread.sleep(5000L);
    }
}
