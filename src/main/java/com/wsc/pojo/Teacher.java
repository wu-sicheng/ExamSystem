package com.wsc.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by wsc on 17-1-13.
 */
@XmlRootElement(name="teacher")
@XmlAccessorType(XmlAccessType.FIELD)
public class Teacher {
    @XmlElement
    private int teacherId=-1;
    @XmlElement
    private String classId="";
    @XmlElement
    private String paperId="";
    @XmlElement
    private String teacherName="";
    private String teacherDisplayName="";
    @XmlElement
    private String teacherPassword;
    @XmlElement
    private int teacherGander=-1;
    @XmlElement
    private String teacherNo="";
    @XmlElement
    private String teacherMail;
    @XmlElement
    private String teacherPhone="";
    @XmlElement
    private int teacherState=-1;
    @XmlElement
    private int roleId=-1;
    @XmlElement
    private Date teacherCreateTime;
    @XmlElement
    private Date teacherDeleteTime;

    public Teacher() {
    }

    public Teacher(int teacherId, String classId, String paperId, String teacherName,String teacherDisplayName,String teacherPassword, int teacherGander, String teacherNo, String teacherMail, String teacherPhone, int teacherState, int roleId, Date teacherCreateTime, Date teacherDeleteTime) {
        this.teacherId = teacherId;
        this.classId = classId;
        this.paperId = paperId;
        this.teacherName = teacherName;
        this.teacherDisplayName=teacherDisplayName;
        this.teacherPassword = teacherPassword;
        this.teacherGander = teacherGander;
        this.teacherNo = teacherNo;
        this.teacherMail = teacherMail;
        this.teacherPhone = teacherPhone;
        this.teacherState = teacherState;
        this.roleId = roleId;
        this.teacherCreateTime = teacherCreateTime;
        this.teacherDeleteTime = teacherDeleteTime;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherDisplayName() {
        return teacherDisplayName;
    }

    public void setTeacherDisplayName(String teacherDisplayName) {
        this.teacherDisplayName = teacherDisplayName;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public int getTeacherGander() {
        return teacherGander;
    }

    public void setTeacherGander(int teacherGander) {
        this.teacherGander = teacherGander;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherMail() {
        return teacherMail;
    }

    public void setTeacherMail(String teacherMail) {
        this.teacherMail = teacherMail;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public int getTeacherState() {
        return teacherState;
    }

    public void setTeacherState(int teacherState) {
        this.teacherState = teacherState;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Date getTeacherCreateTime() {
        return teacherCreateTime;
    }

    public void setTeacherCreateTime(Date teacherCreateTime) {
        this.teacherCreateTime = teacherCreateTime;
    }

    public Date getTeacherDeleteTime() {
        return teacherDeleteTime;
    }

    public void setTeacherDeleteTime(Date teacherDeleteTime) {
        this.teacherDeleteTime = teacherDeleteTime;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", classId='" + classId + '\'' +
                ", paperId='" + paperId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherDisplayName='" + teacherDisplayName + '\'' +
                ", teacherPassword=*******'" + '\'' +
                ", teacherGander=" + teacherGander +
                ", teacherNo='" + teacherNo + '\'' +
                ", teacherMail='" + teacherMail + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", teacherState=" + teacherState +
                ", roleId=" + roleId +
                ", teacherCreateTime=" + teacherCreateTime +
                ", teacherDeleteTime=" + teacherDeleteTime +
                '}';
    }
}
