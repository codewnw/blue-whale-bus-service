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
	<div class="container">
		<div class="row">
			<div class="col-md-3 ">
				<div class="list-group ">
	              <a href="#" class="list-group-item list-group-item-action active">Dashboard</a>
	              <a href="${pageContext.request.contextPath}/reset-password.jsp" class="list-group-item list-group-item-action">Reset Password</a>
	              <a href="#" class="list-group-item list-group-item-action">Comments</a>
	              <a href="process-bookings-history.jsp" class="list-group-item list-group-item-action">BookingHistory</a>
	              <a href="#" class="list-group-item list-group-item-action">Reports</a>
	              <a href="#" class="list-group-item list-group-item-action">Settings</a>
	              </div>
            </div> 
			<div class="col-md-9">
				<div class="card">
		        	<div class="card-body">
						<div class="row">
							<div class="col-md-12">
								<h4>Your Profile</h4>
								<hr>
							</div>
						</div>
						<div class="row">
		                	<div class="col-md-12">
		                		<form>
                              <div class="form-group row">
                                <label for="username" class="col-4 col-form-label">User Name*</label> 
                                <div class="col-8">
                                  <input id="username" name="username" placeholder="${sessionScope.username}" class="form-control here" required="required" type="text">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="name" class="col-4 col-form-label">First Name</label> 
                                <div class="col-8">
                                  <input id="name" name="name" placeholder="${sessionScope.firstName}" class="form-control here" type="text">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="lastname" class="col-4 col-form-label">Last Name</label> 
                                <div class="col-8">
                                  <input id="lastname" name="lastName" placeholder="${sessionScope.lastName}" class="form-control here" type="text">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="email" class="col-4 col-form-label">Email*</label> 
                                <div class="col-8">
                                  <input id="email" name="email" placeholder="${sessionScope.username}" class="form-control here" required="required" type="text">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="website" class="col-4 col-form-label">Website</label> 
                                <div class="col-8">
                                  <input id="website" name="website" placeholder="website" class="form-control here" type="text">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="publicinfo" class="col-4 col-form-label">Public Info</label> 
                                <div class="col-8">
                                  <textarea id="publicinfo" name="publicinfo" cols="40" rows="4" class="form-control"></textarea>
                                </div>
                              </div>
                              <div class="form-group row">
                                <div class="offset-4 col-8">
                                  <button name="submit" type="submit" class="btn btn-primary">Update My Profile</button>
                                </div>
                              </div>
                            </form>
		                	</div>
		                </div>
					</div>
		        </div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>