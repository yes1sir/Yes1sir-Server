package yes1sir.yessir;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // 여기에 원하는 경로 패턴을 지정합니다.
                        .allowedOriginPatterns("*")  // 허용할 도메인을 지정합니다.
                        .allowedHeaders("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "PATCH")
                        .exposedHeaders("Authorization", "RefreshToken");
                        //.allowCredentials(true);  // 이 줄을 포함하여 쿠키를 포함한 크로스 도메인 요청을 허용합니다.
            }
        };
    }
}
