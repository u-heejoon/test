package com.sso.domains.member;

import java.time.LocalDateTime;

public class MemberInfo {

    public record Main(
      Long id,
      String username,
      LocalDateTime createdAt,
      LocalDateTime updatedAt
    ) {
        public static Main of(Member member) {
            return new Main(
              member.getId(),
              member.getUsername(),
              member.getCreatedAt(),
              member.getUpdatedAt()
            );
        }
    }

    public record MemberName(Long id, String username) {
        public static MemberName of(Member member) {
            return new MemberName(member.getId(), member.getUsername());
        }
    }
}
