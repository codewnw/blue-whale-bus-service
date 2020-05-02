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
		<h1>Book Seat</h1>
		<p class="lead">Please select the seats...</p>
	</div>
	<div class="container">
		<form action="${pageContext.request.contextPath}/buses/temp" method="post">
			<table>
				<c:forEach var="seat" items="${sessionScope.bus.seats}">
					<tr>
						<td><img
							src="${pageContext.request.contextPath}/resources/images/seat.png"
							width="200px" height="200px" />
							<input name="seatNo" type="checkbox"
							value="${seat}">${seat}</td>
						
					</tr>
				</c:forEach>
				<input type="submit" value="Book Seats" >
			</table>
		</form>
	</div>
	</main>
	<%@ include file="footer.jsp"%>
</body>
</html>