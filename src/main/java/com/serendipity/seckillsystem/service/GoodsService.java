package com.serendipity.seckillsystem.service;

import com.serendipity.seckillsystem.dao.GoodsDao;
import com.serendipity.seckillsystem.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author serendipity
 * @version 1.0
 * @date 2020/3/1 14:54
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    public List<GoodsVo> listGoodsVo(){
        return goodsDao.listGoodsVo();
    }

    public GoodsVo getGoodsVoByGoodsId(Long goodsId) {
        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }
}
