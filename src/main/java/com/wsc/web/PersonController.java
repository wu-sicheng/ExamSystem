package com.wsc.web;

import com.wsc.pojo.Student;
import com.wsc.pojo.Teacher;
import com.wsc.pojo.TheClass;
import com.wsc.service.inter.IPersonService;
import com.wsc.util.Encryption;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by wsc on 17-1-30.
 * 人员管理接口
 */
@RequestMapping("/person")
@Controller
public class PersonController {

    @Autowired
    private IPersonService iPersonService;

    /*
     * 教师及管理员的人员管理
     */

    @RequiresRoles(value ={"teacher","admin","student"},logical = Logical.OR)
    @RequestMapping(value = "/teacher/{id}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher getTeacherById(@PathVariable int id){
        Teacher teacher=iPersonService.queryTeacherByTeacherId(id);
        return teacher;
    }

    @RequiresRoles(value ={"teacher","admin","student"},logical = Logical.OR)
    @RequestMapping(value = "/teacher/list",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Set<Teacher> getTeacherList(){
        Set<Teacher> list=iPersonService.queryTeacherAll();
        return list;
    }

/*    @RequiresRoles(value ={"teacher","admin"},logical = Logical.OR)*/
    @RequestMapping(value = "/teacher/create",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher createTeacher(@RequestBody Teacher teacher){
        teacher.setTeacherPassword(Encryption.md5En(teacher.getTeacherPassword()));
        iPersonService.createTeacher(teacher);
        return teacher;
    }

    @RequiresRoles(value ={"teacher","admin"},logical = Logical.OR)
    @RequestMapping(value = "/teacher/update",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher updateTeacher(@RequestBody Teacher teacher){
        Teacher teacherRe=iPersonService.queryTeacherByTeacherId(teacher.getTeacherId());
        if(teacherRe.getTeacherPassword().equals(teacher.getTeacherPassword())){
            teacher.setTeacherPassword(teacherRe.getTeacherPassword());
        }
        else{
            teacher.setTeacherPassword(Encryption.md5En(teacher.getTeacherPassword()));
        }
        iPersonService.updateTeacher(teacher.getTeacherId(),teacher);
        return teacherRe;
    }

    @RequiresRoles(value ={"admin"})
    @RequestMapping(value = "teacher/delete/{teacherId}",method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher deleteTeacher(@PathVariable int teacherId){
        Teacher teacherRe=iPersonService.queryTeacherByTeacherId(teacherId);
        iPersonService.deleteTeacherByTeacherId(teacherId);
        return teacherRe;
    }

    @RequiresRoles(value ={"teacher","admin","student"},logical = Logical.OR)
    @RequestMapping(value = "teacher/paper-id/{paperId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Set<Teacher> queryTeacherByPaperId(@PathVariable int paperId){
        return iPersonService.queryTeacherByPaperId(paperId);
    }

    @RequiresRoles(value ={"teacher","admin","student"},logical = Logical.OR)
    @RequestMapping(value = "teacher/class-id/{classId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Set<Teacher> queryTeacherByClassId(@PathVariable int classId){
        return iPersonService.queryTeacherByClassId(classId);
    }

    @RequiresRoles(value ={"teacher","admin","student"},logical = Logical.OR)
    @RequestMapping(value = "teacher/teacher-name/{name}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher queryTeacherByTeacherName(@PathVariable String name){
        return iPersonService.queryTeacherByTeacherName(name);
    }

    @RequiresRoles(value ={"teacher","admin","student"},logical = Logical.OR)
    @RequestMapping(value = "student/create",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Student createStudent(@RequestBody Student student){
        iPersonService.createStudent(student);
        return student;
    }

    @RequiresRoles(value ={"teacher","admin","student"},logical = Logical.OR)
    @RequestMapping(value = "student/update",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Student updateStudent(@RequestBody Student student){
        Student studentRe=iPersonService.queryStudentByStudentId(student.getStudentId());
        iPersonService.updateStudent(student.getStudentId(),student);
        return studentRe;
    }

    //TODO
    @RequiresRoles(value ={"admin"})
    @RequestMapping(value = "student/delete/{studentId}",method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Student deleteStudent(@PathVariable int studentId){
        Student student=iPersonService.deleteStudent(studentId);
        return student;
    }

    @RequiresRoles(value ={"teacher","admin","student"},logical = Logical.OR)
    @RequestMapping(value = "student/list",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Set<Student> queryStudentAll(){
        return iPersonService.queryStudentAll();
    }

    @RequiresRoles(value ={"teacher","admin","student"},logical = Logical.OR)
    @RequestMapping(value = "student/paper-id/{paperId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Set<Student> queryStudentByPaperId(@PathVariable int paperId){
        return iPersonService.queryStudentByPaperId(paperId);
    }

    @RequiresRoles(value ={"teacher","admin","student"},logical = Logical.OR)
    @RequestMapping(value = "student/class-id/{classId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Set<Student> queryStudentByClassId(@PathVariable int classId){
        return iPersonService.queryStudentByClassId(classId);
    }

    @RequiresRoles(value ={"teacher","admin","student"},logical = Logical.OR)
    @RequestMapping(value = "student/student-name/{name}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Student queryStudentByStudentName(@PathVariable String name){
        return iPersonService.queryStudentByStudentName(name);
    }

    @RequiresRoles(value = {"teacher","student","admin"},logical = Logical.OR)
    @RequestMapping(value = "student/{studentId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Student queryStudentByStudentId(@PathVariable int studentId){
        return iPersonService.queryStudentByStudentId(studentId);
    }

    @RequiresRoles("admin")
    @RequestMapping(value = "class/create",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    TheClass createTheClass(@RequestBody TheClass theClass){
        iPersonService.createTheClass(theClass);
        return theClass;
    }

    @RequiresRoles("admin")
    @RequestMapping(value = "class/delete/{theClassId}",method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    @ResponseBody
    TheClass deleteTheClass(@PathVariable int theClassId){
        TheClass theClassRe=iPersonService.queryTheClass(theClassId);
        iPersonService.deleteTheClass(theClassId);
        return theClassRe;
    }

    @RequiresRoles("admin")
    @RequestMapping(value = "class/update",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    @ResponseBody
    TheClass updateTheClass(@RequestBody TheClass theClass){
        TheClass theClassRe=iPersonService.queryTheClass(theClass.getTheClassId());
        iPersonService.updateTheClass(theClass);
        return theClassRe;
    }

    @RequiresRoles(value = {"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "class/{theClassId}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    TheClass queryTheClass(@PathVariable int theClassId){
        return iPersonService.queryTheClass(theClassId);
    }

    @RequiresRoles(value = {"admin","teacher","student"},logical = Logical.OR)
    @RequestMapping(value = "class/list",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    List<TheClass> queryTheClassList(){
        return iPersonService.queryTheClassListAll();
    }
}
