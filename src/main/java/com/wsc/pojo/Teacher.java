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
    private int teacherId;
    @XmlElement
    private String classId;
    @XmlElement
    private String paperId;
    @XmlElement
    private String teacherName;
    @XmlElement
    private String teacherPassword;
    @XmlElement
    private int teacherGander;
    @XmlElement
    private String teacherNo;
    @XmlElement
    private String teacherMail;
    @XmlElement
    private String teacherPhone;
    @XmlElement
    private int teacherState;
    @XmlElement
    private int teacherPower;
    @XmlElement
    private Date teacherCreateTime;
    @XmlElement
    private Date teacherDeleteTime;

    public Teacher() {
    }

    public Teacher(int teacherId, String classId, String paperId, String teacherName, String teacherPassword, int teacherGander, String teacherNo, String teacherMail, String teacherPhone, int teacherState, int teacherPower, Date teacherCreateTime, Date teacherDeleteTime) {
        this.teacherId = teacherId;
        this.classId = classId;
        this.paperId = paperId;
        this.teacherName = teacherName;
        this.teacherPassword = teacherPassword;
        this.teacherGander = teacherGander;
        this.teacherNo = teacherNo;
        this.teacherMail = teacherMail;
        this.teacherPhone = teacherPhone;
        this.teacherState = teacherState;
        this.teacherPower = teacherPower;
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

    public int getTeacherPower() {
        return teacherPower;
    }

    public void setTeacherPower(int teacherPower) {
        this.teacherPower = teacherPower;
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
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherGander=" + teacherGander +
                ", teacherNo='" + teacherNo + '\'' +
                ", teacherMail='" + teacherMail + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", teacherState=" + teacherState +
                ", teacherPower=" + teacherPower +
                ", teacherCreateTime=" + teacherCreateTime +
                ", teacherDeleteTime=" + teacherDeleteTime +
                '}';
    }
}
