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
<%-- 		<p>${param.msg eq null ? '' :  param.msg}</p> --%>
		<div class="jumbotron">
			<h1>Reset Password..</h1>
			<p class="lead" style="color:red;">${param.errorMessage}</p>
		</div>

		<form method="post" action="${pageContext.request.contextPath}/changePassword">

			<div>
				<label for="emailId">Email Id:</label> <input
					type="text" name="emailId" class="form-control" placeholder="${param.emailId}"
					id="emailId" value="${param.emailId}" required>
			</div>
			<div>
				<label for="newPassword">New Password:</label> <input
					type="password" name="newPassword" class="form-control"
					id="newPassword" required>
					<span id='errorMsg'></span>
			</div>
			<div>
				<label for="confirmNewPassword">Confirm New Password:</label> <input
					type="password" name="confirmNewPassword" class="form-control"
					id="confirmNewPassword" onchange='check();' required>
				<span id='message'></span>
			</div>
			<br>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


	</main>
	<%@ include file="footer.jsp"%>
	<script>
		var check = function() {

			if (document.getElementById('newPassword').value != document
					.getElementById('confirmNewPassword').value) {
				document.getElementById('message').style.color = 'red';
				document.getElementById('message').innerHTML = 'Entered Password is not matching!! Try Again';
			} else {
				document.getElementById('message').innerHTML = '';
			}
		}
	</script>
</body>
</html>