package com.nstgic.jwt.config;

import com.nstgic.jwt.jwt.JwtAccessDeniedHandler;
import com.nstgic.jwt.jwt.JwtAuthenticationEntryPoint;
import com.nstgic.jwt.jwt.JwtSecurityConfig;
import com.nstgic.jwt.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final TokenProvider tokenProvider;
    private final CorsFilter corsFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CSRF 설정 Disable
        http.cors().and().addFilter(corsFilter);

        http.csrf(
                csrfCustomizer -> csrfCustomizer
                        .ignoringRequestMatchers("/h2-console/**")
                        .disable() // TODO
        );

        http.headers(
                // h2-console에서 iframe을 사용함. X-Frame-Options을 위해 sameOrigin 설정
                headersCustomizer -> headersCustomizer
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
        );
        // exception handling 할 때 우리가 만든 클래스를 추가

        http.sessionManagement(
                sessionManagementCustomizer -> sessionManagementCustomizer
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        http.exceptionHandling(
                exceptionCustomizer ->exceptionCustomizer
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                        .accessDeniedHandler(jwtAccessDeniedHandler)
        );

        // 로그인, 회원가입 API 는 토큰이 없는 상태에서 요청이 들어오기 때문에 permitAll 설정
        http.authorizeHttpRequests((authorize) -> authorize
                //h2 사용하는 환경을 위해서 permit
                .requestMatchers("/h2-console/**").permitAll()
                //회원 가입에 jwt 인증을 요청할수 없다.
                .requestMatchers("/auth/**").permitAll()
                //마이 페이지 처럼 인증이 필요한 url로의 접근은 permit하지 않는다.
                .requestMatchers("/mypage/**").authenticated()
                .anyRequest().permitAll()
        );

        http.apply(new JwtSecurityConfig(tokenProvider));


        return http.build();
    }
}