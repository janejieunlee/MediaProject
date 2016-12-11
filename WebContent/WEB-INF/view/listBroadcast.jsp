<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<title>NursNars</title>


<style>
#myDiv1 {
	width: 300px;
	height: 700px;
	display: block;
}

#myDiv2 {
	width: 1300px;
	height: 700px;
	display: block;
}

#myDiv3 {
	margin: auto;
	width: 70%;
	float: right;
	border: 3px solid #color;
}

ul.myUl {
	list-style: none;
}

li.myLi {
	margin-left: 10px;
	float: left;
	list-style: none;
}

#myPro {
	width: 320px;
	height: 200px;
}
</style>

</head>
<body>
	<jsp:include page="/WEB-INF/layout/header.jsp" />

	<div class="container">

		<div class="page-header" id="banner">


			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<p>
						<br /></br/>
					</p>
				</div>
			</div>

			<div class="row">
				<div id="myDiv1" class="col-lg-3 col-md-3 col-sm-4">
					<!-- menu -->
					<div class="list-group table-of-contents">
						<!-- <a class="list-group-item" href="#">즐겨찾기</a>-->
						<a class="list-group-item" href="list.do?ctgId=${1}">패션의류</a>
						<!-- 1 -->
						<a class="list-group-item" href="list.do?ctgId=${2}">잡화/명품</a>
						<!-- 2 -->
						<a class="list-group-item" href="list.do?ctgId=${3}">화장품</a>
						<!-- 3 -->
						<a class="list-group-item" href="list.do?ctgId=${4}">유아동/문화</a>
						<!-- 4 -->
						<a class="list-group-item" href="list.do?ctgId=${5}">스포츠/여행</a>
						<!-- 5 -->
						<a class="list-group-item" href="list.do?ctgId=${6}">식품/주방</a>
						<!-- 6 -->
						<a class="list-group-item" href="list.do?ctgId=${7}">가구/생활</a>
						<!-- 7 -->
						<a class="list-group-item" href="list.do?ctgId=${8}">가전/컴퓨터</a>
						<!-- 8 -->
					</div>
				</div>

				<div id="myDiv2" class="bs-component">
					<h3>${ctgName}</h3>
					<c:if test="${broadcastPage.hasNoBroadcastes()}">
						<tr>
							<td colspan="4">방송이 없습니다.</td>
						</tr>
					</c:if>

					<c:forEach var="broadcast" items="${broadcastPage.content}"
						varStatus="status">
						<c:if test="${status.index%3==0}">
							<ul class="myUl">
						</c:if>
						<li class="myLi">
							<div class="thumbnail" style="width: 230px; height: 240px">
								<img src="images/${broadcast.picture}"
									style="width: 200px; height: 150px">
								<div class="pull-right">${broadcast.lowPrice}원</div>
								<div>
									<a
										href="read.do?no=${broadcast.broadcastId}&pageNo=${broadcastPage.currentPage}&user=${authUser.id}">
										<c:out value="${broadcast.name}" />
									</a>
								</div>
								<div>
									<p>${broadcast.productName}</p>
								</div>
							</div>
						</li>
						<c:if test="${status.index%3==0}">
							</ul>
						</c:if>
					</c:forEach>

				</div>


				<footer>
					<div id="myDiv3" class="row">
						<div class="col-lg-4">

							<ul class="pagination">
								<!-- 왼쪽 화살표 -->
								<li class="disabled"><a href="#">&laquo;</a></li>

								<c:if test="${broadcastPage.hasBroadcastes()}">
									<c:if test="${broadcastPage.startPage>5}">
										<li><a href="list.do?pageNo=${broadcastPage.startPage-5}">&laquo;</a></li>
									</c:if>

									<!-- 페이지 횟수 -->
									<c:forEach var="pNo" begin="${broadcastPage.startPage}"
										end="${broadcastPage.endPage}">
										<li><a href="list.do?pageNo=${pNo}"
											class="btn btn-default">${pNo}</a></li>
									</c:forEach>

									<c:if
										test="${broadcastPage.endPage < broadcastPage.totalPages}">
										<li><a
											href="list.do?pageNo=${broadcastPage.startPage + 5}">&raquo;</a>
										</li>
									</c:if>
								</c:if>
								<!-- 오른쪽 화살표 -->
								<li><a href="#">&raquo;</a></li>
							</ul>

						</div>
					</div>
				</footer>

			</div>

		</div>
	</div>




</body>
</html>
