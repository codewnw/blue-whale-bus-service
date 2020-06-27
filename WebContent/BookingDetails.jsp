<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.bluewhale.bus.model.Booking" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Details</title>
<style>
.style1 {
	padding: 80px;
	text-align: center;
	background: #1abc9c;
	color: white;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="style1">
		<h3>${param.congrats} </h3>
		<p>${param.bookingmsg}</p>
		<p>${param.bookingId}</p>
		<h2>Booking Details</h2>

		<table border="1" align="center">
			<tr>
				<td>From Place:</td>
				<td>${param.fromPlace}</td>
			</tr>
			<tr>
				<td>To Place:</td>
				<td>${param.toPlace}</td>
			</tr>
			<tr>
				<td>Travel Date:</td>
				<td>${param.travelDate}</td>
			</tr>
			<tr>
				<td>Booking Status:</td>
				<td>${requestScope.bookSeat.bookingStatus}</td>
			</tr>
			<tr>
				<td>Booking Price:</td>
				<td>${param.bookingPrice}</td>
			</tr>
			<tr>
				<td>Bus No:</td>
				<td>${param.busId}</td>
			</tr>
			<tr>
				<td>Seat No:</td>
				<td>${param.seatNo}</td>
			</tr>
			<tr>
				<td>Booking Created Date:</td>
				<td>${requestScope.bookSeat.bookingCreatedDate}</td>
			</tr>
		</table>
		<br>
		<hr>
		<br>
		<a href="bookSeat.jsp">Place another booking</a>
		<br><br>
		<a href="profile.jsp">Return to Profile Page</a>
		<br><br>
		<button type=button name="back" onclick="history.back()">Back</button>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>