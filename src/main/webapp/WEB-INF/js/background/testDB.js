/**
 * Created by wsc on 17-2-25.
 */
function addPaper(){
    $("#dlgPaper").dialog("open").dialog("setTitle","新建试卷");
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
    var row = $('#dgPaper').datagrid('getSelected');
    var url=window.location.href;
    var urlTo=url.replace("/background/admin/testDBContro/paperMess","/test-db/paper/delete/").concat(row.paperId);
    console.log(row.paperId);
    console.log(urlTo);

    if (row){
        $.messager.confirm('注意','你确定删除该试卷吗？',function(r){
            console.log(r);
            if (r){
                alert(r);
                $.ajax({
                    url:urlTo,
                    type:"DELETE",
                    contentType:"application/json",
                    dataType:"json",
                    success:function(data){
                        alert("删除试卷成功"+data);
                        $("#dgPaper").datagrid("reload");
                    },
                    error:function(data){
                        alert("删除试卷失败"+data);
                    }
                });
            }
        });
    }
}

function newPaper(){
    var title=$('#dlgPaper').panel('options').title;
    console.log(title);
    if(title=="新建试卷"){
        var url=window.location.href;
        var urlTo=url.replace("/background/admin/testDBContro/paperMess","/test-db/paper/create");
        var all={};
        var paperJSON=JSON.stringify($("#fmPaper").serializeObject());
        var paper=JSON.parse(paperJSON);

        paper.paperId=1;
        paper.subjectId=Number(paper.subjectId);

        var addJSON={"paperState":1,"createTime":1,"deleteTime":1};
        $.extend(all,paper,addJSON);

        var toServer=JSON.stringify(all);

        console.log(all);
        console.log(JSON.stringify(all));
        console.log(paperJSON);


        $.ajax({
            type:"POST",
            url:urlTo,
            data:toServer,
            contentType:"application/json",
            dataType:"json",
            success:function(data){
                console.log(data);
                alert("创建试卷成功");
                $("#dlgPaper").dialog("close");
                $('#dgPaper').datagrid('reload');
            },
            error:function(data){
                console.log("error");
                alert("创建试卷失败"+data);
            }
        });
    }
    else if(title=="编辑试卷"){
        var row = $("#dgPaper").datagrid("getSelected");
        var url=window.location.href;
        var urlTo=url.replace("/background/admin/testDBContro/paperMess","/test-db/paper/update");
        var all={};
        var paperJSON=JSON.stringify($("#fmPaper").serializeObject());
        var paper=JSON.parse(paperJSON);

        paper.paperId=row.paperId;
        paper.subjectId=Number(paper.subjectId);

        var addJSON={"paperState":1,"createTime":1,"deleteTime":1};
        $.extend(all,paper,addJSON);

        var toServer=JSON.stringify(all);

        console.log(all);
        console.log(JSON.stringify(all));
        console.log(paperJSON);


        $.ajax({
            type:"PUT",
            url:urlTo,
            data:toServer,
            contentType:"application/json",
            dataType:"json",
            success:function(data){
                console.log(data);
                alert("修改试卷数据成功");
                $("#dlgPaper").dialog("close");
                $('#dgPaper').datagrid('reload');
            },
            error:function(data){
                console.log("error");
                alert("修改试卷失败"+data);
            }
        });
    }
}

function addQuestion(){
    $("#dlgQuestion").dialog("open").dialog("setTitle","新建试题");
    $("#fmQuestion").form("clear");
}

function editQuestion(){
    var row = $("#dgQuestion").datagrid("getSelected");
    console.log(row.questionId);
    console.log(row);
    if (row){
        $("#dlgQuestion").dialog("open").dialog("setTitle","编辑试题");
        $("#fmQuestion").form("load",row);
    }
}
window.global = {
    host: 'ddada',
    urlcongif: {
        "/test-db/question/delete/": "/test-db/question/delete/"
    }
}
function deleteQuestion(){
    var row = $('#dgQuestion').datagrid('getSelected');
    var url=window.location.href;
    console.log(url)
    var urlTo=url.replace("/background/admin/testDBContro/questionMess","/test-db/question/delete/").concat(row.questionId);

    console.log(row.questionId);
    console.log(urlTo);

    if (row){
        $.messager.confirm('注意','你确定删除该试题吗？',function(r){
            console.log(r);
            if (r){
                alert(r);
                $.ajax({
                    url:urlTo,
                    type:"DELETE",
                    contentType:"application/json",
                    dataType:"json",
                    success:function(data){
                        alert("删除试题成功"+data);
                        $("#dgQuestion").datagrid("reload");
                    },
                    error:function(data){
                        alert("删除试题失败"+data);
                    }
                });
            }
        });
    }
}

