package tacos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author 崔家辉
 * @date 2020/08/26 09:09
 * @Description:
 */
@RunWith(SpringRunner.class)
@WebMvcTest // Spring Boot 提供的一个特殊测试注释，它安排测试在 Spring MVC 应用程序的上下文中运行
// 还为测试 Spring MVC 提供了 Spring 支持。虽然可以让它启动服务器，但模拟 Spring MVC 的机制就足以满足你的目的了。
// 测试类被注入了一个 MockMvc 对象中，以此用来测试来驱动模型。
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) // 从 MockMvc 对象开始，执行针对 /（根路径）的 HTTP GET 请求
                .andExpect(status().isOk()) // 响应应该有一个HTTP 200（OK）状态
                .andExpect(view().name("home")) // 视图应该有一个合理的主页名称
                .andExpect(content().string(containsString("Welcome to...")));
        // 呈现的视图应该包含 “Welcome to...”
    }
}
