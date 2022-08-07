package com.example.dddstudy.excode.vo;

import lombok.Getter;

@Getter
public class Address {
    private String Address1;
    private String Address2;
    private String Zipcode;

    public Address(String address1, String address2, String zipcode) {
        Address1 = address1;
        Address2 = address2;
        Zipcode = zipcode;
    }
}
