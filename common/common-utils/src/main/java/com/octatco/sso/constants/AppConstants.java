package com.octatco.sso.constants;

import lombok.NoArgsConstructor;

/**
 * 애플리케이션 전반적인 부분에서 사용할 상수
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class AppConstants {
    public static final String REQUEST_ID_KEY = "X-REQUEST-ID";

    /**
     * FORMAT
     */
    public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT_YYYYMMDD = "yyyy-MM-dd hh:mm:ss";
    public static final String NUMBER_CHARACTERS = "0123456789";
    public static final String ALPHABET_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final String ALPHABET_AND_NUMBER_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static final String SPECIAL_CHARACTERS = "!@#$%^&*_+-=";

}
