package com.wsc.service.impl;

import com.wsc.dao.inter.IManagerDao;
import com.wsc.dao.inter.IStudentDao;
import com.wsc.dao.inter.ITeacherDao;
import com.wsc.dao.inter.ITheClassDao;
import com.wsc.exceptions.ManagerException;
import com.wsc.exceptions.PersonException;
import com.wsc.exceptions.PersonNotExistException;
import com.wsc.pojo.Manager;
import com.wsc.pojo.Student;
import com.wsc.pojo.Teacher;
import com.wsc.pojo.TheClass;
import com.wsc.service.inter.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by wsc on 17-1-18.
 */
@Service
public class PersonServiceImpl implements IPersonService {
    private static final Logger LOGGER= LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private ITeacherDao iTeacherDao;

    @Autowired
    private IStudentDao iStudentDao;

    @Autowired
    private IManagerDao iManagerDao;

    @Autowired
    private ITheClassDao iTheClassDao;

    private List<Integer> listTeacherId;
    private List<Integer> listStudentId;
    private List<Integer> listTheClassId;

    /*
     * 教师及管理员的人员管理
     */
    @Override
    public boolean createTeacher(Teacher teacher) throws PersonException{
        if(!judgeNull(teacher)){
            listTeacherId=getAllTeacherId();
            if(listTeacherId==null||!listTeacherId.contains(teacher.getTeacherId())){
                iTeacherDao.addTeacher(teacher);
                return true;
            }
            else{
                throw new PersonException("数据库中已经有该数据");
            }
        }
        else{
            throw new PersonException("存储的数据存在空值");
        }
    }

