<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>测试 -- 商品列表</title>
<style type="text/css">
table, th, td { 
	border-collapse: collapse; 
	border: 1px solid #666;
}
th, td {
	padding: 3px 5px;
}
</style>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<th>id</th>
			<th>category_id</th>
			<th>item_type</th>
			<th>title</th>
			<th>sell_point</th>
			<th>price</th>
			<th>num</th>
			<th>barcode</th>
			<th>image</th>
			<th>status</th>
			<th>priority</th>
		</tr>
		<c:forEach items="${goodsList }" var="goods">
		<tr>
			<td>${goods.id }</td>
			<td>${goods.categoryId }</td>
			<td>${goods.itemType }</td>
			<td>${goods.title }</td>
			<td>${goods.sellPoint }</td>
			<td>${goods.price }</td>
			<td>${goods.num }</td>
			<td>${goods.barcode }</td>
			<td><img height="50" src="${pageContext.request.contextPath }/${goods.image }" /></td>
			<td>${goods.status }</td>
			<td>${goods.priority }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>  