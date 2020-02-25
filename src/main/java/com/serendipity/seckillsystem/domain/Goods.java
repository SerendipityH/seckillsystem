package com.serendipity.seckillsystem.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author serendipity
 * @version 1.0
 * @date 2020/2/6 13:11
 */
@Getter
@Setter
public class Goods {
    private Long id;
    private String goodsName;
    private String goodsTitle;
    private String goodsImg;
    private String goodsDetail;
    private Double goodsPrice;
    private Integer goodsStock;
}
