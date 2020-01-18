package com.serendipity.seckillsystem.controller;

import com.serendipity.seckillsystem.domain.User;
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
    @RequestMapping("/db/get")
    public Result<User> dbGet(Integer id){
        User user = userService.getById(id);
        return Result.success(user);
    }


    @RequestMapping("/db/tx")
    public Result<Boolean> dbTX(Integer id){
        userService.tx();
        return Result.success(true);
    }
}
