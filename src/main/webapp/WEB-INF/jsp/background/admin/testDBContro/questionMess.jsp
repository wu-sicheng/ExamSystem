<%--
  Created by IntelliJ IDEA.
  User: wsc
  Date: 17-2-25
  Time: 下午8:56
  To change this template use File | Settings | File Templates.
--%>
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
    <title>试题数据</title>
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
<table id="dgQuestion" title="试题数据" class="easyui-datagrid" fit="true"
       url="${pageContext.request.contextPath}/test-db/question/all"
       method="get"
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="questionId" nowrap>编号(唯一)</th>
        <th field="questionTitle" nowrap>名字(唯一)</th>
        <th field="questionText" nowrap>问题题干</th>
        <th field="questionAnswer" nowrap>问题选项</th>
        <th field="questionRight" nowrap>问题正确答案</th>
        <th field="questionScore" nowrap>分数</th>
        <th field="questionType" nowrap>问题类型</th>
        <th field="subjectId" nowrap>所属科目编号</th>
        <th field="questionCreateTime" nowrap>创建时间</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#addPaper" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addQuestion()">新建题目</a>
    <a href="#editPaper" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editQuestion()">编辑题目</a>
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteQuestion()">删除题目</a>
</div>
<div id="dlgQuestion" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fmQuestion" method="post" enctype="application/json">
        <div id="questionTitle" class="fitem">
            <label>名字(唯一)</label>
            <input name="questionTitle" class="easyui-validatebox" required="true">
        </div>
        <div id="questionText" class="fitem">
            <label>问题题干</label>
            <input name="questionText" class="easyui-validatebox" required="true">
        </div>
        <div id="questionAnswer" class="fitem">
            <label>问题选项</label>
            <input name="questionAnswer" class="easyui-validatebox" required="true">
        </div>
        <div id="questionRight" class="fitem">
            <label>问题答案</label>
            <input name="questionRight" class="easyui-validatebox" required="true">
        </div>
        <div id="questionScore" class="fitem">
            <label>分数</label>
            <input name="questionScore" class="easyui-validatebox" required="true">
        </div>
        <div id="questionType" class="fitem">
            <label>类型</label>
            <input name="questionType" class="easyui-validatebox" required="true">
        </div>
        <div id="subjectId" class="fitem">
            <label>所属科目</label>
            <input name="subjectId" class="easyui-validatebox" required="true">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="newQuestion()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgQuestion').dialog('close')">取消</a>
</div>
</body>
</html>

