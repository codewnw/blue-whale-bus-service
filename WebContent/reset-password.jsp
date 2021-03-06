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
			<p class="lead" style="color:red;">${param.errorMessage}</p>
		</div>

		<form method="post" action="${pageContext.request.contextPath}/resetpassword">

			<div>
				<label for="oldPassword">Old Password:</label> <input type="password"
					name="oldPassword" class="form-control" id="oldPassword">
			</div>

			<div>
				<label for="newPassword">New Password:</label> <input
					type="password" name="newPassword" class="form-control"
					id="newPassword">
			</div>
			<div>
				<label for="confirmNewPassword">Confirm New Password:</label> <input
					type="password" name="confirmNewPassword" class="form-control"
					id="confirmNewPassword" onkeyup='check();'>
				<span id='message'></span>
			</div>
			<br>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


	</main>
	<%@ include file="footer.jsp"%>
	<script>
		var check = function() {
		  if (document.getElementById('newPassword').value !=
		    document.getElementById('confirmNewPassword').value) {
			  document.getElementById('message').style.color = 'red';
			  document.getElementById('message').innerHTML = 'New password not matching';
		  } else{
			  document.getElementById('message').innerHTML = '';
		  }
		}
	</script>
</body>
</html>