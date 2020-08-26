package rundeepin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Shiro02Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Shiro02Application.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 提供了一个 ViewControllerRegistry，可以使用它来注册一个或多个视图控制器
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/index").setViewName("home");
        registry.addViewController("/home").setViewName("home");
    }
}
