/*
 * Copyright 2015-2020 uuzu.com All right reserved.
 */
package com.mob.dubbo.provider.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.config.spring.ServiceBean;
import com.mob.dubbo.service.GreetService;

/**
 * server provider boot setting by spring
 * 
 * @author zxc Aug 18, 2015 17:53:17 PM
 */
@Configuration
@ComponentScan
public class ProviderAppConfig {

    // 定义开启注解扫描
    @Bean
    public AnnotationBean annotation() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.mob.dubbo");
        return annotationBean;
    }

    // 当前应用配置
    @Bean
    public ApplicationConfig application() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("greeting-server");
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

    /**
     * 服务提供者协议配置</br>
     * 
     * <pre>
     * <dubbo:protocol name="dubbo" server="netty" port="20880" serialization="dubbo"/>
     * </pre>
     * 
     * @return
     */
    @Bean
    public ProtocolConfig protocol() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setServer("netty");
        protocolConfig.setPort(20880);
        protocolConfig.setThreads(10);
        protocolConfig.setSerialization("dubbo");
        return protocolConfig;
    }

    // 服务提供者暴露服务配置
    @Bean
    public ServiceBean<GreetService> greetServiceExport(GreetService greetService) {
        ServiceBean<GreetService> serviceBean = new ServiceBean<GreetService>();
        serviceBean.setProxy("javassist");
        serviceBean.setVersion("1.0.0");
        serviceBean.setInterface(GreetService.class);
        serviceBean.setRef(greetService);
        return serviceBean;
    }
}
