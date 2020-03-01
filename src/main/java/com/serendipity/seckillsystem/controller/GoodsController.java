package com.serendipity.seckillsystem.controller;

import com.serendipity.seckillsystem.domain.MiaoshaUser;
import com.serendipity.seckillsystem.redis.RedisService;

import com.serendipity.seckillsystem.service.GoodsService;
import com.serendipity.seckillsystem.service.MiaoshaUserService;
import com.serendipity.seckillsystem.service.UserService;
import com.serendipity.seckillsystem.vo.GoodsVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author serendipity
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {


    private static Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @RequestMapping("/to_list")
    public String toList(Model model, MiaoshaUser user) {
        //查询商品列表
        List<GoodsVo> goodsVos = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsVos);
        return "goods_list";
    }


    @RequestMapping("/to_detail/{goodsId}")
    public String detail(Model model, MiaoshaUser user, @PathVariable("goodsId")Long goodsId) {
        //查询商品列表
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goods);
        model.addAttribute("user",user);
        long startAt = goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int miaoshaStatus = 0;
        int remainSeconds = 0;

        if(now < startAt){//秒杀还没开始，倒计时
            miaoshaStatus = 0;
            remainSeconds = (int)((startAt - now)/1000);
        }else if(now > endAt){//秒杀结束
            miaoshaStatus = 2;
             remainSeconds = -1;
        }else{
            miaoshaStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds ", remainSeconds);
        return "goods_detail";
    }
}
