package com.example.dddstudy.domain.converter;

import com.example.dddstudy.domain.vo.Money;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class MoneyConverter implements AttributeConverter<Money, Integer> {

    // 밸류 타입 -> DB 칼럼 변환
    @Override
    public Integer convertToDatabaseColumn(Money money) {
        return money == null ? null : money.getValue();
    }

    // DB 칼럼 -> 밸류 타입 변환
    @Override
    public Money convertToEntityAttribute(Integer value) {
        return value == null ? null : new Money(value);
    }
}

/**
 * 밸류 타입의 프로퍼티를 한 개 컬럼에 매핑해야 할 때 사용.
 * AttributeConverter는 밸류 타입과 칼럼 데이터 간의 변환을 처리하기 위한 기능을 정의.
 */