function newQuestion(){
    var title=$('#dlgQuestion').panel('options').title;
    console.log(title);
    if(title=="新建试题"){
        var url=window.location.href;
        var urlTo=url.replace("/background/admin/testDBContro/questionMess","/test-db/question/create");
        var all={};
        var questionJSON=JSON.stringify($("#fmQuestion").serializeObject());
        var question=JSON.parse(questionJSON);

        question.questionId=1;
        question.subjectId=Number(question.subjectId);

        var addJSON={"questionState":1,"questionCreateTime":1,"questionDeleteTime":1};
        $.extend(all,question,addJSON);

        var toServer=JSON.stringify(all);

        console.log(all);
        console.log(JSON.stringify(all));
        console.log(questionJSON);


        $.ajax({
            type:"POST",
            url:urlTo,
            data:toServer,
            contentType:"application/json",
            dataType:"json",
            success:function(data){
                console.log(data);
                alert("创建试题成功");
                $("#dlgQuestion").dialog("close");
                $('#dgQuestion').datagrid('reload');
            },
            error:function(data){
                console.log("error");
                alert("创建试题失败"+data);
            }
        });
    }
    else if(title=="编辑试题"){
        var row = $("#dgQuestion").datagrid("getSelected");
        var url=window.location.href;

        var urlTo=url.replace("/background/admin/testDBContro/questionMess","/test-db/question/update");
        var all={};
        var questionJSON=JSON.stringify($("#fmQuestion").serializeObject());
        var question=JSON.parse(questionJSON);

        question.questionId=row.questionId;
        question.subjectId=Number(question.subjectId);

        var addJSON={"questionState":1,"questionCreateTime":1,"questionDeleteTime":1};
        $.extend(all,question,addJSON);

        var toServer=JSON.stringify(all);

        console.log(all);
        console.log(JSON.stringify(all));
        console.log(questionJSON);


        $.ajax({
            type:"PUT",
            url:urlTo,
            data:toServer,
            contentType:"application/json",
            dataType:"json",
            success:function(data){
                console.log(data);
                alert("修改试题数据成功");
                $("#dlgQuestion").dialog("close");
                $('#dgQuestion').datagrid('reload');
            },
            error:function(data){
                console.log("error");
                alert("修改试题失败"+data);
            }
        });
    }
}

function addSubject(){
    $("#dlgSubject").dialog("open").dialog("setTitle","新建科目");
    $("#fmSubject").form("clear");
}

function editSubject(){
    var row = $("#dgStudent").datagrid("getSelected");
    console.log(row.subjectId);
    console.log(row);
    if (row){
        $("#dlgSubject").dialog("open").dialog("setTitle","编辑科目");
        $("#fmSubject").form("load",row);
    }
}

function deleteSubject(){
    var row = $('#dgSubject').datagrid('getSelected');
    var url=window.location.href;
    console.log(url)
    var urlTo=url.replace("/background/admin/testDBContro/subjectMess","/test-db/subject/delete/").concat(row.subjectId);

    console.log(row.subjectId);
    console.log(urlTo);

    if (row){
        $.messager.confirm('注意','你确定删除该科目吗？',function(r){
            console.log(r);
            if (r){
                alert(r);
                $.ajax({
                    url:urlTo,
                    type:"DELETE",
                    contentType:"application/json",
                    dataType:"json",
                    success:function(data){
                        alert("删除科目成功"+data);
                        $("#dgQuestion").datagrid("reload");
                    },
                    error:function(data){
                        alert("删除科目失败"+data);
                    }
                });
            }
        });
    }
}

function newSubject(){

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