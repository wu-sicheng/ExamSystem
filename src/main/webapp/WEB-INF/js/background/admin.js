/**
 * Created by wsc on 17-2-22.
 */
var nameSet=[];
var noSet=[];
var emailSet=[];
var phoneSet=[];

/*
* 判断编辑用户以及新建用户的时候的值是否有重复
* */
$(document).ready(function(){
    loadMess();
    var row=$("#dg").datagrid("getSelected");
    //判断教师的名字
    $("#teacherName").keyup(function(e){
        var input=e.target.value;
        console.log(input);
        if(nameSet.indexOf(input)!=-1){
            if(row.teacherName!=input){
                console.log("输入值重复");
            }
        }
    });
    //教师的职工号
    $("#teacherNo").keyup(function(e){
        var input=e.target.value;
        console.log(input);
        if(noSet.indexOf(input)!=-1){
            if(row.teacherNo!=input){
                console.log("输入值重复");
            }
        }
    });
    //教师的邮件
    $("#teacherMail").keyup(function(e){
        var input=e.target.value;
        console.log(input);
        if(emailSet.indexOf(input)!=-1){
            if(row.teacherMail!=input){
                console.log("输入值重复");
            }
        }
    });
    //教师的电话号码
    $("#teacherPhone").keyup(function(e){
        var input=e.target.value;
        console.log(input);
        if(phoneSet.indexOf(input)!=-1){
            if(row.teacherPhone!=input){
                console.log("输入值重复");
            }
        }
    });
});


function addTab(title, url){
    if ($('#centerTab').tabs('exists', title)){
        $('#centerTab').tabs('select', title);
    } else {
        var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
        $('#centerTab').tabs('add',{
            title:title,
            content:content,
            closable:true
        });
    }
}
function addUser(){
    $("#dlg").dialog("open").dialog("setTitle","新建用户");
    $("#fm").form("clear");
}
function editUser(){
    var row = $("#dg").datagrid("getSelected");
    console.log(row.teacherId);
    console.log(row);
    if (row){
        $("#dlg").dialog("open").dialog("setTitle","编辑用户");
        $("#fm").form("load",row);
    }
}
function newUser(){
    var title=$('#dlg').panel('options').title;
    console.log(title);
    if(title=="新建用户"){
        var url=window.location.href;
        var urlTo=url.replace("/background/admin/teacherMess","/person/teacher/create");
        var all={};
        var teacherJSON=JSON.stringify($("#fm").serializeObject());
        var teacher=JSON.parse(teacherJSON);

        teacher.teacherId=1;
        teacher.teacherGander=Number(teacher.teacherGander);
        teacher.roleId=Number(teacher.roleId);

        var addJSON={"teacherState":1,"teacherCreateTime":null,"teacherDeleteTime":null};
        $.extend(all,teacher,addJSON);

        var toServer=JSON.stringify(all);

        console.log(all);
        console.log(JSON.stringify(all));
        console.log(teacherJSON);


        $.ajax({
            type:"POST",
            url:urlTo,
            data:toServer,
            contentType:"application/json",
            dataType:"json",
            success:function(data){
                console.log(data);
                alert("创建用户数据成功");
                $("#dlg").dialog("close");
                $('#dg').datagrid('reload');
            },
            error:function(data){
                console.log("error");
                alert("创建用户失败"+data);
            }
        });
    }
    else if(title=="编辑用户"){
        var row = $("#dg").datagrid("getSelected");
        var url=window.location.href;
        var urlTo=url.replace("/background/admin/teacherMess","/person/teacher/update");
        var all={};
        var teacherJSON=JSON.stringify($("#fm").serializeObject());
        var teacher=JSON.parse(teacherJSON);

        teacher.teacherId=row.teacherId;
        teacher.classId=row.classId;
        teacher.paperId=row.paperId;
        teacher.teacherGander=Number(teacher.teacherGander);
        teacher.roleId=Number(teacher.roleId);

        var addJSON={"teacherState":1,"teacherCreateTime":null,"teacherDeleteTime":null};
        $.extend(all,teacher,addJSON);

        var toServer=JSON.stringify(all);

        console.log(all);
        console.log(JSON.stringify(all));
        console.log(teacherJSON);


        $.ajax({
            type:"PUT",
            url:urlTo,
            data:toServer,
            contentType:"application/json",
            dataType:"json",
            success:function(data){
                console.log(data);
                alert("修改用户数据成功");
                $("#dlg").dialog("close");
                $('#dg').datagrid('reload');
            },
            error:function(data){
                console.log("error");
                alert("修改用户失败"+data);
            }
        });
    }
}

