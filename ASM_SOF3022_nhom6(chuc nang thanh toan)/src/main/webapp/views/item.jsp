<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="margin-top: 30px; width: 800px">
		<h3 style="text-align: center;">Add</h3>
		<table class="table table-bordered" border="1" style="width: 100%; margin-top: 20px">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Status</th>
			</tr>
			<c:forEach var="item" items="${items}">
			<tr>
				<td>${item.id }</td>
				<td>${item.name }</td>
				<td>${item.price }</td>
				<td>
					<a class="btn btn-primary" href="/cart/add/${item.id}">Add to card</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>