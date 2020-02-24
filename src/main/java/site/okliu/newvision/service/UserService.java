package site.okliu.newvision.service;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.okliu.newvision.mapper.UserMapper;
import site.okliu.newvision.model.User;

import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.UserDynamicSqlSupport.*;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user1) {
        SelectStatementProvider selectStatement = select(user.allColumns())
                .from(user)
                .where(accountId, isEqualTo(user1.getAccountId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<User> dbUser = userMapper.selectOne(selectStatement);
        if (dbUser.isPresent()){
            User user2 = dbUser.get();
            // 更新
            user2.setToken(user1.getToken());
            user2.setName(user1.getName());
            user2.setAvatarUrl(user1.getAvatarUrl());
            user2.setGmtModify(System.currentTimeMillis());
            userMapper.updateByPrimaryKeySelective(user2);// 使用选择的值进行更新
        }else{
            // 插入
            user1.setGmtCreate(System.currentTimeMillis());
            user1.setGmtModify(user1.getGmtCreate());
            userMapper.insert(user1);
        }
    }
}
