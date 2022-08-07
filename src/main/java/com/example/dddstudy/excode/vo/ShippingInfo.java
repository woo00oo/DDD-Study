package com.example.dddstudy.excode.vo;

import lombok.Getter;

@Getter
public class ShippingInfo {
    private Receiver receiver;
    private Address address;

    public ShippingInfo(Receiver receiver, Address address) {
        this.receiver = receiver;
        this.address = address;
    }

}
