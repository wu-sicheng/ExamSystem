<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>

<h2>Student Information</h2>
<form:form method="POST" action="/ExamSystem/addMess">
    <table>
        <tr>
            <td><form:label path="teacherName">名字：</form:label></td>
            <td><form:input path="teacherName" /></td>
        </tr>
        <tr>
            <td><form:label path="teacherPassword">年龄：</form:label></td>
            <td><form:input path="teacherPassword" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交表单"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>