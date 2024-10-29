package org.nhnacademy.ssacthree_eureka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = false)
@Configuration
// Security로 인증된 사용자만 eureka서버에 접속 가능
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // csrf보호 비활성화
        http.csrf(AbstractHttpConfigurer::disable);
        // 요청 권한 설정
        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.anyRequest().authenticated()
        );
        // HTTP Basic 인증을 기본 설정으로 추가
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
