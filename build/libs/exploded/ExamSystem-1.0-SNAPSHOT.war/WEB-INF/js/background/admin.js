/**
 * Created by wsc on 17-2-22.
 */
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
function newUser(){
    var url=window.location.href;
    var urlTo=url.replace("/background/admin/powerManager","/person/teacher/create");
    var teacherJSON=JSON.stringify($("#fm").serializeObject());
    var addJSON={"teacherState":1,"teacherCreateTime":null,"teacherDeleteTime":null};
    $.extend(teacherJSON,addJSON);
    console.log(teacherJSONcd);


/*    console.log(teacher);
    console.log(teacher.serialize()+"&teacherState=1&teacherCreateTime=null&teacherDeleteTime=null");
    console.log(JSON.stringify(teacher.serializeObject()));*/

/*    $.ajax({
        type:"POST",
        url:urlTo,
        data:$("#fm").serialize(),
        contentType:"application/json",
        dataType:"json",
        success:function(data){
            console.log(data);
        },
        error:function(data){
            console.log("error");
        }
    });*/
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