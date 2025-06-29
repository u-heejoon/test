package com.octatco.sso.interfaces.web;


import com.octatco.sso.domains.member.MemberInfo;

import java.time.LocalDateTime;

public class MemberDto {

    public record MemberResponse(
      Long id,
      String username,
      LocalDateTime createdAt,
      LocalDateTime updatedAt
    ) {
        public static MemberResponse from(final MemberInfo.Main main) {
            return new MemberResponse(
              main.id(),
              main.username(),
              main.createdAt(),
              main.updatedAt()
            );
        }
    }

}
