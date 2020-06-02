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
	<p>${param.msg eq null ? '' :  param.msg}</p>
	<div class="jumbotron">
		<h1>BlueWhale - Travel on Safer Wheels ${sessionScope.username}</h1>
		<p class="lead">India's largest Bus Operator !!!</p>
		<a class="btn btn-lg btn-primary"
			href="{{ site.baseurl }}/docs/{{ site.docs_version }}/components/navbar/"
			role="button">View navbar docs &raquo;</a>
	</div>
	</main>
	<%@ include file="footer.jsp"%>
</body>
</html>