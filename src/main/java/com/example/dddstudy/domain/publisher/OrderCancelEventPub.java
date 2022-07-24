package com.example.dddstudy.domain.publisher;

import com.example.dddstudy.domain.event.OrderCanceledEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderCancelEventPub {
    private final ApplicationEventPublisher publisher;

    public void pub(OrderCanceledEvent evt) {
        log.info("이벤트 발행 시작");
        publisher.publishEvent(evt);
    }
}
