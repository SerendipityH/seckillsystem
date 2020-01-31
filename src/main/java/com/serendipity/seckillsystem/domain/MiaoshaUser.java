package com.serendipity.seckillsystem.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author serendipity
 */
@Getter
@Setter
public class MiaoshaUser {
    private Long id;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;
}
