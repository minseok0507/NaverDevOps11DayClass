<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
   <style>
	   *{
		   margin: 0;
		   padding: 0;
		   box-sizing: border-box;
	   }
       body *{
           font-family: 'Jua';
       }

	   div.mainlayout > div{
		   min-width: 800px;
	   }

	   div.mainlayout > div a{
		   text-decoration: none;
		   color: black;
	   }

	   div.mainlayout > div.header-tile{
		   width: 100%;
		   height: 100px;
		   line-height: 100px;
		   font-size: 35px;
		   text-align: center;
	   }

	   div.mainlayout > div.menu-tile{
		   width: 100%;
		   height: 80px;
		   line-height: 80px;
	   }

	   div.mainlayout > div.info-tile{
		   position: fixed;
		   top: 250px;
		   left: 50px;
		   width: 100px;
		   height: 200px;
		   border: 2px solid gray;
		   min-width: 200px;
	   }

	   div.mainlayout > div.main-tile{
		   margin: auto;
		   width: 800px;
		   height: auto;

	   }
   </style>
</head>
<body>
<div class="mainlayout">
	<div class="header-tile">
		<tiles:insertAttribute name="header"/>
	</div>
	<div class="menu-tile">
		<tiles:insertAttribute name="menu"/>
	</div>
	<div class="info-tile">
		<tiles:insertAttribute name="info"/>
	</div>
	<div class="main-tile">
		<tiles:insertAttribute name="main"/>
	</div>
</div>
</body>
</html>















