/*
 * Copyright 2015-2020 uuzu.com All right reserved.
 */
package com.mob.dubbo.service;

/**
 * 服务提供者与消费者共享服务接口
 * 
 * @author zxc Aug 18, 2015 17:53:17 PM
 */
public interface GreetService {

    String hello(String key);
}
