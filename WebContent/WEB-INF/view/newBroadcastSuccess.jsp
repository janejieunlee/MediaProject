<%@page import="org.apache.catalina.connector.Request"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">

<title>NursNars</title>
</head>

<body>

  <% System.out.println("바보"); %>
	<form method="POST" action="http://35.162.132.169:3000/broadcast">
	   <input type="hidden" name="b_id" value="${newBroadcastNo}"/>
	   <input type="hidden" name="m_id" value="${authUser.id}">
	</form>
	
</body>
<script src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
<script>

$(document).ready(function(){ 
	
	
	$('form').submit();
	
	
});

</script>
</html>