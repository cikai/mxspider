<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset='utf-8'>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="images/favicon.ico" mce_href="images/favicon.ico" rel="bookmark" type="image/x-icon" />
<link href="images/favicon.ico" mce_href="images/favicon.ico" rel="icon" type="image/x-icon" />
<link href="images/favicon.ico" mce_href="images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
<link rel='stylesheet' type='text/css' href='css/libs/bootstrap.css'>
<link rel='stylesheet' type='text/css' href='css/libs/jquery.dataTables.css'>
<link rel='stylesheet' type='text/css' href='css/libs/dataTables.bootstrap.css'>
<link rel="stylesheet" type="text/css" href="css/articleList.css">
<script src="js/libs/jquery-2.1.4.js"></script>
<script src="js/libs/bootstrap.js"></script>
<script src="js/libs/jquery.dataTables.js"></script>
<script src="js/libs/dataTables.bootstrap.js"></script>
<script data-main="js/main" src="js/libs/require.js"></script>

<!--[if lt IE 9]>
    <script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<title>文章摘选系统</title>
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">

			<div class="navbar-header">
				<a class="navbar-brand" href="javascript:void(0)">文章摘选系统</a>
			</div>

			<div class="collapse navbar-collapse">
				<form class="navbar-form navbar-right">
					<button class="btn btn-default" id="run">爬取文章</button>
				</form>
			</div>

		</div>
	</nav>

	<div id="main">

		<table id="orderForm" class="display" width="100%"></table>

	</div>

	<div id="article">
		<div id="title"></div>
		<div id="content"></div>
	</div>
	
</body>
</html>
