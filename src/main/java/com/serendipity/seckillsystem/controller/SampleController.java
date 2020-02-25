package com.serendipity.seckillsystem.controller;

import com.serendipity.seckillsystem.domain.User;
import com.serendipity.seckillsystem.redis.RedisService;
import com.serendipity.seckillsystem.redis.UserKey;
import com.serendipity.seckillsystem.result.Result;
import com.serendipity.seckillsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author serendipity
 */
@RestController
@RequestMapping()
public class SampleController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/db/get")
    public Result<User> dbGet(Integer id) {
        User user = userService.getById(id);
        return Result.success(user);
    }


    @RequestMapping("/db/tx")
    public Result<Boolean> dbTX(Integer id) {
        userService.tx();
        return Result.success(true);
    }

    @RequestMapping("/redis/get")
    public Result<User> redisGet(Integer id) {
        User user = redisService.get(UserKey.getById, "" + 1, User.class);
        return Result.success(user);
    }


    @RequestMapping("/redis/set")
    public Result<User> redisSet(Integer id) {
        User user = new User();
        user.setId(1);
        user.setName("11111111111");
        redisService.set(UserKey.getById, "" + 1, user);
        
        return Result.success(user);
    }

}
