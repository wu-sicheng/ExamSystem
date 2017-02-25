/**
 * Created by wsc on 17-2-22.
 */
var nameSet=[];
var noSet=[];
var emailSet=[];
var phoneSet=[];

$(document).ready(function(){
    loadMess();
    var row=$("#dg").datagrid("getSelected");
    $("#teacherName").keyup(function(e){
        var input=e.target.value;
        console.log(input);
        //
        if(nameSet.indexOf(input)!=-1||row.teacherName==input){
            console.log("输入值重复");
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
