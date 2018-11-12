<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<title>Login Page</title>
<link href="<c:url value="/css/login.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>	
	<div class="container" id="container-main">
		<div class="row">
			<div class="col-md-3 hidden-sm" ></div>
			<div class="col-md-6 col-xs-12 rect-box">
				<form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post" autocomplete="off">
					<div class="row title">
						<div class="col-md-12 col-xs-12 text-center"><spring:message code="login.title" /></div>
					</div>
					<br/>
					<div class="row">
						<div class="col-md-3 col-xs-12 " ><spring:message code="login.username" /></div>
						<div class="col-md-6 col-xs-12 " ><form:input path="userName" placeholder="User Name"
							 /><br><form:errors style="color:red" path="userName"/></div>						
					</div>
					<br/>
					<div class="row">
						<div class="col-md-3 col-xs-12 "><spring:message code="login.password" /></div>
						<div class="col-md-6 col-xs-12 "><form:password path="password" placeholder="Password" /><br><form:errors style="color:red" path="password" /><br/></div>
					</div>
					<c:if test="${not empty errorMessage }">
						<div class="row">
							<div class="col-md-12 col-xs-12 "><p class="error"><b>${errorMessage }</b></p></div>
						</div>
					</c:if>
					<br/>
					<div class="row">
						<div class="col-md-4 col-xs-6"></div>
						<div class="col-md-4 col-xs-12"><button type="submit">
							<spring:message code="login.signin" />
						</button></div>
					</div>
				</form:form>
			</div>
			
		</div>
	</div>
</body>
</html>
