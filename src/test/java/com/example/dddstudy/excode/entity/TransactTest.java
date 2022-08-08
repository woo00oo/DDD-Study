package com.example.dddstudy.excode.entity;

import com.example.dddstudy.excode.vo.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TransactTest {

    @DisplayName("카카오페이 결제")
    @Test
    void kakaopay_test() {

        //when

        /**
         * 레파지토리 클래스를 따로 구현하지 않았기에 아래의 코드가 동작한다고 가정
         *
         * merchantSettingRepository.findByMid(mid);
         * kakaopaySettingRepository.findByMid(mid);
         */
        MerchantCommonSettings merchantCommonSettings = new MerchantCommonSettings("Y", "Y", "Y");
        KakaopaySettings kakaopaySettings = new KakaopaySettings();

        //given
        merchantCommonSettings.setPayEasySettings(kakaopaySettings);
        Transact transact = new Transact(new Money(1000), merchantCommonSettings);

        //then
        assertThat(transact.getSettings().getPayEasySettings()).isInstanceOf(KakaopaySettings.class);

    }

    @DisplayName("페이코 결제")
    @Test
    void payco_test() {

        //when

        /**
         * 레파지토리 클래스를 따로 구현하지 않았기에 아래의 코드가 동작한다고 가정
         *
         * merchantSettingRepository.findByMid(mid);
         * paycoSettingRepository.findByMid(mid);
         */
        MerchantCommonSettings merchantCommonSettings = new MerchantCommonSettings("Y", "Y", "Y");
        PaycoSettings paycoSettings = new PaycoSettings();

        //given
        merchantCommonSettings.setPayEasySettings(paycoSettings);
        Transact transact = new Transact(new Money(1000), merchantCommonSettings);

        //then
        assertThat(transact.getSettings().getPayEasySettings()).isInstanceOf(PaycoSettings.class);

    }

    @DisplayName("신용카드 결제")
    @Test
    void creditCard_test() {

        //when

        /**
         * 레파지토리 클래스를 따로 구현하지 않았기에 아래의 코드가 동작한다고 가정
         *
         * merchantSettingRepository.findByMid(mid);
         * creditCardSettingRepository.findByMid(mid);
         */
        MerchantCommonSettings merchantCommonSettings = new MerchantCommonSettings("Y", "Y", "Y");
        CreditCardSettings creditCardSettings = new CreditCardSettings();

        //given
        /**
         * 신용 카드 관련 세팅 정보를 간편 결제 관련 세팅 정보에 세팅할 경우 -> 체크익셉션 발생.
         */
        //merchantCommonSettings.setPayEasySettings(creditCardSettings);
        merchantCommonSettings.setCreditCardSettings(creditCardSettings);
        Transact transact = new Transact(new Money(1000), merchantCommonSettings);

        //then
        assertThat(transact.getSettings().getCreditCardSettings()).isInstanceOf(CreditCardSettings.class);

    }

}

/**
 * 새로운 간편 결제 수단을 추가 한다고 가정하면, PayEasySettings 인터페이스를 상속 받은 구체 구현 클래스만 개발하면 된다. 기존 코드를 수정할 필요가 없다.
 */