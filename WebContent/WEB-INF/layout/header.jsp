<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<!-- 여기 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>NursNars</title>
</head>
<body>

	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<!-- <a class="navbar-brand" href="#">NursNars</a> -->

				<a href="main.do"><img src="images/main.png" height="100px"></a>


			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<form class="navbar-form navbar-left" action="search.do"
					role="search" method="post">

					<div class="form-group">
						<div class="col-lg-10">

							<select class="form-control" id="select" name="searchId">
								<option>-</option>
								<option>상품명</option>
								<option>판매자</option>
							</select>

						</div>
					</div>



					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search"
							name="word">
					</div>
					<button type="submit" class="btn btn-default">검색</button>

				</form>

				<ul class="nav navbar-nav">
					<li><a href="#"><p data-toggle="modal"
								data-target="#Streaming">방송하기</p></a></li>
					<li><a href="#"><p data-toggle="modal"
								data-target="#Reserve">예약하기</p></a></li>
					<!-- <li><a href="register.do">방송하기</a></li>
                      <li><a href="reserve.do">예약하기</a></li> -->
					<li><a href="schedule.do">시간표</a></li>
				</ul>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li><u:isLogin>
								<li><a href="comment.do?user=${authUser.id}">나의 Channel</a>
								</li>
								<li><a href="changePwd.do">회원정보수정</a></li>
								<li><a href="logout.do">로그아웃</a></li>
							</u:isLogin> <u:notLogin>
								<li><a href="login.do">로그인</a></li>
								<li><a href="join.do">회원가입</a></li>
							</u:notLogin></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- </nav>-->

	</div>

	<ul class="breadcrumb">
		<li><a href="main.do?user=${authUser.id}">HOME</a></li>
		<li><a href="schedule.do">시간표</a></li>
	</ul>

	<!-- 방송하기 Modal -->
	<div class="modal fade" id="Streaming" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<form class="form-horizontal" action="register.do" method="post"
					enctype="multipart/form-data">
					<!-- action="register.do" enctype="multipart/form-data" enctype은 표시 -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">방송하기</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="name" class="col-lg-2 control-label">방송 제목</label>
							<div class="col-lg-10">
								<input class="form-control" id="focusedInput" type="text"
									name="name" value="${param.name}">
								<c:if test="${errors.name}">name을 입력하세요.</c:if>
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-lg-2 control-label">Picture</label>
							<div class="col-lg-10">

								<input type="file" name="picture" />
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-lg-2 control-label">상품명</label>
							<div class="col-lg-10">
								<input class="form-control" id="focusedInput" type="text"
									name="productName" value="${param.productName}">
								<c:if test="${errors.productName}">productName을 입력하세요.</c:if>
							</div>
						</div>


						<!--lowPrice-->
						<div class="form-group">
							<label for="name" class="col-lg-2 control-label">최저입찰가</label>
							<div class="col-lg-10">
								<input class="form-control" id="focusedInput" type="text"
									name="lowPrice" value="${param.lowPrice}">
								<c:if test="${errors.lowPrice}">lowPrice을 입력하세요.</c:if>
							</div>
						</div>



						<!--ctgId-->
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


					</div>
					<div class="modal-footer">
						<div class="form-group">
							<div class="col-lg-10">
								<!-- <form action="http://35.162.132.169:3000/braodcast" method="POST">	 -->
								<input type="submit" class="btn btn-primary" value="방송하기">
								<!-- </form> -->
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>

	<!-- 예약하기 Modal -->
	<!-- Modal -->
	<div class="modal fade" id="Reserve" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<form name="Form1" class="form-horizontal" action="reserve.do"
					method="post">


					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">예약하기</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="name" class="col-lg-2 control-label">방송 제목</label>
							<div class="col-lg-10">
								<input class="form-control" id="focusedInput" type="text"
									name="name" value="${param.name}">
								<c:if test="${errors.name}">name을 입력하세요.</c:if>
							</div>
						</div>

						<!--picture-->
						<div class="form-group">
							<label for="name" class="col-lg-2 control-label">Picture</label>
							<div class="col-lg-10">
								<input class="form-control" id="focusedInput" type="text"
									name="picture" value="${param.picture}">
								<c:if test="${errors.picture}">picture을 입력하세요.</c:if>
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-lg-2 control-label">상품명</label>
							<div class="col-lg-10">
								<input class="form-control" id="focusedInput" type="text"
									name="productName" value="${param.productName}">
								<c:if test="${errors.productName}">productName을 입력하세요.</c:if>
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-lg-2 control-label">최저입찰가</label>
							<div class="col-lg-10">
								<input class="form-control" id="focusedInput" type="text"
									name="lowPrice" value="${param.lowPrice}">
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
								<input type="date" name="date"> <input type="time"
									name="time">
							</div>
						</div>

					</div>
					<div class="modal-footer">

						<div class="form-group">
							<div class="col-lg-10">

								<input type="submit" class="btn btn-primary" value="방송 예약">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>

							</div>
						</div>


					</div>

				</form>
			</div>

		</div>
	</div>

</body>
</html>
