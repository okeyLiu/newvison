package site.okliu.newvision.provider;

import site.okliu.newvision.mapper.UserMapper;
import site.okliu.newvision.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieProvider {

    public static User getUserAndPutInSessionFromCookies(HttpServletRequest request, UserMapper userMapper) {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    return user;
                }
            }
        }
        return null;
    }

}
