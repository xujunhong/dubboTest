/*
 * Copyright 2015-2020 uuzu.com All right reserved.
 */
package com.mob.dubbo.provider;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mob.dubbo.provider.conf.ProviderAppConfig;

/**
 * @author zxc Aug 18, 2015 17:53:17 PM
 */
public class ProviderBootServer {

    private static final Logger                       LOG = Logger.getLogger(ProviderBootServer.class);

    private static AnnotationConfigApplicationContext ctx;

    public static void main(String[] args) throws IOException {
        ctx = new AnnotationConfigApplicationContext(ProviderAppConfig.class);
        ctx.start();
        System.in.read();
        LOG.error(" ProviderBootServer start !");
    }
}
