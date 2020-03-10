package site.okliu.newvision.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
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

    private UserMapper userMapper;

    @Autowired
    public UserExtMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findByToken(String tokenStr) {
        return getUser(token, tokenStr);
    }

    public User getUser(SqlColumn<String> columnBy, String columnValue) {
        SelectStatementProvider selectStatement =
                select(user.allColumns())
                        .from(user)
                        .where(columnBy, isEqualTo(columnValue))
                        .build()
                        .render(RenderingStrategies.MYBATIS3);
        Optional<User> user = userMapper.selectOne(selectStatement);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public User findByAccountId(String userAccountId) {
        return getUser(accountId, userAccountId);
    }

    public List<User> listByIds(ArrayList<Long> ids) {
        return userMapper.select(c -> c.where(id, isIn(ids)));
    }
}
