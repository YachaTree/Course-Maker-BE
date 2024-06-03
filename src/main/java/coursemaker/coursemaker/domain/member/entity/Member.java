package coursemaker.coursemaker.domain.member.entity;

import coursemaker.coursemaker.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_type", columnDefinition = "VARCHAR(255) DEFAULT 'BASIC'")
    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @Column(nullable = false, unique = true)
    private String username; // 회원 id

    @Column(name = "name", columnDefinition = "VARCHAR(10)")
    private String name; // 회원 이름

    @Column(name = "email", columnDefinition = "VARCHAR(20) UNIQUE")
    private String email; // 회원 이메일

    @Column(unique = true, columnDefinition = "VARCHAR(10) UNIQUE")
    private String nickname; // 회원 닉네임

    @Column(nullable = true, length = 15)
    private String phoneNumber; // 회원 전화번호

    @Column(name = "password", columnDefinition = "VARCHAR(100)")
    private String password; // 회원 비밀번호

    @Column(nullable = false)
    private String roles; // 회원 등급

    @Column(name = "profile_img_url", columnDefinition = "VARCHAR(255)")
    private String profileImgUrl;

    @Column(name = "profile_description", columnDefinition = "VARCHAR(150)")
    private String profileDescription;

    @Column(name = "deleted_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime deletedAt;


    public enum LoginType {
        BASIC,
        KAKAO
    }

    @Builder(builderMethodName = "addMemberBuilder")
    public Member(String email, LoginType loginType, String name, String nickname, String password, String profileImgUrl, String profileDescription) {
        this.email = email;
        this.loginType = loginType;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.profileImgUrl = profileImgUrl;
        this.profileDescription = profileDescription;
    }
}