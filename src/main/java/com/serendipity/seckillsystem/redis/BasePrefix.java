package com.serendipity.seckillsystem.redis;

/**
 * @author serendipity
 */
public abstract class BasePrefix implements KeyPrefix {

    private Integer expireSeconds;

    private String prefix;

    public BasePrefix() {
    }
    public BasePrefix(String prefix) {//0代表永不过期
        this(0,prefix);
    }
    public BasePrefix(Integer expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public Integer expireSeconds() {

        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String simpleName = getClass().getSimpleName();
        return simpleName+":"+prefix;
    }
}
