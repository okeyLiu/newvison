package site.okliu.newvision.mapper;

import org.apache.ibatis.annotations.*;
import site.okliu.newvision.model.User;

@Mapper
public interface UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modify,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModify},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Long id);

    @Select("select * from user where account_id=#{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name=#{name}, gmt_modify=#{gmtModify}, avatar_url=#{avatarUrl}, token=#{token} where id=#{id}")
    void update(User user);
}
