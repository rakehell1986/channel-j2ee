package com.oc.channel.channel.controller;

import com.oc.channel.utils.ChannelDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tigershome on 2020/3/30.
 */
@RestController
@RequestMapping("/channel/test/consumer-a/v1")
public class ConsumerAControllerV1 {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String callHello() {
        //return restTemplate.getForObject("http://localhost:8071/channel/test/provider-a/v1/hello", String.class);
        return restTemplate.getForObject("http://provider-a:8071/channel/test/provider-a/v1/hello", String.class);

    }
}
