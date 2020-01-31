package com.serendipity.seckillsystem.controller;

import com.serendipity.seckillsystem.domain.MiaoshaUser;
import com.serendipity.seckillsystem.redis.RedisService;

import com.serendipity.seckillsystem.service.MiaoshaUserService;
import com.serendipity.seckillsystem.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;


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
    private MiaoshaUserService miaoshaUserService;

    @RequestMapping("/to_list")
    public String toList(Model model,MiaoshaUser user)
    {

        model.addAttribute("user",user);
        return "goods_list";
    }


}
