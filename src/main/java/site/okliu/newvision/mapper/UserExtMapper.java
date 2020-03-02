package site.okliu.newvision.mapper;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import site.okliu.newvision.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.UserDynamicSqlSupport.*;

@Repository
public class UserExtMapper {

    @Autowired
    private UserMapper userMapper;

    public User findByToken(String tokenStr) {
        SelectStatementProvider selectStatement =
                select(user.allColumns())
                        .from(user)
                        .where(token, isEqualTo(tokenStr))
                        .build()
                        .render(RenderingStrategies.MYBATIS3);
        Optional<User> user = userMapper.selectOne(selectStatement);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public User findByAccountId(String userAccountId) {
        SelectStatementProvider selectStatement = select(user.allColumns())
                .from(user)
                .where(accountId, isEqualTo(userAccountId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<User> dbUser = userMapper.selectOne(selectStatement);
        if(dbUser.isPresent()){
            return dbUser.get();
        }
        return null;
    }

    public List<User> listByIds(ArrayList<Long> ids) {
        return userMapper.select(c->c.where(id,isIn(ids)));
    }
}
