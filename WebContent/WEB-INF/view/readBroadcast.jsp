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
		height:700px;
		display:block;
	}
	
	#myPic
	{
		width:450px;
		height:350px;
		display:inline-block;
		float:left;
	}
	
	#myInfo
	{
		width:300px;
		height:500px;
		display:inline-block;
		float:left;
	}
	
	#myRec
	{
		width:780px;
		height:400px;
		display:inline-block;
	}
	
	ul.myUl
	{
		list-style:none;
	}

	li.myLi
	{
		margin-left:10px;
		float: left;
		list-style:none;
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
		
          <div id="myPic" class="bs-component">
          		<img src="images/${broadcastData.broadcast.picture}" width="400px" height="300px">
				<!-- <img src="http://placehold.it/400x300">-->
		  </div>
		  
		  <div id="myInfo" class="list-group"> 
				  <a class="list-group-item">
				    <h4 class="list-group-item-heading">상품 번호</h4>
				    <p class="list-group-item-text">${broadcastData.broadcast.broadcastId}</p>
				  </a>
			  
				  <a class="list-group-item">
				    <h4 class="list-group-item-heading">방송자</h4>
				    <p class="list-group-item-text">${broadcastData.broadcast.broadcaster}</p>
				  </a>
			  
				  <a class="list-group-item">
				    <h4 class="list-group-item-heading">방송명</h4>
				    <p class="list-group-item-text">${broadcastData.broadcast.name}</p>
				  </a>
			  
			      <a class="list-group-item">
			    	<h4 class="list-group-item-heading">상품명</h4>
			        <p class="list-group-item-text">${broadcastData.broadcast.productName}</p>
			      </a>
			      
				  <a class="list-group-item">
				   <h4 class="list-group-item-heading">방송 날짜</h4>
				   <p class="list-group-item-text">${broadcastData.broadcast.date}</p>
			      </a>
			      
			      <a class="list-group-item">
			    	<h4 class="list-group-item-heading">최저 입찰가</h4>
			        <p class="list-group-item-text">${broadcastData.broadcast.lowPrice}원</p>   
			      </a>
			      
			      <!-- 
			      <a href="#" class="list-group-item">
			      	<h4>즐겨찾기</h4>
			      </a>
			      -->
			      
			        <a class="list-group-item">
			      	
			      			<form name="toBraodcast" action="http://35.162.132.169:3000/view" method="POST">
								<h4 class="join">참여하기</h4>
								<input type="hidden" value="${broadcastData.broadcast.broadcastId}" name="b_id" />
								<input type="hidden" value ="${authUser.id}" name="m_id">
								</form>
			      </a>
			</div>


			<div id="myRec">
				<h3>맞춤 동영상</h3>
					<c:forEach var="broadcast" items="${recommendList}">
						<ul class="myUl">
							<li class="myLi">
								<div class="thumbnail" style="width:175px;height:210px">
									<img src="images/${broadcast.picture}" style="width:170px;height:120px">
									<!-- <img src="http://placehold.it/170x120">-->
									<div class="pull-right"><h5>${broadcast.lowPrice}원</h5></div>
									<div>
										<a href="read.do?no=${broadcast.broadcastId}&pageNo=${broadcastPage.currentPage}&user=${authUser.id}">						
											<c:out value="${broadcast.name}"/>
										</a>
									</div>
									<div>${broadcast.productName}</div>
								</div>
							</li>
						</ul>
					</c:forEach>
          	</div>
	</div>

<script>

$('.join').click(function(){
	
  var form = $(this).parent();
  form.submit();
})


</script>

          
</body>
</html>   