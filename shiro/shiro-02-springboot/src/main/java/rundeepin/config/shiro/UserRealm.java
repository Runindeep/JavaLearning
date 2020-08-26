package rundeepin.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author 崔家辉
 * @date 2020/08/21 15:21
 * @Description:
 */
public class UserRealm extends AuthorizingRealm {
    // @Autowired
    // private LoginService loginService;

    /**
     * 获取权限信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 获取认证信息
     *
     * @param authenticationToken
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = "alice";
        String password = "4453";
        // cjh 用户名认证：自动处理
        // UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // if (!userName.equals(token.getUsername())) {
        //     return null;
        // }
        if (!userName.equals(authenticationToken.getPrincipal())) {
            return null;
        }
        // cjh 密码认证：shiro 处理
        return new SimpleAuthenticationInfo(userName, password, "");
    }
}
