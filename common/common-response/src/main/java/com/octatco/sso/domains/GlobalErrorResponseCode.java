package com.octatco.sso.domains;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GlobalErrorResponseCode implements ResponseCode {
    INTERNAL_SERVER_ERROR("G000", "서버 내부 에러가 발생했습니다."),
    BAD_REQUEST("G001", "잘못된 요청입니다."),
    UNAUTHORIZED("G002", "인증되지 않은 요청입니다."),
    FORBIDDEN("G003", "권한이 없는 요청입니다."),
    NOT_FOUND("G004", "요청한 리소스를 찾을 수 없습니다."),
    METHOD_NOT_ALLOWED("G005", "허용되지 않은 HTTP 메서드입니다."),
    NOT_ACCEPTABLE("G006", "요청한 형식이 처리할 수 없습니다."),
    UNSUPPORTED_MEDIA_TYPE("G007", "지원되지 않는 미디어 타입입니다."),
    TOO_MANY_REQUESTS("G008", "요청 횟수가 너무 많습니다. 잠시 후 다시 시도해주세요."),
    SERVICE_UNAVAILABLE("G009", "서비스가 현재 사용할 수 없습니다. 잠시 후 다시 시도해주세요."),
    GATEWAY_TIMEOUT("G010", "요청이 타임아웃되었습니다. 잠시 후 다시 시도해주세요."),
    HTTP_VERSION_NOT_SUPPORTED("G011", "지원되지 않는 HTTP 버전입니다."),
    REQUEST_TIMEOUT("G012", "요청이 타임아웃되었습니다. 잠시 후 다시 시도해주세요."),
    REQUEST_ENTITY_TOO_LARGE("G013", "요청 엔티티가 너무 큽니다."),
    REQUEST_URI_TOO_LONG("G014", "요청 URI가 너무 깁니다."),
    METHOD_ARG_NOT_VALID("G015", "유효성 오류가 발생했습니다."),
    CONFLICT("G016", "이미 존재하는 리소스입니다.")
    ;
    private final String code;
    private final String message;

}
