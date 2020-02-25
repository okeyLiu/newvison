package site.okliu.newvision.mapper;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import site.okliu.newvision.model.User;

import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;
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
        return user.get();
    }

    public User findByAccountId(String userAccountId) {
        SelectStatementProvider selectStatement = select(user.allColumns())
                .from(user)
                .where(accountId, isEqualTo(userAccountId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<User> dbUser = userMapper.selectOne(selectStatement);
        return dbUser.get();
    }
}
