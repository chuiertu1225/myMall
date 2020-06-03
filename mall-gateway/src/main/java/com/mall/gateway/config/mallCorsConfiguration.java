package com.mall.gateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class mallCorsConfiguration {
    @Bean
    public CorsFilter corsFilter(){
        // 初始化配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许跨域的域名，如果携带cookie，不能写*
        corsConfiguration.addAllowedOrigin("http://localhost:9001");
        // 设置是否允许携带cookie
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedMethod("*"); // 代表所有请求方法
        corsConfiguration.addAllowedHeader("*"); // 允许携带任何头信息
        // 初始化cors配置源对象
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(configurationSource);
    }
}
