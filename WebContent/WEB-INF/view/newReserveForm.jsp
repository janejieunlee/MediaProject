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
                      
					<form name="Form1" class="form-horizontal" action="reserve.do" method="post">

                <fieldset>
                  <legend>예약하기</legend>
                 </fieldset>

		                  <div class="form-group">
		                    <label for="name" class="col-lg-2 control-label">방송 제목</label>
		                    <div class="col-lg-10">
		                    <input class="form-control" id="focusedInput" type="text" name="name" value="${param.name}">
							<c:if test="${errors.name}">name을 입력하세요.</c:if>
							</div>
	                 	 </div> 
						
						  <!--picture-->
						  <div class="form-group">
		                    <label for="name" class="col-lg-2 control-label">Picture</label>
		                    <div class="col-lg-10">
		                    <input class="form-control" id="focusedInput" type="text" name="picture" value="${param.picture}">
							<c:if test="${errors.picture}">picture을 입력하세요.</c:if>
							</div>
	                 	 </div> 
	                 	 
						  <div class="form-group">
		                    <label for="name" class="col-lg-2 control-label">상품명</label>
		                    <div class="col-lg-10">
		                    <input class="form-control" id="focusedInput" type="text" name="productName" value="${param.productName}">
							<c:if test="${errors.productName}">productName을 입력하세요.</c:if>
							</div>
	                 	 </div> 

						<div class="form-group">
		                    <label for="name" class="col-lg-2 control-label">최저입찰가</label>
		                    <div class="col-lg-10">
		                    <input class="form-control" id="focusedInput" type="text" name="lowPrice" value="${param.lowPrice}">
							<c:if test="${errors.lowPrice}">lowPrice을 입력하세요.</c:if>
							</div>
	                 	 </div> 
						
						<div class="form-group">
		                    <label for="name" class="col-lg-2 control-label">Category</label>
		                    <div class="col-lg-10">
							 <select class="form-control" id="select" name="ctgId">
							 	<option>패션의류</option>
							 	<option>잡화/명품</option>
							 	<option>화장품</option>
							 	<option>유아동/문화</option>
							 	<option>스포츠/여행</option>
							 	<option>식품/주방</option>
							 	<option>가구/생활</option>
							 	<option>가전/컴퓨터</option>
							 </select>
							 
							</div>
	                 	 </div> 
	                 	 
 						<div class="form-group">
 						<label for="name" class="col-lg-2 control-label">날짜/시간</label>
	 						<div class="col-lg-10">
								<input type="date" name="date">	
								<input type="time" name="time">	
							</div>
						</div>
										                 	 
 						<div class="form-group">
		                    <div class="col-lg-10">	
		                    <center>					
								<input type="submit" class="btn btn-primary" value="방송 예약">
							</center>
							</div>
	                 	 </div> 


						</form>
						
				</div>
			</div>

</body>
</html>