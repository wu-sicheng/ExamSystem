/**
 * Created by wsc on 17-2-25.
 */
function addPaper(){
    $("#dlgPaper").dialog("open").dialog("setTitle","新建用户");
    $("#fmPaper").form("clear");
}

function editPaper(){
    var row = $("#dgPaper").datagrid("getSelected");
    console.log(row.paperId);
    console.log(row);
    if (row){
        $("#dlgPaper").dialog("open").dialog("setTitle","编辑试卷");
        $("#fmPaper").form("load",row);
    }
}

function deletePaper(){

}

function newPaper(){
    var title=$('#dlgPaper').panel('options').title;
    console.log(title);
    if(title=="新建试卷"){
        var url=window.location.href;

        /**
         * ttp://localhost:8080/ExamSystem/background/admin/testDBContro/paperMess
         */
        var urlTo=url.replace("/background/admin/testDBContro/paperMess","/test-db/paper/create");
        var all={};
        var paperJSON=JSON.stringify($("#fmPaper").serializeObject());
        var paper=JSON.parse(paperJSON);

        paper.paperId=1;
        paper.subjectId=Number(paper.subjectId);

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