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
		 
		<div class="table-responsive">
		  <table class="table">
		  <tr>
		  	<td>글번호</td>
		  	<td>제목</td>
		  	<td>작성일</td>
		  	<td>작성자</td>
		  	<td>조회수</td>
		  </tr>
		<c:forEach var="calendar" items="${list }">
		 	<tr>
		 	<td>${calendar.cal_no}</td>
		 	<td><a href="detail?cal_no=${calendar.cal_no}"> ${calendar.cal_title} </a></td>
		 	
		 	
		 	</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center">
				<input class="btn btn-success" type="button" value="메인으로"	id="main" />		
			</td>
		</tr>
		  </table>
		  	
	</div>
		</div>
    </section>
            
        </header>
        
    </body>
</html>