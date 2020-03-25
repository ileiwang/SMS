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
	<title>我的课程表</title>
</head>
<body>
	<center><h1>课程表</h1></center>
	<table class="table table-hover">
		<thead>
			<tr align="center" class="success">
				<td><input type="checkbox" name="checkAll" id="checkAll"></td>
				<td>课程号</td>
				<td>课程名</td>
				<td>地点</td>
				<td>周次</td>
				<td>节次</td>
				<td>起始周</td>
				<td>学分</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.courses}" var="course" varStatus="stat">
			<tr id="data_${stat.index}" align="center">
				<td><input type="checkbox" id="box_${stat.index}" value="${student.id}"></td>
				<td>${course.num}</td>
				<td>${course.name }</td>
				<td>${course.place}</td>
				<td>${course.day}</td>
				<td>${course.coursetime}</td>
				<td>${course.start}周-${course.last}周</td>
				<td>${course.credit}</td>
			</tr>
		</c:forEach>
		<tbody>
		</table>
	</body>
	</html>

