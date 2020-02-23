package site.okliu.newvision.interceptor;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import site.okliu.newvision.mapper.UserMapper;
import site.okliu.newvision.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.UserDynamicSqlSupport.*;

public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token1 = cookie.getValue();
                    SelectStatementProvider selectStatement =
                            select(user.allColumns())
                            .from(user)
                            .where(token, isEqualTo(token1))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                    Optional<User> user = userMapper.selectOne(selectStatement);
                    if (user.isPresent()) {
                        request.getSession().setAttribute("user", user.get());
                    }
                    break;
                }
            }
        }
        return true;
    }

}
