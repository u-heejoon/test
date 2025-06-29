package com.octatco.sso.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 카프카, 레디스 등에서 사용할 토픽 및 키
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TopicConstants {
    private static final String TOPIC_PREFIX = "octatco:sso:";
}
