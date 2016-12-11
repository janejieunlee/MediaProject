<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">

<title>NursNars</title>

<style>

ul{
list-style:none;
}

li{
margin-left:10px;
float: left;
list-style:none;
}
</style>
</head>


<body>
<%
    String redirectURL = "/NursNars/main.do";
    response.sendRedirect(redirectURL);
%>

</body>
</html>