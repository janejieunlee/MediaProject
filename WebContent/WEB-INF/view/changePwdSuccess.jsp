<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>암호 변경</title>
</head>
<body>

	<%
	    String user ="";
		user = request.getParameter("subject");
		String redirectURL = "/NursNars/changePwd.do";
		response.sendRedirect(redirectURL);
	%>

</body>
</html>