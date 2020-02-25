package com.serendipity.seckillsystem.controller;

import com.serendipity.seckillsystem.domain.MiaoshaGoods;
import com.serendipity.seckillsystem.redis.RedisService;
import com.serendipity.seckillsystem.result.CodeMsg;
import com.serendipity.seckillsystem.result.Result;
import com.serendipity.seckillsystem.service.MiaoshaUserService;
import com.serendipity.seckillsystem.service.UserService;
import com.serendipity.seckillsystem.util.ValidatorUtil;
import com.serendipity.seckillsystem.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;


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

    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        logger.info(loginVo.toString());
        //参数校验
      /*  String password = loginVo.getPassword();
        String mobile = loginVo.getMobile();
        if (StringUtils.isEmpty(password)) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if (StringUtils.isEmpty(mobile)) {
            return Result.error(CodeMsg.MOBILE_EMPTY);
        }
        if (!ValidatorUtil.isMobile(mobile)) {
            return Result.error(CodeMsg.MOBILE_ERROR);
        }*/
        //登录
        miaoshaUserService.login(response, loginVo);
        return Result.success(true);
    }
}
