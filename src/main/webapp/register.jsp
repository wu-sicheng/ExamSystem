<%--
  Created by IntelliJ IDEA.
  User: wsc
  Date: 17-2-13
  Time: 下午8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <div>
        <form id="register" method="post" action="/ExamSystem/register">
            <div id="mail">邮箱<input id="mail_input" name="mail" type="text"/></div>
            <div id="password">密码<input id="password_input" name="password" type="password"/></div>
            <div id="submit"><input id="submit_input" name="submit_input" type="submit" value="提交"/></div>
        </form>
    </div>
    <div>
        <form id="regulation">
            <input id="regulation_yes_no" type="checkbox"/>
        </form>
    </div>
    <div>
        <a href="regulation.jsp">条例</a>
    </div>
</body>
</html>
