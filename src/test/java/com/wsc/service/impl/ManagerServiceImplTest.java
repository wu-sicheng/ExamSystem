package com.wsc.service.impl;

import com.wsc.pojo.Manager;
import com.wsc.service.inter.IManagerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by wsc on 17-1-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring-service.xml",
        "classpath:spring-mybatis.xml"})
public class ManagerServiceImplTest {

    @Autowired
    private IManagerService iManagerService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createPower() throws Exception {
        Manager manager=new Manager(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        iManagerService.createPower(manager);
    }
    /*
    * /usr/lib/jvm/jdk1.8.0_111/bin/java -ea -Didea.launcher.port=7536 -Didea.launcher.bin.path=/usr/share/idea-IU-163.10154.41/bin -Dfile.encoding=UTF-8 -classpath /usr/share/idea-IU-163.10154.41/lib/idea_rt.jar:/usr/share/idea-IU-163.10154.41/plugins/junit/lib/junit-rt.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/charsets.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/deploy.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/ext/dnsns.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/ext/jaccess.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/ext/jfxrt.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/ext/localedata.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/ext/nashorn.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/ext/sunec.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/ext/zipfs.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/javaws.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/jce.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/jfr.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/jfxswt.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/jsse.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/management-agent.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/plugin.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/resources.jar:/usr/lib/jvm/jdk1.8.0_111/jre/lib/rt.jar:/media/wsc/Work/workspace/paper/build/classes/test:/media/wsc/Work/workspace/paper/build/classes/main:/media/wsc/Work/workspace/paper/build/resources/main:/home/wsc/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-api/1.7.22/a1c83373863cec7ae8d89dc1c5722d8cb6ec0309/slf4j-api-1.7.22.jar:/home/wsc/.gradle/caches/modules-2/files-2.1/org.mybatis/mybatis/3.4.2/2b9a5082fe0bdb3128bab8b4b19b23ca0f3d9b38/mybatis-3.4.2.jar:/home/wsc/.gradle/caches/modules-2/files-2.1/org.mybatis/mybatis-spring/1.3.1/5197169e15a43066f177a1cd12a098e1283fdc76/mybatis-spring-1.3.1.jar:/home/wsc/.gradle/caches/modules-2/files-2.1/mysql/mysql-connector-java/6.0.5/9d8df5a1f3273110f2a9ad304961bdd03d696d86/mysql-connector-java-6.0.5.jar:/home/wsc/.gradle/caches/modules-2/files-2.1/com.alibaba/druid/1.0.26/f4bc6159b34e4cda5abd6480203492b470aa1a36/druid-1.0.26.jar:/home/wsc/.gradle/caches/modules-2/files-2.1/junit/junit/4.12/2973d150c0dc1fefe998f834810d68f278ea58ec/junit-4.12.jar:/home/wsc/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-simple/1.7.22/595058a6ec00a6e58f2f48113e8708f036a19cf7/slf4j-simple-1.7.22.jar:/home/wsc/.gradle/caches/modules-2/files-2.1/org.hamcrest/hamcrest-core/1.3/42a25dc3219429f0e5d060061f71acb49bf010a0/hamcrest-core-1.3.jar:/media/wsc/Work/lib/spring/aopalliance-1.0.jar:/media/wsc/Work/lib/spring/commons-logging-1.2.jar:/media/wsc/Work/lib/spring/spring-aop-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-aspects-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-beans-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-context-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-context-support-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-core-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-expression-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-instrument-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-instrument-tomcat-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-jdbc-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-jms-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-messaging-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-orm-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-oxm-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-test-4.3.4.RELEASE.jar:/media/wsc/Work/lib/spring/spring-tx-4.3.4.RELEASE.jar com.intellij.rt.execution.application.AppMain com.intellij.rt.execution.junit.JUnitStarter -ideVersion5 com.wsc.service.impl.ManagerServiceImplTest,createPower
一月 17, 2017 6:05:22 下午 org.springframework.test.context.support.DefaultTestContextBootstrapper getDefaultTestExecutionListenerClassNames
信息: Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener]
一月 17, 2017 6:05:22 下午 org.springframework.test.context.support.DefaultTestContextBootstrapper instantiateListeners
信息: Could not instantiate TestExecutionListener [org.springframework.test.context.web.ServletTestExecutionListener]. Specify custom listener classes or make the default listener classes (and their required dependencies) available. Offending class: [javax/servlet/ServletContext]
一月 17, 2017 6:05:22 下午 org.springframework.test.context.support.DefaultTestContextBootstrapper getTestExecutionListeners
信息: Using TestExecutionListeners: [org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@2ef9b8bc, org.springframework.test.context.support.DependencyInjectionTestExecutionListener@5d624da6, org.springframework.test.context.support.DirtiesContextTestExecutionListener@1e67b872, org.springframework.test.context.transaction.TransactionalTestExecutionListener@60addb54, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@3f2a3a5]
一月 17, 2017 6:05:22 下午 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
信息: Loading XML bean definitions from class path resource [spring-service.xml]
一月 17, 2017 6:05:23 下午 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
信息: Loading XML bean definitions from class path resource [spring-mybatis.xml]
一月 17, 2017 6:05:23 下午 org.springframework.context.support.GenericApplicationContext prepareRefresh
信息: Refreshing org.springframework.context.support.GenericApplicationContext@d2cc05a: startup date [Tue Jan 17 18:05:23 CST 2017]; root of context hierarchy
一月 17, 2017 6:05:23 下午 org.springframework.context.support.PropertySourcesPlaceholderConfigurer loadProperties
信息: Loading properties file from class path resource [jdbc.properties]
一月 17, 2017 6:05:23 下午 org.springframework.context.support.GenericApplicationContext refresh
警告: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'managerServiceImpl' defined in file [/media/wsc/Work/workspace/paper/build/classes/main/com/wsc/service/impl/ManagerServiceImpl.class]: Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.wsc.service.impl.ManagerServiceImpl]: Constructor threw exception; nested exception is java.lang.NullPointerException

一月 17, 2017 6:05:23 下午 org.springframework.test.context.TestContextManager prepareTestInstance
严重: Caught exception while allowing TestExecutionListener [org.springframework.test.context.support.DependencyInjectionTestExecutionListener@5d624da6] to prepare test instance [com.wsc.service.impl.ManagerServiceImplTest@4ac3c60d]
java.lang.IllegalStateException: Failed to load ApplicationContext
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:83)
	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.injectDependencies(DependencyInjectionTestExecutionListener.java:117)
	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.prepareTestInstance(DependencyInjectionTestExecutionListener.java:83)
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:230)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.createTest(SpringJUnit4ClassRunner.java:228)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner$1.runReflectiveCall(SpringJUnit4ClassRunner.java:287)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.methodBlock(SpringJUnit4ClassRunner.java:289)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:247)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:94)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61)
	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:191)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:51)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:237)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'managerServiceImpl' defined in file [/media/wsc/Work/workspace/paper/build/classes/main/com/wsc/service/impl/ManagerServiceImpl.class]: Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.wsc.service.impl.ManagerServiceImpl]: Constructor threw exception; nested exception is java.lang.NullPointerException
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1110)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1054)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:512)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:482)
	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:754)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:866)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:542)
	at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
	at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
	at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:108)
	at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:251)
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:98)
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:116)
	... 29 more
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.wsc.service.impl.ManagerServiceImpl]: Constructor threw exception; nested exception is java.lang.NullPointerException
	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:154)
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:89)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1102)
	... 45 more
Caused by: java.lang.NullPointerException
	at com.wsc.service.impl.ManagerServiceImpl.<init>(ManagerServiceImpl.java:22)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:142)
	... 47 more


java.lang.IllegalStateException: Failed to load ApplicationContext

	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:83)
	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.injectDependencies(DependencyInjectionTestExecutionListener.java:117)
	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.prepareTestInstance(DependencyInjectionTestExecutionListener.java:83)
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:230)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.createTest(SpringJUnit4ClassRunner.java:228)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner$1.runReflectiveCall(SpringJUnit4ClassRunner.java:287)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.methodBlock(SpringJUnit4ClassRunner.java:289)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:247)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:94)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61)
	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:191)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:51)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:237)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'managerServiceImpl' defined in file [/media/wsc/Work/workspace/paper/build/classes/main/com/wsc/service/impl/ManagerServiceImpl.class]: Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.wsc.service.impl.ManagerServiceImpl]: Constructor threw exception; nested exception is java.lang.NullPointerException
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1110)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1054)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:512)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:482)
	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:754)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:866)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:542)
	at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
	at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
	at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:108)
	at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:251)
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:98)
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:116)
	... 29 more
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.wsc.service.impl.ManagerServiceImpl]: Constructor threw exception; nested exception is java.lang.NullPointerException
	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:154)
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:89)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1102)
	... 45 more
Caused by: java.lang.NullPointerException
	at com.wsc.service.impl.ManagerServiceImpl.<init>(ManagerServiceImpl.java:22)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:142)
	... 47 more


Process finished with exit code 255

    *
    * */
}