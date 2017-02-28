<%--
  Created by IntelliJ IDEA.
  User: wsc
  Date: 17-2-25
  Time: 下午8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>试卷数据</title>
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
            src="${pageContext.request.contextPath}/js/background/testDB.js"></script>
</head>
<body>
<table id="dgPaper" title="试题数据" class="easyui-datagrid" fit="true"
       url="${pageContext.request.contextPath}/test-db/paper/all"
       method="get"
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="paperId" nowrap>编号(唯一)</th>
        <th field="paperName" nowrap>名字(唯一)</th>
        <th field="questionId" nowrap>问题编号</th>
        <th field="subjectId" nowrap>科目编号</th>
        <th field="paperTimeBegin" nowrap>考试开始时间</th>
        <th field="paperTimeEnd" nowrap>考试结束时间</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#addPaper" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addPaper()">新建试卷</a>
    <a href="#editPaper" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editPaper()">编辑试卷</a>
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deletePaper()">删除试卷</a>
</div>
<div id="dlgPaper" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fmPaper" method="post" enctype="application/json">
        <div id="paperName" class="fitem">
            <label>名字(唯一)</label>
            <input name="paperName" class="easyui-validatebox" required="true">
        </div>
        <div id="questionId" class="fitem">
            <label>问题编号</label>
            <input name="questionId" class="easyui-validatebox" required="true">
        </div>
        <div id="subjectId" class="fitem">
            <label>科目编号</label>
            <input name="subjectId" class="easyui-validatebox" required="true">
        </div>
        <div id="paperTimeBegin" class="fitem">
            <label>考试开始时间</label>
            <input name="paperTimeBegin" class="easyui-validatebox" required="true">
        </div>
        <div id="paperTimeEnd" class="fitem">
            <label>考试结束时间</label>
            <input name="paperTimeEnd" class="easyui-validatebox" required="true">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="newPaper()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgQuestion').dialog('close')">取消</a>
</div>
</body>
</html>
