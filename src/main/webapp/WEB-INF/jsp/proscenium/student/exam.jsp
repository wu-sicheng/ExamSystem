<%--
  Created by IntelliJ IDEA.
  User: wsc
  Date: 17-2-27
  Time: 下午7:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试界面</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1"><span
                            class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                            class="icon-bar"></span><span class="icon-bar"></span></button>
                    <a class="navbar-brand" href="#">考试系统</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#">首页</a>
                        </li>
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/proscenium/student/practise">试题练习</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/proscenium/student/exam">在线考试</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/proscenium/student/result">结果查询</a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="${pageContext.request.contextPath}/proscenium/student/examNotify">通知</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">个人中心<strong
                                    class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/proscenium/student/personalZone">我的主页</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/proscenium/student/settings">设置</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/proscenium/student/logout">退出</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
            <hr/>
            <br/> <br/> <br/> <br/> <br/> <br/> <br/>
            <div class="row clearfix">
                <div class="col-md-8 column">
                    <div class="progress">
                        <div class="progress-bar progress-success">
                        </div>
                    </div>
                </div>
                <div class="col-md-4 column">
                    <p>
                        倒计时
                    </p>
                </div>
            </div>
            <hr/>
            <h3>
                题目类型
            </h3>
            <hr/>
            <h3>
                题干
            </h3>
            <hr/>
            <ul>
                <li>
                    选项A
                </li>
                <li>
                    选项B
                </li>
                <li>
                    选项C
                </li>
                <li>
                    选项D
                </li>
            </ul>
        </div>
    </div>
    <hr/>
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column" style="float:right">
            <button type="button" class="btn btn-default">提交按钮</button>
            <button type="button" class="btn btn-default">下一题按钮</button>
        </div>
    </div>
    <hr/>
    <div class="row clearfix" style="wirth:fit">
        题目编号
        <div class="col-md-12 column">

            <ul class="pagination">
                <%-- <li>
                     <a href="#">Prev</a>
                </li> --%>
                <li>
                    <a href="#">1</a>
                </li>
                <li>
                    <a href="#">2</a>
                </li>
                <li>
                    <a href="#">3</a>
                </li>
                <li>
                    <a href="#">4</a>
                </li>
                <li>
                    <a href="#">5</a>
                </li>
                <%--
                          <li>
                             <a href="#">Next</a>
                          </li> --%>
            </ul>
        </div>
    </div>
    <hr/>
    <div class="row clearfix">
        <div class="col-md-12 column">
            一些开发者等相关的信息
        </div>
    </div>
</div>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/jQuery/jquery-3.1.1.min.js"></script>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
