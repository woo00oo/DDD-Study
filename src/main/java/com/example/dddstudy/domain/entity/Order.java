package com.example.dddstudy.domain.entity;

import com.example.dddstudy.domain.id.OrderNo;
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

    @Column(name = "total_amounts")
    private Money totalAmounts;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_line",
                joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines = new ArrayList<>();

    protected Order() {}
}
