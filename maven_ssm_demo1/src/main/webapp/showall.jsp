<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<!-- <script type="text/javascript">
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
		url:"showAll.do",
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
			alert("fail");
			}
		});
}
});

</script>
<title>show all</title>
</head>
<body>
<button id="showAll">show all</button><br />
<table id="tbl" align="center">
 
        <caption>User Account Information</caption>
 
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