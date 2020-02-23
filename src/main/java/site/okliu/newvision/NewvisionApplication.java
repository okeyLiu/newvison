package site.okliu.newvision;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("site.okliu.newvision.mapper")
public class NewvisionApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewvisionApplication.class, args);
    }

}
