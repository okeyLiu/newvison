package site.okliu.newvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.okliu.newvision.constant.AppConstant;
import site.okliu.newvision.dto.AccessTokenDTO;
import site.okliu.newvision.dto.GithubUser;
import site.okliu.newvision.provider.GithubProvider;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name="state") String state){
        System.out.println("code = " + code);
        System.out.println("state = " + state);
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(AppConstant.CLIENT_ID);
        accessTokenDTO.setClient_secret(AppConstant.CLIENT_SECRET);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(AppConstant.REDIRECT_URI);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println("user.getName() = " + user.getName());
        return "index";
    }

}