function destroyUser(){
    //第一次调用的url
    //http://localhost:8080/ExamSystem/person/teacher/delete/5
    //第二次调用的url
    //http://localhost:8080/ExamSystem/person/teacher/delete/#5
    //其中的row.teacherId的数据均为 5

    var row = $('#dg').datagrid('getSelected');
    var url=window.location.href;
    var urlTo=url.replace("/background/admin/teacherMess","/person/teacher/delete/").concat(row.teacherId);
    console.log(row.teacherId);
    console.log(urlTo);

    if (row){
        $.messager.confirm('注意','你确定删除该用户吗？',function(r){
            console.log(r);
            if (r){
                alert(r);
                $.ajax({
                   url:urlTo,
                   type:"DELETE",
                    contentType:"application/json",
                    dataType:"json",
                    success:function(data){
                       alert("删除用户成功"+data);
                       $("#dg").datagrid("reload");
                    },
                    error:function(data){
                        alert("删除用户失败"+data);
                    }
                });
            }
        });
    }
}

function addStudent(){
    $("#dlgStudent").dialog("open").dialog("setTitle","新建用户");
    $("#fmStudent").form("clear");
}

function editStudent(){
    var row = $("#dgStudent").datagrid("getSelected");
    console.log(row.studentId);
    console.log(row);
    if (row){
        $("#dlgStudent").dialog("open").dialog("setTitle","编辑用户");
        $("#fmStudent").form("load",row);
    }
}

function newStudent(){
    var title=$('#dlgStudent').panel('options').title;
    console.log(title);
    if(title=="新建用户"){
        var url=window.location.href;
        var urlTo=url.replace("/background/admin/personContro/studentMess","/person/student/create");
        var all={};
        var studentJSON=JSON.stringify($("#fmStudent").serializeObject());
        var student=JSON.parse(studentJSON);

        student.studentId=1;
        student.studentGander=Number(student.studentGander);
        student.roleId=Number(student.roleId);
        student.classId=Number(student.classId);
        student.studentGrader=Number(student.studentGrader);

        var addJSON={"studentState":1,"teacherCreateTime":null,"teacherDeleteTime":null};
        $.extend(all,student,addJSON);

        var toServer=JSON.stringify(all);

        console.log(all);
        console.log(JSON.stringify(all));
        console.log(studentJSON);

        $.ajax({
            type:"POST",
            url:urlTo,
            data:toServer,
            contentType:"application/json",
            dataType:"json",
            success:function(data){
                console.log(data);
                alert("创建用户数据成功");
                $("#dlgStudent").dialog("close");
                $('#dgStudent').datagrid('reload');
            },
            error:function(data){
                console.log("error");
                alert("创建用户失败"+data);
            }
        });
    }
    else if(title=="编辑用户"){
        var row = $("#dgStudent").datagrid("getSelected");
        var url=window.location.href;
        var urlTo=url.replace("/background/admin/personContro/studentMess","/person/student/update");
        var all={};
        var studentJSON=JSON.stringify($("#fmStudent").serializeObject());
        var student=JSON.parse(studentJSON);

        student.studentId=row.studentId;
        student.classId=Number(student.classId);
        student.paperId=Number(student.paperId);
        student.studentGander=Number(student.studentGander);
        student.roleId=Number(student.roleId);
        student.studentGrader=Number(student.studentGrader);


        var addJSON={"studentState":1,"studentCreateTime":null,"studentDeleteTime":null};
        $.extend(all,student,addJSON);

        var toServer=JSON.stringify(all);

        console.log(all);
        console.log(JSON.stringify(all));
        console.log(studentJSON);


        $.ajax({
            type:"PUT",
            url:urlTo,
            data:toServer,
            contentType:"application/json",
            dataType:"json",
            success:function(data){
                console.log(data);
                alert("修改用户数据成功");
                $("#dlgStudent").dialog("close");
                $('#dgStudent').datagrid('reload');
            },
            error:function(data){
                console.log("error");
                alert("修改用户失败"+data);
            }
        });
    }
}

function destroyStudent(){
    var row = $('#dgStudent').datagrid('getSelected');
    var url=window.location.href;
    var urlTo=url.replace("/background/admin/personContro/studentMess","/person/student/delete/").concat(row.studentId);
    console.log(row.studentId);
    console.log(urlTo);

    if (row){
        $.messager.confirm('注意','你确定删除该用户吗？',function(r){
            console.log(r);
            if (r){
                alert(r);
                $.ajax({
                    url:urlTo,
                    type:"DELETE",
                    contentType:"application/json",
                    dataType:"json",
                    success:function(data){
                        alert("删除用户成功"+data);
                        $("#dgStudent").datagrid("reload");
                    },
                    error:function(data){
                        alert("删除用户失败"+data);
                    }
                });
            }
        });
    }
}

