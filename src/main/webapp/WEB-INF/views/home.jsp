<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- 추가할부분 -->
<html>
<head>
		<meta charset="UTF-8"> <!-- 추가할부분 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 추가할부분 -->
	<meta http-equiv="X-UA-Compatible" content="ie=edge"> <!-- 추가할부분 -->
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
 	 <li><a href ="intro">회사소개</a></li> 
 	 <li><a href ="intro2">대표소개</a></li>  
 	 <li><a href ="intro3">조직도</a></li>  
 	 <a href="main"></a>
 	 <li><a href="empcount">사원수 : ${cnt }</a></li>
 	 <li><a href="index">인덱스</a></li>
</body>
</html>