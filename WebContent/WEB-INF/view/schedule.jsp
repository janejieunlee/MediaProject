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
	#myDiv1
	{
		width:300px;
		height:800px;
		display:block;
	}
	
	#myDiv2
	{
		width:1300px;
		height:800px;
		display:block;
	}
	
	#myDate
	{
		width:400px;
		display:inline-block;
		float:right;
	}
	
	#myTable
	{
		display:inline-block;
		width:800px;
	}
</style>

</head>
<body>
	<jsp:include page="/WEB-INF/layout/header.jsp"/>

    <div class="container">

      <div class="page-header" id="banner">
          
       	<div class="row">
          <div class="col-lg-8 col-md-7 col-sm-6">
            <p><br/></br/></p>
          </div>
        </div>
      
      
        <div class="row">
          <div id="myDiv1" class="col-lg-3 col-md-3 col-sm-4">
			<!-- menu -->
            <div class="list-group table-of-contents">
              <!-- <a class="list-group-item" href="#">즐겨찾기</a>-->
              <a class="list-group-item" href="list.do?ctgId=${1}">패션의류</a>	<!-- 1 -->
              
              <a class="list-group-item" href="list.do?ctgId=${2}">잡화/명품</a>		<!-- 2 -->
              <a class="list-group-item" href="list.do?ctgId=${3}">화장품</a>	<!-- 3 -->
              <a class="list-group-item" href="list.do?ctgId=${4}">유아동/문화</a>	<!-- 4 -->
              <a class="list-group-item" href="list.do?ctgId=${5}">스포츠/여행</a>	<!-- 5 -->
              <a class="list-group-item" href="list.do?ctgId=${6}">식품/주방</a>	<!-- 6 -->
              <a class="list-group-item" href="list.do?ctgId=${7}">가구/생활</a>	<!-- 7 -->
              <a class="list-group-item" href="list.do?ctgId=${8}">가전/컴퓨터</a>	<!-- 8 -->
            </div>            
	  	</div>
		
   		 <div id="myDiv2">
   		 	<h2>시간표</h2>
   		 
   		 
   		    <div id="myDate">
   		 	<!-- 날짜검색 -->
			<form action="schedule.do">	 		
		 		<div class="form-group">
		 			<div class="col-lg-10">
						<input type="date" name="date">			
						<input type="submit" class="btn btn-primary" value="검색">
					</div>
		    	</div>		
			</form>
			</div>
			
   		 	<div id="myTable">
   		 	<table class="table table-striped table-hover ">
			  <thead>
					<tr>
						<th>방송시간</th>
						<th>방송명</th>
						<th>판매자</th>
						<th>상품명</th>
					</tr>
			  </thead>
			  <tbody>
					<c:if test="${broadcastPage.hasNoBroadcastes()}">
						<tr>
							<td colspan="4">방송이 없습니다.</td>
						</tr>
					</c:if>
					
					<c:forEach var="broadcast" items="${broadcastPage.content}">
							<tr>
							<td>${broadcast.date}</td>
							<td>
								<!-- 여기 고쳐야함 -->
								<a href="read.do?no=${broadcast.broadcastId}&pageNo=${broadcastPage.currentPage}&user=${authUser.id}">						
									<c:out value="${broadcast.name}"/>
								</a>			
								
							</td>
							<td>${broadcast.broadcaster}</td>
							<td>${broadcast.productName}</td>
			
						</tr>			
			
					
					</c:forEach>
			
				</tbody>
				</table>
			</div>
	
		</div>

</div>
</div>	
</div>
</div>




          
</body>
</html>   