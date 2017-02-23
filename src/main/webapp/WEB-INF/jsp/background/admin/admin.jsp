<%--
  Created by IntelliJ IDEA.
  User: wsc
  Date: 17-2-2
  Time: 下午8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*"
         contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 启用EL表达式 -->
<%@ page isELIgnored="false"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
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
<body class="easyui-layout">
<!-- 北边区域 -->
<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:20px">考试系统后台管理界面</div>
<!-- 各个模块 -->
<div data-options="region:'west',split:true,title:'导航菜单'" style="width:150px;padding:10px;">
    <!-- 子模块：模板管理 -->
    <div class="easyui-accordion" data-options="fit:true,border:false">

        <div title="人员管理" style="padding:10px;">
            <li><a href="#powerManager" class="easyui-linkbutton" onclick="addTab('权限管理','${pageContext.request.contextPath}/background/admin/powerManager')">权限管理</a></li>
        </div>

        <div title="题库管理" style="padding:10px;">
            <a href="${pageContext.request.contextPath}/background/admin/powerManager" type="_blank">powerManager</a>
        </div>

        <div title="考试管理" style="padding:10px;">
        </div>

        <div title="结果管理" style="padding:10px;">
        </div>

        <div title="系统管理" style="padding:10px;">
        </div>
    </div>
</div>
<%--<!-- 东部区域 -->--%>
<%--<div data-options="region:'east',split:true" style="width:10px;padding:10px;"></div>--%>
<!-- 底部 -->
<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">
    <div id="footer" align="center">Copyright &copy; 2017 考试系统</div>
</div>
<!-- 中央布局 -->
<div data-options="region:'center'"  fit="true" border="false" >
    <div class="easyui-tabs" id="centerTab" fit="true" border="false">
        <div title="欢迎页" style="padding:20px;overflow:hidden;">
            <div style="margin-top:20px;">
                <h3>你好，欢迎来到系统</h3>
                <p>${name}</p>
                <p>${password}</p>
            </div>
        </div>
    </div>
</div>
</body>
</body>
</html>
