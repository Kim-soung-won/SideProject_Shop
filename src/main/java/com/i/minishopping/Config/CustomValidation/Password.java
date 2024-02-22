package com.i.minishopping.Config.CustomValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD, ElementType.FIELD}) //어노테이션이 적용될 대상 지정{method, field}
@Retention(RetentionPolicy.RUNTIME) //어노테이션 유지정책 RUNTIME = 런타임까지 살아남아 유지한다, 리플렉션으로 접근 가능
@Constraint(validatedBy = CustomRuleValidator.class)
// @Password 어노테이션이 빈 밸리데이션 제약 사항을 포함함을 의미, validatedBy 속성을 통해 구현된 클래스를 지정
public @interface Password {
//    Password 어노테이션 정의
    String message() default "Password do not adhere to the specified rule"; //유효성 검증 실패시 메시지
    Class<?>[] groups() default {}; //어노테이션 그룹화 빈배열이 기본값
    Class<? extends Payload>[] payload() default {}; //유효성 검증에 필요한 메타데이터 지정
}
