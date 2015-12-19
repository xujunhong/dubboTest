/*
 * Copyright 2015-2020 uuzu.com All right reserved.
 */
package com.mob.dubbo.consumer.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mob.dubbo.service.GreetService;

/**
 * @author zxc Aug 18, 2015 17:53:17 PM
 */
@Component
public class GreetingClient {

    @Autowired
    private GreetService greetService;

    // 发起RPC调用
    public String sayHello() {
        return this.greetService.hello("Hell World");
    }

    // 发起RPC调用
    public String sayHello4Custom(String somthing) {
        return this.greetService.hello(somthing);
    }
}
