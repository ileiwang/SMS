<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>添加管理员</title>
</head>
<body>
	<center>
		<form action="${ctx}/admin/addAdmin" method="post" id="addAdmin">
			<input type="hidden" name="flag" value="2">
			管理员号：<input type="text" name="num"><br>
			姓名：<input type="text" name="name"><br>
			生日：<input type="text" name="birthday"><br>
			身份证：<input type="text" name="idcard"><br>
			性别：<select name="sex"><br>
				<option value="男">男</option>
				<option value="女">女</option>
			</select>
			密码：<input type="text" name="password"><br>
			电话：<input type="text" name="tel"><br>
			QQ:<input type="text" name="qq"><br>
			Email:<input type="text" name="email"><br>
			地址：<input type="text" name="address"><br>
			<input type="submit" value="添加"><input type="reset" value="重置">

		</form>

	</center>
</body>
</html>

