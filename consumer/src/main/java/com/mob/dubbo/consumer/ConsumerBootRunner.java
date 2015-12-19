/*
 * Copyright 2015-2020 uuzu.com All right reserved.
 */
package com.mob.dubbo.consumer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mob.dubbo.consumer.conf.ConsumerAppConfig;
import com.mob.dubbo.consumer.handler.GreetingClient;

/**
 * @author zxc Aug 18, 2015 17:53:17 PM
 */
public class ConsumerBootRunner {

    private static final Logger                       LOG = Logger.getLogger(ConsumerBootRunner.class);

    private static AnnotationConfigApplicationContext ctx;

    public static void main(String[] args) {
        ctx = new AnnotationConfigApplicationContext(ConsumerAppConfig.class);
        ctx.start();

        Thread t = new Thread(new Runnable() {

            private Scanner scan;

            public void run() {
                while (true) {
                    try {
                        GreetingClient client = ctx.getBean(GreetingClient.class);
                        String temp = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date());

                        scan = new Scanner(System.in);
                        System.out.println("Please input a String:");

                        String ret = client.sayHello4Custom(temp + scan.next());
                        LOG.error(ret);
                        Thread.sleep(5000 * 10);
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }
}
