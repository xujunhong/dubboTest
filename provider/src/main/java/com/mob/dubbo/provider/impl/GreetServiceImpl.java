/*
 * Copyright 2015-2020 uuzu.com All right reserved.
 */
package com.mob.dubbo.provider.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mob.dubbo.service.GreetService;

/**
 * @author zxc Aug 18, 2015 17:53:17 PM
 */
@Service("greetService")
public class GreetServiceImpl implements GreetService {

    private static final Logger logger = Logger.getLogger(GreetService.class);

    @Override
    public String hello(String key) {
        logger.error("consumer start invoke, param is [" + key + "]");
        String ret = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + key;
        logger.error(ret);
        return ret;
    }
}
