package rundeepin.config.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 崔家辉
 * @date 2020/08/21 14:30
 * @Description:
 */
@Configuration
public class ShiroConfig {

    @Bean // cjh 1 将自己的验证方式加入容器
    public UserRealm myShiroRealm() {
        return new UserRealm();
    }

    @Bean // cjh 2 权限管理，配置主要是Realm的管理认证
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    @Bean // cjh 3 Filter工厂，设置对应的过滤条件和跳转条件
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/toLogin");
        Map<String, String> filterChainMap = new LinkedHashMap<>();
        filterChainMap.put("/user/*", "authc");
        // filterChainMap.put("/user/update", "authc");
        bean.setFilterChainDefinitionMap(filterChainMap);
        return bean;
    }

}
