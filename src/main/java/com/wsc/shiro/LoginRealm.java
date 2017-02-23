package com.wsc.shiro;

import com.wsc.exceptions.StudentNotExistException;
import com.wsc.exceptions.TeacherNotExistException;
import com.wsc.pojo.Student;
import com.wsc.pojo.Teacher;
import com.wsc.service.inter.IPersonService;
import com.wsc.web.LoginController;
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

    @Resource
    private LoginController loginController;

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
        String mail = token.getPrincipal().toString();
        String loginType=loginController.getLoginType();
        if("admin".equals(loginType)||"teacher".equals(loginType)){
            Teacher teacher = iPersonService.queryTeacherByMail(mail);
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(teacher.getTeacherMail(),
                    teacher.getTeacherPassword(),
                    "a") ;
            LOGGER.info("teacher_realm登录操作");
            return authenticationInfo ;
        }
        else if("student".equals(loginType)||"guest".equals(loginType)){
            Student student = iPersonService.queryStudentByMail(mail);
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(student.getStudentMail(),
                    student.getStudentPassword(),
                    "a") ;
            LOGGER.info("student_realm登录操作");
            return authenticationInfo ;
        }
        return null ;
    }
}
