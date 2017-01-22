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
import com.wsc.service.inter.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by wsc on 17-1-18.
 */
@Service
public class PersonServiceImpl implements IPersonService {

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

    /**
     * 教师及管理员的人员管理
     *
     * @param teacher
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

    /**
     * 学生的人员管理
     *
     * @param student
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

    /**
     * 教师及管理员的权限管理
     *
     * @param teacherId
     */
    @Override
    public boolean createPerson(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            int teacherPower=iTeacherDao.queryTeacherPower(teacherId);
            Manager manager=iManagerDao.queryManagerByManagerId(teacherPower);
            if(manager.getCreateStudent()==1&&manager.getCreateTeacher()==1&&manager.getCreateTheClass()==1){
                return true;
            }
            else{
                return false;
            }
        }
        throw new ManagerException("找不到所示的权限");
    }

    @Override
    public boolean deletePerson(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            int teacherPower=iTeacherDao.queryTeacherPower(teacherId);
            Manager manager=iManagerDao.queryManagerByManagerId(teacherPower);
            if(manager.getDeleteTeacher()==1&&manager.getDeleteStudent()==1&&manager.getDeleteTheClass()==1){
                return true;
            }
            else{
                return false;
            }
        }
        throw new ManagerException("找不到所示的权限");
    }

    @Override
    public boolean updatePerson(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            int teacherPower=iTeacherDao.queryTeacherPower(teacherId);
            Manager manager=iManagerDao.queryManagerByManagerId(teacherPower);
            if(manager.getUpdateStudent()==1&&manager.getUpdateTeacher()==1&&manager.getUpdateTheClass()==1){
                return true;
            }
            else{
                return false;
            }
        }
        throw new ManagerException("找不到所示的权限");
    }

    @Override
    public boolean queryPerson(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            int teacherPower=iTeacherDao.queryTeacherPower(teacherId);
            Manager manager=iManagerDao.queryManagerByManagerId(teacherPower);
            if(manager.getQueryStudent()==1&&manager.getQueryTeacher()==1&&manager.getQueryTheClass()==1){
                return true;
            }
            else{
                return false;
            }
        }
        throw new ManagerException("找不到所示的权限");
    }

    @Override
    public boolean createTestDB(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            int teacherPower=iTeacherDao.queryTeacherPower(teacherId);
            Manager manager=iManagerDao.queryManagerByManagerId(teacherPower);
            if(manager.getCreateQuestion()==1&&manager.getCreatePaper()==1){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            throw new ManagerException("找不到所示的权限");
        }
    }

    @Override
    public boolean deleteTestDB(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            int teacherPower=iTeacherDao.queryTeacherPower(teacherId);
            Manager manager=iManagerDao.queryManagerByManagerId(teacherPower);
            if(manager.getDeletePaper()==1&&manager.getDeleteQuestion()==1){
                return true;
            }
            else{
                return false;
            }
        }
        throw new ManagerException("找不到所示的权限");
    }

    @Override
    public boolean updateTestDB(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            int teacherPower=iTeacherDao.queryTeacherPower(teacherId);
            Manager manager=iManagerDao.queryManagerByManagerId(teacherPower);
            if(manager.getUpdatePaper()==1&&manager.getUpdateQuestion()==1){
                return true;
            }
            else{
                return false;
            }
        }
        throw new ManagerException("找不到所示的权限");
    }

    @Override
    public boolean queryTestDB(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            int teacherPower=iTeacherDao.queryTeacherPower(teacherId);
            Manager manager=iManagerDao.queryManagerByManagerId(teacherPower);
            if(manager.getQueryPaper()==1&&manager.getQueryQuestion()==1){
                return true;
            }
            else{
                return false;
            }
        }
        throw new ManagerException("找不到所示的权限");
    }

    @Override
    public boolean createResult(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            int teacherPower=iTeacherDao.queryTeacherPower(teacherId);
            Manager manager=iManagerDao.queryManagerByManagerId(teacherPower);
            if(manager.getCreateResult()==1){
                return true;
            }
            else{
                return false;
            }
        }
        throw new ManagerException("找不到所示的权限");
    }

    @Override
    public boolean deleteResult(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            int teacherPower=iTeacherDao.queryTeacherPower(teacherId);
            Manager manager=iManagerDao.queryManagerByManagerId(teacherPower);
            if(manager.getDeleteResult()==1){
                return true;
            }
            else{
                return false;
            }
        }
        throw new ManagerException("找不到所示的权限");
    }

    @Override
    public boolean updateResult(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            int teacherPower=iTeacherDao.queryTeacherPower(teacherId);
            Manager manager=iManagerDao.queryManagerByManagerId(teacherPower);
            if(manager.getUpdateResult()==1){
                return true;
            }
            else{
                return false;
            }
        }
        throw new ManagerException("找不到所示的权限");
    }

    @Override
    public boolean queryResult(int teacherId) {
        listTeacherId=getAllTeacherId();
        if(listTeacherId.contains(teacherId)){
            int teacherPower=iTeacherDao.queryTeacherPower(teacherId);
            Manager manager=iManagerDao.queryManagerByManagerId(teacherPower);
            if(manager.getQueryResult()==1){
                return true;
            }
            else{
                return false;
            }
        }
        throw new ManagerException("找不到所示的权限");
    }

    private List<Integer> getAllTeacherId(){
        return iTeacherDao.queryTeacherIdAll();
    }

    private List<Integer> getAllStudentId(){
        return iStudentDao.queryStudentIdAll();
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