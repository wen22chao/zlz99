<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>测试在控制器层获取多项数据</title>
</head>
<body>
	<form action="get_user_list.do" method="POST">
	<div>请输入第1个用户的用户名：</div>
	<div><input type="text" name="username" /></div>
	<div>请输入第1个用户的密码：</div>
	<div><input type="text" name="password" /></div>
	<hr />
	<div>请输入第2个用户的用户名：</div>
	<div><input type="text" name="username" /></div>
	<div>请输入第2个用户的密码：</div>
	<div><input type="text" name="password" /></div>
	<hr />
	<div>请输入第3个用户的用户名：</div>
	<div><input type="text" name="username" /></div>
	<div>请输入第3个用户的密码：</div>
	<div><input type="text" name="password" /></div>
	<hr />
	<div>请输入第4个用户的用户名：</div>
	<div><input type="text" name="username" /></div>
	<div>请输入第4个用户的密码：</div>
	<div><input type="text" name="password" /></div>
	<hr />
	<input type="submit" value="提交" />
	</form>
</body>
</html>  