<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer | Cart</title>
<style>
input.update-button {
	margin: 10px;
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
	font-size: 16px;
	border-radius: 10px;
	position: absolute;
	top: 0px;
	right: 10px;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

ul {
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center; /* Center the li horizontally */
	align-items: center; /* Center the li vertically */
	height: fit-content; /* Make the ul fill the viewport height */
}

li {
	margin: 0;
	padding: 0;
	font-size: 40px;
	text-align: center; /* Center the text within the li */
}

header {
	background-color: #333;
	color: #fff;
	padding: 10px;
	position: relative;
}

input.home-button {
	margin: 10px;
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
	font-size: 16px;
	border-radius: 10px;
	position: absolute;
	top: 0px;
}

table {
	width: 100%;
	border-collapse: collapse;
	border-radius: 20px; /* Add rounded borders */
	overflow: hidden; /* Hide overflow for rounded borders */
}

table th, table td {
	border: 1px solid black;
	padding: 8px;
	text-align: center;
}

table th {
	background-color: #f2f2f2;
}

input.cart {
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #4caf50;
	color: #fff;
	cursor: pointer;
	/* width: 50%; */
	margin-top: 5px;
}

input.order {
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #4caf50;
	color: #fff;
	cursor: pointer;
	/* width: 50%; */
	margin-top: 5px;
}
</style>
</head>
<body>
	<header>
		<ul>
			<li>Grocery Delivery Application</li>
		</ul>
		<form action="http://localhost:8080/mvc.jdbc/customer/home"
			method="post">
			<input type="submit" value="Home" class="home-button">
		</form>
		<form action="http://localhost:8080/mvc.jdbc/customer/updateProfile"
			method="post">
			<input type="submit" value="Update Profile" id="update"
				class="update-button">
		</form>
	</header>
	<table>
		<tr>
			<th colspan="5">Products</th>
		</tr>
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Rating</th>
			<th>Discount</th>
			<th>Cart</th>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.getName()}</td>
				<td>${product.getPrice()}</td>
				<td>${product.getRatings()}</td>
				<td>${product.getDiscount()}</td>
				<td><form
						action="http://localhost:8080/mvc.jdbc/customer/removeCart"
						method="post">
						<input type="hidden" name="Id" value="${product.getId()}" /> <input
							type="submit" value="Remove from Cart" class="cart" />
					</form></td>
			</tr>
		</c:forEach>
	</table>

	<form action="http://localhost:8080/mvc.jdbc/customer/checkout" method="post">
		<input type="submit" value="Place Order" class="order">
	</form>

</body>
</html>