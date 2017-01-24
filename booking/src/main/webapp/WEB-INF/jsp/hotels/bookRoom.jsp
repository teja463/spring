<!DOCTYPE html>
<html>
<head>
<%@ include file="../init.jsp"%>


<script src="/booking/static/js/hotels.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://uxsolutions.github.io/bootstrap-datepicker/bootstrap-datepicker/css/bootstrap-datepicker3.min.css">
<script src="https://uxsolutions.github.io/bootstrap-datepicker/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
<title><spring:message code="book.room" /></title>
</head>
<body class="container">
	<script>
		$(function(){
			$("#checkIn").datepicker({
				 format: 'dd-mm-yyyy'
			});
			$("#checkOut").datepicker({
				 format: 'dd-mm-yyyy'
			});
		});
		
	</script>
	<form:form action="/booking/room/process" commandName="bookRoom" method="POST">
	
		<div class="form-group">
			<spring:bind path="city">
				<label for="room"><spring:message code="select.city" /></label> 
				<form:select path="city" class="form-control" id="city">
					<option></option>
					<c:forEach items="${cities }" var="city">
						<option value="${city.name }">${city.name }</option>
					</c:forEach>
				</form:select>
				<div class="${status.error? 'alert alert-danger' : '' }">
					<form:errors path="city"  />
				</div>
			</spring:bind>
		</div>
		
		<div class="form-group">
			<spring:bind path="city">
				<label for="hotel"><spring:message code="select.hotel" /></label> 
				<form:select path="hotel" class="form-control" id="hotel">
					
				</form:select>
				<div class="${status.error? 'alert alert-danger' : '' }">
					<form:errors path="hotel"  />
				</div>
			</spring:bind>
		</div>
		
		<div class="form-group">
			<spring:bind path="roomsBooked">
			
				<label for="roomsBooked"><spring:message code="no.of.rooms" /></label>
				<form:input path="roomsBooked" value="${bookRoom.roomsBooked }" class="form-control" placeholder="Please Number of Rooms"/>
				<div class="${status.error? 'alert alert-danger' : '' }">
					<form:errors path="roomsBooked"  />
				</div>
			</spring:bind>
		</div>
		
		<div class="form-group">
			<spring:bind path="checkIn">
				<label for="checkIn"><spring:message code="checkin.date" /></label>
				<form:input path="checkIn" value="${bookRoom.checkIn }" class="form-control" placeholder="Please enter Check in date" />
				<div class="${status.error? 'alert alert-danger' : '' }">
					<form:errors path="checkIn"  />
				</div>
			</spring:bind>
		</div>
		
		<div class="form-group">
			<spring:bind path="checkOut">
				<label for="checkOut"><spring:message code="checkout.date" /></label>
				<form:input path="checkOut" value="${bookRoom.checkOut }" class="form-control" placeholder="Please enter Check out date"/>
				<div class="${status.error? 'alert alert-danger' : '' }">
					<form:errors path="checkOut"  />
				</div>
			</spring:bind>
		</div>
		<input type="submit" value="<spring:message code='booking.book' />" role="button" class="btn btn-primary btn-lg btn-block" />
		<a href="/booking" role="button" class="btn btn-warning btn-lg btn-block"><spring:message code="booking.cancel" /></a>
	</form:form>

</body>
</html>