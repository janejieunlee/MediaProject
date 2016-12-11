<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">

<title>가입</title>
</head>
<body>


	<div class="col-lg-6">
		<center>
			<img src="images/logo.png" height="200px">
		</center>
		<div class="well bs-component">
			<form class="form-horizontal" action="join.do" method="post">
				<!-- O -->
				<fieldset>
					<legend>회원가입</legend>
				</fieldset>




				<!-- m_id -->

				<div class="form-group">
					<label for="id" class="col-lg-2 control-label">Id</label>
					<div class="col-lg-10">
						<input class="form-control" id="focusedInput" type="text"
							name="id" value="${param.id}">

						<c:if test="${errors.id}">ID를 입력하세요.</c:if>
						<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
					</div>
				</div>

				<!-- m_name -->

				<div class="form-group">
					<label for="inputName" class="col-lg-2 control-label">Name</label>
					<div class="col-lg-10">

						<input class="form-control" id="focusedInput" type="text"
							name="name" value="${param.name}">

						<c:if test="${errors.name}">이름을 입력하세요.</c:if>
					</div>
				</div>


				<!-- m_pic -->
				<div class="form-group">
					<label for="picture" class="col-lg-2 control-label">Picture</label>
					<div class="col-lg-10">
						<input class="form-control" id="focusedInput" type="text"
							name="picture" value="${param.picture}">
						<c:if test="${errors.picture}">Picture을 입력하세요.</c:if>
					</div>
				</div>

				<!-- m_email -->
				<div class="form-group">
					<label for="email" class="col-lg-2 control-label">Email</label>
					<div class="col-lg-10">
						<input class="form-control" id="focusedInput" type="text"
							name="email" value="${param.email}">
						<c:if test="${errors.email}">Email을 입력하세요.</c:if>
					</div>
				</div>

				<!-- m_ph_num -->
				<div class="form-group">
					<label for="phoneNumber" class="col-lg-2 control-label">PhoneNumber</label>
					<div class="col-lg-10">
						<input class="form-control" id="focusedInput" type="text"
							name="phoneNumber" value="${param.phoneNumber}">
						<c:if test="${errors.phoneNumber}">phoneNumber를 입력하세요.</c:if>
					</div>
				</div>

				<!-- m_password -->
				<div class="form-group">
					<label for="inputPassword" class="col-lg-2 control-label">Password</label>
					<div class="col-lg-10">
						<input class="form-control" id="focusedInput" type="password"
							name="password">
						<c:if test="${errors.password}">암호를 입력하세요.</c:if>
					</div>
				</div>


				<div class="form-group">
					<label for="inputPassword" class="col-lg-2 control-label">Password</label>
					<div class="col-lg-10">
						<input class="form-control" id="focusedInput" type="password"
							name="confirmPassword">
						<c:if test="${errors.confirmPassword}">확인을 입력하세요.</c:if>
						<c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
					</div>
				</div>
		</div>

		<center>
			<div class="form-group">
				<div class="col-lg-10">
					<input type="submit" class="btn btn-default btn-lg" value="변경하기">

					<input type="submit" class="btn btn-primary btn-lg" value="가입하기">

				</div>
			</div>
		</center>
		</fieldset>
		</form>
	</div>
	</div>
</body>
</html>