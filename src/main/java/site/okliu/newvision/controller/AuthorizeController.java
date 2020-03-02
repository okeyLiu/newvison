package site.okliu.newvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.okliu.newvision.dto.AccessTokenDTO;
import site.okliu.newvision.dto.GithubUser;
import site.okliu.newvision.model.User;
import site.okliu.newvision.provider.GithubProvider;
import site.okliu.newvision.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.client.redirect_uri}")
    private String redirectUri;

    @Autowired
    private UserService userService;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if(githubUser != null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setAvatarUrl(githubUser.getAvatar_url());
            userService.createOrUpdate(user);
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        }else{
            //登录失败，重新登录
            return "redirect:/";
        }
    }
    /***********************
     * 临时测试使用，无网环境  *
     ***********************/
    @GetMapping("/tempLogin")
    public String tempLogin(HttpServletResponse response){
        String token = "00000000-0000-0000-0000-000000000000";
        response.addCookie(new Cookie("token","00000000-0000-0000-0000-000000000000"));
        User user = new User();
        user.setToken(token);
        user.setName("测试用户");
        user.setAccountId("9999999");
        user.setAvatarUrl("http://localhost:8080/images/default.jpg");
        userService.createOrUpdate(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String toLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String toRegisterPage(Model model){
        List<String> icons = new ArrayList<>();
        for (int i = 0; i <= 25 ; i++) {
            icons.add("http://localhost:8080/images/icon-"+i+".jpg");
        }
        model.addAttribute("icons",icons);
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session,HttpServletResponse response){
        session.removeAttribute("user");
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

}
