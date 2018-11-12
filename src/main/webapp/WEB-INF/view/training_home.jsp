<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home Page</title>
<jsp:include page="header_menu.jsp"></jsp:include>

<style>
@media screen and (max-width: 500px) {
	.img {
		width: 300;
		height: 350;
	}
}

@media screen and (min-width: 500px) {
	.img {
		display: block;
		margin-left: auto;
		margin-right: auto;
		width: 500;
		height: 550;
	}
}
</style>
</head>
<br>
<br>
<body>
	<div class="container">
		<div class="row">
			<img src="<c:url value="/images/training-home.png" />" class="img" />
		</div>
	</div>
</body>