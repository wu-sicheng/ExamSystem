<%--
  Created by IntelliJ IDEA.
  User: wsc
  Date: 17-2-22
  Time: 下午3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>权限管理</title>
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
<table id="dg" title="人员" class="easyui-datagrid" fit="true"
       url="${pageContext.request.contextPath}/person/teacher/list"
       method="get"
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="teacherId" nowrap>编号(唯一)</th>
        <th field="teacherName" nowrap>名字(唯一)</th>
        <th field="teacherDisplayName" nowrap>网名</th>
        <th field="teacherPassword" nowrap>密码</th>
        <th field="teacherGander" nowrap>性别</th>
        <th field="teacherNo" nowrap>职工号(唯一)</th>
        <th field="teacherMail" nowrap>邮箱(唯一)</th>
        <th field="teacherPhone" nowrap>电话(唯一)</th>
        <th field="roleId" nowrap>权限</th>
        <th field="classId" nowrap>班级编号</th>
        <th field="paperId" nowrap>试卷编号</th>
        <th field="roleId" nowrap>权限</th>
        <th field="teacherCreateTime" nowrap>创建时间</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dlg').dialog('open')">新建用户</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
</div>
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">新建用户</div>
    <form id="fm" method="post" enctype="application/json">
        <div class="fitem" display="none">
            <label>编号(唯一)</label>
            <input name="teacherId" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>名字(唯一)</label>
            <input name="teacherName" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>网名</label>
            <input name="teacherDisplayName" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>密码(md5加密)</label>
            <input name="teacherPassword" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>性别</label>
            <input name="teacherGander" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>职工号(唯一)</label>
            <input name="teacherNo" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>邮箱(唯一)</label>
            <input name="teacherMail" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>电话(唯一)</label>
            <input name="teacherPhone" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>权限</label>
            <input name="roldId" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>班级编号</label>
            <input name="classId" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>试卷编号</label>
            <input name="paperId" class="easyui-validatebox" required="true">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="newUser()">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>
</body>
</html>
