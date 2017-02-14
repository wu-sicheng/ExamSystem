<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>登录界面</title>
</head>
<body>

<h2>Login Information</h2>
<form method="POST" action="/ExamSystem/login">
  <table>
    <tr>
      <td>账号：</td>
      <td><input name="teacherName" /></td>
    </tr>
    <tr>
      <td>密码：</td>
      <td><input name="teacherPassword" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="提交"/>
      </td>
    </tr>
  </table>
  <br/>
  <input type="checkbox" name="student" value="学生"/>学生
  <input type="checkbox" name="teacher" value="教师"/>教师
  <input type="checkbox" name="admin" value="后台"/>后台
  <input type="checkbox" name="guest" value="游客"/>游客
</form>
<a href="register.jsp">没有账号,立即注册</a>
</body>
</html>