<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		
		<script src="<c:url value="/js/jquery-3.7.1.js" />"></script>
		<script src="<c:url value="/js/bootstrap.js" />"></script>
		<script src="<c:url value="/js/bootbox.all.js" />"/></script>

		<script src="<c:url value="/js/jquery.validate.js" />"></script>
		<script src="<c:url value="/js/localization/messages_es_AR.js" />"></script>
		
		<link rel="stylesheet" href="<c:url value="/css/bootstrap.css" />">
		<link rel="stylesheet" href="<c:url value="/css/general.css" />">
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">Sistema reclamos</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="/reclamos/listar">Listado de reclamos</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/reclamos/nuevo">Nuevo reclamos</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		
		<div class="container">
		<!-- inicio del contenido dinamico!!! -->
