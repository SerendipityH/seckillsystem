package com.serendipity.seckillsystem.dao;

import com.serendipity.seckillsystem.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author serendipity
 * @version 1.0
 * @date 2020/3/1 14:55
 */
@Mapper
public interface GoodsDao {
    @Select("select g.*, mg.miaosha_price,mg.stock_count,mg.start_date,mg.end_date from miaosha_goods mg left join goods g on mg.goods_id = g.id ")
    public List<GoodsVo> listGoodsVo();

    @Select("select g.*, mg.miaosha_price,mg.stock_count,mg.start_date,mg.end_date from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId}")
    public GoodsVo getGoodsVoByGoodsId(@Param("goodsId") Long goodsId);
}
