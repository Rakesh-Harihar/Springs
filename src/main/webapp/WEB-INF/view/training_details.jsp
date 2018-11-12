<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Details</title>
<meta charset="utf-8">
<link href="<c:url value="/css/vendor.css"/>" rel="stylesheet">
<script src="<c:url value="/js/search_plugin.js"/>"></script>
</head>
<body>

	<jsp:include page="header_menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-md-offset-0 col-xs-8 col-sm-8 ">
				<p class="form-title">Training Details</p>
				<div class="row search" style="margin-top: 15px;">
					<input type="text" class="col-md-12" style="margin-left: 17px;"
						id="myInput" onkeyup="trainingSearch()"
						placeholder="Search for Topic..." title="Type in a name">
				</div>
				<table id="myTable">
					<tr>
						<th class="col-md-2 col-xs-2">Sl.No.</th>
						<th class="col-md-2 col-xs-2">Topic</th>
						<th class="col-md-2 col-xs-2">Requested By</th>
						<th class="col-md-2 col-xs-2">Start Date</th>
						<th class="col-md-2 col-xs-2">End Date</th>
						<th class="col-md-2 col-xs-2"></th>
					</tr>
					<c:choose>
						<c:when test="${not empty trainingDetails}">
							<c:forEach var="training" items="${trainingDetails}"
								varStatus="trainingCount">
								<tr>
									<td>${trainingCount.count}</td>
									<td>${training.topic}</td>
									<td>${training.createdBy}</td>
									<td>${training.startDate}</td>
									<td>${training.endDate}</td>
									<td>
										<a href="viewTrainingDetials?trainingId=${training.trainingId }">
											
											<button type="button" class="btn btn-outline-info"> 
										<span class="glyphicon glyphicon-th"></span> Detail
									</button>
										</a>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<td>
								<h3>No Data Found</h3>
							</td>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</div>
	</div>
</body>
</html>