<%@page import="com.valtech.trainingprocess.vendor.model.Vendor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Vendor Details</title>
<style type="text/css">
	
	.error{
		font-size: 12px;
	}
	
</style>
</head>
<body>
	<c:set var="url" scope="request" />
	<c:if test="${vendor.vendorId != 0 }">
		<c:set var="url"
			value="updateVendorDetail"
			scope="request" />
	</c:if>
	<c:if test="${vendor.vendorId == 0 }">
		<c:set var="url" value="saveVendor" scope="request" />
	</c:if>
	<jsp:include page="header_menu.jsp"></jsp:include>
	
	<div class="container">

		<div class="row">
			<div class="hidden-sm hidden-xs col-md-4"></div>
			<div class="col-sm-12 col-md-4">
			
			<c:if test="${vendor.vendorId != 0 }">
				<p class="form-title">Vendor Modification</p>
			</c:if>
			<c:if test="${vendor.vendorId == 0 }">
				<p class="form-title">Vendor Registration</p>
			</c:if>

				<c:if test="${not empty errorMessage }">
					<div class="row">
						<div class="col-md-12 col-xs-12">
							<p class="error">
								<b>${errorMessage }</b>
							</p>
						</div>
					</div>
				</c:if>
				<form:form action="${url}" modelAttribute="vendor" autocomplete="off">
					<div class="row">
						<div class="col-md-4 col-xs-12">Vendor name</div>
						<div class="col-md-8 col-xs-12">
							<form:input value="${vendor.vendorName}" path="vendorName" />
							<br />
							<form:errors class="error" path="vendorName" />
						</div>
					</div>
					<div id="spnvendorName" style="color: red; text-align: center"></div>
					<br />
					<form:input type="hidden" path="vendorId"/>
					<div class="row">
						<div class="col-md-4 col-xs-12">Address1</div>
						<div class="col-md-8 col-xs-12">
							<form:input value="${vendor.address1}" path="address1" />
							<br />
							<form:errors class="error" path="address1" />
						</div>
					</div>
					<div id="spnaddress1" style="color: red; text-align: center"></div>
					<br />
					
					<div class="row">
						<div class="col-md-4 col-xs-12">Address2</div>
						<div class="col-md-8 col-xs-12">
							<form:input value="${vendor.address2}" path="address2" />
							<br />
						</div>
					</div>
					<div id="spnaddress2" style="color: red; text-align: center"></div>
					<br />

					<div class="row">
						<div class="col-md-4 col-xs-12">City</div>
						<div class="col-md-8 col-xs-12">
							<form:input value="${vendor.city}" path="city" />
							<br />
							<form:errors class="error" path="city" />
						</div>
					</div>
					<div id="spncity" style="color: red; text-align: center"></div>
					<br />

					<div class="row">
						<div class="col-md-4 col-xs-12">State</div>
						<div class="col-md-8 col-xs-12">
							<form:input value="${vendor.state}" path="state" />
							<br />
							<form:errors class="error" path="state" />
						</div>
					</div>
					<div id="spnstate" style="color: red; text-align: center"></div>
					<br />

					<div class="row">
						<div class="col-md-4 col-xs-12">Pincode</div>
						<div class="col-md-4 col-xs-12">
							<form:input value="${vendor.pincode}" path="pincode" />
							<br />
							<form:errors class="error" path="pincode" />
						</div>
					</div>
					<div id="spnpincode" style="color: red; text-align: center"></div>
					<br />

					<div class="row">
						<div class="col-md-4 col-xs-12">Mobile</div>
						<div class="col-md-8 col-xs-12">
							<form:input value="${vendor.mobile}" path="mobile" />
							<br />
							<form:errors class="error" path="mobile" />
						</div>
					</div>
					<div id="spnmobile" style="color: red; text-align: center"></div>
					<br />

					<div class="row">
						<div class="col-md-4 col-xs-12">Office Telephone</div>
						<div class="col-md-4 col-xs-12">
							<form:input value="${vendor.offtel}" path="offtel" />
						</div>
					</div>
					<br />
					
					<div class="row">
						<div class="col-md-4 col-xs-12">Email</div>
						<div class="col-md-8 col-xs-12">
							<form:input value="${vendor.email}" path="email" />
							<br />
							<form:errors class="error" path="email" />
						</div>
					</div>
					<div id="spnemail" style="color: red; text-align: center"></div>
					<br />
					
					
					<div class="row">
						<div class="col-md-4 col-xs-12">Alternate Email</div>
						<div class="col-md-4 col-xs-12">
							<form:input value="${vendor.altemail}" path="altemail" />
						</div>
					</div>
					<br />

					<div class="row" style="border-style: outset;">
						<div class="row">
							<div class="col-md-12 col-xs-12 text-center">
								<strong>First Contact Person</strong>
							</div>
							<div class="col-md-4 col-xs-12">Name</div>
							<div class="col-md-4 col-xs-12">
								<form:input value="${vendor.name1}" path="name1" />
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-4 col-xs-12">Email</div>
							<div class="col-md-4 col-xs-12">
								<form:input value="${vendor.email1}" path="email1" />
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-4 col-xs-12">Mobile</div>
							<div class="col-md-4 col-xs-12">
								<form:input value="${vendor.mobile1}" path="mobile1" />
							</div>
						</div>
						<br />
					</div>
					<br />
					<div class="row" style="border-style: outset;">
						<div class="row">
							<div class="col-md-12 col-xs-12 text-center">
								<strong>Second Contact Person</strong>
							</div>
							<div class="col-md-4 col-xs-12">Name</div>
							<div class="col-md-4 col-xs-12">
								<form:input value="${vendor.name2}" path="name2" />
							</div>
						</div>

						<br />
						<div class="row">
							<div class="col-md-4 col-xs-12">Email</div>
							<div class="col-md-4 col-xs-12">
								<form:input value="${vendor.email2}" path="email2" />
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-4 col-xs-12">Mobile</div>
							<div class="col-md-4 col-xs-12">
								<form:input value="${vendor.mobile2}" path="mobile2" />
							</div>
						</div>
						<br />
					</div>
					<br />
                 
					<div class="row">
						<div class="col-md-4 col-xs-12"></div>
						<c:if test="${vendor.vendorId !=0 }">
							<div class="col-md-4 col-xs-12">
								<a href="viewVendorDetails">
							 		<button type="button" class="btn btn-warning btn-md btn-size">
										back
									</button>
								</a>
							</div>
							<div class="col-md-4 col-xs-12">
								<input Class="btn btn-primary btn-md btn-size" type="submit"
									value="Update" id="update" />
							</div>
						</c:if>
						<c:if test="${vendor.vendorId == 0 }">
							<div class="col-md-4 col-xs-12">
								<input Class="btn btn-primary btn-md btn-size" type="submit"
									value="Submit" />
							</div>
							<div class="col-md-4 col-xs-12">
								<input Class="btn btn-warning btn-md btn-size" type="reset"
									value="Reset" />
							</div>
						</c:if>
					</div>
					<br>
					<br>
						<div class="col-md-4  col-xs-4 hidden-xs hidden-sm"></div>
             		</form:form>
			</div>
		</div>
	</div>
</body>
</html>
