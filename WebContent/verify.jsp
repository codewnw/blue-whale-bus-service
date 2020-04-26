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
	<form method="post" action="${pageContext.request.contextPath}/verify">
		<div class="form-group">
			<label for="exampleInputEmail1">Email address</label> <input
				type="text" name="email" class="form-control"
				id="exampleInputEmail1" aria-describedby="emailHelp">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">OTP</label> <input type="text"
				name="otp" class="form-control" id="exampleInputPassword1">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</main>
	<%@ include file="footer.jsp"%>
</body>
</html>