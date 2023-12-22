<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Creative - Start Bootstrap Theme</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/assets/favicon.ico" />
        <!-- Bootstrap Icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <!-- SimpleLightbox plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
        <!-- Core theme  (includes Bootstrap)-->
        <link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        
        <!-- header -->
        <%@ include file = "include/header.jsp" %>
        
        
        <!-- Masthead-->
        <section class="content container-fluid">
		<div class="box-header">
			<h3 class="box-title">게시판 글수정</h3>
		</div>
		<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label>제목</label> <input type="text"
					name='cal_title' class="form-control"  value="${calendar.cal_title}">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" name="cal_contents" rows="3">${calendar.cal_memo}</textarea>
			</div>

						<!-- 수정에 사용할 글번호 -->
			<input type="hidden" name="cal_no" value="${calendar.cal_no }" />
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-primary">수정완료</button>
			<button class="btn btn-success" type="button" onclick="location.href='/calendar/read?cal_no=${calendar.cal_no}'">취소하기</button>
			<button class="btn btn-success" type="button" onclick="location.href='calendar'">목록보기</button>	
		</div>
	</form>
		
    </section>
        
    </body>
</html>