package tacos.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 崔家辉
 * @date 2020/08/26 11:37
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    // WebMvcConfigurer 定义了几个配置 Spring MVC 的方法
    // 尽管它是一个接口，但它提供了所有方法的默认实现，因此只需覆盖所需的方法
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 提供了一个 ViewControllerRegistry，可以使用它来注册一个或多个视图控制器
        registry.addViewController("/").setViewName("home");
    }
}
