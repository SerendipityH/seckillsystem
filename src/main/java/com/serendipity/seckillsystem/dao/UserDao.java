package com.serendipity.seckillsystem.dao;

import com.serendipity.seckillsystem.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author serendipity
 */
@Mapper
public interface UserDao {
    /**
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    public User getById(@Param("id") Integer id);

    @Insert("insert into user(id,name) values(#{id},#{name})")
    public boolean insertUser(User user);
}