function addTheClass(){
    $("#dlgTheClass").dialog("open").dialog("setTitle","新建班级");
    $("#fmTheClass").form("clear");
}

function editTheClass(){
    var row = $("#dgTheClass").datagrid("getSelected");
    console.log(row.theClassId);
    console.log(row);
    if (row){
        $("#dlgTheClass").dialog("open").dialog("setTitle","编辑班级");
        $("#fmTheClass").form("load",row);
    }
}

function destroyTheClass(){
    var row = $('#dgTheClass').datagrid('getSelected');
    var url=window.location.href;
    var urlTo=url.replace("/background/admin/personContro/classMess","/person/class/delete/").concat(row.theClassId);
    console.log(row.theClassId);
    console.log(urlTo);

    if (row){
        $.messager.confirm('注意','你确定删除该班级吗？',function(r){
            console.log(r);
            if (r){
                alert(r);
                $.ajax({
                    url:urlTo,
                    type:"DELETE",
                    contentType:"application/json",
                    dataType:"json",
                    success:function(data){
                        alert("删除班级成功"+data);
                        $("#dgTheClass").datagrid("reload");
                    },
                    error:function(data){
                        alert("删除班级失败"+data);
                    }
                });
            }
        });
    }
}

function newTheClass(){
    var title=$('#dlgTheClass').panel('options').title;
    console.log(title);
    if(title=="新建班级"){
        var url=window.location.href;
        var urlTo=url.replace("/background/admin/personContro/classMess","/person/class/create");
        var all={};
        var theClassJSON=JSON.stringify($("#fmTheClass").serializeObject());
        var theClass=JSON.parse(theClassJSON);

        theClass.theClassId=1;

        var addJSON={"theClassState":1,"theClassCreateTime":null,"theClassDeleteTime":null};
        $.extend(all,theClass,addJSON);

        var toServer=JSON.stringify(all);

        console.log(all);
        console.log(JSON.stringify(all));
        console.log(theClassJSON);


        $.ajax({
            type:"POST",
            url:urlTo,
            data:toServer,
            contentType:"application/json",
            dataType:"json",
            success:function(data){
                console.log(data);
                alert("创建用户数据成功");
                $("#dlgTheClass").dialog("close");
                $('#dgTheClass').datagrid('reload');
            },
            error:function(data){
                console.log("error");
                alert("创建用户失败"+data);
            }
        });
    }
    else if(title=="编辑班级"){
        var row = $("#dgTheClass").datagrid("getSelected");
        var url=window.location.href;
        var urlTo=url.replace("/background/admin/personContro/classMess","/person/class/update");
        var all={};
        var theClassJSON=JSON.stringify($("#fmTheClass").serializeObject());
        var theClass=JSON.parse(theClassJSON);

        theClass.theClassId=row.theClassId;

        var addJSON={"theClassState":1,"theClassCreateTime":null,"theClassDeleteTime":null};
        $.extend(all,theClass,addJSON);

        var toServer=JSON.stringify(all);

        console.log(all);
        console.log(JSON.stringify(all));
        console.log(theClassJSON);


        $.ajax({
            type:"PUT",
            url:urlTo,
            data:toServer,
            contentType:"application/json",
            dataType:"json",
            success:function(data){
                console.log(data);
                alert("修改用户数据成功");
                $("#dlgTheClass").dialog("close");
                $('#dgTheClass').datagrid('reload');
            },
            error:function(data){
                console.log("error");
                alert("修改用户失败"+data);
            }
        });
    }
}


function loadMess(){
    var url=window.location.href;
    var urlTo=url.replace("/background/admin/teacherMess","/person/teacher/list");
    $.ajax({
       url:urlTo,
        type:"GET",
        contentType:"application/json",
        dataType:"json",
        success:function(data){
           console.log(data);
           console.log(JSON.stringify(data));
           $.each(data,function(index,value){
               nameSet.push(value.teacherName);
               noSet.push(value.teacherNo);
               emailSet.push(value.teacherMail);
               phoneSet.push(value.phoneSet);
           });
           console.log("nameSet:"+nameSet+" noSet:"+noSet+" emailSet:"+emailSet+" phoneSet:"+phoneSet);
        },
        error:function(data){
            console.log("error读取失败");
        }
    });
}

$.fn.serializeObject = function(){
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}
