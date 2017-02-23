<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>登录界面</title>
  <script type="application/javascript">
    function is_null(){
        var account=document.getElementById("account").value;
        var password=document.getElementById("password").value;
        if(account==null||account==""||password==null||password==""){
            alert("请输入账号或密码");
            return false;
        }
    }
  </script>
</head>
<body>

<h2>Login Information</h2>
<form method="POST" action="/ExamSystem/login" onsubmit="return is_null()">
  <table>
    <tr>
      <td>账号：</td>
      <td><input id="account" name="account" value="test@qq.com"/></td>
    </tr>
    <tr>
      <td>密码：</td>
      <td><input id="password" name="password" type="password" value="123456"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="提交"/>
      </td>
    </tr>
  </table>
  <br/>
  <input id="student_id" type="radio" name="role" value="student" />学生
  <input id="teacher_id" type="radio" name="role" value="teacher"/>教师
  <input id="page_id" type="radio" name="role" value="admin" checked="checked"/>后台
  <input id="guest_id" type="radio" name="role" value="guest"/>游客
</form>
<a href="register.jsp">没有账号,立即注册</a>
</body>
</html>
</html>