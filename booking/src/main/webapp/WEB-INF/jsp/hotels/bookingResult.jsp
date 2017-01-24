<!DOCTYPE html>
<html>
<head>
<%@ include file="../init.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Status</title>
</head>
<body class="container">
<%@ include file="../../../banner.jsp" %>
<div class="alert alert-success">
	<strong>${status }</strong> ${message }
</div>
<a href="/booking" role="button" class="btn btn-primary btn-lg btn-block"><spring:message code="booking.goto.home" /></a>
<%@ include file="../../../footer.jsp" %>
</body>
</html>