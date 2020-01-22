package com.serendipity.seckillsystem.controller;

import com.serendipity.seckillsystem.redis.RedisService;
import com.serendipity.seckillsystem.result.Result;
import com.serendipity.seckillsystem.service.UserService;
import com.serendipity.seckillsystem.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author serendipity
 */
@Controller
@RequestMapping("/login")
public class LoginController {


    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(LoginVo loginVo){
        logger.info(loginVo.toString());
        return null;
    }
}
