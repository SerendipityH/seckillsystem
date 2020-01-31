package com.serendipity.seckillsystem.service;

import com.serendipity.seckillsystem.dao.MiaoshaUserDao;
import com.serendipity.seckillsystem.domain.MiaoshaUser;
import com.serendipity.seckillsystem.exception.GlobalException;
import com.serendipity.seckillsystem.redis.MiaoShaUserKey;
import com.serendipity.seckillsystem.redis.RedisService;
import com.serendipity.seckillsystem.result.CodeMsg;
import com.serendipity.seckillsystem.util.MD5Util;
import com.serendipity.seckillsystem.util.UUIDUtil;
import com.serendipity.seckillsystem.vo.LoginVo;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author serendipity
 */
@Service
public class MiaoshaUserService {

    @Autowired
    private MiaoshaUserDao miaoshaUserDao;
    @Autowired
    private RedisService redisService;
    public static final String COOKIE_NAME_TOKEN = "token";

    public MiaoshaUser getById(Long id) {
        return miaoshaUserDao.getById(id);
    }

    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        if (null == loginVo) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        MiaoshaUser user = getById(Long.parseLong(mobile));
        //判断手机号是否存在
        if (null == user) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbpass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(password, saltDB);
        if (!calcPass.equals(dbpass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //
        addCookie(response,user);
        return true;
    }
    private void addCookie(HttpServletResponse response,MiaoshaUser user){
        //生成cookie
        String token = UUIDUtil.uuid();
        redisService.set(MiaoShaUserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(MiaoShaUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    public MiaoshaUser getByToken(HttpServletResponse response,String token) {
        if(StringUtils.isEmpty(token)){
           return null;
        }
        MiaoshaUser user = redisService.get(MiaoShaUserKey.token, token, MiaoshaUser.class);
        //延长有效期
        if(user != null){
            addCookie(response,user);
        }

        return user;
    }
}
