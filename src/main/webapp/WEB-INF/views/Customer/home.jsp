<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer | Home</title>
<style>
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

input.logout-button {
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

input.cart-button {
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

#errorText {
	color: red;
}

.container {
	display: flex;
	margin-left:450px;
}

.filter {
	margin: 10px;
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
	font-size: 16px;
	border-radius: 10px;
}
</style>
</head>

<body>
	<header>
		<ul>
			<li>Grocery Delivery Application</li>
		</ul>
		<form action="http://localhost:8080/mvc.jdbc/customer/showcart"
			method="post">
			<input type="submit" value="Cart" class="cart-button">
		</form>
		<form action="http://localhost:8080/mvc.jdbc/customer/logout"
			method="post">
			<input type="submit" value="Logout" id="logout" class="logout-button">
		</form>
	</header>
	<h4 style="text-align: center;" id="errorText">${error }</h4>
	<h4 style="text-align: center;" id="addedText">${added }</h4>
	<div class="container">
		<form action="http://localhost:8080/mvc.jdbc/product/byPrice" method="post">
			<input type="submit" value="Price" class="filter" />
		</form>
		<form action="http://localhost:8080/mvc.jdbc/product/byRating" method="post">
			<input type="submit" value="Ratings" class="filter" />
		</form>
		<form action="http://localhost:8080/mvc.jdbc/product/byDiscount" method="post">
			<input type="submit" value="Discount" class="filter" />
		</form>
		<form action="http://localhost:8080/mvc.jdbc/customer/home" method="post">
			<input type="submit" value="No Filter" class="filter" />
		</form>
	</div>
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
						action="http://localhost:8080/mvc.jdbc/customer/addtocart"
						method="post">
						<input type="hidden" name="Id" value="${product.getId()}" /> <input
							type="hidden" name="Name" value="${product.getName()}" /> <input
							type="hidden" name="Price" value="${product.getPrice()}" /> <input
							type="hidden" name="Ratings" value="${product.getRatings()}" />
						<input type="hidden" name="Discount"
							value="${product.getDiscount()}" /> <input type="submit"
							value="Add to Cart" class="cart" />
					</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>