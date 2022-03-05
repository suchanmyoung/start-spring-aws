package com.suchan.startspringaws.config.auth;

import com.suchan.startspringaws.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
    @EnableWebSecurity : Spring Security 설정 활성화
    authorizeRequests : URL 별 권한 관리를 설정하는 옵션의 시작점
    antMatchers : 권한 관리 대상을 지정하는 옵션
    anyMatchers : 설정된 값들 이외 나머지 URL. 여기서는 authenticated를 추가하여 나머지 URL들은 모두 인증된 사용자들에게만 허용도록 함
 */

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
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