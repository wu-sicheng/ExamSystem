package other;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wsc on 17-2-1.
 */
public class TestShiro {
    private static final Logger LOGGER= LoggerFactory.getLogger(TestShiro.class);
    @Test
    public void main() {
        //创建一个SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("/media/wsc/Work/workspace/paper/src/test/java/other/shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        //将工厂绑定到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("zhang","123");
        try{
            subject.login(token);
            LOGGER.info("登录成功");
        }catch (AuthenticationException e){

        }
        Assert.assertEquals(true,subject.isAuthenticated());
        subject.logout();
    }
}
