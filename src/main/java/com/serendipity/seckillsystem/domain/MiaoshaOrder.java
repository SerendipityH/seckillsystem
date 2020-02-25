package com.serendipity.seckillsystem.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author serendipity
 * @version 1.0
 * @date 2020/2/6 13:14
 */
@Getter
@Setter
public class MiaoshaOrder {
    private Long id;
    private Long userId;
    private Long  orderId;
    private Long goodsId;
}
