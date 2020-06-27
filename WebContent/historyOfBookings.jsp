<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="listSize" scope="session" value="${bookingHistList.size()}"/>
<h4>Booking History for ${sessionScope.username}</h4>

<hr>
<br>
<c:if test="${listSize > 0}">
    <table border="1px">
			<tr>
				<th>Booking Id</th>
				<th>Travel_Date</th>
				<th>Bus Number</th>
				<th>Seat Number</th>
				<th>Booking Status</th>
				<th>Booking Details</th>
			</tr>
			<c:forEach items="${requestScope.bookingHistList}" var="bookingHistory">
			<tr>
				<td>${bookingHistory.bookingId}</td>
				<td>${bookingHistory.travelDate}</td>
				<td>${bookingHistory.busId}</td>
				<td>${bookingHistory.seatNo}</td>
				<td>${bookingHistory.bookingStatus}</td>
				<td><a href="BookingDetails.jsp">${bookingHistory.bookingId} details</a></td>
			</tr>
			</c:forEach>
		</table>
</c:if>
<c:if test="${listSize <= 0}">
<c:out value="No Bookings to display" />
</c:if>
<br><br>
<button type=button name="back" onclick="history.back()">Go Back</button>