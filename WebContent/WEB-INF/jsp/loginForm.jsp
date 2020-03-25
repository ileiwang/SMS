<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript">
	function validate(f)
	{
		if(!(/^\w{5,15}$/.test(f.num.value)))
		{
			alert("学号需要5-15位字符！");
			f.num.focus();
			return false;
		}
		if(!(/^\w{5,15}$/.test(f.password.value)))
		{
			alert("密码需要5-15位字符！");
			f.password.focus();
			return false;
		}
		return true;
	}
</script>
<script>
	$(document).ready(function(){
		$('[data-toggle="tooltip"]').tooltip();   
	});
</script>
</head>
<body>
	<center>
		<button type="button" class="btn btn-primary btn-lg btn-block">用户登录</button>
		<br>
		<br>
		<form action="login" method="post" onsubmit="return validate(this)" class="form-horizontal" role="form">
	
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">学号</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="num" 
				   placeholder="请输入学号" name="num">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">密码</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="password" 
				   placeholder="请输入密码" name="password">
		</div>
	</div>

		<a data-toggle="tooltip" data-placement="bottom" title="忘记密码？" href="findPass.jsp">忘记密码?</a><br>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label>
					<input id="rempass" type="checkbox" checked> 记住密码
				</label>
			</div>
		</div>
	</div>


			<p3>用户类型</p3><br>
			<select name="type" id="type" class="form-control">
				<option value="student">学生</option>
				<option value="admin">管理员</option>
			</select> 
			<br>
			<br>
			<input type="submit" class="btn btn-default" name="登录" value="登录">
			<input type="reset" class="btn btn-default" name="重置" value="重置">
		</form>
	</center>

</body>
</html>