<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body { /* 
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
	margin-bottom: 10px;
}

.container {
	width: 300px;
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	margin-left: 520px;
	margin-top: 50px;
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
input[type="number"], input[type="text"]{

	position:relative;
	left:50px;

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
</style>
<script>
function validateForm() {
    var idInput = document.forms["productForm"]["Id"];
    var nameInput = document.forms["productForm"]["Name"];
    var priceInput = document.forms["productForm"]["Price"];
    var ratingsInput = document.forms["productForm"]["Ratings"];
    var discountInput = document.forms["productForm"]["Discount"];
    
    var errorText = document.getElementById("errorText");
    
    // Check if Name field is empty
    if (nameInput.value === "") {
        errorText.textContent = "Name is required";
        nameInput.classList.add("error");
        return false;
    }
    
    // Check if Price field is empty or not a valid float
    if (priceInput.value === "" || isNaN(parseFloat(priceInput.value))) {
        errorText.textContent = "Price must be a valid float";
        priceInput.classList.add("error");
        return false;
    }
    
    // Check if Ratings field is empty or not a valid float
    if (ratingsInput.value === "" || isNaN(parseFloat(ratingsInput.value))) {
        errorText.textContent = "Ratings must be a valid float";
        ratingsInput.classList.add("error");
        return false;
    }
    
    // Check if Discount field is empty or not a valid float
    if (discountInput.value === "" || isNaN(parseFloat(discountInput.value))) {
        errorText.textContent = "Discount must be a valid float";
        discountInput.classList.add("error");
        return false;
    }
    
    // All fields are valid, clear error message and remove error styling
    errorText.textContent = "";
    nameInput.classList.remove("error");
    priceInput.classList.remove("error");
    ratingsInput.classList.remove("error");
    discountInput.classList.remove("error");
    
    return true;
}
</script>
</head>
<body>
	<header>
		<ul>
			<li>Grocery Delivery Application</li>
		</ul>
	</header>

	<div style="text-align: center; font-size: 30px;">Admin | Power</div>

	<div class="container">
		<h2>Product Update Form</h2>

		<h4 id="errorText">${error }</h4>

		<form name="productForm" action="update/process" method="post"
			onsubmit="return validateForm()">
			<label><input type="number" name="Id" placeholder="Id (int)" value="${product.getId()}" readonly>
			</label> <label><input type="text" name="Name"
				placeholder="Name (String)" value="${product.getName()}">
			</label> <label> <input type="text" name="Price"
				placeholder="Price (Float)" value="${product.getPrice()}">
			</label> <label> <input type="text" name="Ratings"
				placeholder="Ratings (Float)" value="${product.getRatings()}" readonly>
			</label> <label> <input type="text" name="Discount"
				placeholder="Discount (Float)" value="${product.getDiscount()}">
			</label> <input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>