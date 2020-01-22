package com.serendipity.seckillsystem.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author serendipity
 */
@Getter
@Setter
public class LoginVo {
    private String mobile;
    private String password;

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
