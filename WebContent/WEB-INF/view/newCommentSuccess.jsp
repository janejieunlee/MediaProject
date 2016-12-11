<%@ page contentType="text/html; charset=utf-8"%>

<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>

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

${subject}

	<%
	    String user ="";
		user = request.getParameter("subject");
		String redirectURL = "/NursNars/comment.do?user="+user;
		response.sendRedirect(redirectURL);
	%>

</body>
</html>