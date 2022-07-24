package com.example.dddstudy.domain.entity;

import com.example.dddstudy.domain.converter.MoneyConverter;
import com.example.dddstudy.domain.enumclass.OrderState;
import com.example.dddstudy.domain.event.OrderCanceledEvent;
import com.example.dddstudy.domain.id.OrderNo;
import com.example.dddstudy.domain.publisher.OrderCancelEventPub;
import com.example.dddstudy.domain.vo.Money;
import com.example.dddstudy.domain.vo.OrderLine;
import com.example.dddstudy.domain.vo.Orderer;
import com.example.dddstudy.domain.vo.ShippingInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "purchase_order")
public class Order {

    @EmbeddedId @GeneratedValue(strategy = GenerationType.IDENTITY)
    private OrderNo number;

    @Embedded
    private Orderer orderer;

    @Embedded
    private ShippingInfo shippingInfo;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "total_amounts")
    private Money totalAmounts;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_line",
                joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines = new ArrayList<>();

    private OrderState state;

    protected Order() {}

    /**
     * 주문 취소
     */
    public void cancel(OrderCancelEventPub publisher) {
        this.state = OrderState.CANCELED;
        publisher.pub(new OrderCanceledEvent(this.number));
    }

    /**
     * 테스트용 생성자
     */
    public Order(OrderNo number) {
        this.number = number;
    }
}
