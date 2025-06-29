package com.octatco.sso.aop;

import com.octatco.sso.domains.GlobalErrorResponseCode;
import com.octatco.sso.domains.ResponseCode;

public class ResponseCodeHelper {

    /**
     * http status code를 기반으로 ResponseCode를 반환
     * @param httpStatusCode http status code
     * @return ResponseCode
     */
    public static ResponseCode httpStatusErrorCodeToResponseCode(int httpStatusCode) {
        return switch (httpStatusCode) {
            case 400 -> GlobalErrorResponseCode.BAD_REQUEST;
            case 401 -> GlobalErrorResponseCode.UNAUTHORIZED;
            case 403 -> GlobalErrorResponseCode.FORBIDDEN;
            case 404 -> GlobalErrorResponseCode.NOT_FOUND;
            case 405 -> GlobalErrorResponseCode.METHOD_NOT_ALLOWED;
            case 406 -> GlobalErrorResponseCode.NOT_ACCEPTABLE;
            case 408 -> GlobalErrorResponseCode.REQUEST_TIMEOUT;
            case 409 -> GlobalErrorResponseCode.CONFLICT;
            case 413 -> GlobalErrorResponseCode.REQUEST_ENTITY_TOO_LARGE;
            case 414 -> GlobalErrorResponseCode.REQUEST_URI_TOO_LONG;
            case 415 -> GlobalErrorResponseCode.UNSUPPORTED_MEDIA_TYPE;
            case 429 -> GlobalErrorResponseCode.TOO_MANY_REQUESTS;
            case 503 -> GlobalErrorResponseCode.SERVICE_UNAVAILABLE;
            case 504 -> GlobalErrorResponseCode.GATEWAY_TIMEOUT;
            default -> GlobalErrorResponseCode.INTERNAL_SERVER_ERROR;
        };
    }
}
