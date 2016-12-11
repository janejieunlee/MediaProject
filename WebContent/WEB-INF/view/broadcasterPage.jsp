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
	width: 900px;
}

#myProfile {
	display: inline-block;
	width: 900px;
}

#myComment {
	display: inline-block;
	width: 600px;
	padding: 10px;
}

#myGrade {
	display: inline-block;
	width: 150px;
	padding: 10px;
	float: left;
}

#myPhoneNumber {
	float: right;
	display: block;
}

#myEmail {
	float: right;
	display: block;
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

					<div id="myProfile" class="jumbotron">
						<h2>${myPageId}</h2>
						<div id="myPhoneNumber" class="pull-right">
							연락처 : ${broadcasterPage.phoneNumber} <br /> Email :
							${broadcasterPage.email}
						</div>
						<div id="myIntroduction">${broadcasterPage.introduction}</div>
					</div>

					<!-- <div class="form-group"> -->

					<form action="write.do" method="post">
						<div id="myGrade">
							<select class="form-control" id="select" name="searchGrade">
								<option>-</option>
								<option value="0">&#9734;&#9734;&#9734;&#9734;&#9734;</option>
								<option value="1">&#9733;&#9734;&#9734;&#9734;&#9734;</option>
								<option value="2">&#9733;&#9733;&#9734;&#9734;&#9734;</option>
								<option value="3">&#9733;&#9733;&#9733;&#9734;&#9734;</option>
								<option value="4">&#9733;&#9733;&#9733;&#9733;&#9734;</option>
								<option value="5">&#9733;&#9733;&#9733;&#9733;&#9733;</option>
							</select>
						</div>

						<div id="myComment">
							<input type="text" class="form-control" id="inputDefault"
								name="content">
							<!-- <textarea name="content" rows="5" cols="30">${param.content}</textarea> -->
						</div>
						<input type="hidden" name="subject" value="${myPageId}"> <input
							class="btn btn-default" type="submit" value="Leave a Review">
					</form>

					<div id="myTable">

						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>평점</th>
									<th>구매자</th>
									<th>상품평</th>
								</tr>
							</thead>

							<tbody>
								<c:if test="${commentPage.hasNoComments()}">
									<tr>
										<td colspan="4">게시글이 없습니다.</td>
									</tr>
								</c:if>

								<c:forEach var="comment" items="${commentPage.content}">
									<tr>
										<td><c:if test="${comment.grade == 0}">&#9734;&#9734;&#9734;&#9734;&#9734;</c:if>
											<c:if test="${comment.grade == 1}">&#9733;&#9734;&#9734;&#9734;&#9734;</c:if>
											<c:if test="${comment.grade == 2}">&#9733;&#9733;&#9734;&#9734;&#9734;</c:if>
											<c:if test="${comment.grade == 3}">&#9733;&#9733;&#9733;&#9734;&#9734;</c:if>
											<c:if test="${comment.grade == 4}">&#9733;&#9733;&#9733;&#9733;&#9734;</c:if>
											<c:if test="${comment.grade == 5}">&#9733;&#9733;&#9733;&#9733;&#9733;</c:if>
											<sup>${comment.grade}</sup></td>
										<td>${comment.writer}</td>
										<td>${comment.content}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>

				</div>

			</div>
		</div>
	</div>




</body>
</html>
