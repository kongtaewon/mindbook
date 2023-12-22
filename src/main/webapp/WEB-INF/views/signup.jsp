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
        <!-- Masthead-->
        <header class="masthead">
            <div class="container px-4 px-lg-5 h-100">
                <div class="row gx-4 gx-lg-5 h-70 align-items-center justify-content-center text-center">
                    <div class="col-lg-8 align-self-end">
                        <div>
                        
회원 가입
<hr>
<form method="post">
아이디<br>
<input id="newid" type="text" name="uid" placeholder="이메일 입력." required />
<input id="idch" type="button" value="중복 확인">
<br>
암호<br>
<input id=pw type="password" name="upw" placeholder="암호 입력" onchange="check_pw()" required /><br>
<br>
<br>
닉네임<br>
<input type="text" name="uname" placeholder="닉네임 입력." required /><br>
<br>

<br>


<input type="hidden" name="" value="" />

<input type="submit" value="등록" />
<a href="login">취소</a>

</form>
</div>
                        <hr class="divider" />
                    </div>
                    
                </div>
                
            </div>
        <%@ include file = "include/header.jsp" %>
        
        
            
            
        </header>
        
    </body>
</html>