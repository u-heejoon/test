package com.octatco.sso.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 인증/인가 처리할 때 사용할 상수
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthConstants {
    public static final String REDIRECT_URI = "redirectUri";
    public static final String TOKEN_PREFIX = "Bearer ";
}
