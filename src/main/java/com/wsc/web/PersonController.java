package com.wsc.web;

import com.wsc.pojo.Student;
import com.wsc.pojo.Teacher;
import com.wsc.pojo.TheClass;
import com.wsc.service.inter.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.List;

/**
 * Created by wsc on 17-1-30.
 * 人员管理接口
 */
@RequestMapping("/person")
@Controller
public class PersonController {

    @Autowired
    private IPersonService iPersonService;

    @RequestMapping(value = "/teacher/{id}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public @ResponseBody Teacher getTeacherById(@PathVariable int id){
        Teacher teacher=iPersonService.queryTeacherByTeacherId(id);
        return teacher;
    }

    @RequestMapping(value = "/teacher/list",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Teacher> getTeacher(){
        List<Teacher> list=iPersonService.queryTeacherAll();
        return list;
    }

    /*
     * 教师及管理员的人员管理
     */
    @RequestMapping(value = "/teacher/create",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher createTeacher(@RequestBody Teacher teacher){
        iPersonService.createTeacher(teacher);
        return teacher;
    }

    @RequestMapping(value = "/teacher/update",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher updateTeacher(@RequestBody Teacher teacher){
        Teacher teacherRe=iPersonService.queryTeacherByTeacherId(teacher.getTeacherId());
        iPersonService.updateTeacher(teacher.getTeacherId(),teacher);
        return teacherRe;
    }

    @RequestMapping(value = "teacher/delete/{teacherId}",method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher deleteTeacher(@PathVariable int teacherId){
        Teacher teacherRe=iPersonService.queryTeacherByTeacherId(teacherId);
        iPersonService.deleteTeacher(teacherId);
        return teacherRe;
    }

    @RequestMapping(value = "teacher/paper-id/{paperId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Teacher> queryTeacherByPaperId(@PathVariable int paperId){
        return iPersonService.queryTeacherByPaperId(paperId);
    }

    @RequestMapping(value = "teacher/class-id/{classId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Teacher> queryTeacherByClassId(@PathVariable int classId){
        return iPersonService.queryTeacherByClassId(classId);
    }

    @RequestMapping(value = "teacher/teacher-name/{name}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Teacher> queryTeacherByTeacherName(@PathVariable String name){
        return iPersonService.queryTeacherByTeacherName(name);
    }

    @RequestMapping(value = "student/create",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Student createStudent(@RequestBody Student student){
        iPersonService.createStudent(student);
        return student;
    }

    @RequestMapping(value = "student/update",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Student updateStudent(@RequestBody Student student){
        Student studentRe=iPersonService.queryStudentByStudentId(student.getStudentId());
        iPersonService.updateStudent(student.getStudentId(),student);
        return studentRe;
    }

    //TODO
    @RequestMapping(value = "student/delete/{studentId}",method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Student deleteStudent(@PathVariable int studentId){
        Student student=iPersonService.deleteStudent(studentId);
        return student;
    }

    @RequestMapping(value = "student/list",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Student> queryStudentAll(){
        return iPersonService.queryStudentAll();
    }

    @RequestMapping(value = "student/paper-id/{paperId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Student> queryStudentByPaperId(@PathVariable int paperId){
        return iPersonService.queryStudentByPaperId(paperId);
    }

    @RequestMapping(value = "student/class-id/{classId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Student> queryStudentByClassId(@PathVariable int classId){
        return iPersonService.queryStudentByClassId(classId);
    }

    @RequestMapping(value = "student/student-name/{name}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Student> queryStudentByStudentName(@PathVariable String name){
        return iPersonService.queryStudentByStudentName(name);
    }

    @RequestMapping(value = "student/{studentId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Student queryStudentByStudentId(@PathVariable int studentId){
        return iPersonService.queryStudentByStudentId(studentId);
    }

    @RequestMapping(value = "class/create",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    TheClass createTheClass(@RequestBody TheClass theClass){
        iPersonService.createTheClass(theClass);
        return theClass;
    }

    @RequestMapping(value = "class/delete/{theClassId}",method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    @ResponseBody
    TheClass deleteTheClass(@PathVariable int theClassId){
        TheClass theClassRe=iPersonService.queryTheClass(theClassId);
        iPersonService.deleteTheClass(theClassId);
        return theClassRe;
    }

    @RequestMapping(value = "class/update",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    @ResponseBody
    TheClass updateTheClass(@RequestBody TheClass theClass){
        TheClass theClassRe=iPersonService.queryTheClass(theClass.getTheClassId());
        iPersonService.updateTheClass(theClass);
        return theClassRe;
    }

    @RequestMapping(value = "class/{theClassId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    TheClass queryTheClass(@PathVariable int theClassId){
        return iPersonService.queryTheClass(theClassId);
    }

    @RequestMapping(value = "class/list",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    List<TheClass> queryTheClassList(){
        return iPersonService.queryTheClassListAll();
    }
}
