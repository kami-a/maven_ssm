<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<!-- 检测jQuery是否引入
<script type="text/javascript">
if(typeof jQuery == 'undefined'){
	window.alert("没有jquery");
}else{
	window.alert("you");
}
</script> -->
<script type="text/javascript">
$(document).ready(function(){
document.getElementById("showAll").onclick=function(){
	/* window.alert("dianjile"); */
	 $.ajax({
		type:"POST",
		url:"/maven_ssm_demo1/user/showAll.do",
		dataType:"json",
		data:{},
		success:function(returnMsg){
			
			for (var i = 0; i < returnMsg.length; i++) {
		        var tr;
		        //注意这里[tr=]不要写成[tr+=]
		        tr = "<td>"+returnMsg[i]['id']+"</td>";
		        tr += "<td>"+returnMsg[i]['name']+"</td>";
		        tr += "<td>"+returnMsg[i]['password']+"</td>";
		        tr += "<td>"+returnMsg[i]['sex']+"</td>";
		        tr += "<td>"+returnMsg[i]['tel']+"</td>";
		        //将语句拼接到<table>中显示
		        $("#tbl").append("<tr>"+tr+"</tr>");
			}
			},
		error:function(){
			alert("请登录后重试");
			}
		});
}
});

</script>
<title>所有用户</title>
</head>
<body>
<button id="showAll">展示所有用户信息</button><br>
<a href="login.jsp">登录</a>
<a href="regedit.jsp">注册</a><br>
<table id="tbl" align="center">
 
        <caption>用户信息表</caption>
 
          <tr>
            <th>ID</th>
            <th>UserName</th>
            <th>PassWord</th>
            <th>Sex</th>
            <th>Tel</th>
          </tr>
 
      </table>
</body>
</html>