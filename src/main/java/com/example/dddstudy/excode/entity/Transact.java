package com.example.dddstudy.excode.entity;

import com.example.dddstudy.excode.vo.MerchantCommonSettings;
import com.example.dddstudy.excode.vo.Money;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Transact {
    private String transNo;
    private Money amount;
    private MerchantCommonSettings settings;

    /**
     * 결제 데이터 생성
     * @param amount
     * @param settings
     */
    public Transact(Money amount, MerchantCommonSettings settings) {
        this.transNo = UUID.randomUUID().toString();
        this.amount = amount;
        this.settings = settings;
    }
}
