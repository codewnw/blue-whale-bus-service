<%@ page import="com.bluewhale.bus.model.Booking" %>
<jsp:useBean id="booking" class="com.bluewhale.bus.model.Booking"></jsp:useBean>
<jsp:setProperty property="*" name="booking"/>
<%
	request.setAttribute("bookSeat", booking);
%>
<jsp:forward page="/book-seat">
	<jsp:param value="Congratulations !" name="congrats"/>
	<jsp:param value="Seat Booking is successful" name="bookingmsg"/>
</jsp:forward>