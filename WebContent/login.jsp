<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blue Whale Bus Service</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<main role="main" class="container">
		<div class="jumbotron">
			<h4>${requestScope.resetPasswordSuccessfulMsg}</h4>
		</div>
		<form method="post" action="${pageContext.request.contextPath}/login">
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="text" name="email" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp"> <small
					id="emailHelp" class="form-text text-muted">We'll never
					share your email with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" name="password" class="form-control"
					id="exampleInputPassword1">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>

			<div>
				<br> <a type="button" class="btn btn-primary"
					href="${pageContext.request.contextPath}/forgot">Forgot
					Password?</a>
			</div>
		</form>
	</main>
	<%@ include file="footer.jsp"%>
</body>
</html>