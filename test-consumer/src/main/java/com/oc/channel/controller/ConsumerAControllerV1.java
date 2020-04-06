package com.oc.channel.controller;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import com.oc.channel.tests.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tigershome on 2020/3/30.
 */
@RestController
@RequestMapping("/channel/test/consumer-a/v1")
public class ConsumerAControllerV1 {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hello")
    public String callHello() {
        return restTemplate.getForObject("http://provider-a/channel/test/provider-a/v1/hello", String.class);
    }

    @GetMapping("/house-info")
    public HouseInfo getHouseInfo(@RequestParam("name") String name) {
        return restTemplate.getForObject("http://provider-a/channel/test/provider-a/v1/house-info", HouseInfo.class);
    }

    @GetMapping("house-info/{name}")
    public String getHouseInfoAsString(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://provider-a/channel/test/provider-a/v1/house-info/{name}", String.class, name);
    }


}
