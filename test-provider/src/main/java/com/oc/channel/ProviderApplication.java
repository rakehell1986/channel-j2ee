package com.oc.channel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by tigershome on 2020/3/30.
 */

@SpringBootApplication(scanBasePackages = {"com.oc.channel"})
@EnableEurekaClient
public class ProviderApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ProviderApplication.class);
    }

//    @Bean
//    ServletWebServerFactory servletWebServerFactory(){
//        return new TomcatServletWebServerFactory();
//    }
}
