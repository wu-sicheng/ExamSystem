package com.wsc.shiro;

import com.wsc.pojo.Teacher;
import com.wsc.service.inter.IPersonService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by wsc on 17-2-2.
 */
public class LoginRealm extends AuthorizingRealm {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoginRealm.class);

    @Resource
    private IPersonService iPersonService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String usermail = principals.getPrimaryPrincipal().toString() ;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
        Set<String> roleName = iPersonService.findRoles(usermail) ;
        Set<String> permissions = iPersonService.findPermissions(usermail) ;
        info.setRoles(roleName);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String mail = token.getPrincipal().toString() ;
        LOGGER.info(token.toString());
        Teacher teacher = iPersonService.queryTeacherByMail(mail);
        if (teacher != null){
            //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realName。
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(teacher.getTeacherMail(),teacher.getTeacherPassword(),
                    "a") ;
            LOGGER.info("realm登录操作");
            return authenticationInfo ;
        }else{
            return null ;
        }
    }
}
