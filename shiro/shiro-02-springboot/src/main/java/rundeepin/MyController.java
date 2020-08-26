package rundeepin;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 崔家辉
 * @date 2020/08/26 17:12
 * @Description:
 */
@Slf4j
@Controller
public class MyController {

    @GetMapping("user/add")
    public String addUser() {
        return "user/add";
    }

    @GetMapping("user/update")
    public String updateUser() {
        return "user/update";
    }

    @GetMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @PostMapping("login")
    public String login(String userName, String password, Model model) {
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            user.login(token);
            return "home";
        } catch (UnknownAccountException uae) { // 未知账户
            log.info("There is no user with username of " + token.getPrincipal());
            model.addAttribute("msg", "未知账户");
            return "login";
        } catch (IncorrectCredentialsException ice) { // 密码不正确
            log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            model.addAttribute("msg", "密码不正确");
            return "login";
        } catch (LockedAccountException lae) { // 账户已锁定
            log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                    "Please contact your administrator to unlock it.");
            model.addAttribute("msg", "账户已锁定");
            return "login";
        } catch (AuthenticationException ae) { // 其他异常：可根据需要自定义
            // 自定义日志输出内容
            log.info("其他登录认证异常");
            model.addAttribute("msg", "其他登录认证异常");
            return "login";
        }
    }
}
