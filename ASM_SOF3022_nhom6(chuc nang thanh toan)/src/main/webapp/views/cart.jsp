<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="margin-top: 30px; width: 1200px">
		<h3 style="text-align: center;">List</h3>
		<table class="table table-bordered" border="1" style="width: 100%; margin-top: 20px">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Amount</th>
				<th>Status</th>
			</tr>
			<c:forEach var="item" items="${items}">
				
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td>
							<form id="updateForm-${item.id}" action="/cart/update/${item.id}/1" method="post">
								<input type="number" name="qty" value="${item.qty}"  onchange="updateAction(${item.id}, this.value)" onkeypress="handleEnter(event, ${item.id})" style="widows: 50px" min="1">
							</form>
						</td>
						<td>${item.price * item.qty}</td>
						<td><a class="btn btn-danger" href="/cart/remove/${item.id}">remove</a></td>
					</tr>
			</c:forEach>
			</table>
			<a class="btn btn-primary" href="/item/index">add more</a>
			<a class="btn btn-danger" href="/cart/clear">clear cart</a>
			<br>
			<h3>revenue staistics</h3>
			<p> count: ${count}</p>
			<p>total count: ${totalCount}</p>
			<p>Amount: ${amount}</p>
			</div>
	<script>
    function updateAction(itemId, newQty) {
        let form = document.getElementById("updateForm-" + itemId);
        form.action = "/cart/update/" + itemId + "/" + newQty;
    }

    function handleEnter(event, itemId) {
        if (event.key === "Enter") {
            event.preventDefault(); 
            document.getElementById("updateForm-" + itemId).submit();
        }
    }
</script>			
</body>
</html>