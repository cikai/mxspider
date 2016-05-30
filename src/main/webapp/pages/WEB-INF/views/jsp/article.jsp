<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<title><c:forEach var="article" items="${page}">
		<c:out value="${article.title}" />
	</c:forEach></title>
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">

		<div class="navbar-header">
			<a class="navbar-brand" href="http://localhost:8080/take-away/main">文章摘选系统</a>
		</div>

		<div class="collapse navbar-collapse">
			<div class="navbar-form navbar-right">
				<button class="btn btn-default" id="back">返回首页</button>
			</div>
		</div>

	</div>
	</nav>

	<div id="main">
		<div id="title">
			<c:forEach var="article" items="${page}">
				<c:out value="${article.title}" />
			</c:forEach>
		</div>
		<br />
		<div id="url">
			<c:forEach var="article" items="${page}">
				原文链接： <a href='<c:out value="${article.url}"></c:out>'><c:out value="${article.url}" /></a>
			</c:forEach>
		</div>
		<br />
		<div id="content">
			<c:forEach var="article" items="${page}">
				<c:out value="${article.content}" />
			</c:forEach>
		</div>
	</div>

	<style>
		#main {
		  margin-top: 100px;
		  margin-left: 5%;
		  width: 90%
		}
		
		#title {
		  text-align: center;
		  font-size: 25px;
		}
		
		#url {
		  width: 60%;
		  margin-left: 20%;
		  text-align: center;
		  font-size: 15px;
		}
		
		#content {
		  width: 60%;
		  margin-left: 20%;
		  font-size: 15px;
		}
	</style>
	
	<script>
		$(document).ready(function() {
			$("#back").on("click", function() {
				window.location="http://localhost:8080/take-away/main";
			});
		});	
	</script>
	
</body>
</html>