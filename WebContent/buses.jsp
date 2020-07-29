<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.*"%>
<%@ page import="com.bluewhale.bus.model.Bus" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.bus-div {
	margin: 4px;
	border: 1px solid grey;
	border-radius: 5px;
	width: 100%;
	height: 130px;
}

.bus-div:hover {
	background-color: #a8dadc;
}

.bus-div-sec-1 {
	float: left;
	padding: 2px;
	width: 15%;
	height: 100%;
}

.bus-div-sec-2 {
	float: left;
	padding: 2px;
	width: 20%;
	height: 100%;
}

.bus-div-sec-3 {
	float: left;
	padding: 2px;
	width: 30%;
	height: 100%;
}

.bus-div-sec-4 {
	float: left;
	padding: 2px;
	width: 15%;
	height: 100%;
}

.zoom {
	
}

.zoom:hover {
	transform: scale(1.05);
	/* (150% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
}
</style>
<meta charset="ISO-8859-1">
<title>Blue Whale Bus Service</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<c:forEach var="bus" items="${sessionScope.buses}">
			<div class="bus-div">
				<div class="bus-div-sec-1">
					<div style="float: none;">
						<img align="middle" alt=""
							src="${pageContext.request.contextPath}/resources/images/${fn:toLowerCase(bus.type)}.png"
							width="100%" height="100">
					</div>
					<div style="float: none;">
						<p style="text-align: center;">${bus.type}</p>
					</div>

				</div>
				<div class="bus-div-sec-2">
					<div align="center">
						<c:set var="depTimeArr"
							value="${fn:split(bus.departureTime, ' ')}" />
						<c:set var="depTime" value="${depTimeArr[0]}" />
						<c:set var="depAmPm" value="${depTimeArr[1]}" />
						<span style="font-size: x-large;"><strong>${depTime}</strong></span>
						<span style="font-size: medium;">${depAmPm}</span>
					</div>
					<div align="center">
						<span style="font-size: large;">${bus.origin}</span>
					</div>
					<div style="margin-top: 5px" align="center">
						<span style="font-size: large;">${bus.departureDate}</span>
					</div>
				</div>
				<div class="bus-div-sec-3">
					<div style="float: none; padding: 2px;">
						<div style="float: left; width: 25%;">
							<img alt=""
								src="${pageContext.request.contextPath}/resources/images/source-to-destination.png"
								width="60" height="60">
						</div>

						<div style="float: left; width: 50%;">
							<div style="float: none;" align="center">
								<span style="font-size: x-large;"><strong>${bus.travelTime}</strong></span> <span
									style="font-size: large;">Hours</span>
							</div>
							<div style="float: none; margin-top: 10px;" align="center">
								<span>-------------------------</span>
							</div>
						</div>


						<div style="float: right; width: 25%;">
							<img alt=""
								src="${pageContext.request.contextPath}/resources/images/source-to-destination.png"
								width="60" height="60">
						</div>
						<div
							style="float: left; width: 100%; padding: 2px; padding-top: 4px;">
							<c:forEach var="amenity" items="${bus.amenities}">
							${amenity }&nbsp;|&nbsp;
							</c:forEach>
						</div>
					</div>

				</div>
				<div class="bus-div-sec-2">
					<div align="center">
						<c:set var="arrivalTimeArr"
							value="${fn:split(bus.arrivalTime, ' ')}" />
						<c:set var="arrivalTime" value="${arrivalTimeArr[0]}" />
						<c:set var="arrivalAmPm" value="${arrivalTimeArr[1]}" />
						<span style="font-size: x-large;"><strong>${arrivalTime}</strong></span>
						<span style="font-size: medium;">${arrivalAmPm}</span>
					</div>
					<div align="center">
						<span style="font-size: large;">${bus.destination}</span>
					</div>
					<div style="margin-top: 5px" align="center">
						<span style="font-size: large;">${bus.arrivalDate}</span>
					</div>
				</div>
				<div class="bus-div-sec-4">
					<div align="center" style="margin-bottom: 6px">
						<span style="font-size: large;">&#8377;</span> <span
							style="font-size: x-large;"><strong>${bus.fare}</strong></span>
					</div>
					<div align="center" style="margin: 1px">
						<span style="font-size: large;"><button type="button"
								class="btn btn-success btn-block">Offer</button></span>
					</div>
					<div align="center" style="margin: 1px">
						<% Bus selectedBus=(Bus)pageContext.findAttribute("bus");
						session.setAttribute("bus",selectedBus); %>
						<span style="font-size: large;"><a type="button"
							class="btn btn-primary btn-block zoom"
							href="${pageContext.request.contextPath}/buses/${bus.id}/info">Book</a></span>
					</div>
				</div>
			</div>
			
		</c:forEach>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>