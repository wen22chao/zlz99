<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>测试复选框和输入框提交数据</title>
</head>
<body>
	<form method="get" action="handle_form3.do">
	<div>第1种商品</div>
	<div>
		<input type="checkbox" name="goods" value="100010" />
		<input type="text" name="num" value="3" />
	</div>
	<hr />
	<div>第2种商品</div>
	<div>
		<input type="checkbox" name="goods" value="100011" />
		<input type="text" name="num" value="" />
	</div>
	<hr />
	<div>第3种商品</div>
	<div>
		<input type="checkbox" name="goods" value="100012" />
		<input type="text" name="num" value="" />
	</div>
	<input type="submit" value="提交" />
	</form>
</body>
</html>  