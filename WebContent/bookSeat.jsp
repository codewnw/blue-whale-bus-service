<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Seat !!!</title>
<style>

table {
  border-collapse: collapse;
}

table, th, td {
  border: 1px solid black;
  width:500px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<center><h1>Book Your Seat</h1>
	<form action="process-booking.jsp" method="post">
		<table border="1px">
			<tr>
				<td><label>From Place:</label></td>
				<td><input type="text" name="fromPlace"
					placeholder="Enter Start Place"></td>
			</tr>
			<tr>
				<td><label>To Place:</label></td>
				<td><input type="text" name="toPlace"
					placeholder="Enter Destination"></td>
			</tr>
			<tr>
				<td><label>Select Bus:</label></td>
				<td><select name="busId">
						<option value="">--Select--</option>
						<option value="10A">10A</option>
						<option value="21B">21B</option>
						<option value="35T">35T</option>
						<option value="41S">41S</option>
						<option value="59Y">59Y</option>
						<option value="107G">107G</option>
						</select></td>
			</tr>
			<tr>
				<td><label>Date of Journey:</label></td>
				<td><input type="date" name="travelDate"></td>
			</tr>
			<tr>
				<td><label>Booking Price:</label></td>
				<td><input type="text" name="bookingPrice"
					placeholder="Enter Price"></td>
			</tr>
			<tr>
				<td><label>Select Seat No:</label></td>
				<td><select name="seatNo">
						<option value="">--Select--</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
				</select></td>
			</tr>
			<tr>
				<td><label>Payment Mode:</label></td>
				<td><select name="paymentMode">
						<option value="">--Select--</option>
						<option value="Credit Card">Credit Card</option>
						<option value="Debit Card">Debit Card</option>
						<option value="Net Banking">Net Banking</option>
						<option value="UPI">UPI</option>
			</tr>
			<tr>
				<td><label><input type="reset" value="Reset"></label></td>
				<td><input type="submit" value="Book"></td>
			</tr>
		</table>
	</form></center>
	<jsp:include page="footer.jsp" />
</body>
</html>