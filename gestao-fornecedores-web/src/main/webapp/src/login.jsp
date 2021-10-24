<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fornecedores | Sign in</title>
</head>
<body>
	<div>
		<div>
			<h3>Sign in</h3>
			<form action="../login" method="post">
				<input type="text" name="username" placeholder="username" required="required">
				<input type="password" name="password" placeholder="password" required="required">		
				<input type="hidden" value="signin" name="flag">		
				<input type="submit" value="Sign in">	
				<label>Doesn't have an account yet?</label>
				<a href="signup.jsp">Create Account</a>
			</form>
		</div>
	</div>
</body>
</html>