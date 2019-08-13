<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>测试下拉菜单</title>
<script type="text/javascript" 
	src="../js/jquery.min.js"></script>
</head>
<body>

<select id="provinces" style="width: 120px;">
	<option value="0">----- 请选择 -----</option>
	<c:forEach items="${provinces }" var="p">
	<option value="${p.code }">${p.name }</option>
	</c:forEach>
</select>

<select id="cities" style="width: 120px;">
	<option value="0">----- 请选择 -----</option>
</select>

<select id="areas" style="width: 120px;">
	<option value="0">----- 请选择 -----</option>
</select>

<script type="text/javascript">
$("#provinces").change(function() {
	// 默认选项
	var defaultOption = "<option value=\"0\">----- 请选择 -----</option>";
	// 获取当前选中的省的代号
	var provinceCode = $("#provinces").val();
	// 判断代号是否有效，即选中的是不是“请选择”
	if (provinceCode == 0) {
		// 把“市”、“区”列表还原为默认状态
		$("#cities").html(defaultOption);
		$("#areas").html(defaultOption);
		return;
	}
	
	// 提交并处理ajax请求	
	$.ajax({
		"url": "../city/list.do",
		"data": "provinceCode=" + provinceCode,
		"type": "GET",
		"dataType": "json",
		"success": function(obj) {
			// 省变了，先把“市”列表还原为默认状态
			$("#cities").html(defaultOption);
			// 把“区”列表还原为默认状态
			$("#areas").html(defaultOption);
			
			// 获取响应数据中的列表数据
			var list = obj.data;
			// 遍历列表数据
			for(var i=0; i < list.length; i++) {
				// 得到列表项
				var opt = "<option value=\"" + list[i].code + "\">" + list[i].name + "</option>";
				// 将列表项添加到下拉列表中
				$("#cities").append(opt);
			}
		}
	});
});

$("#cities").change(function() {
	// 获取当前选中的“市”的代号
	var cityCode = $("#cities").val();
	// 判断代码是否有效
	if (cityCode == 0) {
		// 默认选项
		var defaultOption = "<option value=\"0\">----- 请选择 -----</option>";
		// “市”变成了“请选择”，把“区”列表还原为默认状态
		$("#areas").html(defaultOption);
		return;
	}
	// 确定提交到的网址
	var url = "../area/list.do";
	// 确定请求参数
	var data = "cityCode=" + cityCode;
	// 提交并处理ajax请求
	$.ajax({
		"url": url,
		"data": data,
		"type": "GET",
		"dataType": "json",
		"success": function(obj) {
			// 先清空“区”列表
			$("#areas").empty();
			// 获取响应数据中的列表数据
			var list = obj.data;
			// 处理响应的列表数据
			for (var i = 0; i < list.length; i++) {
				// 生成每一个列表项
				var opt = "<option value=\"" + list[i].code + "\">" + list[i].name + "</option>";
				// 将列表项添加到整个列表中
				$("#areas").append(opt);
			}
		}
	});
});
</script>

<pre>
	第1步：
		请求路径：/test/address.do，
		控制器接收到请求后，获取所有省的信息，
		然后将这些信息转发到/web/test.jsp
	第2步：
		在test.jsp中，通过jstl遍历产生所有省的选项
	第3步：
		在test.jsp中引用jquery
	第4步：
		使得“省”列表改变时有反应，
		则先为“省”列表分配id
		然后创建js函数，为“省”列表绑定change()函数
	第5步：
		在“省”列表函数响应时，
		则应该获取当前选中的省的代号，
		并发送ajax请求到服务器，
		获取该省的所有市的列表
	第6步：
		为“市”列表分配id
	第7步：
		当“省”改变时，获取到了该省的所有市的列表，
		先将“市”列表清空：$("#cities").empty()
		则遍历市的列表数据，生成 option 标签的内容，
		并且，每生成一个，就添加到“市”列表中
</pre>

</body>
</html>  







