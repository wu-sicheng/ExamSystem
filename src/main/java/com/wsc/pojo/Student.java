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
    private int roleId;
    private int studentState;
    private Date studentCreateTime;
    private Date studentDeleteTime;

    public Student() {
    }

    public Student(int studentId, int classId, String paperId, String studentName, String studentPassword, int studentGander, String studentNo, String studentMajor, int studentGrader, String studentNum, String studentMail, String studentPhone, int roleId, int studentState, Date studentCreateTime, Date studentDeleteTime) {
        this.studentId = studentId;
        this.classId = classId;
        this.paperId = paperId;
        this.studentName = studentName;
        this.studentPassword = studentPassword;
        this.studentGander = studentGander;
        this.studentNo = studentNo;
        this.studentMajor = studentMajor;
        this.studentGrader = studentGrader;
        this.studentNum = studentNum;
        this.studentMail = studentMail;
        this.studentPhone = studentPhone;
        this.roleId = roleId;
        this.studentState = studentState;
        this.studentCreateTime = studentCreateTime;
        this.studentDeleteTime = studentDeleteTime;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public int getStudentGander() {
        return studentGander;
    }

    public void setStudentGander(int studentGander) {
        this.studentGander = studentGander;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public int getStudentGrader() {
        return studentGrader;
    }

    public void setStudentGrader(int studentGrader) {
        this.studentGrader = studentGrader;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentMail() {
        return studentMail;
    }

    public void setStudentMail(String studentMail) {
        this.studentMail = studentMail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStudentState() {
        return studentState;
    }

    public void setStudentState(int studentState) {
        this.studentState = studentState;
    }

    public Date getStudentCreateTime() {
        return studentCreateTime;
    }

    public void setStudentCreateTime(Date studentCreateTime) {
        this.studentCreateTime = studentCreateTime;
    }

    public Date getStudentDeleteTime() {
        return studentDeleteTime;
    }

    public void setStudentDeleteTime(Date studentDeleteTime) {
        this.studentDeleteTime = studentDeleteTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", classId=" + classId +
                ", paperId='" + paperId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", studentGander=" + studentGander +
                ", studentNo='" + studentNo + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentGrader=" + studentGrader +
                ", studentNum='" + studentNum + '\'' +
                ", studentMail='" + studentMail + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", roleId=" + roleId +
                ", studentState=" + studentState +
                ", studentCreateTime=" + studentCreateTime +
                ", studentDeleteTime=" + studentDeleteTime +
                '}';
    }
}
