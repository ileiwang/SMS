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
	<title>${sessionScope.user.name}的成绩</title>
</head>
<body>

	<table class="table table-hover">
		<tr>
			<td>
				<form name="selectStudent" method="post" id="selectStudent" action="${ctx}/student/selectStudent">
					学号：<input type="text" name="num">&nbsp;&nbsp;&nbsp;
					姓名：<input type="text" name="name">&nbsp;&nbsp;&nbsp;
					<input type="submit" value="搜索"/>&nbsp;&nbsp;&nbsp;
					<input id="delete" type="button" value="删除"/>
				</form>
			</td>
		</tr>

		<tr>
			<td>
				<table class="table table-hover">
					<tr class="success" align="center">
						<td><input type="checkbox" name="checkAll" id="checkAll"></td>
						<td>科目</td>
						<td>分数</td>
						<td align="center">操作</td>
					</tr>
					<c:forEach items="${requestScope.scores}" var="score" varStatus="stat">
					<tr id="data_${stat.index}" align="center">
						<td><input type="checkbox" id="box_${stat.index}" value="${student.id}"></td>
						<td>${score.course.name }</td>
						<td>${score.score}</td>
						<td align="center" >
							<a href="${ctx}/student/updateStudent?flag=1&id=${student.id}">
								<img title="修改" src="${ctx}/images/update.png"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</td>
	</tr>

	<tr>
		<td align="center">
			<sms:pager
			pageIndex="${requestScope.pageModel.pageIndex}" 
			pageSize="${requestScope.pageModel.pageSize}" 
			recordCount="${requestScope.pageModel.recordCount}" 
			style="digg"
			submitUrl="${ctx}/student/selectScore?pageIndex={0}"/>
		</td>
	</tr>
</table>
</body>
</html>

