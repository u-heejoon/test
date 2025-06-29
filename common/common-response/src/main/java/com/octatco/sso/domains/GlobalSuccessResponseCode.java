package com.octatco.sso.domains;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 성공 응답 코드
 */
@Getter
@RequiredArgsConstructor
public enum GlobalSuccessResponseCode implements ResponseCode {
    OK("200",  "OK"),
    CREATED("201", "Created"),
    ACCEPTED("202", "Accepted"),
    NO_CONTENT("204", "No Content")

    ;

    private final String code;
    private final String message;
}
