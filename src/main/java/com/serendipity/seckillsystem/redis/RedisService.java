package com.serendipity.seckillsystem.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * @author serendipity
 */
@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真的key
            String realKey = prefix.getPrefix() + key;
            String str = jedis.get(realKey);
            return stringToBean(str, clazz);
        } finally {
            returnToPool(jedis);
        }
    }

    public <T> Boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            if (null == str || str.length() <= 0) {
                return false;
            }
            //生成真的key
            String realKey = prefix.getPrefix() + key;
            Integer seconds = prefix.expireSeconds();
            if (seconds <= 0) {
                jedis.set(realKey, str);
            } else {
                jedis.setex(key, seconds, str);
            }
            jedis.set(realKey, str);
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    /*
     是否存在
     */
    public <T> Boolean exists(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真的key
            String realKey = prefix.getPrefix() + key;
            return jedis.exists(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /*
     增加
    */
    public <T> Long incr(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真的key
            String realKey = prefix.getPrefix() + key;
            return jedis.incr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 减少
     */
    public <T> Long decr(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真的key
            String realKey = prefix.getPrefix() + key;
            return jedis.decr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    public void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    public <T> T stringToBean(String str, Class<T> aClass) {
        if (null == str || str.length() <= 0 || aClass == null) {
            return null;
        }
        if (aClass == int.class || aClass == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (aClass == long.class || aClass == Long.class) {
            return (T) Long.valueOf(str);
        } else if (aClass == String.class) {
            return (T) str;
        } else {
            return JSON.toJavaObject(JSON.parseObject(str), aClass);
        }
    }

    public <T> String beanToString(T value) {
        if (null == value) {
            return null;
        }
        Class<?> aClass = value.getClass();
        if (aClass == int.class || aClass == Integer.class) {
            return "" + value;
        } else if (aClass == long.class || aClass == Long.class) {
            return "" + value;
        } else if (aClass == String.class) {
            return (String) value;
        } else {
            return JSON.toJSONString(value);
        }
    }

}
