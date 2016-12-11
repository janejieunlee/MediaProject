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
	height: 800px;
	display: block;
}

#myDiv2 {
	width: 1300px;
	height: 800px;
	display: block;
}

#myDate {
	width: 400px;
	display: inline-block;
	float: right;
}

#myTable {
	display: inline-block;
	width: 800px;
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

				<div id="myDiv2">
					<h2 id="tables">검색 결과</h2>

					<div id="myTable">
						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th>방송 번호</th>
									<th>방송명</th>
									<th>작성자</th>
									<th>상품명</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${searchPage.hasNoResult()}">
									<tr>
										<td colspan="4">방송이 없습니다.</td>
									</tr>
								</c:if>

								<c:forEach var="broadcast" items="${searchPage.content}">
									<tr>
										<td>${broadcast.broadcastId}</td>
										<td>
											<!-- 여기 고쳐야함 --> <a
											href="read.do?no=${broadcast.broadcastId}&pageNo=${searchPage.currentPage}&user=${authUser.id}">
												<c:out value="${broadcast.name}" />
										</a>

										</td>
										<td>${broadcast.broadcaster}</td>
										<td>${broadcast.productName}</td>

									</tr>


								</c:forEach>
								<c:if test="${searchPage.hasResults()}">
									<tr>
										<td colspan="4"><c:if test="${searchPage.startPage>5}">
												<a href="search.do?pageNo=${searchPage.startPage-5}">[이전]</a>
											</c:if> <c:forEach var="pNo" begin="${searchPage.startPage}"
												end="${searchPage.endPage}">
												<a href="search.do?pageNo=${pNo}">[${pNo}]</a>
											</c:forEach> <c:if test="${searchPage.endPage < searchPage.totalPages}">
												<a href="search.do?pageNo=${searchPage.startPage + 5}">[다음]</a>
											</c:if></td>
									</tr>
								</c:if>
							</tbody>
						</table>
					</div>

				</div>

			</div>
		</div>
	</div>






</body>
</html>
