<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.bluewhale.bus.model.Booking"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Details</title>
<style>
.table-fill {
	background: white;
	border-radius: 3px;
	border-collapse: collapse;
	height: 320px;
	margin: auto;
	max-width: 600px;
	padding: 5px;
	width: 100%;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
	animation: float 5s infinite;
}

th {
	color: #D5DDE5;;
	background: #1b1e24;
	border-bottom: 4px solid #9ea7af;
	border-right: 1px solid #343a45;
	font-size: 23px;
	font-weight: 100;
	padding: 24px;
	text-align: left;
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
	vertical-align: middle;
}

th:first-child {
	border-top-left-radius: 3px;
}

th:last-child {
	border-top-right-radius: 3px;
	border-right: none;
}

tr {
	border-top: 1px solid #C1C3D1;
	border-bottom-: 1px solid #C1C3D1;
	color: #666B85;
	font-size: 16px;
	font-weight: normal;
	text-shadow: 0 1px 1px rgba(256, 256, 256, 0.1);
}

tr:hover td {
	background: #4E5066;
	color: #FFFFFF;
	border-top: 1px solid #22262e;
}

td {
	background: #FFFFFF;
	padding: 20px;
	text-align: left;
	vertical-align: middle;
	font-weight: 300;
	font-size: 18px;
	text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);
	border-right: 1px solid #C1C3D1;
}

td:last-child {
	border-right: 0px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<main role="main" class="container">
	<div class="jumbotron">
		<p class="lead">${ requestScope.bookingmsg }</p>
		<p class="lead" style="font-weight: bold;">Booking Id : ${requestScope.bookingId}</p>
		<p class="lead">${ requestScope.emailmsg } </p>
	</div>

	<table class="table-fill">
		<thead class="thead-light">
			<tr>
				<th colspan="2">Booking Details</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>From Place:</td>
				<td>${requestScope.bookSeat.fromPlace}</td>
			</tr>
			<tr>
				<td>To Place:</td>
				<td>${requestScope.bookSeat.toPlace}</td>
			</tr>
			<tr>
				<td>Travel Date:</td>
				<td>${requestScope.bookSeat.travelDate}</td>
			</tr>
			<tr>
				<td>Booking Status:</td>
				<td>${requestScope.bookSeat.bookingStatus}</td>
			</tr>
			<tr>
				<td>Booking Price:</td>
				<td>${requestScope.bookSeat.bookingPrice}</td>
			</tr>
			<tr>
				<td>Bus No:</td>
				<td>${requestScope.bookSeat.busId}</td>
			</tr>
			<tr>
				<td>Seat No:</td>
				<td>${requestScope.bookSeat.seatNo}</td>
			</tr>
			<tr>
				<td>Booking Created Date:</td>
				<td>${requestScope.bookSeat.bookingCreatedDate}</td>
			</tr>
		</tbody>
	</table>
	<div>
	<div class="text-left">
	  <a href="${pageContext.request.contextPath}/process-bookings-history.jsp">
	  <input type="button" class="btn btn-primary" value="View All Bookings"/></a>
	</div>
	<div class="text-right">
	  <a href="${pageContext.request.contextPath}/buses/all">
	  <input type="button" class="btn btn-primary" value="Place another booking"/></a>
	</div>
	</div>
	
	</main>
	<jsp:include page="footer.jsp" />
</body>
</html>