<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<title>Vendor Details</title>
<link href="<c:url value="/css/vendor.css"/>" rel="stylesheet">
<script src="<c:url value="/js/search_plugin.js"/>"></script>
</head>
<body>
	<jsp:include page="header_menu.jsp"></jsp:include>
	<c:if test="${not empty errorMessage }">
						<div class="row">
							<div class="col-md-7 col-xs-12 " style="color:red;">${errorMessage }</div>
						</div>
					</c:if>
	<c:if test="${empty errorMessage }">			
	<div class="row">
	<div  class="col-md-8 col-md-offset-2 col-xs-8 col-sm-8 ">
	<p class="form-title">Vendor Details</p>
	<div class="row search" style="margin-top: 15px;">
		<input  type="text" style="margin-left: 17px;" 
			class="col-md-12"
			id="myInput" onkeyup="vendorSearch()" placeholder="Search for vendor..."
			title="Type in a name">
	</div>
	
	<table id="myTable">
		<tr class="header">
			<th class="col-md-1 col-xs-1">Sl No</th>
			<th class="col-md-2 col-xs-2">Vendor Name</th>
			<th class="col-md-2 col-xs-2">City</th>
			<th class="col-md-2 col-xs-2">Phone</th>
			<th class="col-md-1 col-xs-2"></th>
			<th class="col-md-1 col-xs-2"></th>
		</tr>
		<c:choose>
			<c:when test="${not empty vendorList}">
				<c:forEach var="vendor" items="${vendorList}" varStatus="serial">
					<tr>
						<td class="col-md-1 col-xs-2 col-sm-1">${serial.count}</td>
						<td class="col-md-2 col-xs-2 col-sm-2">${vendor.vendorName}</td>
						<td class="col-md-2 col-xs-2 col-sm-2">${vendor.city}, ${vendor.state}</td>
						<td class="col-md-2 col-xs-2 col-sm-2">${vendor.mobile}</td>
						<td class="col-md-1 col-xs-2 col-sm-2">
						<a href="editVendor?vendorId=${vendor.vendorId}">
							<button type="button" class="btn btn-default btn-sm">
          						<span class="glyphicon glyphicon-edit"></span> Edit
        					</button>
						</a></td>
						<td class="col-md-1 col-xs-2 col-sm-2">
							<a href="viewTrainerList?vendorId=${vendor.vendorId}">
							 	<button type="button" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-user"></span> Trainer
								</button>
							</a>
						</td>
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
	</div>
	</div>
	</c:if>
</body>
</html>