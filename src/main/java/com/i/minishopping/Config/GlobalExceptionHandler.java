package com.i.minishopping.Config;

import com.i.minishopping.DTOResponse.Common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CommonResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        // 예외 메시지를 포함하여 사용자 정의 응답 반환
        CommonResponse response = new CommonResponse(500, "데이터가 없습니다.");
        log.info("데이터가 없습니다.");
        return  ResponseEntity.ok().body(response);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CommonResponse> handleIllegalArgumentException(NullPointerException ex) {
        // 예외 메시지를 포함하여 사용자 정의 응답 반환
        CommonResponse response = new CommonResponse(500, "데이터가 없습니다.");
        log.info("데이터가 없습니다. Null 이에요");
        return  ResponseEntity.ok().body(response);
    }
}
