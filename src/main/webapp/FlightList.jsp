<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Travel Thru Air</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<% 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	
		if(session.getAttribute("username")==null){
			response.sendRedirect("Login.jsp");
		}
	%>

		<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-warning">
			<a class="navbar-brand" href="/">Travel Thru Air</a>
			<ul class="navbar-nav ml-auto">
			
				<li><a href="<%=request.getContextPath()%>/filtertime"
					class="nav-link">Deals</a></li>
				<li><a href="<%=request.getContextPath()%>/filtercitypage"
					class="nav-link">Filter</a></li>
				<%if(session.getAttribute("username")!=null){ %>
				
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
				<% }else{ %>
				<li><a href="<%=request.getContextPath()%>/login"
					class="nav-link">Login</a></li>
				<%} %>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of All Flights</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Departure City</th>
						<th>Arrival City</th>
						<th>Cost</th>
						<th>Departure Time</th>
						<th>Arrival Time</th>
						<th>Stops</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="listFlight" items="${listFlight}">

						<tr>
							<td><c:out value="${listFlight.id}" /></td>
							<td><c:out value="${listFlight.departure_city}" /></td>
							<td><c:out value="${listFlight.arrival_city}" /></td>
							<td><c:out value="${listFlight.cost}" /></td>
							<td><c:out value="${listFlight.departure_time}" /></td>
							<td><c:out value="${listFlight.arrival_time}" /></td>
							<td><c:out value="${listFlight.stops}" /></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
	
	<div class="container text-center">
		<a href="<%=request.getContextPath()%>/new" class="btn btn-primary">Add New Flight</a>
	</div>
</body>
</html>