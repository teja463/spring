<%@ include file="../includeTagLibs.jsp" %>
<table class="table table-bordered table-striped">
	<tr>
	
		<th>Hotel Name</th>
		<th>City</th>
		<th>Rating</th>
		<th>Room Price</th>
		<th>Available Rooms</th>
	</tr>
	<c:forEach items="${hotels }" var="hotel">
		<tr>
			<td>${hotel.name }</td>
			<td>${hotel.city }</td>
			<td>${hotel.rating }</td>
			<td>${hotel.roomPrice }</td>
			<td>${hotel.availableRooms }</td>
		</tr>
	</c:forEach>
</table>