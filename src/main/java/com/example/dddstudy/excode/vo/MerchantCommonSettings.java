package com.example.dddstudy.excode.vo;

import lombok.Getter;

@Getter
public class MerchantCommonSettings<T extends PayEasySettings> {

    private String dmPlusYn;
    private String midSwapYn;
    private String sendErrorEmailYn;
    private T payEasySettings;

    /**
     * 간편 결제일 경우 추가 설정
     */
    public void setPayEasySettings(T payEasySettings) {
        this.payEasySettings = payEasySettings;
    }

    /**
     * 결제 공통 설정 VO 객체 생성
     * @param dmPlusYn
     * @param midSwapYn
     * @param sendErrorEmailYn
     */
    public MerchantCommonSettings(String dmPlusYn, String midSwapYn, String sendErrorEmailYn) {
        this.dmPlusYn = dmPlusYn;
        this.midSwapYn = midSwapYn;
        this.sendErrorEmailYn = sendErrorEmailYn;
    }
}