    @Override
    public Teacher updateTeacher(int teacherId, Teacher teacher) {
        Teacher teacherRet=null;
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            teacherRet=queryTeacherByTeacherId(teacherId);
            teacher.setTeacherId(teacherId);
            iTeacherDao.updateTeacher(teacher);
            return teacherRet;
        }
        else{
            throw new PersonNotExistException("数据库中找不到这个人");
        }
    }

    @Override
    public Teacher deleteTeacher(int teacherId) {
        listTeacherId=getAllTeacherId();
        Teacher teacher=queryTeacherByTeacherId(teacherId);
        if(listTeacherId.contains(teacherId)){
            iTeacherDao.deleteTeacher(teacherId);
            return teacher;
        }
        else{
            throw new PersonNotExistException("数据库中找不到这个人");
        }
    }

    @Override
    public List<Teacher> queryTeacherAll() {
        listTeacherId =getAllTeacherId();
        try{
            if(listTeacherId.get(0)!=null){
                return iTeacherDao.queryTeacherList(Collections.min(listTeacherId),Collections.max(listTeacherId));
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            throw new PersonException("数据库中找不到数据");
        }
        return null;
    }

    @Override
    public List<Teacher> queryTeacherByPaperId(int paperId) {
        List<Teacher> teacherList=iTeacherDao.queryTeacherByPaperId(String.valueOf(paperId));
        try{
            if(teacherList.get(0)!=null){
                return teacherList;
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            throw new PersonNotExistException("找不到符合条件的");
        }
        return null;
    }

    @Override
    public List<Teacher> queryTeacherByClassId(int classId) {
        List<Teacher> teacherList=iTeacherDao.queryTeacherByPaperId(String.valueOf(classId));
        try{
            if(teacherList.get(0)!=null){
                return teacherList;
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            throw new PersonNotExistException("找不到符合条件的");
        }
        return null;
    }

    @Override
    public List<Teacher> queryTeacherByTeacherName(String name) {
        List<Teacher> teacherList=iTeacherDao.queryTeacherByTeacherName(name);
        try{
            if(teacherList.get(0)!=null){
                return teacherList;
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            throw new PersonNotExistException("找不到符合条件的");
        }
        return null;
    }

    @Override
    public Teacher queryTeacherByTeacherId(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            return iTeacherDao.queryTeacherById(teacherId);
        }
        else{
            throw new PersonNotExistException("id为"+teacherId+"的数据不存在");
        }
    }

    /*
     * 学生的人员管理
     */
    @Override
    public boolean createStudent(Student student) {
        if(!judgeStudentNull(student)){
            listStudentId=getAllStudentId();
            if(listStudentId==null||!listStudentId.contains(student.getStudentId())){
                iStudentDao.addStudent(student);
                return true;
            }
            else{
                throw new PersonException("数据库student中已经有该数据");
            }
        }
        else{
            throw new PersonException("存储的数据存在空值");
        }
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        Student studentRe=null;
        listStudentId=getAllStudentId();
        if(listStudentId.contains(studentId)){
            studentRe=queryStudentByStudentId(studentId);
            student.setStudentId(studentId);
            iStudentDao.updateStudent(student);
            return studentRe;
        }
        else{
            throw new PersonNotExistException("数据库中找不到这个人");
        }
    }

    @Override
    public Student deleteStudent(int studentId) {
        listStudentId=getAllStudentId();
        Student student=queryStudentByStudentId(studentId);
        if(listStudentId.contains(studentId)){
            iStudentDao.deleteStudent(studentId);
            return student;
        }
        else{
            throw new PersonNotExistException("数据库中找不到这个人");
        }
    }

    @Override
    public List<Student> queryStudentAll() {
        listStudentId =getAllStudentId();
        try{
            if(listStudentId.get(0)!=null){
                return iStudentDao.queryStudentList(Collections.min(listStudentId),Collections.max(listStudentId));
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            throw new PersonException("数据库中找不到数据");
        }
        return null;
    }

    @Override
    public List<Student> queryStudentByPaperId(int paperId) {
        List<Student> studentList=iStudentDao.queryStudentByPaperId(String.valueOf(paperId));
        try{
            if(studentList.get(0)!=null){
                return studentList;
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            throw new PersonNotExistException("找不到符合条件的");
        }
        return null;
    }

    @Override
    public List<Student> queryStudentByClassId(int classId) {
        List<Student> studentList=iStudentDao.queryStudentByTheClassId(classId);
        try{
            if(studentList.get(0)!=null){
                return studentList;
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            throw new PersonNotExistException("找不到符合条件的");
        }
        return null;
    }

    @Override
    public List<Student> queryStudentByStudentName(String name) {
        List<Student> studentList=iStudentDao.queryStudentByStudentName(name);
        try{
            if(studentList.get(0)!=null){
                return studentList;
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            throw new PersonNotExistException("找不到符合条件的");
        }
        return null;
    }

    @Override
    public Student queryStudentByStudentId(int studentId) {
        listStudentId=getAllStudentId();
        if(listStudentId.contains(studentId)){
            return iStudentDao.queryStudent(studentId);
        }
        else{
            throw new PersonNotExistException("找不到这个人");
        }
    }

    /*
    班级管理
     */
    @Override
    public boolean createTheClass(TheClass theClass) {
        listTheClassId=getAllTheClassId();
        if(!listTheClassId.contains(theClass.getTheClassId())){
            iTheClassDao.createTheClass(theClass);
            return true;
        }
        else{
            LOGGER.info("数据库the_class中含有数据the_class_id为"+theClass.getTheClassId()+"的数据");
            throw new PersonException("数据库the_class中含有数据the_class_id为"+theClass.getTheClassId()+"的数据");
        }
    }

    @Override
    public TheClass deleteTheClass(int theClassId) {
        listTheClassId=getAllTheClassId();
        if(listTheClassId.contains(theClassId)){
            TheClass theClassRe=iTheClassDao.queryTheClass(theClassId);
            iTheClassDao.deleteTheClass(theClassId);
            return theClassRe;
        }
        else{
            LOGGER.info("数据库the_class中不含有数据the_class_id为"+theClassId+"的数据");
            throw new PersonException("数据库the_class中不含有数据the_class_id为"+theClassId+"的数据");
        }
    }

    @Override
    public TheClass updateTheClass(TheClass theClass) {
        listTheClassId=getAllTheClassId();
        if(listTheClassId.contains(theClass.getTheClassId())){
            TheClass theClassRe=iTheClassDao.queryTheClass(theClass.getTheClassId());
            iTheClassDao.updateTheClass(theClass);
            return theClassRe;
        }
        else{
            LOGGER.info("数据库the_class中不含有数据the_class_id为"+theClass.getTheClassId()+"的数据");
            throw new PersonException("数据库the_class中不含有数据the_class_id为"+theClass.getTheClassId()+"的数据");
        }
    }

    @Override
    public TheClass queryTheClass(int theClassId) {
        listTheClassId=getAllTheClassId();
        if(listTheClassId.contains(theClassId)){
            return iTheClassDao.queryTheClass(theClassId);
        }
        else{
            LOGGER.info("数据库the_class中不含有数据the_class_id为"+theClassId+"的数据");
            throw new PersonException("数据库the_class中不含有数据the_class_id为"+theClassId+"的数据");
        }
    }

    @Override
    public List<TheClass> queryTheClassList(int fromTheClassId, int toTheClassId) {
        listTheClassId=getAllTheClassId();
        try{
            if(listTheClassId.get(0)!=null){
                return iTheClassDao.queryTheClassList(fromTheClassId,toTheClassId);
            }
        }catch (IndexOutOfBoundsException e){
            LOGGER.info(e.getMessage());
            LOGGER.info("数据库theClass中不含有符合"+fromTheClassId+"到"+toTheClassId+"的数据");
            throw new PersonException("数据库theClass中不含有符合"+fromTheClassId+"到"+toTheClassId+"的数据");
        }
        throw new PersonException("数据库theClass中不含有符合"+fromTheClassId+"到"+toTheClassId+"的数据");
    }


    /*
     * 权限管理
     */
    @Override
    public boolean createPerson(int powerId) {
        Manager manager=iManagerDao.queryManagerByManagerId(powerId);
        try {
            if(manager.getCreateStudent()==1&&manager.getCreateTeacher()==1&&manager.getCreateTheClass()==1){
                return true;
            }
            else{
                return false;
            }
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            throw new ManagerException("找不到所示权限");
        }
    }

    @Override
    public boolean deletePerson(int powerId) {
        Manager manager=iManagerDao.queryManagerByManagerId(powerId);
        try {
            if(manager.getDeleteTeacher()==1&&manager.getDeleteStudent()==1&&manager.getDeleteTheClass()==1){
                return true;
            }
            else{
                return false;
            }
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            throw new ManagerException("找不到所示权限");
        }
    }

    @Override
    public boolean updatePerson(int powerId) {
        Manager manager=iManagerDao.queryManagerByManagerId(powerId);
        try {
            if(manager.getUpdateStudent()==1&&manager.getUpdateTeacher()==1&&manager.getUpdateTheClass()==1){
                return true;
            }
            else{
                return false;
            }
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            throw new ManagerException("找不到所示权限");
        }
    }

    @Override
    public boolean queryPerson(int powerId) {
        Manager manager=iManagerDao.queryManagerByManagerId(powerId);
        try {
            if(manager.getQueryStudent()==1&&manager.getQueryTeacher()==1&&manager.getQueryTheClass()==1){
                return true;
            }
            else{
                return false;
            }
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            throw new ManagerException("找不到所示权限");
        }
    }

    @Override
    public boolean createTestDB(int powerId) {
        Manager manager=iManagerDao.queryManagerByManagerId(powerId);
        try {
            if(manager.getCreateQuestion()==1&&manager.getCreatePaper()==1){
                return true;
            }
            else{
                return false;
            }
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            throw new ManagerException("找不到所示权限");
        }
    }

    @Override
    public boolean deleteTestDB(int powerId) {
        Manager manager=iManagerDao.queryManagerByManagerId(powerId);
        try {
            if(manager.getDeletePaper()==1&&manager.getDeleteQuestion()==1){
                return true;
            }
            else{
                return false;
            }
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            throw new ManagerException("找不到所示权限");
        }
    }

    @Override
    public boolean updateTestDB(int powerId) {
        Manager manager=iManagerDao.queryManagerByManagerId(powerId);
        try {
            if(manager.getUpdatePaper()==1&&manager.getUpdateQuestion()==1){
                return true;
            }
            else{
                return false;
            }
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            throw new ManagerException("找不到所示权限");
        }
    }

    @Override
    public boolean queryTestDB(int powerId) {
        Manager manager=iManagerDao.queryManagerByManagerId(powerId);
        try {
            if(manager.getQueryPaper()==1&&manager.getQueryQuestion()==1){
                return true;
            }
            else{
                return false;
            }
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            throw new ManagerException("找不到所示权限");
        }
    }

    @Override
    public boolean createResult(int powerId) {
        Manager manager=iManagerDao.queryManagerByManagerId(powerId);
        try {
            if(manager.getCreateResult()==1){
                return true;
            }
            else{
                return false;
            }
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            throw new ManagerException("找不到所示权限");
        }
    }

    @Override
    public boolean deleteResult(int powerId) {
        Manager manager=iManagerDao.queryManagerByManagerId(powerId);
        try {
            if(manager.getDeleteResult()==1){
                return true;
            }
            else{
                return false;
            }
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            throw new ManagerException("找不到所示权限");
        }
    }

    @Override
    public boolean updateResult(int powerId) {
        Manager manager=iManagerDao.queryManagerByManagerId(powerId);
        try {
            if(manager.getUpdateResult()==1){
                return true;
            }
            else{
                return false;
            }
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            throw new ManagerException("找不到所示权限");
        }
    }

    @Override
    public boolean queryResult(int powerId) {
        Manager manager=iManagerDao.queryManagerByManagerId(powerId);
        try {
            if(manager.getQueryResult()==1){
                return true;
            }
            else{
                return false;
            }
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            throw new ManagerException("找不到所示权限");
        }
    }

    private List<Integer> getAllTeacherId(){
        return iTeacherDao.queryTeacherIdAll();
    }

    private List<Integer> getAllStudentId(){
        return iStudentDao.queryStudentIdAll();
    }

    private List<Integer> getAllTheClassId(){
        return iTheClassDao.queryTheClassIdAll();
    }


    private boolean judgeNull(Teacher teacher){
        if(teacher.getTeacherName()==null||teacher.getTeacherMail()==null||teacher.getTeacherPassword()==null){
            return true;
        }
        return false;
    }

    private boolean judgeStudentNull(Student student){
        if(student.getStudentName()==null||student.getStudentPassword()==null||student.getStudentMail()==null){
            return true;
        }
        return false;
    }
}
