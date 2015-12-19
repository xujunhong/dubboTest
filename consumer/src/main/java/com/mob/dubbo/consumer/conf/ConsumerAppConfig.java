/*
 * Copyright 2015-2020 uuzu.com All right reserved.
 */
package com.mob.dubbo.consumer.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.mob.dubbo.service.GreetService;

/**
 * @author zxc Aug 18, 2015 17:53:17 PM
 */
@Configuration
@ComponentScan
public class ConsumerAppConfig {

    // 定义开启注解扫描
    @Bean
    public AnnotationBean annotation() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.mob.dubbo");
        return annotationBean;
    }

    @Bean
    public ConsumerConfig consumer() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(100000);
        return consumerConfig;
    }

    // 当前应用配置
    @Bean
    public ApplicationConfig application() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("greeting-client");
        return applicationConfig;
    }

    // 连接注册中心配置
    @Bean
    public RegistryConfig registry() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://121.42.30.104:2181;121.42.30.104:2182;121.42.30.104:2183");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    // 引用远程服务
    @Bean
    public ReferenceBean<GreetService> greetService() {
        ReferenceBean<GreetService> ref = new ReferenceBean<GreetService>();
        ref.setInterface(GreetService.class);
        ref.setVersion("1.0.0");
        ref.setLoadbalance("roundrobin");// 轮询策略
        return ref;
    }
}
