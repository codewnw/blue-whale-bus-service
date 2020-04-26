<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page !!!</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>Registration Form</h1>
	<form action="jsp/process-profile.jsp" method="post">
		<table border="1px">
			<tr>
				<td><label>First Name:</label></td>
				<td><input type="text" name="firstName"
					placeholder="Enter your first name"></td>
			</tr>
			<tr>
				<td><label>Last Name:</label></td>
				<td><input type="text" name="lastName"
					placeholder="Enter your last name"></td>
			</tr>
			<tr>
				<td><label>Email:</label></td>
				<td><input type="email" name="email"
					placeholder="Enter your email"></td>
			</tr>
			<tr>
				<td><label>User Name:</label></td>
				<td><input type="text" name="userName"
					placeholder="Enter a name for login"></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><input type="password" name="password"
					placeholder="Enter password for login"></td>
			</tr>
			<tr>
				<td><label>Date Of Birth:</label></td>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<td><label>Phone Number:</label></td>
				<td><input type="number" name="phoneNo"
					placeholder="Enter contact number"></td>
			</tr>
			<tr>
				<td><label>Address:</label></td>
				<td><textarea name="address" rows="5" cols="50"></textarea></td>
			</tr>
			<tr>
				<td><label>Gender:</label></td>
				<td><input type="radio" name="gender" value="Male">
					Male &nbsp; <input type="radio" name="gender" value="Female">
					Female</td>
			</tr>
			<tr>
				<td><label>Country:</label></td>
				<td><select name="country">
						<option value="">--Select--</option>
						<option value="IND">India</option>
						<option value="USA">America</option>
						<option value="AUS">Australia</option>
						<option value="CHN">China</option>
				</select></td>
			</tr>
			<tr>
				<td><label><input type="reset" value="Reset"></label></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>