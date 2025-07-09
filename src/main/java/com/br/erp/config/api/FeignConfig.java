package com.br.erp.config.api;

import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class FeignConfig {
    @Bean
    public feign.Client feignClient() {
        return new OkHttpClient();
    }
}
