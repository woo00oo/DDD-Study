package com.example.dddstudy.domain.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//@Embeddable
public class ProductId implements Serializable {

    @Column(name = "product_id")
    private String id;

    protected ProductId() {}
}
