package com.oc.channel.controller;

import com.oc.channel.logs.LogMonitor;
import com.oc.channel.tests.HouseInfo;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tigershome on 2020/3/30.
 */

@RestController
@RequestMapping("/channel/test/provider-a/v1")
@Slf4j
public class ProviderAControllerV1 {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hello")
    public String hello(){
        return "This is Provider A v1";
    }

    @GetMapping("/house-info")
    @LogMonitor
    public HouseInfo getHouseInfo(@RequestParam("name") String name) {
        log.info("Getting house info from {}", serverPort);
        return new HouseInfo("Shanghai", "Shanghai", "ZHONGSHAN ROAD");
    }

    @GetMapping("house-info/{name}")
    @LogMonitor
    public String getHouseInfoAsString(@PathVariable("name") String name) {
        log.info("Getting house info from {}", serverPort);
        return name;
    }
}
