package com.example.dddstudy.excode.entity;

import com.example.dddstudy.excode.vo.Money;
import com.example.dddstudy.excode.vo.OrderLine;
import com.example.dddstudy.excode.enumclass.OrderState;
import com.example.dddstudy.excode.vo.ShippingInfo;

import java.util.List;

public class Order {
    private List<OrderLine> orderLines;
    private Money totalAmounts;
    private ShippingInfo shippingInfo;
    private OrderState state;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }

    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }
        this.shippingInfo = shippingInfo;
    }

    /**
     * 최소 한 종류 이상의 상품을 주문 해야 한다
     * @param orderLines
     */
    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    /**
     * 총 주문 금액은 각 상품의 구매 가격 합을 모두 더한 금액이다
     */
    private void calculateTotalAmounts() {
        int sum = this.orderLines.stream()
                .mapToInt(x -> x.getAmounts().getValue())
                .sum();
        this.totalAmounts = new Money(sum);
    }

    /**
     * 출고 상태 확인
     */
    private void verifyNotYetShipped() {
        if (this.state != OrderState.PAYMENT_WAITING
                && this.state != OrderState.PREPARING) {
            throw new IllegalStateException("aleady shipped");
        }
    }

}
