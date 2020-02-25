package com.serendipity.seckillsystem.dao;

import com.serendipity.seckillsystem.domain.MiaoshaGoods;
import com.serendipity.seckillsystem.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

/**
 * @author serendipity
 */
@Mapper
public interface MiaoshaUserDao {
    @Select("select * from miaosha_user where id = #{id}")
    public MiaoshaUser getById(@Param("id") Long id);
}
