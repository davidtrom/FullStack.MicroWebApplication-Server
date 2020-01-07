package com.theocho.youflix;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins("*", "https://angular-youflix-videoapp.herokuapp.com", "https://safe-springs-62086.herokuapp.com/videos", "https://safe-springs-62086.herokuapp.com", "https://angular-youflix-videoapp.herokuapp.com/videos");
    }
}
