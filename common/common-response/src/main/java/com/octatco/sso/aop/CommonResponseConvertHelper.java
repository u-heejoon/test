package com.octatco.sso.aop;

import com.octatco.sso.domains.CommonResponse;
import com.octatco.sso.domains.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 공통 응답 객체 => ResponseBodyAdvice를 따로 선언하지 않아도 Converting 해줄 수 있게 돕는 helper class
 */
@Slf4j
@RestControllerAdvice
public class CommonResponseConvertHelper implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(final MethodParameter returnType, final Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getContainingClass().isAnnotationPresent(RestController.class)
               // class에 @SkipCommonResponse가 있으면 안됨
               && returnType.getContainingClass().getAnnotation(SkipCommonResponse.class) == null
               // method에 @SkipCommonResponse가 있으면 안됨
               && returnType.getMethodAnnotation(SkipCommonResponse.class) == null;
    }

    @Override
    public Object beforeBodyWrite(final Object body, final MethodParameter returnType, final MediaType selectedContentType, final Class<? extends HttpMessageConverter<?>> selectedConverterType, final ServerHttpRequest request, final ServerHttpResponse response) {
        if (ObjectUtils.isEmpty(body) || body instanceof CommonResponse) {
            return body;
        }

        final int httpStatus = ((ServletServerHttpResponse) response).getServletResponse().getStatus();
        if (httpStatus >= 400) {
            final ResponseCode errorCode = ResponseCodeHelper.httpStatusErrorCodeToResponseCode(httpStatus);
            return CommonResponse.fail(errorCode, body);
        }

        return CommonResponse.success(body);
    }
}
