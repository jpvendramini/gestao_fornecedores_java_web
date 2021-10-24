<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fornecedores | Sign up</title>
</head>
<body>
	<div>
		<div>
			<h3>Sign up</h3>
			<form action="signup" method="post">
				<input type="text" name="username" placeholder="username" required="required">
				<input type="password" name="password" placeholder="password" required="required">
				<input type="password" name="password" placeholder="repeat password" required="required">	
				<input type="hidden" value="signup" name="flag">					
				<input type="submit" value="Sign up">
				<label>Return to login ;)</label>
				<a href="login.jsp">Login</a>
			</form>
		</div>
	</div>
</body>
</html>