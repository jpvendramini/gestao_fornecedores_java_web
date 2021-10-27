<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../style/loginstyle.css">
<title>Fornecedores | Sign in</title>
</head>
<body>
	<div class="container">
		<div class="login">
			<h3>Sign in</h3>
			<form action="../login" method="post">
				<input type="text" name="username" placeholder="username" required="required"></br>
				<input type="password" name="password" placeholder="password" required="required"></br>		
				<input type="hidden" value="signin" name="flag">
				<input type="submit" value="Sign in"></br>	
				<label>Doesn't have an account yet?</label></br>
				<a href="signup.jsp">Create Account</a>
			</form>
		</div>
	</div>
</body>
</html>