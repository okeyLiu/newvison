package site.okliu.newvision.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.okliu.newvision.mapper.UserExtMapper;
import site.okliu.newvision.mapper.UserMapper;
import site.okliu.newvision.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserMapper userMapper;
    private UserExtMapper userExtMapper;

    @Autowired
    public UserService(UserMapper userMapper, UserExtMapper userExtMapper) {
        this.userMapper = userMapper;
        this.userExtMapper = userExtMapper;
    }

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

    public List<User> findByIds(ArrayList<Long> ids) {
        return userExtMapper.listByIds(ids);
    }

    public User findById(Long id) {
        Optional<User> optionalUser = userMapper.selectByPrimaryKey(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }
}
