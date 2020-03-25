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
	<title>添加成绩</title>
</head>
<body>
	<form action="${ctx}/score/addScore" method="post" id="addScore">
		<input type="hidden" name="flag" value="2">
		<table class="table table-hover">
			<thead>
				<tr>
					<td><center>添加成绩</center></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>成绩：<input type="text" name="score"></td>
				</tr>
				<tr>
					<td>学号：<input type="text" name="student_num"></td>
				</tr>
				<tr>
					<td>课程：
						<select  name="course_id"">
							<option value="0">--课程选择--</option>
							<c:forEach items="${requestScope.courses }" var="course">
							<option value="${course.id }">${course.name }</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="添加"><input type="reset" value="重置"></td>
				</tr>
				<tbody>
				</form>
			</body>
			</html>