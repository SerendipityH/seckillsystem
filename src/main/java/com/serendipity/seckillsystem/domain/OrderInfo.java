package com.serendipity.seckillsystem.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author serendipity
 * @version 1.0
 * @date 2020/2/6 13:13
 */
@Getter
@Setter
public class OrderInfo {
    private Long id;
    private Long userId;
    private Long goodsId;
    private Long  deliveryAddrId;
    private String goodsName;
    private Integer goodsCount;
    private Double goodsPrice;
    private Integer orderChannel;
    private Integer status;
    private Date createDate;
    private Date payDate;
}
