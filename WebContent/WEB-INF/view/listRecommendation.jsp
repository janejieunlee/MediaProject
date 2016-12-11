<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">

<title>NursNars</title>
</head>


<body>

	<jsp:include page="/WEB-INF/layout/header.jsp" />
	<jsp:include page="/WEB-INF/layout/menu.jsp" />

	<h1>-맞춤 추천-</h1>

	<c:forEach var="broadcast" items="${recommendList}">
		<tr>
			<td>${broadcast.broadcastId}</td>
			<td>
				<!-- 여기 고쳐야함 --> <a
				href="read.do?no=${broadcast.broadcastId}&pageNo=${broadcastPage.currentPage}&user=${authUser.id}">
					<c:out value="${broadcast.name}" />
			</a>

			</td>
			<td>${broadcast.broadcaster}</td>
			<td>${broadcast.productName}</td>

		</tr>
	</c:forEach>


</body>
</html>