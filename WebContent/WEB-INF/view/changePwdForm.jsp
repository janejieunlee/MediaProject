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
	width: 700px;
	height: 800px;
	display: inline-block;
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

#myBtn {
	float: right;
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
					<h3>회원정보수정</h3>

					<form action="changePwd.do" method="post">

						<div class="form-group">
							<label class="control-label" for="disabledInput">ID</label> <input
								class="form-control" id="disabledInput" type="text"
								placeholder="${userId}" disabled="">
						</div>

						<div class="form-group">
							<label class="control-label" for="disabledInput">Name</label> <input
								class="form-control" id="disabledInput" type="text"
								placeholder="${userName}" disabled="">
						</div>

						<div class="form-group">
							<label class="control-label" for="focusedInput">Current
								Password</label> <input class="form-control" name="curPwd"
								type="password">
							<c:if test="${errors.curPwd}">현재 암호를 입력하세요.</c:if>
							<c:if test="${errors.badCurPwd}">현재 암호가 일치하지 않습니다.</c:if>
						</div>

						<div class="form-group">
							<label class="control-label" for="focusedInput">New
								Password</label> <input class="form-control" name="newPwd"
								type="password">
							<c:if test="${errors.newPwd}">새 암호를 입력하세요.</c:if>
						</div>

						<div class="form-group">
							<label class="control-label" for="focusedInput">Email</label> <input
								class="form-control" name="new_email" type="text"
								value="${myPage.email}">
							<c:if test="${errors.new_email}">새 이메일을 입력하세요.</c:if>
						</div>

						<div class="form-group">
							<label class="control-label" for="focusedInput">Phone
								Number</label> <input class="form-control" name="new_ph_num" type="text"
								value="${myPage.phoneNumber}">
							<c:if test="${errors.new_ph_num}">새 번호을 입력하세요.</c:if>
						</div>

						<div class="form-group">
							<label class="control-label" for="inputLarge">Self-Introduction</label>
							<input class="form-control input-lg" type="text"
								name="new_introduction" value="${myPage.introduction}">
							<c:if test="${errors.new_introduction}">새 자기소개을 입력하세요.</c:if>
						</div>

						<div id="myBtn" class="form-group">
							<div class="col-lg-10">
								<input type="submit" class="btn btn-primary" value="회원정보 변경">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>



</body>
</html>
