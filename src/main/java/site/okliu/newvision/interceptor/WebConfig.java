package site.okliu.newvision.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import site.okliu.newvision.service.NotificationService;
import site.okliu.newvision.service.UserService;

// import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
// @EnableWebMvc 导致 默认配置的静态路径不执行
public class WebConfig implements WebMvcConfigurer {

    private UserService userService;
    private NotificationService notificationService;

    @Autowired
    public WebConfig(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    @Bean
    public SessionInterceptor sessionInterceptor() {
        return new SessionInterceptor(userService, notificationService);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor()).addPathPatterns("/**");
    }

}
