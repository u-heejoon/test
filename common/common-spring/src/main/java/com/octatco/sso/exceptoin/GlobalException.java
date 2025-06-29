package com.octatco.sso.exceptoin;

import com.octatco.sso.domains.ResponseCode;
import lombok.Getter;

/**
 * Custom exception class
 */
@Getter
public class GlobalException extends RuntimeException {
    private final ResponseCode responseCode;

    public GlobalException(final ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }

    public GlobalException(final String message, final ResponseCode responseCode) {
        super(message);
        this.responseCode = responseCode;
    }

}
