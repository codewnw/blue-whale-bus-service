<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blue Whale Bus Service</title>
<style>
th, td {
	padding: 25px;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<main role="main" class="container">
		<p>${param.msg eq null ? '' :  param.msg}</p>
		<div class="jumbotron">
			<h1>Reset Password..</h1>
			<p class="lead">Check your registered mail for OTP...</p>
		</div>

		<form method="post" action="${pageContext.request.contextPath}/resetpassword">

			<div>
				<label for="exampleInputPassword1">Email ID:</label> <input
					type="text" name="emailId" value=${emailId } readonly
					class="form-control" id="exampleInputPassword1">
			</div>

			<div>
				<label for="exampleInputPassword1">OTP:</label> <input type="text"
					name="otp" class="form-control" id="exampleInputPassword1">
			</div>

			<div>
				<label for="exampleInputPassword1">New Password:</label> <input
					type="password" name="password" class="form-control"
					id="exampleInputPassword1">
			</div>
			<br>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


	</main>
	<%@ include file="footer.jsp"%>
</body>
</html>