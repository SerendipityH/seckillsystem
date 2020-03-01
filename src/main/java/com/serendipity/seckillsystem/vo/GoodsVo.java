package com.serendipity.seckillsystem.vo;

import com.serendipity.seckillsystem.domain.Goods;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author serendipity
 * @version 1.0
 * @date 2020/3/1 14:56
 */
@Getter
@Setter
public class GoodsVo extends Goods {
    private Integer stockCount;
    private Double miaoshaPrice;
    private Date startDate;
    private Date endDate;
}
