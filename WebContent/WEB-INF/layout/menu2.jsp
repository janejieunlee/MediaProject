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

    <div class="container">

      <div class="page-header" id="banner">
          
       	<div class="row">
          <div class="col-lg-8 col-md-7 col-sm-6">
            <p><br/></br/></p>
          </div>
        </div>
      
      
        <div class="row">
          <div class="col-lg-3 col-md-3 col-sm-4">
			
			<!-- <img src="images/main.png" height="150px"> -->

            <div class="list-group table-of-contents">
              <a class="list-group-item" href="#">즐겨찾기</a>
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
          
          		여기에 내용쓰면 되나..?
          </div>
          </div>
          </div>
          
</body>
</html>        