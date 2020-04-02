package com.oc.channel.channel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tigershome on 2020/3/30.
 */

@RestController
@RequestMapping("/channel/test/provider-a/v1")
public class ProviderAControllerV1 {

    @GetMapping("/hello")
    public String hello(){
        return "This is Provider A v1";
    }
}
