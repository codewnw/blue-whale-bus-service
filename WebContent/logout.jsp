<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
	<jsp:include page="header.jsp" />
		<main role="main" class="container">
		<div class="jumbotron">
			<h4>${param.resetPasswordSuccessfulMsg}</h4>
			<p class="lead">Login to Continue...</p>
			<a href="${pageContext.request.contextPath}/login">New Login</a>
		</div>
		</main>
	<jsp:include page="footer.jsp" />
</body>
</html>