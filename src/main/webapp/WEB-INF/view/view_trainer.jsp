
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainer Detail Form</title>
<link href="<c:url value="/css/vendor.css"/>" rel="stylesheet">
<script src="<c:url value="/js/search_plugin.js"/>"></script>
</head>
<body>

	<jsp:include page="header_menu.jsp"></jsp:include>
				
	<div class="row">

		<div class="col-md-10 col-md-offset-1 col-xs-12 col-sm-12 ">
			<p class="form-title">Trainer Details</p>
			<!-- vendor details -->
			<div class="details">
				<div class="row">
					<div class="col-md-2"><b>Vendor name:</b></div>
					<div class="col-md-2">${vendor.vendorName}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-1"><b>Address:</b></div>
					<div class="col-md-4">${vendor.address1 },${vendor.address2 },
						${vendor.city }, ${vendor.state }, ${vendor.pincode }.</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-1"><b>Mobile:</b></div>
					<div class="col-md-3">${vendor.mobile }</div>

					<div class="col-md-3"><b>Office
						Telephone:</b></div>
					<div class="col-md-2">${vendor.offtel }</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-4">
						<table>
							<caption><b>First Contact Person</b></caption>
							<tr>
								<th>Name :</th>
								<td>${vendor.name1 }</td>
							</tr>
							<tr>
								<th>Email :</th>
								<td>${vendor.email1 }</td>
							</tr>
							<tr>
								<th>Phone :</th>
								<td>${vendor.mobile1 }</td>
							</tr>
						</table>
					</div>
					<c:if test="${not empty vendor.name2 }">
						<div class="col-md-4 col-md-offset-2">
							<table>
								<caption><b>Second Contact Person</b></caption>
								<tr>
									<th>Name :</th>
									<td>${vendor.name2 }</td>
								</tr>
								<tr>
									<th>Email :</th>
									<td>${vendor.email2 }</td>
								</tr>
								<tr>
									<th>Phone :</th>
									<td>${vendor.mobile2 }</td>
								</tr>
							</table>
						</div>
					</c:if>
				</div>
			</div>
			<form action="viewVendorDetails">
				<input Class="btn btn-warning btn-md btn-size" type="submit" value="Back"/>		
			</form>
			<div class="row search" style="margin-top: 15px;">
				<input type="text" class="col-md-12" style="margin-left: 17px;"
					id="myInput" onkeyup="trainerSearch()"
					placeholder="Search for Trainer..." title="Type in a name">
			</div>
			<table id="myTable">
				<tr>
					<th class="col-md-1 col-xs-1">Sl No</th> 
					<th class="col-md-2 col-xs-2">Trainer Name</th>
					<th class="col-md-2 col-xs-2">Subject</th>
					<th class="col-md-2 col-xs-2">Phone</th>
					<th class="col-md-2 col-xs-2">Address</th>
					<th class="col-md-1 col-xs-1">TOC</th>
					<th class="col-md-1 col-xs-1">Profile</th>
					<th class="col-md-1 col-xs-1">Edit</th>
				</tr>
				<c:choose>
					<c:when test="${not empty trainerList }">
						<c:forEach var="trainer" items="${trainerList}" varStatus="serial">
							<tr>
								<td class="col-md-1 col-xs-1">${serial.count}</td> 
								<td class="col-md-2 col-xs-2 col-sm-2">${trainer.trainerName}</td>
								<td class="col-md-2 col-xs-2 col-sm-2">${trainer.subject}</td>
								<td class="col-md-2 col-xs-2 col-sm-2">${trainer.phone}</td>
								<td class="col-md-2 col-xs-2 col-sm-2">${trainer.address1}<br>${trainer.address2}<br>${trainer.city}<br>${trainer.state}<br>${trainer.pincode}</td>
								<td class="col-md-1 col-xs-1 col-sm-2">
									<c:choose>
										<c:when test="${not empty trainer.tableOfContent}">
											<a href="data:application/pdf;base64,${trainer.tableOfContent}"
												download='${trainer.tocFileName}' title='${trainer.tocFileName}'>
												<button type="button" class="btn btn-default btn-sm">
													<span class="glyphicon glyphicon-download-alt"></span>
												</button>
											</a>
										</c:when>
										<c:otherwise>
            								<button type="button" class="btn btn-default btn-sm" disabled>
												<span class="glyphicon glyphicon-download-alt"></span>
											</button>
         								</c:otherwise>
									</c:choose>
								</td>
								<td class="col-md-1 col-xs-1 col-sm-2">
									<c:choose>
										<c:when test="${not empty trainer.trainerProfile}">
											<a href="data:application/pdf;base64,${trainer.trainerProfile}"
												download='${trainer.profileFileName}' title='${trainer.profileFileName}'>
												<button type="button" class="btn btn-default btn-sm">
													<span class="glyphicon glyphicon-download-alt"></span>
												</button>
											</a>
										</c:when>
										<c:otherwise>
											<button type="button" class="btn btn-default btn-sm" disabled>
												<span class="glyphicon glyphicon-download-alt"></span>
											</button>
            								
         								</c:otherwise>
									</c:choose>
								</td>
								<td class="col-md-1 col-xs-1 col-sm-2">
									<a href="editTrainer?vendorId=${vendor.vendorId }&trainerId=${trainer.trainerId}">
										<button type="button" class="btn btn-default btn-sm">
          									<span class="glyphicon glyphicon-edit"></span> Edit
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
</body>
</html>