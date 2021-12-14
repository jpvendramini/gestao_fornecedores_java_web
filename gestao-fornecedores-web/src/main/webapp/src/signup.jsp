<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../style/loginstyle.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Fornecedores | Sign up</title>
</head>
<body>
	<div class="container">
		<div class="login">
			<h3>Sign up</h3>
			<form action="signup" method="post">
				<input type="text" name="username" placeholder="username" required="required" class="form-control"></br>
				<input type="password" name="password" placeholder="password" required="required" class="form-control"></br>
				<input type="password" name="password" placeholder="repeat password" required="required" class="form-control"></br>	
				<input type="hidden" value="signup" name="flag">					
				<input type="submit" value="Sign up" class="btn btn-primary"></br>
				<a href="login.jsp">Return to login ;)</a></br>				
			</form>
		</div>
	</div>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>