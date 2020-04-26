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
	<form method="post"
		action="${pageContext.request.contextPath}/buses/upload-schedule">
		<div class="form-group">
			<label for="exampleInputEmail1">Path</label> <input
				type="text" name="path" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</main>
	<%@ include file="footer.jsp"%>
</body>
</html>