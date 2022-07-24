package com.example.dddstudy.domain.event;

import com.example.dddstudy.domain.id.OrderNo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCanceledEvent {
    private OrderNo number;
}
