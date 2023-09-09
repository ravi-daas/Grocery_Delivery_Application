<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin | Home</title>
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

.container {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-wrap: wrap;
	margin-top: 20px;
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

.box1, .box2 {
	width: 200px;
	height: 200px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	padding: 20px;
	margin: 10px;
}

.box1 h3, .box2 h3 {
	margin-bottom: 10px;
}

.box1 input[type="submit"], .box2 input[type="submit"] {
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #4caf50;
	color: #fff;
	cursor: pointer;
	width: 100%;
	margin-top: 10px;
}

.box1 input[type="submit"]:hover, .box2 input[type="submit"]:hover {
	background-color: #45a049;
}

.box1 input[type="submit"], .box2 input[type="submit"], .box1 input[type="submit"]:hover,
	.box2 input[type="submit"]:hover {
	margin-bottom: 5px;
}

.container {
	padding: 20px;
}

.box1, .box2 {
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<header>
		<ul>
			<li>Grocery Delivery Application</li>
		</ul>
		<form action="logout" method="post">
			<input type="submit" value="Logout" class="admin-button">
		</form>
	</header>
	<br>

	<div style="text-align: center; font-size: 30px;">Admin | Power</div>

	<div class="container">
		<div class="box1">
			<h3>Product</h3>
			<form action="../product/details" method="post">
				<input type="submit" value="Add">
			</form>
			<form action="../product/show" method="post">
				<input type="submit" value="Update">
			</form>
			<form action="../product/show" method="post">
				<input type="submit" value="Delete">
			</form>
		</div>

		<div class="box2">
			<h3>Discount</h3>
			<form action="../product/show" method="post">
				<input type="submit" value="Give">
			</form>
		</div>
	</div>
</body>
</html>
