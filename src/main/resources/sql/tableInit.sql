#创建数据库
DROP DATABASE IF EXISTS paper;
CREATE DATABASE paper;
USE paper;

#创建表格
#学生表格
CREATE TABLE student(
  id INT AUTO_INCREMENT NOT NULL UNIQUE,  #id自增加
  studentId INT PRIMARY KEY NOT NULL UNIQUE,#学生Id
  classId INT NOT NULL,#班级Id
  paperId VARCHAR(255),#试卷Id,多个
  studentName VARCHAR(255) NOT NULL,#学生名字
  studentPassword VARCHAR(255) NOT NULL,#学生登录密码
  studentGander INT NOT NULL,#学生性别 0男1女
  studentNo TEXT NOT NULL,#学生学号
  studentMajor TEXT,#学生专业
  studentGrader INT,#学生年级
  studentNum TEXT,#学生准考证号
  studentMail TEXT,#学生邮箱
  studentPhone TEXT,#学生电话
  roleId INT,#学生的权限
  studentState INT, #学生状态，0删除，1没有删除
  studentCreateTime DATETIME,
  studentDeleteTime DATETIME,
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`id`)
);

#教师表格,管理员同表
CREATE TABLE teacher(
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY ,#id自增加
  teacherId INT NOT NULL,#教师的id
  classId TEXT,#班级id，多个
  paperId TEXT,#试卷id，多个
  teacherName VARCHAR(255) NOT NULL,#教师名称
  teacherDisplayName VARCHAR(20),#显示的名称
  teacherPassword VARCHAR(255) NOT NULL,#教师密码
  teacherGander INT NOT NULL,#教师性别
  teacherNo TEXT NOT NULL,#教师工号
  teacherMail TEXT,#教师邮箱
  teacherPhone TEXT,#教师电话
  teacherState INT,#教师状态，0删除，1没有删除
  roleId INT, #教师权限
  teacherCreateTime DATETIME,
  teacherDeleteTime DATETIME,
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`id`)
);

#班级表格
CREATE TABLE theClass(
  id INT AUTO_INCREMENT NOT NULL UNIQUE,
  theClassId INT PRIMARY KEY NOT NULL UNIQUE,
  theClassState INT NOT NULL,
  theClassName VARCHAR(255),
  theClassCreateTime DATETIME,
  theClassDeleteTime DATETIME
);

#科目表格
CREATE TABLE subject(
  id INT AUTO_INCREMENT NOT NULL UNIQUE,
  subjectId INT PRIMARY KEY NOT NULL UNIQUE,
  subjectName VARCHAR(255),
  subjectCreateTime DATETIME,
  subjectDeleteTime DATETIME,
  subjectState INT
);

#权限管理
CREATE TABLE manager(
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE, #id自增加
  managerId INT NOT NULL UNIQUE,
  createStudent INT NOT NULL,
  createTeacher INT NOT NULL,
  createPaper INT NOT NULL,
  createQuestion INT NOT NULL,
  createResult INT NOT NULL,
  createTheClass INT NOT NULL,

  deleteStudent INT NOT NULL,
  deleteTeacher INT NOT NULL,
  deletePaper INT NOT NULL,
  deleteQuestion INT NOT NULL,
  deleteResult INT NOT NULL,
  deleteTheClass INT NOT NULL,

  updateStudent INT NOT NULL,
  updateTeacher INT NOT NULL,
  updatePaper INT NOT NULL,
  updateQuestion INT NOT NULL,
  updateResult INT NOT NULL,
  updateTheClass INT NOT NULL,

  queryStudent INT NOT NULL,
  queryTeacher INT NOT NULL,
  queryPaper INT NOT NULL,
  queryQuestion INT NOT NULL,
  queryResult INT NOT NULL,
  queryTheClass INT NOT NULL,

  managerState INT NOT NULL
);

#试卷表格
CREATE TABLE paper(
  id INT AUTO_INCREMENT NOT NULL UNIQUE,
  paperId INT PRIMARY KEY NOT NULL UNIQUE,#试卷id
  questionId TEXT,#问题列表 question:{{1,2,3,4}}
  subjectId INT, #科目
  paperTimeBegin DATETIME, #考试开始时间
  paperTimeEnd DATETIME, #考试结束时间
  paperState INT NOT NULL,
  createTime DATETIME,
  deleteTime DATETIME
);

#题目表格
CREATE TABLE question (
  id INT AUTO_INCREMENT NOT NULL UNIQUE, #id自增加
  questionId INT PRIMARY KEY, #问题id
  subjectId INT,
  questionTitle TEXT, #问题标题
  questionText TEXT, #问题主干
  questionAnswer TEXT, #问题答案
  questionRight TEXT, #问题正确答案
  questionScore DOUBLE, #问题分数
  questionType INT, #问题类型，0单项选择，1不定项选择，2填空，3判断，4简答，5论述，6编程OJ
  questionCreateTime DATETIME, #创建时间
  questionDeleteTime DATETIME, #删除时间
  questionState INT #状态，1为没有删除，0表示删除
);

#考试结果表格
CREATE TABLE result(
  id INT AUTO_INCREMENT NOT NULL UNIQUE, #id 自增加
  resultId INT PRIMARY KEY NOT NULL, #结果id
  studentId INT NOT NULL UNIQUE, #学生的id
  paperId INT NOT NULL,#对应的试卷
  resultScorce INT, #学生的分数
  resultDetail TEXT, #学生的题目结果 格式为detail:{{questionId:result},{questionId:result},...}
  resultCreateTime DATETIME,
  resultDeleteTime DATETIME,
  resultState INT
);

#部门信息
#科目信息

#处理表格之间的关系
ALTER TABLE student ADD FOREIGN KEY (classId) REFERENCES theClass(classId);
ALTER TABLE result ADD FOREIGN KEY (studentId) REFERENCES student(studentId);

#初始化表格数据
INSERT INTO theClass VALUES (NULL ,1,1,"class1");
INSERT INTO theClass VALUES (NULL ,2,0,"class2");
INSERT INTO student VALUES (NULL ,1,1,"1,2","wusicheng","password",1,"studentNo","major","2","num","mail@mail.com","18826222446",1,1,"2016-2-2 00:00:00","2017-2-2 12:12:21");
INSERT INTO student VALUES (NULL ,2,2,"2,3","wusic","password",1,"studentNo","major","2","num","mail@mail.com","18826222446",1,1,"2016-2-2 00:00:00","2017-2-2 12:12:21");


# 权限控制
DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id int(11) NOT NULL AUTO_INCREMENT,
  roleName varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS permission;
CREATE TABLE permission (
  id int(11) NOT NULL AUTO_INCREMENT,
  permissionName varchar(50) DEFAULT NULL,
  roleId int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY roleId (roleId),
  CONSTRAINT t_permission_ibfk_1 FOREIGN KEY (roleId) REFERENCES role(id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

