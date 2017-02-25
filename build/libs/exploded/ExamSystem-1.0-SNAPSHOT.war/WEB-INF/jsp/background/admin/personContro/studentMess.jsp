<%--
  Created by IntelliJ IDEA.
  User: wsc
  Date: 17-2-25
  Time: 下午4:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>学生信息</title>
    <!--导入easy_ui相关数据-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/easy_ui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/easy_ui/themes/icon.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/easy_ui/demo/demo.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/easy_ui/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/easy_ui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/easy_ui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/easy_ui/themes/default/easyui.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/background/admin.js"></script>
</head>
<body>
<p>学生信息</p>
<table id="dgStudent" title="人员" class="easyui-datagrid" fit="true"
       url="${pageContext.request.contextPath}/person/student/list"
       method="get"
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>

<%--        "studentId": 2,
        "classId": 2,
        "paperId": "2,3",
        "studentName": "wusic",
        "studentDisplayName": "",
        "studentPassword": "password",
        "studentGander": 1,
        "studentNo": "studentNo",
        "studentMajor": "major",
        "studentGrader": 2,
        "studentNum": "num",
        "studentMail": "mail@mail.com",
        "studentPhone": "18826222446",
        "roleId": 1,
    "studentState": 1,
        "studentCreateTime": 1454392800000,
    "studentDeleteTime": 1486059141000--%>

    <tr>
        <th field="studentId" nowrap>编号(唯一)</th>
        <th field="studentName" nowrap>名字(唯一)</th>
        <th field="studentDisplayName" nowrap>网名</th>
        <th field="studentPassword" nowrap>密码</th>
        <th field="studentGander" nowrap>性别</th>
        <th field="studentNo" nowrap>学号(唯一)</th>
        <th field="studentMail" nowrap>邮箱(唯一)</th>
        <th field="studentPhone" nowrap>电话(唯一)</th>
        <th field="studentMajor" nowrap>专业</th>
        <th field="studentGrader" nowrap>年级</th>
        <th field="studentNum" nowrap>准考证号(唯一)</th>
        <th field="roleId" nowrap>权限</th>
        <th field="classId" nowrap onclick="addTab('班级数据','${pageContext.request.contextPath}/background/admin/personContro/teacherClassMess')">班级编号</th>
        <th field="paperId" nowrap onclick="javascript:alert('点击');">试卷编号</th>
        <th field="studentCreateTime" nowrap>创建时间</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addUser()">新建用户</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a>
    <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除用户</a>
    <button onclick="loadMess()">点击</button>
</div>
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post" enctype="application/json">
        <div id="teacherName" class="fitem">
            <label>名字(唯一)</label>
            <input name="teacherName" class="easyui-validatebox" required="true">
        </div>
        <div id="teacherDisplay" class="fitem">
            <label>网名</label>
            <input name="teacherDisplayName" class="easyui-validatebox" required="true">
        </div>
        <div id="teacherPassword" class="fitem">
            <label>密码(md5加密)</label>
            <input name="teacherPassword" class="easyui-validatebox" required="true">
        </div>
        <div id="teacherGander" class="fitem">
            <label>性别</label>
            <input name="teacherGander" class="easyui-validatebox" required="true">
        </div>
        <div id="teacherNo" class="fitem">
            <label>职工号(唯一)</label>
            <input name="teacherNo" class="easyui-validatebox" required="true">
        </div>
        <div id="teacherMail" class="fitem">
            <label>邮箱(唯一)</label>
            <input name="teacherMail" class="easyui-validatebox" required="true">
        </div>
        <div id="teacherPhone" class="fitem">
            <label>电话(唯一)</label>
            <input name="teacherPhone" class="easyui-validatebox" required="true">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="newUser()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
</body>
</html>
