<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
</head>
<body>
<h2>登录页面</h2>
<form action="/maven_ssm_demo1/user/login.do" method="post">
账号：<input type="text" name="name" placeholder="账号"><br />
密码：<input type="password" name="password" placeholder="密码"><br>
<input type="submit" value="登录">
<input type="reset" value="重置">
</form>
<br>
<a href="regedit.jsp">注册</a>
<a href="showall.jsp">所有用户</a>
</body>
</html>
