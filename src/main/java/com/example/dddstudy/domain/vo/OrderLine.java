package com.example.dddstudy.domain.vo;


import com.example.dddstudy.domain.converter.MoneyConverter;
import com.example.dddstudy.domain.id.ProductId;

import javax.persistence.*;

@Embeddable
public class OrderLine {

    //@Embedded
    private ProductId productId;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "price")
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "amounts")
    private Money amounts;

    protected OrderLine() {}

}
