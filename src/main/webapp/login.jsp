<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<head>
    <title>登录界面</title>
    <script type="application/javascript">
        function is_null() {
            var account = document.getElementById("account").value;
            var password = document.getElementById("password").value;
            if (account == null || account == "" || password == null || password == "") {
                alert("请输入账号或密码");
                return false;
            }
        }
    </script>
    <style>
        .form-bg {
            background: #00b4ef;
        }

        .form-horizontal {
            background: #fff;
            padding-bottom: 40px;
            border-radius: 15px;
            text-align: center;
        }

        .form-horizontal .heading {
            display: block;
            font-size: 35px;
            font-weight: 700;
            padding: 35px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 30px;
        }

        .form-horizontal .form-group {
            padding: 0 40px;
            margin: 0 0 25px 0;
            position: relative;
        }

        .form-horizontal .form-control {
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            transition: all 0.3s ease 0s;
        }

        .form-horizontal .form-control:focus {
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }

        .form-horizontal .form-group i {
            position: absolute;
            top: 12px;
            left: 60px;
            font-size: 17px;
            color: #c8c8c8;
            transition: all 0.5s ease 0s;
        }

        .form-horizontal .form-control:focus + i {
            color: #00b4ef;
        }

        .form-horizontal .fa-question-circle {
            display: inline-block;
            position: absolute;
            top: 12px;
            right: 60px;
            font-size: 20px;
            color: #808080;
            transition: all 0.5s ease 0s;
        }

        .form-horizontal .fa-question-circle:hover {
            color: #000;
        }

        .form-horizontal .main-checkbox {
            float: left;
            width: 20px;
            height: 20px;
            background: #11a3fc;
            border-radius: 50%;
            position: relative;
            margin: 5px 0 0 5px;
            border: 1px solid #11a3fc;
        }

        .form-horizontal .main-checkbox label {
            width: 20px;
            height: 20px;
            position: absolute;
            top: 0;
            left: 0;
            cursor: pointer;
        }

        .form-horizontal .main-checkbox label:after {
            content: "";
            width: 10px;
            height: 5px;
            position: absolute;
            top: 5px;
            left: 4px;
            border: 3px solid #fff;
            border-top: none;
            border-right: none;
            background: transparent;
            opacity: 0;
            -webkit-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }

        .form-horizontal .main-checkbox input[type=checkbox] {
            visibility: hidden;
        }

        .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after {
            opacity: 1;
        }

        .form-horizontal .text {
            float: left;
            margin-left: 7px;
            line-height: 20px;
            padding-top: 5px;
            text-transform: capitalize;
        }

        .form-horizontal .btn {
            float: right;
            font-size: 14px;
            color: #fff;
            background: #00b4ef;
            border-radius: 30px;
            padding: 10px 25px;
            border: none;
            text-transform: capitalize;
            transition: all 0.5s ease 0s;
        }

        @media only screen and (max-width: 479px) {
            .form-horizontal .form-group {
                padding: 0 25px;
            }

            .form-horizontal .form-group i {
                left: 45px;
            }

            .form-horizontal .btn {
                padding: 10px 20px;
            }
        }
    </style>
</head>
<body>
<%--        <h2>Login Information</h2>
        <form method="POST" action="/ExamSystem/login" onsubmit="return is_null()">
            <table>
                <tr>
                    <td>账号：</td>
                    <td><input id="account" name="account" value="test@qq.com"/></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input id="password" name="password" type="password" value="123456"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" class="btn btn-primary" value="登录"/>
                    </td>
                </tr>
            </table>
            <br/>
            <input id="student_id" type="radio" name="role" value="student"/>学生
            <input id="teacher_id" type="radio" name="role" value="teacher"/>教师
            <input id="page_id" type="radio" name="role" value="admin" checked="checked"/>后台
            <input id="guest_id" type="radio" name="role" value="guest"/>游客
        </form>
        <a href="register.jsp">没有账号,立即注册</a>--%>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" method="POST" action="/ExamSystem/login" onsubmit="return is_null()">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="text" id="account" name="account" value="test@qq.com" class="form-control"
                           placeholder="用户名/手机号码/电子邮件">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input id="password" name="password" type="password" class="form-control" value="123456"
                           placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>

                <input id="student_id" type="radio" name="role" value="student" checked="checked"/>学生
                <input id="teacher_id" type="radio" name="role" value="teacher"/>教师
                <input id="page_id" type="radio" name="role" value="admin" />后台
                <input id="guest_id" type="radio" name="role" value="guest"/>游客

                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">记住我</span>
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </form>
            <br/>
            <a href="register.jsp">没有账号,立即注册</a>
            <a href="forgetPassword.jsp">忘记密码</a>
        </div>
    </div>
</div>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/jQuery/jquery-3.1.1.min.js"></script>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>