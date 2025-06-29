package com.octatco.sso.domains;

/**
 * 공통 응답 코드에서 사용 해야 하는 필드를 강제하기 위한 인터페이스
 * @see CommonResponse CommonResponse 공통 응답 객체
 * @see GlobalSuccessResponseCode SuccessResponseCode 응답 성공시 응답 코드
 */
public interface ResponseCode {
    String getCode();
    String getMessage();
}
