package com.springboot.config.auth;

import com.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        /*
         * csrf, headers.frameOptions : h2-console 화면 사용을 위해 disable
         * autorizeRequests : URL별 권한 관리 시작 옵션
         * logout : logout시 '/'로 이동
         * oauth2Login : oauth2 기능 설정 시작 옵션
         * userInfoEndPoint : 로그인 성공 후 사용자 정보를 가져오는 설정
         * userService : 로그인 성공 시 제공할 서비스 인터페이스
         */

        http
            .csrf().disable()
            .headers().frameOptions().disable()
        .and()
            .authorizeRequests()
            .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
            .antMatchers("/api/v1/**").hasRole(Role.USER.name())
            .anyRequest().authenticated()
        .and()
            .logout()
                    .logoutSuccessUrl("/")
        .and()
            .oauth2Login()
                    .userInfoEndpoint()
                        .userService(customOAuth2UserService);

    }
}
