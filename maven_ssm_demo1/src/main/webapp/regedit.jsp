<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
</head>
<body>
<h2>注册页面</h2>
<form action="/maven_ssm_demo1/user/regedit.do" method="post">
账号：<input type="text" name="name" placeholder="账号"><br />
密码：<input type="password" name="password" placeholder="密码"><br>
<input type="submit" value="注册">
<input type="reset" value="重置">
</form>
<br>
<a href="login.jsp">登录</a>
<a href="showall.jsp">所有用户</a>
</body>
</html>