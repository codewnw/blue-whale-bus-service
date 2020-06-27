<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2>Welcome, ${sessionScope.username}</h2>

	<ul>
		<li><a href="bookSeat.jsp">Book your Seat</a></li>
	</ul>

	<table style="background-color: #ffffcc;">
		<tr>
          <td align="center">
			<h2>View history of bookings</h2>
			</td>
         </tr>
         <tr>
         	<td align="center"><a href="process-bookings-history.jsp">
            	<font size="4" color="blue">click here</font></a>
            </td>
		</tr>
     </table>

	<jsp:include page="footer.jsp" />
</body>
</html>