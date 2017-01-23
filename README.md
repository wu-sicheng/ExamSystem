# 在线考试系统（练习+毕业设计）

## 项目说明
### 架构说明
开发系统是Ubuntu16.04，开发工具是Idea，使用gradle进行项目构建，junit进行单元测试，使用的框架为Spring+SpringMVC+MyBatis,数据库采用MySQL，数据库连接池采用阿里的Druid

### 业务说明
在线的考试系统，其主要的业务为在线考试，在线试题分析，人员管理，OJ（待定）

## 目录结构

![](http://ww3.sinaimg.cn/large/63f8de7fgw1fbrh2gj9xaj208t0fn3zq.jpg)

![](http://ww3.sinaimg.cn/large/63f8de7fgw1fbrh3fiblkj208p0cuwfn.jpg)

### 各文件夹及其作用
- java:项目的源码目录
  - controller：控制层
  - dao.inter:数据库操作接口
  - pojo:普通的entity文件
  - service：服务层
- resources：相关配置来源目录
  - mapping：MyBatis映射文件
  - sql：sql操作源文件
  - jdbc.properties：数据库的配置文件
  - mybatis-config.xml：MyBatis的配置文件
  - spring-mvc.xml：spring和SpringMVC的整合文件
  - spring-mybatis.xml：Spring和MyBati整合文件
- webapp：web项目的文件
- test：测试目录
  - java ：测试源码
  - resources：测试相关来源
-build.gradle：Gradle构建项目文件
-settings.gradle：gradle的设置文件

## 数据库设计阶段


## Spring和MyBatis的整合过程

- 定义相关依赖
- 创建mybatis-config.xml文件，用于设置MyBatis的相关参数
- 创建spring-mybatis.xml用于整合Spring和MyBatis
- 数据库的配置文件
- 定义pojo文件，以Teacher为例
- 创建ITeacherDao
- 创建mapping文件TeacherDao.xml
- 测试文件
- 测试结果

### 定义相关依赖
- spring的相关依赖(待更改)

![](http://ww2.sinaimg.cn/large/63f8de7fgw1fbrhmw35l0j20e90b70v0.jpg)

- MyBatis相关依赖
```
compile 'org.mybatis:mybatis:3.4.2'//MyBatis本身的库
compile 'org.mybatis:mybatis-spring:1.3.1'//MyBatis和Spring整合的库
```
- mysql连接数据库
```
compile 'mysql:mysql-connector-java:6.0.5'//Java连接数据库的库
```
- druid连接池
```
compile 'com.alibaba:druid:1.0.26'//连接池
```

### 创建mybatis-config.xml文件，用于设置MyBatis的相关参数
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <!--允许 JDBC 支持自动生成主键，需要驱动兼容-->
        <setting name="useGeneratedKeys" value="true"/>
        <!--使用列标签代替列名-->
        <setting name="useColumnLabel" value="true"/>
        <!--从经典数据库列名 A_COLUMN 到经典 Java 属性名 aColumn 的类似映射-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
</configuration>  
```

### 创建spring-mybatis.xml用于整合Spring和MyBatis
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

    <!--设置扫描参数，参数文件为jdbc.properties-->
    <context:property-placeholder location="classpath:jdbc.properties "/>

    <!--JavaBean的自动扫描包-->
    <context:component-scan base-package="com.wsc.dao.inter"/>

    <!--配置数据库连接池-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="maxActive" value="30"/>
        <property name="defaultAutoCommit" value="false"/>
        <property name="maxWait" value="1000"/>
    </bean>

    <!--MyBatis的SQLSessionFactory-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
        <property name="typeAliasesPackage" value="com.wsc.pojo"/>
        <property name="mapperLocations" value="classpath:mapping/*.xml"/>
    </bean>

    <!--MyBatis的Mapping-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
        <property name="basePackage" value="com.wsc.dao.inter"/>
    </bean>
</beans>

```

### 数据库的配置文件
```
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/paper?useUnicode=true&characterEncoding=utf8
jdbc.username=root
jdbc.password=1235
```

### 定义pojo文件，以Teacher为例
```Java
package com.wsc.pojo;

import java.util.Date;

/**
 * Created by wsc on 17-1-13.
 */
public class Student {
    private int studentId;
    private int classId;
    private String paperId;
    private String studentName;
    private String studentPassword;
    private int studentGander;
    private String studentNo;
    private String studentMajor;
    private int studentGrader;
    private String studentNum;
    private String studentMail;
    private String studentPhone;
    private int studentPower;
    private int studentState;
    private Date studentCreateTime;
    private Date studentDeleteTime;
    
    /*
        构造器
        getter和setter
        toString(),便于测试
    */
}
```

### 创建IStudentDao
```Java
package com.wsc.dao.inter;

import com.wsc.pojo.Student;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wsc on 17-1-13.
 */
public interface IStudentDao {
    /**
     * 往数据库添加一个学生
     * @param student 学生元素
     * @return true表示添加成功，false表示添加失败
     */
    boolean addStudent(Student student);

    /**
     * 通过studentId删除一个学生
     * @param studentId 学生Id
     * @return 删除学生的信息，这里的删除只是将学生的State由1改为0，在数据库中不会将其完全删
    Student deleteStudent(int studentId);
     */

    Student deleteStudent(int studentId);
    /**
     * 更新学生信息
     * @param student 更新的学生的信息
     * @param studentId 更新信息学生的id
     * @return 是否更新成功
     */
    boolean updateStudent(Student student,int studentId);

    /**
     * 通过学生id查询学生信息
     * @param studentId
     * @return 学生信息
     */
    Student queryStudent(int studentId);

    /**
     * 查询一个学生集
     * @param fromStudentId 开始的id
     * @param manyStudentId 结束的id
     * @return 结果集
     */
    List<Student> queryStudentList(int fromStudentId,int manyStudentId);
}

```
### 创建mapping文件StudenDao.xml
```xml
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.wsc.dao.inter.ITeacherDao">
    <!--创建一个教师-->
    <insert id="addTeacher" parameterType="Teacher">
        INSERT INTO teacher (id,teacherId,classId,paperId,teacherName,teacherPassword,
        teacherGander,teacherNo,teacherMail,teacherPhone,teacherState,teacherPower,
        teacherCreateTime) VALUES (NULL,#{teacherId},#{classId},#{paperId},#{teacherName},
        #{teacherPassword},#{teacherGander},#{teacherNo},#{teacherMail},#{teacherPhone},
        1,2,now());
    </insert>

    <!--删除一个教师数据，将标志位置为0并插入删除时间-->
    <update id="deleteTeacher" parameterType="int">
        UPDATE teacher SET teacherState=0,teacherDeleteTime=now() WHERE teacherId=#{teacherId};
    </update>

    <!--更新教师数据-->
    <update id="updateTeacher">
        UPDATE teacher SET classId=#{classId},paperId=#{paperId},
        teacherName=#{teacherName},teacherPassword=#{teacherPassword},
        teacherGander=#{teacherGander},teacherNo=#{teacherNo},
        teacherMail=#{teacherMail},teacherPhone=#{teacherPhone} WHERE teacherId=#{teacherId};
    </update>

    <!--通过id来查询教师信息-->
    <select id="queryTeacher" parameterType="int">
        SELECT * from teacher WHERE teacherId=#{teacherId};
    </select>

    <!--查询教师列表-->
    <select id="queryTeacherIdList" parameterType="int">
        SELECT * FROM teacher WHERE teacherId <![CDATA[>=]]]> #{fromTeacherId} AND teacherId <![CDATA[<]]]> #{fromTeacherId+manyTeacherId};
    </select>

    <!--通过class id来查询教师数据集-->
    <select id="queryTeacherByClassId" parameterType="String">
        SELECT * FROM teacher WHERE classId LIKE %#{classId}','%;
    </select>

    <!--提升教师权限-->
    <update id="upperPower" parameterType="int">
        UPDATE teacher SET teacherPower=teacherPower+1 WHERE teacherId=#{id};
    </update>

    <!--降低教师权限-->
    <update id="lowerPower" parameterType="int">
        UPDATE teacher SET teacherPower=teacherPower-1 WHERE teacherId=#{id};
    </update>

    <!--将教师权限设置为3-->
    <update id="setLevel3" parameterType="int">
        UPDATE teacher SET teacherPower=3 WHERE teacherId=#{id};
    </update>

    <!--将教师权限设置为2-->
    <update id="setLevel2" parameterType="int">
        UPDATE teacher SET teacherPower=2 WHERE teacherId=#{id};
    </update>

    <!--将教师权限设置为1-->
    <update id="setLevel1" parameterType="int">
        UPDATE teacher SET teacherPower=1 WHERE teacherId=#{id};
    </update>
</mapper>
```
### 测试文件
```Java
package com.wsc.dao.inter;

import com.wsc.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * 用于spring和mybatis的整合测试
 * Created by wsc on 17-1-14.
 */
@RunWith(SpringJUnit4ClassRunner.class)//Spring结合JUnit
@ContextConfiguration(value = {"classpath:spring-mybatis.xml"})//运行Junit的时候将设置文件载入
public class IStudentDaoTestSpring {
    private static final Logger LOGGER= LoggerFactory.getLogger(IStudentDaoTestSpring.class);

    @Resource
    private IStudentDao iStudentDao;

    @Test
    public void queryStudent() throws Exception {
        Student student=iStudentDao.queryStudent(1);
        LOGGER.info(student.toString());
    }
}
```
### 测试结果
```
[main] INFO com.wsc.dao.inter.IStudentDaoTest - Student{studentId=1, classId=1, paperId='1,2', studentName='wusicheng', studentPassword='password', studentGander=1, studentNo='studentNo', studentMajor='major', studentGrader=2, studentNum='num', studentMail='mail@mail.com', studentPhone='12312313213', studentPower=1, studentState=1, studentCreateTime=Tue Feb 02 14:00:00 CST 2016, studentDeleteTime=Fri Feb 03 02:12:21 CST 2017}
```
### 通过测试，Spring和MyBatis整合成功



## 那些坑
### MyBatis的模糊搜索
```SQL
SELECT * FROM teacher WHERE paperId LIKE CONCAT('%',#{paperId},',%');
```

### MyBatis的大小写
```SQL
SELECT * FROM teacher WHERE teacherId <![CDATA[>=]]> #{fromTeacherId} AND teacherId <![CDATA[<=]]> #{toTeacherId} AND teacherState=1;
```
<<<<<<< HEAD
### MyBatis的问题
数据库

![](http://ww1.sinaimg.cn/large/63f8de7fgy1fc0wo1p8paj20je02twek&690)

![](http://ww1.sinaimg.cn/large/63f8de7fgy1fc0wpe4fdtj20ob03i74a&690)

```Java
    public boolean createSubject(int teacherId, Subject subject) {
        subjectIdList=getQuestionIdList();
        if(iPersonService.createTestDB(teacherId)){
            if(subjectIdList.contains(subject.getSubjectId())){
                LOGGER.info("数据库subject中已经包含id为"+subject.getSubjectId()+"的数据");
                throw new TestDBException("数据库subject中已经包含id为"+subject.getSubjectId()+"的数据");
            }
            else{
                iSubjectDao.createSubject(subject);
                return true;
            }
        }
        else{
            LOGGER.info("没有权限创建数据");
            throw new ManagerException("没有权限");
        }
    }
```
