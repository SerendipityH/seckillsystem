package com.serendipity.seckillsystem.redis;

public class OrderKey extends BasePrefix {
    public OrderKey(Integer expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
