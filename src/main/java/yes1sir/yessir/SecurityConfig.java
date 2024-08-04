package yes1sir.yessir;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/**").permitAll()  // API 요청 허용
                        .anyRequest().authenticated()  // 그 외 모든 요청 인증 필요
                )
                .formLogin(form -> form
                        .loginPage("/login")  // 로그인 페이지 URL
                        .permitAll()
                        .defaultSuccessUrl("/", true)  // 로그인 성공 시 이동할 URL
                )
                .csrf(csrf -> csrf.disable()  // CSRF 비활성화
                );
        return http.build();
    }
}
