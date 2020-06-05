<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/navbar-top-fixed.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/navbar.css" />
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container-xl">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">Blue
				Whale</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExample07XL" aria-controls="navbarsExample07XL"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsExample07XL">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Book
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/buses/all">Buses</a></li>

					<c:if test="${sessionScope.username eq null}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown07XL"
							data-toggle="dropdown" aria-expanded="false">Welcome, Guest</a>
							<div class="dropdown-menu" aria-labelledby="dropdown07XL">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/login">Login</a> <a
									class="dropdown-item"
									href="${pageContext.request.contextPath}/signup">Signup</a>
							</div></li>
					</c:if>
					<c:if test="${sessionScope.username ne null}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown07XL"
							data-toggle="dropdown" aria-expanded="false">Welcome,
								${sessionScope.username}</a>
							<div class="dropdown-menu" aria-labelledby="dropdown07XL">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/logout">Logout</a>
							</div></li>
					</c:if>

				</ul>
				<form class="form-inline my-2 my-md-0">
					<input class="form-control" type="text" placeholder="Search"
						aria-label="Search">
				</form>
			</div>
		</div>
	</nav>
</body>
</html>