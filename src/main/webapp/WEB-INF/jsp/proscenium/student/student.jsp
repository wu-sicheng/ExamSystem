<%--
  Created by IntelliJ IDEA.
  User: wsc
  Date: 17-2-15
  Time: 下午5:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生界面</title>
</head>
<body>
<p>学生界面</p>
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
            <div class="carousel slide" id="carousel-211086">
                <ol class="carousel-indicators">
                    <li class="active" data-slide-to="0" data-target="#carousel-211086">
                    </li>
                    <li data-slide-to="1" data-target="#carousel-211086">
                    </li>
                    <li data-slide-to="2" data-target="#carousel-211086">
                    </li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">
                        <img alt="" src="img/picture1.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                第一张图片
                            </h4>
                            <p>
                                第一张图片的简介
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="img/picture2.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                第二张图片
                            </h4>
                            <p>
                                第二张图片简介
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="img/picture3.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                第三张图片
                            </h4>
                            <p>
                                第三张图片简介
                            </p>
                        </div>
                    </div>
                </div>
                <a class="left carousel-control" href="#carousel-211086" data-slide="prev"><span
                        class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control"
                                                                                href="#carousel-211086"
                                                                                data-slide="next"><span
                    class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
        </div>
    </div>

    <div class="jumbotron well">

    </div>

    <div class="row clearfix">
        <div class="col-md-4 column">
            <h2>
                试题练习
            </h2>
            <p>
                有丰富的练习，可以了解各个知识点
            </p>
            <p>
                <a class="btn" href="#">开始练习 »</a>
            </p>
        </div>
        <div class="col-md-4 column">
            <h2>
                在线考试
            </h2>
            <p>
                考试了，考试了
            </p>
            <p>
                <a class="btn" href="#">开始考试 »</a>
            </p>
        </div>
        <div class="col-md-4 column">
            <h2>
                结果查询
            </h2>
            <p>
                考得如何，查一查
            </p>
            <p>
                <a class="btn" href="#">查询结果 »</a>
            </p>
        </div>
    </div>
    <div class="jumbotron well">

    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
            <h2>
                科目一考试
            </h2>
            <p>
                就是学车考试，只是一个例子
            </p>
            <p>
                <a class="btn" href="#">开始考试 »</a>
            </p>
        </div>
        <div class="col-md-4 column">
            <h2>
                公务员考试
            </h2>
            <p>
                就是公务员考试，一个例子
            </p>
            <p>
                <a class="btn" href="#">开始考试 »</a>
            </p>
        </div>
        <div class="col-md-4 column">
            <h2>
                医学考试
            </h2>
            <p>
                一个医学考试的例子
            </p>
            <p>
                <a class="btn" href="#">开始考试 »</a>
            </p>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <p>

            </p>
        </div>
    </div>
</div>



<script type="text/javascript"
        src="${pageContext.request.contextPath}/jQuery/jquery-3.1.1.min.js"></script>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
