<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Login</title>
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

.container {
	width: 300px;
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	margin: auto auto;
	margin-top: 100px;
	margin-bottom: 100px;
}

h2 {
	text-align: center;
	margin-bottom: 20px;
}

form {
	display: flex;
	flex-direction: column;
}

label {
	margin-bottom: 10px;
}

input[type="text"], input[type="password"], input[type="submit"] {
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 10px;
}

input.error {
	border-color: red;
}

input[type="submit"] {
	background-color: #4caf50;
	color: #fff;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

h4 {
	color: red;
	text-align: center;
}
input.signup-button {
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
</style>
</head>
<body>
	<header>
		<ul>
			<li>Grocery Delivery Application</li>
		</ul>
		<form action="http://localhost:8080/mvc.jdbc/customer/signup" method="post">
			<input type="submit" value="SignUp" class="signup-button">
		</form>
	</header>
	<div class="container">
		<h2>Customer Login Form</h2>

		<h4 id="error-message">${error}</h4>

		<form action="http://localhost:8080/mvc.jdbc/customer/login/process"
			method="post">
			<label> <input type="text" id="username" name="Id"
				placeholder="Username" required>
			</label> <label> <input type="password" id="password" name="password"
				placeholder="Password" required>
			</label> <input type="submit" value="Submit">
		</form>
	</div>

</body>
</html>