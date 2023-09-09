<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin | Login</title>
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
	padding: 20px;
	position: relative;
}

.container {
	width: 300px;
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	margin: auto auto;
	margin-top:100px;
	margin-bottom:100px;
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

input[type="number"], input[type="password"], input[type="submit"] {
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 10px;
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
</style>
<script>
	function validateForm() {
		var id = document.getElementsByName("Id")[0].value;
		var password = document.getElementsByName("Password")[0].value;

		// Reset the input field styles
		resetInputStyles();

		// Validate the input
		var isValid = true;

		// Check if both fields are filled
		if (id.trim() === "" || password.trim() === "") {
			isValid = false;
			highlightInputFields();
		}

		// Check if Id is an integer
		if (!Number.isInteger(Number(id))) {
			isValid = false;
			highlightInputFields();
		}

		return isValid;
	}

	function highlightInputFields() {
		var idInput = document.getElementsByName("Id")[0];
		var passwordInput = document.getElementsByName("Password")[0];

		idInput.style.borderColor = "red";
		passwordInput.style.borderColor = "red";
	}

	function resetInputStyles() {
		var idInput = document.getElementsByName("Id")[0];
		var passwordInput = document.getElementsByName("Password")[0];

		idInput.style.borderColor = "#ccc";
		passwordInput.style.borderColor = "#ccc";
	}
</script>
</head>
<body>
	<header>
		<ul>
			<li>Grocery Delivery Application</li>
		</ul>
	</header>
	<div class="container">
		<h2>Admin Login Form</h2>

		<h4>${error}</h4>

		<form action="process" method="post" onsubmit="return validateForm();">
			<label> <input type="number" name="Id" placeholder="Id">
			</label> <label> <input type="password" name="Password"
				placeholder="Password">
			</label> <input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>