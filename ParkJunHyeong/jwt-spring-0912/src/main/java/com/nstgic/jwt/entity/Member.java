package com.nstgic.jwt.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_tb")
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(updatable = false,unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer state;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "findQuestion")
    private Integer findQuesNum;

    @Column(name = "findAnswer")
    private String findAnswer;

    @ManyToOne
    @JoinColumn
    private Member memberFollowing = this;

    @ManyToOne
    @JoinColumn
    private Member memberFollower = this;
    // follwing = 내가 따르는 member
    @OneToMany(mappedBy = "memberFollowing")
    private List<Member> followingList = new ArrayList<Member>();
    //follwerList = 나를 따르는 meber
    @OneToMany(mappedBy = "memberFollower")
    private List<Member> followerList = new ArrayList<Member>();

    @ManyToOne
    @JoinColumn
    private Member matching = this;

    @OneToMany(mappedBy = "matching")
    private List<Member> matchingList = new ArrayList<Member>();

    @Column(nullable = false)
    private boolean enabled;
//현재는 메일 전송 방식으로 임시 비밀번호를 발급해주고 있음
//    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
//    private VerificationToken verificationToken;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private Set<Role> roles = new HashSet<>();


    //    유저가 가지고 있는 Role 객체를 이용하여 SimpleGrantedAuthority 객체를 생성하고, Stream을 이용하여 Collection 형태로 반환
    @Override /// 해당 유저의 권한을 리턴하는 곳
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
//    Collectors.toList() 메서드를 이용하여 반환되는 Stream 객체를 List 형태로 변환
                .collect(Collectors.toList());
    }
//    GrantedAuthority 객체를 생성할 때 문자열 변환이 필요하지 않기 때문에 유연성이 높아지며, roles 필드를 추가적으로 변경해야 할 경우, 해당 필드만 수정하면 되므로 유지보수가 용이

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        /// 일년동안 사이트에 회원이 안들어오면 휴먼 계정으로 하려고 하면  현재 시간 - 마지막 로그인 시간 해서 선택
        return enabled;
    }
}