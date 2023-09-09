<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>??............</title>
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
	justify-content: space-between;
	align-items: space-between;
	flex-wrap: wrap;
	margin-top: 20px;
	width: 20vw;
	margin-left:540px;
}

h2 {
	text-align: center;
}
input {
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
	</header>
		<h2>Customer</h2>

	<div class="container">
		<form action="signup" method="post">
			<input type="submit" value="SignUp">
		</form>
		<form action="login" method="post">
			<input type="submit" value="LogIn">
		</form>
	</div>
</body>
</html>