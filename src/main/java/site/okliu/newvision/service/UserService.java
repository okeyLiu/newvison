package site.okliu.newvision.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.okliu.newvision.mapper.UserExtMapper;
import site.okliu.newvision.mapper.UserMapper;
import site.okliu.newvision.model.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserExtMapper userExtMapper;


    public User findByToken(String token) {
        return userExtMapper.findByToken(token);
    }

    public void createOrUpdate(User user) {
        User dbUser = userExtMapper.findByAccountId(user.getAccountId());
        if (dbUser != null) {
            // 更新
            dbUser.setToken(user.getToken());
            dbUser.setName(user.getName());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setGmtModify(System.currentTimeMillis());
            userMapper.updateByPrimaryKeySelective(dbUser);// 使用选择的值进行更新
        } else {
            // 插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModify(user.getGmtCreate());
            userMapper.insert(user);
        }
    }
}
