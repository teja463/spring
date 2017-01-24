<%@ include file="../includeTagLibs.jsp" %>
<c:forEach items="${hotels }" var="hotel">
	<option value="${hotel.name }">${hotel.name }</option>
</c:forEach>
