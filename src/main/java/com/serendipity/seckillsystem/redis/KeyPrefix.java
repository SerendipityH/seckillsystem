package com.serendipity.seckillsystem.redis;

/**
 * @author serendipity
 */
public interface KeyPrefix {
    public Integer expireSeconds();

    public String getPrefix();

}
