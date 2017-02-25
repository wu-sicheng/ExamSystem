<%--
  Created by IntelliJ IDEA.
  User: wsc
  Date: 17-2-25
  Time: 下午4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>班级信息</title>
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
<p>班级信息</p>
<table id="dgTheClass" title="人员" class="easyui-datagrid" fit="true"
       url="${pageContext.request.contextPath}/person/class/list"
       method="get"
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="theClassId" nowrap>编号(唯一)</th>
        <th field="theClassName" nowrap>名字(唯一)</th>
        <th field="theClassCreateTime" nowrap>创建时间</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addTheClass()">新建班级</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editTheClass()">编辑班级</a>
    <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyTheClass()">删除班级</a>
</div>
<div id="dlgTheClass" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fmTheClass" method="post" enctype="application/json">
        <div id="theClassName" class="fitem">
            <label>名字(唯一)</label>
            <input name="theClassName" class="easyui-validatebox" required="true">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="newTheClass()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgTheClass').dialog('close')">取消</a>
</div>
</body>
</html>
