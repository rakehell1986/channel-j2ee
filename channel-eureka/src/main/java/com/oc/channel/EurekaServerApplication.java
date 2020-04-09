package com.oc.channel;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

/**
 * Created by tigershome on 2020/3/30.
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EurekaServerApplication.class);
    }

//    @Bean
//    public ServletWebServerFactory tomcatEmbedded() {
//        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
//        tomcatServletWebServerFactory.addConnectorCustomizers((TomcatConnectorCustomizer) connector-> {
//            if((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
//                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
//            }
//        });
//        return tomcatServletWebServerFactory;
//    }
}
