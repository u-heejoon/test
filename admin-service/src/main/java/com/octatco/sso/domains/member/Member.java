package com.octatco.sso.domains.member;

import com.octatco.sso.domains.MutableEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Entity
@Table(name = "MEMBERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends MutableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "아이디는 필수 값입니다.")
    @Column(name = "username", nullable = false, length = 40)
    private String username;

    @NotBlank(message = "비밀번호는 필수 값입니다.")
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @NotBlank(message = "이메일은 필수 값입니다.")
    @Column(name = "email", nullable = false, length = 40)
    private String email;

    public Member(final String username) {
        this.username = username;
    }
}
