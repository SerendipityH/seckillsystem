package com.serendipity.seckillsystem.util;

import java.util.UUID;

/**
 * @author serendipity
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
