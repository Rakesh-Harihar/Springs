<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainee Details</title>
</head>
<body>
	<jsp:include page="header_menu.jsp"></jsp:include>
	<script src="js/assign_trainee_validation.js"></script>
	<p class="form-title">Trainee Registration</p>
	<form:form action="submitTrainee?trainingId=${trainingId }"
		modelAttribute="trainee" autocomplete="off">
		<div class="container">
				
			<div class="row">
				
					<div class="col-md-2 col-xs-4" style="text-align: right;">Trainee Name</div>
					<div class="col-md-2 col-xs-4"><form:input path="name" value="" id="name"/>
								<form:errors style="color:red; font-size:12px;" path="name" />
						<div id="spnname" style="color: red; font-size:12px; text-align: center"></div></div>
					<div class="col-md-2 col-xs-4" style="text-align: right;">Employee ID</div>
					<div class="col-md-2 col-xs-4"><form:input path="employeeId" value="" id="employeeId"/>
								<form:errors style="color:red; font-size:12px;" path="employeeId" />
								<div id="spnid" style="color: red; font-size:12px; text-align: center"></div></div>
					<div class="col-md-2 col-xs-4" style="text-align: right;">Project</div>
					<div class="col-md-2 col-xs-4"><form:input path="project" value="" id="project"/>
								<form:errors style="color:red; font-size:12px;" path="project" />
								<div id="spnproject" style="color: red; text-align: center; font-size:12px;"></div></div>
			</div>	
			<br/>
			<div class="row">
			
				<div class="col-md-4 col-xs-12 text-right">
					
				</div>
				<div class="col-md-8 col-xs-12">
				<c:set var="role" value="${role }" />
				<c:if test="${role==1}">
				     <a href="viewTrainingRequestAll" Class="btn btn-info btn-md btn-size" >Back</a>
				</c:if>
				<c:if test="${role==2}">
				     <a href="viewTrainingRequest" Class="btn btn-info btn-md btn-size" >Back</a>
				</c:if>
				     <input Class="btn btn-primary btn-md btn-size" type="submit" value="Submit" id="traineevalidation"/>
					 <input Class="btn btn-warning btn-md btn-size" type="reset" value="Reset" />	 
				</div>			 
			</div>
			<br>
		</div>			
	</form:form>
	<table class="table">
		<tr>
			<th class="col-md-2 col-xs-1"></th>
			<th class="col-md-2 col-xs-1">Sl.No.</th>
			<th class="col-md-2 col-xs-1">Trainee Name</th>
			<th class="col-md-2 col-xs-2">Employee ID</th>
			<th class="col-md-2 col-xs-2">Project</th>
			<th class="col-md-2 col-xs-2"></th>
		</tr>
		<c:choose>
			<c:when test="${not empty trainees}">
				<c:forEach var="trainee" items="${trainees}" varStatus="serial">
					<tr>
					    <td class="col-md-2 col-xs-2 col-sm-2"></td>
					    <td class="col-md-2 col-xs-2 col-sm-2">${serial.count}</td>
						<td class="col-md-2 col-xs-2 col-sm-2">${trainee.name}</td>
						<td class="col-md-2 col-xs-2 col-sm-2">${trainee.employeeId}</td>
						<td class="col-md-2 col-xs-2 col-sm-2">${trainee.project}</td>
						<td class="col-md-2 col-xs-2 col-sm-2"></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<td>
					<center>No Data Found</center>
				</td>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>