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

	<jsp:include page="/WEB-INF/layout/header.jsp"/>
	<jsp:include page="/WEB-INF/layout/menu.jsp"/>

          <div class="col-lg-6">
                <div class="well bs-component">
	
	- Comment 작성 -
	
	<form action="write.do" method="post">
		<p>
			판매자명 : <br/> <input type="text" name="subject" value="${param.subject}">
			<c:if test="${errors.subject}">판매자명 입력하세요.</c:if>
		</p>
		
		<p>
			내용 : <br/>
			<textarea name="content" rows="5" cols="30">${param.content}</textarea>
		</p>
		
		<input type="submit" value="새 글 등록">	
	</form>
	
	</div>
	</div>
</body>
</html>