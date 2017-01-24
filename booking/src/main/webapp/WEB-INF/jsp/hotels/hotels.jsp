<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../init.jsp" %>
<script src="/booking/static/js/hotels.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Least priced hotels</title>
</head>
<body class="container">
<%@ include file="../../../banner.jsp" %>
<div class="form-group">
  <label for="sel1"><spring:message code="select.city" /></label>
  <select class="form-control" id="cities">
  	<option></option>
   	<c:forEach items="${cities }" var="city">
   		<option>${city.name }</option>
   	</c:forEach>
  </select>
</div>
<div id="citiesTable">
</div>
<a href="/booking" role="button" class="btn btn-primary btn-lg btn-block"><spring:message code="booking.goto.home" /></a>
<%@ include file="../../../footer.jsp" %>
</body>
</html>