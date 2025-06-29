package com.octatco.sso.domains;

import static com.octatco.sso.domains.CommonResponse.Result.*;

/**
 * 공통 응답 객체
 */
public record CommonResponse<T>(
        Result isSuccess,
        String code,
        String message,
        T data
) {

    public static <T> CommonResponse<T> success(T data) {
        return success(GlobalSuccessResponseCode.OK, data);
    }

    public static <T> CommonResponse<T> success() {
        return success(GlobalSuccessResponseCode.NO_CONTENT);
    }

    public static <T> CommonResponse<T> success(ResponseCode responseCode) {
        return success(responseCode, null);
    }

    public static <T> CommonResponse<T> success(ResponseCode responseCode, T data) {
        return new CommonResponse<>(SUCCESS, responseCode.getCode(), responseCode.getMessage(), data);
    }

    // 실패
    public static <T> CommonResponse<T> fail(ResponseCode responseCode) {
        return fail(responseCode, null);
    }

    public static <T> CommonResponse<T> fail(ResponseCode responseCode, T data) {
        return new CommonResponse<>(FAIL, responseCode.getCode(), responseCode.getMessage(), data);
    }

    // 에러
    public static CommonResponse<String> error(ResponseCode responseCode, String message) {
        return new CommonResponse<>(FAIL, responseCode.getCode(), message, null);
    }

    public static CommonResponse<String> error(ResponseCode responseCode, Exception exception) {
        return new CommonResponse<>(FAIL, responseCode.getCode(), responseCode.getMessage(), exception.getMessage());
    }

    public enum Result {
        SUCCESS, FAIL
    }
}
