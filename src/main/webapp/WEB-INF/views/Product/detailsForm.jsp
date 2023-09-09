<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product | Details | Form</title>
<style>
/* Add the CSS code here */
body {/* 
	display: flex;
	justify-content: center;
	align-items: center; */
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
	padding: 10px;
	position: relative;
	margin-bottom:10px;
}

.container {
	width: 300px;
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	margin-left:520px;
	margin-top:100px;
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

input[type="number"], input[type="text"], input[type="password"], input[type="submit"]
	{
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

.error {
	border: 1px solid red;
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

</style>
<script>
	function validateForm() {
		var idInput = document.forms["productForm"]["Id"];
		var nameInput = document.forms["productForm"]["Name"];
		var priceInput = document.forms["productForm"]["Price"];
		var errorText = document.getElementById("errorText");

		errorText.textContent = "";

		if (idInput.value === "") {
			errorText.textContent = "Please enter a value for the Id field.";
			idInput.classList.add("error");
			return false;
		} else {
			idInput.classList.remove("error");
		}

		if (nameInput.value === "") {
			errorText.textContent = "Please enter a value for the Name field.";
			nameInput.classList.add("error");
			return false;
		} else {
			nameInput.classList.remove("error");
		}

		if (priceInput.value === "") {
			errorText.textContent = "Please enter a value for the Price field.";
			priceInput.classList.add("error");
			return false;
		} else {
			priceInput.classList.remove("error");
		}

		// Additional validation for input types
		var id = parseInt(idInput.value);
		if (isNaN(id)) {
			errorText.textContent = "Please enter a valid integer value for the Id field.";
			idInput.classList.add("error");
			return false;
		} else {
			idInput.classList.remove("error");
		}

		var name = nameInput.value;
		if (!/^[a-zA-Z\s]*$/.test(name)) {
			errorText.textContent = "Please enter a valid string value for the Name field.";
			nameInput.classList.add("error");
			return false;
		} else {
			nameInput.classList.remove("error");
		}

		var price = parseFloat(priceInput.value);
		if (isNaN(price)) {
			errorText.textContent = "Please enter a valid float value for the Price field.";
			priceInput.classList.add("error");
			return false;
		} else {
			priceInput.classList.remove("error");
		}

		return true;
	}
</script>
</head>
<body>
	<header>
		<ul>
			<li>Grocery Delivery Application</li>
		</ul>
		<form action="../admin/logout" method="post">
			<input type="submit" value="Logout" class="admin-button">
		</form>
	</header>
	
		<div style="text-align: center; font-size: 30px;">Admin | Power</div>
	
	<div class="container">
		<h2>Product Details Form</h2>

		<h4 id="errorText">${error }</h4>

		<form name="productForm" action="process" method="post"
			onsubmit="return validateForm()">
			<label> <input type="number" name="Id" placeholder="Id (int)">
			</label> <label> <input type="text" name="Name"
				placeholder="Name (String)">
			</label> <label> <input type="text" name="Price"
				placeholder="Price (Float)">
			</label> <input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>
