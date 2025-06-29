package com.octatco.sso.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.octatco.sso.domains.CommonResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * CommonResponseConvertHelper 를 사용했을 때 primitive, String 과 같은 타입들은 에러가 발생함 이를 해결하기 위한 MessageConverter<br>
 *
 * 에러 발생 원인: 리턴 값이 String일 때 적용되는 {@link StringHttpMessageConverter}는 객체를 처리할 수 없음
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomMessageConverter extends AbstractHttpMessageConverter<CommonResponse<Object>> {

    private final ObjectMapper objectMapper;

    public CustomMessageConverter(final ObjectMapper objectMapper) {
        super(MediaType.APPLICATION_JSON);
        this.objectMapper = objectMapper;
    }

    @Override
    protected boolean supports(final Class<?> clazz) {
        // SkipCommonResponse annotation이 존재 하면 해당 Converter를 사용하지 않음
        if (shouldSkipCommonResponse()) {
            return false;
        }

        return clazz.equals(CommonResponse.class) || clazz.isPrimitive() || clazz.equals(String.class);
    }

    @Override
    protected CommonResponse<Object> readInternal(final Class<? extends CommonResponse<Object>> clazz, final HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        throw new UnsupportedOperationException("This Converter can only support writing operation");
    }

    @Override
    protected void writeInternal(final CommonResponse<Object> objectCommonResponse, final HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        final String responseMessage = this.objectMapper.writeValueAsString(objectCommonResponse);
        StreamUtils.copy(responseMessage.getBytes(StandardCharsets.UTF_8), outputMessage.getBody());
    }

    /**
     * 현재 요청이 @SkipCommonResponse를 가지고 있는지 확인
     *
     * @warn HandlerMapping.BEST_MATCHING_HANDLER_ATTRIBUTE가 설정 되는 시점에 따라 동작하지 않을 수 있음
     */
    private boolean shouldSkipCommonResponse() {
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes instanceof ServletRequestAttributes) {
                HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

                // HandlerMapping에서 현재 핸들러 메서드 정보 가져오기
                Object handler = request.getAttribute(HandlerMapping.BEST_MATCHING_HANDLER_ATTRIBUTE);
                if (handler instanceof final HandlerMethod handlerMethod) {

                    // 메서드에 @SkipCommonResponse가 있는지 확인
                    if (handlerMethod.getMethodAnnotation(SkipCommonResponse.class) != null) {
                        return true;
                    }

                    // 클래스에 @SkipCommonResponse가 있는지 확인
                    if (handlerMethod.getBeanType().getAnnotation(SkipCommonResponse.class) != null) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            // 예외 발생 시 기본값으로 false 반환
            return false;
        }

        return false;
    }
}
