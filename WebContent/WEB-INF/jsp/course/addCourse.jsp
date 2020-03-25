<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">  
	<script src="${ctx}/js/jquery.min.js"></script>
	<script src="${ctx}/js/bootstrap.min.js"></script>
	<title>添加课程</title>
</head>
<body>
	<form action="${ctx}/course/addCourse" method="post" id="addCourse">
		<table class="table table-striped">
			<caption>添加课程</caption>
			<tbody>
				<input type="hidden" name="flag" value="2">
				<tr><td>课程号：<input type="text" name="num"></td></tr>
				<tr><td>课程名称：<input type="text" name="name"></td></tr>
				<tr><td>周次：<input type="text" name="day"></td></tr>
				<tr><td>节次：<input type="text" name="coursetime"></td></tr>
				<tr><td>起始周：<input type="text" name="start"></td></tr>
				<tr><td>结束周：<input type="text" name="last"></td></tr>
				<tr><td>学分:<input type="text" name="credit"></td></tr>
				<tr><td>上课地点：<input type="text" name="place"></td></tr>
				<tr><td><input type="submit" value="添加" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" class="btn btn-primary"></td>	</tr>
			</tbody>
		</form>
	</body>
	</html>

