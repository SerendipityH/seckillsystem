package com.serendipity.seckillsystem.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author serendipity
 * @version 1.0
 * @date 2020/2/6 13:12
 */
@Getter
@Setter
public class MiaoshaGoods {
    private Long id;
    private Long goodsId;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}
