package com.example.demo.xiangxue.util;

import com.example.demo.xiangxue.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisCache {

    private static Logger logger = LoggerFactory.getLogger(JedisCache.class);

    @Autowired
    private JedisPool jedisPool;

    public String setString(String  key,String value){
        logger.info("setString============"+key);
        Jedis client = jedisPool.getResource();
        logger.info("client======"+client);
        String flag = "0";
        try {
            flag = client.set(key,value);
        }finally {
            jedisPool.returnResource(client);
        }
        return flag;
    }

    public String  getString(String  key){
        Jedis client = jedisPool.getResource();
        try {
            return client.get(key);
        }finally {
            jedisPool.returnResource(client);
        }
    }


}
