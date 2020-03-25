<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>学生管理系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">  
	<script src="${ctx}/js/jquery.min.js"></script>
	<script src="${ctx}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx }/js/timer.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#nowTime").runTimer();
			$("#exit").click(function(){
				parent.location = "${ctx}/logoff";
			})
		})
	</script>
</head>
<body>
	<table width="100%" class="table table-hover">
		<tr>
			
			<td width="200" height="80"><img src="${ctx}/images/logo.png" width="200" height="80"></td>
			
			
			<td>
				<table width="100%" class="table table-hover">
					
					
					<tr>
						<td height="40" align="right">
							<img src="${ctx}/images/home.png">&nbsp;<a href="${ctx}/main" id="index">首页</a>&nbsp;&nbsp;&nbsp;
							<img src="${ctx}/images/no.png">&nbsp;<a href="javascript:void(0);" id="exit">退出</a>&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					
					<tr>
						<td height="40" align="right">
							欢迎：【${sessionScope.user.name}】同学！
							<span id="nowTime"></span>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</td>
</tr>
</table>
</body>
</html>