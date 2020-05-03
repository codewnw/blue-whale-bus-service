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
			<h1>Book Seat</h1>
			<p class="lead">Please select the seats...</p>
		</div>


		<div class="container">
			<form action="${pageContext.request.contextPath}/buses/temp"
				method="post">

				<table border=0>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><img
							src="${pageContext.request.contextPath}/resources/images/steering.jpg"
							width="100" height="100"></td>
					</tr>
				</table>
				<table>
					<tr>
						<td>
							<table border=4>

								<c:forEach var="seat" items="${sessionScope.bus.seats}" step="4">
									<tr>

										<td><img
											src="${pageContext.request.contextPath}/resources/images/seat.png"
											style="width: 30px; height: 50px;"><input name="seatNo"
											type="checkbox" value="${seat}">${seat}</td>
										<td><img
											src="${pageContext.request.contextPath}/resources/images/seat.png"
											style="width: 30px; height: 50px;"><input name="seatNo"
											type="checkbox" value="${seat+1}">${seat+1}</td>
										<td bgcolor="grey"></td>
										<td><img
											src="${pageContext.request.contextPath}/resources/images/seat.png"
											style="width: 30px; height: 50px;"><input name="seatNo"
											type="checkbox" value="${seat+2}">${seat+2}</td>
										<td><img
											src="${pageContext.request.contextPath}/resources/images/seat.png"
											style="width: 30px; height: 50px;"><input name="seatNo"
											type="checkbox" value="${seat+3}">${seat+3}</td>

									</tr>
								</c:forEach>

							</table>
						</td>
						<td><img
							src="${pageContext.request.contextPath}/resources/images/scania.png"
							align="right" "width="400" height="350"></td>
					</tr>
				</table>

				<div>
					<input type="submit" class="btn btn-primary btn-block zoom"
						height="50">
				</div>
			</form>

			<br>
		</div>
	</main>
	<%@ include file="footer.jsp"%>
</body>
</html>