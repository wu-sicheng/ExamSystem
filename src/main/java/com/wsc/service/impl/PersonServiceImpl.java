package com.wsc.service.impl;

import com.wsc.dao.inter.IManagerDao;
import com.wsc.dao.inter.IStudentDao;
import com.wsc.dao.inter.ITeacherDao;
import com.wsc.dao.inter.ITheClassDao;
import com.wsc.exceptions.*;
import com.wsc.pojo.Manager;
import com.wsc.pojo.Student;
import com.wsc.pojo.Teacher;
import com.wsc.pojo.TheClass;
import com.wsc.service.inter.IPersonService;
import com.wsc.web.LoginController;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by wsc on 17-1-18.
 */
@Service
public class PersonServiceImpl implements IPersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private ITeacherDao iTeacherDao;

    @Autowired
    private IStudentDao iStudentDao;

    @Autowired
    private ITheClassDao iTheClassDao;

    @Resource
    private LoginController loginController;

    private Set<Integer> listTeacherId;
    private Set<Integer> listStudentId;
    private Set<Integer> listTheClassId;

    /*
     * 教师及管理员的人员管理
     */
    @Override
    public boolean createTeacher(Teacher teacher) throws PersonException {
        int maxTeacherId=Collections.max(iTeacherDao.queryListTeacherId());
        if(!judgeExistMail(teacher)){
            teacher.setTeacherId(maxTeacherId+1);
            if("".equals(teacher.getTeacherDisplayName())){
                teacher.setTeacherDisplayName(teacher.getTeacherMail());
            }
            if (!judgeNull(teacher)) {
                iTeacherDao.addTeacher(teacher);
                return true;
            }
            else {
                LOGGER.info("create teacher中存在空值");
                throw new PersonException("存储的数据存在空值");
            }
        }
        else{
            LOGGER.info("数据库teacher中已存在数据为"+teacher.toString()+"的数据");
            throw new PersonException("数据库teacher中已存在数据为"+teacher.toString()+"的数据");
        }
    }

    @Override
    public Teacher updateTeacher(int teacherId, Teacher teacher) {
        Teacher teacherRet = null;
        listTeacherId = getAllTeacherId();
        if (listTeacherId.contains(teacherId)) {
            teacherRet = queryTeacherByTeacherId(teacherId);
            teacher.setTeacherId(teacherId);
            iTeacherDao.updateTeacher(teacher);
            return teacherRet;
        } else {
            throw new PersonNotExistException("数据库teacher中找不到teacherId为" + teacherId + "这个人");
        }
    }

    @Override
    public Teacher updateTeacherByMail(Teacher teacher){
        int id=iTeacherDao.queryTeacherIdByMail(teacher.getTeacherMail());
        return updateTeacher(id,teacher);
    }

    @Override
    public Teacher deleteTeacherByTeacherId(int teacherId) {
        listTeacherId = getAllTeacherId();
        Teacher teacher = queryTeacherByTeacherId(teacherId);
        if (listTeacherId.contains(teacherId)) {
            iTeacherDao.deleteTeacherByTeacherId(teacherId);
            return teacher;
        } else {
            LOGGER.info("数据库teacher中找不到id为"+teacherId+"的数据");
            throw new PersonNotExistException("数据库中找不到这个人");
        }
    }

    @Override
    public Teacher deleteTeacherByTeacherMail(String teacherMail){
        int id=iTeacherDao.queryTeacherIdByMail(teacherMail);
        return deleteTeacherByTeacherId(id);
    }

    @Override
    public Set<Teacher> queryTeacherAll() {
        listTeacherId = getAllTeacherId();
        try {
            if (listTeacherId.size() != 0) {
                return iTeacherDao.queryTeacherList(Collections.min(listTeacherId), Collections.max(listTeacherId));
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new PersonException("数据库teacher中没有数据");
        }
        return null;
    }

    @Override
    public Set<Teacher> queryTeacherByPaperId(int paperId) {
        Set<Teacher> teacherList = iTeacherDao.queryTeacherByPaperId(String.valueOf(paperId));
        try {
            if (teacherList.size() != 0) {
                return teacherList;
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new PersonNotExistException("找不到符合条件的");
        }
        return null;
    }

    @Override
    public Set<Teacher> queryTeacherByClassId(int classId) {
        Set<Teacher> teacherList = iTeacherDao.queryTeacherByClassId(String.valueOf(classId));
        try {
            if (teacherList.size() != 0) {
                return teacherList;
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new PersonNotExistException("找不到符合条件的");
        }
        return null;
    }

    @Override
    public Teacher queryTeacherByTeacherName(String name) {
        return iTeacherDao.queryTeacherByTeacherName(name);
    }

    @Override
    public Teacher queryTeacherByTeacherId(int teacherId) {
        listTeacherId = getAllTeacherId();
        if (listTeacherId.contains(teacherId)) {
            return iTeacherDao.queryTeacherById(teacherId);
        } else {
            throw new PersonNotExistException("id为" + teacherId + "的数据不存在");
        }
    }

    @Override
    public Set<Integer> queryListTeacherId() {
        return iTeacherDao.queryListTeacherId();
    }

    @Override
    public Set<String> queryListTeacherName() {
        return iTeacherDao.queryListTeacherName();
    }

    @Override
    public Set<String> queryListTeacherMail() {
        return iTeacherDao.queryListTeacherMail();
    }

    @Override
    public Set<String> queryListTeacherPhone() {
        return iTeacherDao.queryListTeacherPhone();
    }

    @Override
    public Teacher queryTeacherByMail(String mail) {
        Teacher teacher=iTeacherDao.queryTeacherByMail(mail);
        if (teacher!=null) {
            return teacher;
        }
        else {
            throw new TeacherNotExistException("数据库student中找不到usermail为"+mail+"这个人");
        }
    }

    @Override
    public Teacher queryTeacherByName(String name) {
        return iTeacherDao.queryTeacherByName(name);
    }

    @Override
    public Teacher queryTeacherByPhone(String phone) {
        return iTeacherDao.queryTeacherByPhone(phone);
    }


    /*
     * 学生的人员管理
     */
    @Override

    public boolean createStudent(Student student) {
        int maxTeacherId=Collections.max(iStudentDao.queryStudentIdAll());
        if(!judgeExistMail(student)){
            student.setStudentId(maxTeacherId+1);
            student.setStudentDisplayName(student.getStudentMail());
            if (!judgeNull(student)) {
                iStudentDao.addStudent(student);
                return true;
            }
            else {
                LOGGER.info("create teacher中存在空值");
                throw new PersonException("存储的数据存在空值");
            }
        }
        else{
            LOGGER.info("数据库teacher中已存在数据为"+student.toString()+"的数据");
            throw new PersonException("数据库teacher中已存在数据为"+student.toString()+"的数据");
        }
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        Student studentRe = null;
        listStudentId = getAllStudentId();
        if (listStudentId.contains(studentId)) {
            studentRe = queryStudentByStudentId(studentId);
            student.setStudentId(studentId);
            iStudentDao.updateStudent(student);
            return studentRe;
        } else {
            throw new PersonNotExistException("数据库中找不到这个人");
        }
    }

    @Override
    public Student updateStudentByMail(Student student) {
        Integer studentId=queryStudentByMail(student.getStudentMail()).getStudentId();
        if(studentId!=null){
            return updateStudent(studentId,student);
        }
        else{
            throw new PersonNotExistException("数据库student中找不到mail为"+student.getStudentMail()+"这个人");
        }
    }

    @Override
    public Student deleteStudent(int studentId) {
        listStudentId = getAllStudentId();
        Student student = queryStudentByStudentId(studentId);
        if (listStudentId.contains(studentId)) {
            iStudentDao.deleteStudent(studentId);
            return student;
        } else {
            throw new PersonNotExistException("数据库中找不到这个人");
        }
    }

    @Override
    public Student deleteStudentByTeacherMail(String studentMail) {
        Integer studentId=queryStudentByMail(studentMail).getStudentId();
        if(studentId!=null){
            return deleteStudent(studentId);
        }
        else{
            throw new PersonNotExistException("数据库student中找不到mail为"+studentMail+"这个人");
        }
    }

    @Override
    public Set<Student> queryStudentAll() {
        listStudentId = getAllStudentId();
        try {
            if (listStudentId.size() != 0) {
                return iStudentDao.queryStudentList(Collections.min(listStudentId), Collections.max(listStudentId));
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new PersonException("数据库中找不到数据");
        }
        return null;
    }

    @Override

    public Set<Student> queryStudentByPaperId(int paperId) {
        Set<Student> studentList = iStudentDao.queryStudentByPaperId(String.valueOf(paperId));
        try {
            if (studentList.size() != 0) {
                return studentList;
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new PersonNotExistException("找不到符合条件的");
        }
        return null;
    }

    @Override

    public Set<Student> queryStudentByClassId(int classId) {
        Set<Student> studentList = iStudentDao.queryStudentByTheClassId(classId);
        try {
            if (studentList.size() != 0) {
                return studentList;
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new PersonNotExistException("找不到符合条件的");
        }
        return null;
    }

    @Override
    public Student queryStudentByStudentName(String name) {
        Student student= iStudentDao.queryStudentByStudentName(name);
        try {
            if (student != null) {
                return student;
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new PersonNotExistException("找不到符合条件的");
        }
        return null;
    }

    @Override

    public Student queryStudentByStudentId(int studentId) {
        listStudentId = getAllStudentId();
        if (listStudentId.contains(studentId)) {
            return iStudentDao.queryStudent(studentId);
        }
        else {
            throw new PersonNotExistException("找不到这个人");
        }
    }

    @Override
    public Student queryStudentByMail(String usermail) {
        Student student=iStudentDao.queryStudentByStudentMail(usermail);
        if (student!=null) {
            return student;
        }
        else {
            throw new StudentNotExistException("数据库student中找不到usermail为"+usermail+"这个人");
        }
    }

    @Override
    public Student queryStudentByPhone(String phone) {
        Student student=iStudentDao.queryStudentByStudentPhone(phone);
        if (student!=null) {
            return student;
        }
        else {
            throw new PersonNotExistException("数据库student中找不到phone为"+phone+"这个人");
        }
    }

    @Override
    public Student queryStudentByNum(String num) {
        Student student=iStudentDao.queryStudentByStudentNum(num);
        if (student!=null) {
            return student;
        }
        else {
            throw new PersonNotExistException("数据库student中找不到num为"+num+"这个人");
        }
    }

    @Override
    public Student queryStudentByNo(String no) {
        Student student=iStudentDao.queryStudentByStudentNo(no);
        if (student!=null) {
            return student;
        }
        else {
            throw new PersonNotExistException("数据库student中找不到no为"+no+"这个人");
        }
    }

    @Override
    public Set<String> queryListStudentMail() {
        Set<String> mailSet=iStudentDao.querySetStudentMail();
        if(mailSet.size()!=0){
            return mailSet;
        }
        else{
            throw new PersonNotExistException("数据库student中不存在数据");
        }
    }

    @Override
    public Set<String> queryListStudentPhone() {
        Set<String> mailSet=iStudentDao.querySetStudentPhone();
        if(mailSet.size()!=0){
            return mailSet;
        }
        else{
            throw new PersonNotExistException("数据库student中不存在数据");
        }
    }

    @Override
    public Set<String> queryListStudentName() {
        Set<String> mailSet=iStudentDao.querySetStudentName();
        if(mailSet.size()!=0){
            return mailSet;
        }
        else{
            throw new PersonNotExistException("数据库student中不存在数据");
        }
    }

    /*
    班级管理
     */
    @Override

    public boolean createTheClass(TheClass theClass) {
        int maxTheClassId=Collections.max(iTheClassDao.queryTheClassIdAll());
        if(!judgeExistTheClassName(theClass)){
            theClass.setTheClassId(maxTheClassId+1);
            if(!judgeNullTheClass(theClass)){
                iTheClassDao.createTheClass(theClass);
                return true;
            }
            else {
                LOGGER.info("create teacher中存在空值");
                throw new PersonException("存储的数据存在空值");
            }
        }
        else{
            LOGGER.info("数据库theClass中已存在数据为"+theClass.toString()+"的数据");
            throw new PersonException("数据库theClass中已存在数据为"+theClass.toString()+"的数据");
        }
    }

    @Override

    public TheClass deleteTheClass(int theClassId) {
        listTheClassId = getAllTheClassId();
        if (listTheClassId.contains(theClassId)) {
            TheClass theClassRe = iTheClassDao.queryTheClass(theClassId);
            iTheClassDao.deleteTheClass(theClassId);
            return theClassRe;
        } else {
            LOGGER.info("数据库the_class中不含有数据the_class_id为" + theClassId + "的数据");
            throw new PersonException("数据库the_class中不含有数据the_class_id为" + theClassId + "的数据");
        }
    }

    @Override

    public TheClass updateTheClass(TheClass theClass) {
        listTheClassId = getAllTheClassId();
        if (listTheClassId.contains(theClass.getTheClassId())) {
            TheClass theClassRe = iTheClassDao.queryTheClass(theClass.getTheClassId());
            iTheClassDao.updateTheClass(theClass);
            return theClassRe;
        } else {
            LOGGER.info("数据库the_class中不含有数据the_class_id为" + theClass.getTheClassId() + "的数据");
            throw new PersonException("数据库the_class中不含有数据the_class_id为" + theClass.getTheClassId() + "的数据");
        }
    }

    @Override

    public TheClass queryTheClass(int theClassId) {
        listTheClassId = getAllTheClassId();
        if (listTheClassId.contains(theClassId)) {
            return iTheClassDao.queryTheClass(theClassId);
        } else {
            LOGGER.info("数据库the_class中不含有数据the_class_id为" + theClassId + "的数据");
            throw new PersonException("数据库the_class中不含有数据the_class_id为" + theClassId + "的数据");
        }
    }

    @Override
    public Set<TheClass> queryTheClassList(int fromTheClassId, int toTheClassId) {
        listTheClassId = getAllTheClassId();
        try {
            if (listTheClassId != null) {
                return iTheClassDao.queryTheClassList(fromTheClassId, toTheClassId);
            }
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info(e.getMessage());
            LOGGER.info("数据库theClass中不含有符合" + fromTheClassId + "到" + toTheClassId + "的数据");
            throw new PersonException("数据库theClass中不含有符合" + fromTheClassId + "到" + toTheClassId + "的数据");
        }
        throw new PersonException("数据库theClass中不含有符合" + fromTheClassId + "到" + toTheClassId + "的数据");
    }

    @Override
    public Set<TheClass> queryTheClassListAll() {
        listTheClassId = getAllTheClassId();
        return queryTheClassList(Collections.min(listTheClassId), Collections.max(listTheClassId));
    }


    @Override
    public Set<String> findRoles(String mail) {
        String loginType=loginController.getLoginType();
        LOGGER.info("================================================================="+loginType);
        if("admin".equals(loginType)||"teacher".equals(loginType)){
            LOGGER.info("进入admin,teacher认证");
            return iTeacherDao.findRoles(mail);
        }
        else{
            LOGGER.info("进入student,guest认证");
            return iStudentDao.findRoles(mail);
        }
    }

    @Override
    public Set<String> findPermissions(String mail) {
        String loginType=loginController.getLoginType();
        if("admin".equals(loginType)||"teacher".equals(loginType)){
            return iTeacherDao.findPermissions(mail);
        }
        else if("student".equals(loginType)||"guest".equals(loginType)){
            return iTeacherDao.findRoles(mail);
        }
        return null;
    }


    private Set<Integer> getAllTeacherId() {
        return iTeacherDao.queryTeacherIdAll();
    }


    private Set<Integer> getAllStudentId() {
        return iStudentDao.queryStudentIdAll();
    }


    private Set<Integer> getAllTheClassId() {
        return iTheClassDao.queryTheClassIdAll();
    }


    private boolean judgeNull(Teacher teacher) {
        if (teacher.getTeacherName() == null || teacher.getTeacherMail() == null || teacher.getTeacherPassword() == null) {
            return true;
        }
        return false;
    }

    private boolean judgeNull(Student student) {
        if (student.getStudentName() == null || student.getStudentPassword() == null || student.getStudentMail() == null) {
            return true;
        }
        return false;
    }

    private boolean judgeExist(Teacher teacher) {
        Set<String> teacherNameSet=iTeacherDao.queryListTeacherName();
        Set<String> teacherMailSet=iTeacherDao.queryListTeacherMail();
        Set<String> teacherPhoneSet=iTeacherDao.queryListTeacherPhone();
        if(teacherMailSet.contains(teacher.getTeacherMail())){
            LOGGER.info("数据库teacher中存在teacher_mail为"+teacher.getTeacherMail()+"的用户");
            return true;
        }
        else if(teacherNameSet.contains(teacher.getTeacherName())){
            LOGGER.info("数据库teacher中存在teacher_name为"+teacher.getTeacherName()+"的用户");
            return true;
        }
        else if(teacherPhoneSet.contains(teacher.getTeacherPhone())){
            LOGGER.info("数据库teacher中存在teacher_phone为"+teacher.getTeacherPhone()+"的用户");
            return true;
        }
        else{
            return false;
        }
    }
    private boolean judgeExistMail(Teacher teacher){
        Set<String> teacherMailSet=iTeacherDao.queryListTeacherMail();
        if(teacherMailSet.contains(teacher.getTeacherMail())){
            LOGGER.info("数据库teacher中存在teacher_mail为"+teacher.getTeacherMail()+"的用户");
            return true;
        }
        return false;
    }

    private boolean judgeExistMail(Student student){
        Set<String> studentMailSet=iStudentDao.querySetStudentMail();
        if(studentMailSet.contains(student.getStudentMail())){
            LOGGER.info("数据库student中存在student_mail为"+student.getStudentMail()+"的用户");
            return true;
        }
        return false;
    }

    private boolean judgeExistTheClassName(TheClass theClass){
        Set<TheClass> theClassSet=iTheClassDao.queryTheClassList(Collections.min(iTheClassDao.queryTheClassIdAll()),
                Collections.max(iTheClassDao.queryTheClassIdAll()));
        LOGGER.info(theClassSet.toString());
        LOGGER.info(theClass.toString());
        Set<String> stringSet=new HashSet<>(theClassSet.size());
        Iterator<TheClass> iterator=theClassSet.iterator();
        while(iterator.hasNext()){
            TheClass theClazz=iterator.next();
            stringSet.add(theClazz.getTheClassName());
        }
        LOGGER.info(stringSet.toString());
        if(stringSet.contains(theClass.getTheClassName())){
            return true;
        }
        return false;
    }

    private boolean judgeNullTheClass(TheClass theClass){
        if(theClass.getTheClassName()==null||theClass.getTheClassName().equals("")){
            return true;
        }
        return false;
    }
}
