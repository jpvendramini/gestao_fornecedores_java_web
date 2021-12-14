<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../style/loginstyle.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Fornecedores | Sign in</title>
</head>
<body>
	<div class="container">
		<div class="login">
			<h3>Sign in</h3>
			<form action="../login" method="post">
				<input type="text" name="username" placeholder="username" required="required" class="form-control"></br>
				<input type="password" name="password" placeholder="password" required="required" class="form-control"></br>		
				<input type="hidden" value="signin" name="flag">
				<input type="submit" value="Sign in" class="btn btn-primary"></br>	
				<label>Doesn't have an account yet?</label></br>
				<a href="signup.jsp">Create Account</a>
			</form>
		</div>
	</div>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>