<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">  
	<script src="${ctx}/js/jquery.min.js"></script>
	<script src="${ctx}/js/bootstrap.min.js"></script>
	<title>选课页</title>
</head>
<body>	
	<table class="table table-hover">
		<tr>
			<td>
				<form name="selectCourse" method="post" id="selectCourse" action="${ctx}/course/selectCourse">
					<table class="table table-hover">
						<tr>
							<td class="font3">
								课程号：<input type="text" name="num">
								课程名：<input type="text" name="name">
								<input type="submit" value="搜索"/>
								<input id="delete" type="button" value="删除"/>
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>

		<tr>
			<td>
				<table class="table table-hover">
					<thead>
						<tr class="success" align="center">
							<td><input type="checkbox" name="checkAll" id="checkAll"></td>
							<td>课程号</td>
							<td>课程名</td>
							<td>地点</td>
							<td>周次</td>
							<td>节次</td>
							<td>起始周</td>
							<td>学分</td>
							<td>选课人数</td>
							<td>选课</td>
							<td>退选</td>
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
							<td>${fn:length(course.students)}</td>
							<td align="center"><a href="${ctx}/course/saveCourse?student_id=${sessionScope.user.id}&course_id=${course.id}"><img title="选课" src="${ctx}/images/yes.png"/>选课</a></td>
							<td align="center"><a href="${ctx}/course/deleteCourse?student_id=${sessionScope.user.id}&course_id=${course.id}"><img title="退选" src="${ctx}/images/no.png"/>退选</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</td>
	</tr>
	<!-- 分页标签 -->
	<tr valign="top">
		<td align="center" class="font3">
			<sms:pager
			pageIndex="${requestScope.pageModel.pageIndex}" 
			pageSize="${requestScope.pageModel.pageSize}" 
			recordCount="${requestScope.pageModel.recordCount}" 
			style="digg"
			submitUrl="${ctx}/student/selectStudent?pageIndex={0}"/>
		</td>
	</tr>
</table>
</body>
</html>