<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Table</title>
<style>
body {
	height: 100vh;
	background-color: #f2f2f2;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

ul {
	list-style: none;
	margin: 0px;
	padding-bottom: 10px;
	display: flex;
	justify-content: center;
	align-items: center;
	height: fit-content;
}

li {
	margin: 0;
	padding: 0;
	font-size: 40px;
	text-align: center;
}

header {
	background-color: #333;
	color: #fff;
	padding: 10px;
	position: relative;
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

/* Different background color for alternating columns */
table tr:nth-child(even) td {
	background-color: #e6e6e6;
}

input.update, input.delete {
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #4caf50;
	color: #fff;
	cursor: pointer;
	width: 100%;
	margin-top: 10px;
}

input.update:hover , input.delete:hover {
	background-color: #45a049;
}


input.admin-button {
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

input.add-button {
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


</style>
</head>
<body>
	<header>
		<ul>
			<li>Grocery Delivery Application</li>
		</ul>
		<form action="../product/details" method="post">
			<input type="submit" value="Add" class="add-button">
		</form>
		<form action="../admin/logout" method="post">
			<input type="submit" value="Logout" class="admin-button">
		</form>
	</header>
	<br>
	<div style="text-align: center; font-size: 30px;">Admin | Power</div>
	<br><br>
	<table>
		<tr>
			<th colspan="7">Product</th>
		</tr>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Rating</th>
			<th>Discount</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.getId()}</td>
				<td>${product.getName()}</td>
				<td>${product.getPrice()}</td>
				<td>${product.getRatings()}</td>
				<td>${product.getDiscount()}</td>
				<td><form action="../product/update" method="post">
                        <input type="hidden" name="Id" value="${product.getId()}" />
                        <input type="submit" value="Update" class="update"/>
                    </form></td>
				<td><form action="../product/delete" method="post">
                        <input type="hidden" name="Id" value="${product.getId()}" />
                        <input type="submit" value="Delete" class="delete" />
                    </form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>


