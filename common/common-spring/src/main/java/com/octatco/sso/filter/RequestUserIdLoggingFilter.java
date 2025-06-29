package com.octatco.sso.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static com.octatco.sso.constants.AppConstants.REQUEST_ID_KEY;

/**
 * 요청 추적을 위한 Filter </br>
 * MDC에 RequestId를 담아서 요청을 추적한다.
 */
@Component
public class RequestUserIdLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain) throws ServletException, IOException {
        try {
            String requestEventId = Optional.ofNullable(request.getHeader(REQUEST_ID_KEY))
              .filter(StringUtils::isNotBlank)
              .orElse(UUID.randomUUID().toString());
            MDC.put(REQUEST_ID_KEY, requestEventId);
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(REQUEST_ID_KEY);  // 메모리 누수 방지
        }
    }
}
