package com.octatco.sso.domains;

import com.octatco.sso.constants.AppConstants;
import org.slf4j.MDC;

/**
 * <p>
 *  AuditorAware Default 설정 <br/>
 *  기본 값은 MDC에 저장되어있는 요청 아이디
 * </p>
 */
public class DefaultRequestByAuditorAware extends RequestByAuditorAware {

    @Override
    protected String getAuditor() {
        return MDC.get(AppConstants.REQUEST_ID_KEY);
    }

    @Override
    protected String getDefaultAuditor() {
        return "SYSTEM";
    }
}
