<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../style/loginstyle.css">
<title>Fornecedores | Sign up</title>
</head>
<body>
	<div class="container">
		<div class="login">
			<h3>Sign up</h3>
			<form action="signup" method="post">
				<input type="text" name="username" placeholder="username" required="required"></br>
				<input type="password" name="password" placeholder="password" required="required"></br>
				<input type="password" name="password" placeholder="repeat password" required="required"></br>	
				<input type="hidden" value="signup" name="flag">					
				<input type="submit" value="Sign up"></br>
				<label>Return to login ;)</label>
				<a href="login.jsp">Login</a>
			</form>
		</div>
	</div>
</body>
</html>