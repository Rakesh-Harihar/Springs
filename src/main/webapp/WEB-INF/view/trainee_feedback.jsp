<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Feedback form</title>
</head>
<body>
	<jsp:include page="header_menu.jsp"></jsp:include>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8">
				<div class="col-md-12 col-xs-12 text-center">
					<p class="form-title">Trainee Feedback</p>
				</div>
			</div>
			<br /> <br /> <br /> <br /> <br />
			<div class="col-md-2"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>

			<div class="col-md-4">
				<div class="col-md-6">
					<strong>Employee id:</strong>
				</div>
				<div class="col-md-6">
					<input type="text" size="15" />
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-4">
				<div class="col-md-6">
					<strong>Name of the participant:</strong>
				</div>
				<div class="col-md-6">
					<input type="text" size="15" />
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-4">
				<div class="col-md-6">
					<strong>Name of the course:</strong>
				</div>
				<div class="col-md-6">
					<input type="text" size="15" />
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-4">
				<div class="col-md-6">
					<strong>Name of the faculty:</strong>
				</div>
				<div class="col-md-6">
					<input type="text" size="15" />
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-1"></div>

			<div class="col-md-4">
				<div class="col-md-6">
					<strong>Course Start Date:</strong>
				</div>
				<div class="col-md-6">
					<input type="text" size="15" />
				</div>
			</div>
			<div class="col-md-1"></div>

			<div class="col-md-4">
				<div class="col-md-6">
					<strong>Course End Date:</strong>
				</div>
				<div class="col-md-6">
					<input type="text" size="15" />
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<strong> Kindly rate the following attributes on a scale of
					1-5 where 5 stands for the best and 1 for the least satisfaction </strong>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
	<br />
	<div class="row" style="margin-left: 0px;">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<strong> Rating Scale: </strong>
		</div>
		<br />
		<div class="row">
			<div class="col-md-1"></div>

			<div class="col-md-8" style="border-style: ridge;">
				<div class="col-md-2">
				1 - Poor
				</div>
				<div class="col-md-2">
				2 - Average
				</div>
				<div class="col-md-2">
				3 - Good
				</div>
				<div class="col-md-2">
				4 - Very Good
				</div>
				<div class="col-md-2">
				5 - Excellent
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="col-md-1"></div>
	</div>
	<br />
	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-4" style="border-style: ridge;">
			<div class="col-md-12 col-xs-12 text-center">
				<strong>Program</strong>
			</div>

			<br /> <br />
			<div class="row row-margin">
				<div class="col-md-8">Methodology</div>
				<div class="col-md-4">
					<input type="text" size="1" />
				</div>
			</div>
			<div class="row row-margin">
				<div class="col-md-8">Time Allotted</div>
				<div class="col-md-4">
					<input type="text" size="1" />
				</div>
			</div>
			<div class="row row-margin">
				<div class="col-md-8">Objectives Met</div>
				<div class="col-md-4">
					<input type="text" size="1" />
				</div>
			</div>
			<div class="row row-margin">
				<div class="col-md-8">Exercises, Quizzes, Tests used for
					assessments</div>
				<div class="col-md-4">
					<input type="text" size="1" />
				</div>
			</div>
			<div class="row row-margin">
				<div class="col-md-8">Average of the above Rating</div>
				<div class="col-md-4">
					<input type="text" size="1" />
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-4" style="border-style: ridge;">
			<div class="col-md-12 col-xs-12 text-center">
				<strong>Classroom Environment</strong>
			</div>
			<br /> <br />
			<div class="row" style="margin-left: 5px;">
				<div class="row row-margin">
					<div class="col-md-8">Seating arrangement</div>
					<div class="col-md-4">
						<input type="text" size="1">
					</div>
				</div>

				<div class="row row-margin">
					<div class="col-md-8">Computer Equipments</div>
					<div class="col-md-4">
						<input type="text" size="1">
					</div>
				</div>
				<div class="row row-margin">
					<div class="col-md-8">Audio-Visual Equipments</div>
					<div class="col-md-4">
						<input type="text" size="1">
					</div>
				</div>
				<div class="row row-margin">
					<div class="col-md-8">Average of the above Rating</div>
					<div class="col-md-4">
						<input type="text" size="1">
					</div>
				</div>
				<div class="row row-margin">
					<div class="col-md-8">Average of the above Rating</div>
					<div class="col-md-4">
						<input type="text" size="1">
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-4" style="border-style: ridge;">
			<div class="col-md-12 col-xs-12 text-center">
				<strong>Course Content </strong>
			</div>
			<br /> <br />

			<div class="row row-margin">
				<div class="col-md-8">Content</div>
				<div class="col-md-4">
					<input type="text" size="1">
				</div>
			</div>
			<div class="row row-margin">
				<div class="col-md-8">Coverage</div>
				<div class="col-md-4">
					<input type="text" size="1">
				</div>
			</div>
			<div class="row row-margin">
				<div class="col-md-8">Average of the above Rating</div>
				<div class="col-md-4">
					<input type="text" size="1">
				</div>
			</div>
			<br />
		</div>
		<div class="col-md-1"></div>

		<div class="col-md-4" style="border-style: ridge;">
			<div class="col-md-12 col-xs-12 text-center">
				<strong> Faculty </strong>
			</div>
			<br /> <br />
			<div class="row" style="margin-left: 5px;">

				<div class="row row-margin">
					<div class="col-md-8">Subject Knowledge</div>
					<div class="col-md-4">
						<input type="text" size="1">
					</div>
				</div>
				<div class="row row-margin">
					<div class="col-md-8">Articulation and Presentation</div>
					<div class="col-md-4">
						<input type="text" size="1">
					</div>
				</div>
				<div class="row row-margin">
					<div class="col-md-8">Punctuality</div>
					<div class="col-md-4">
						<input type="text" size="1">
					</div>
				</div>
				<div class="row row-margin">
					<div class="col-md-8">Involvement and Degree of interaction</div>
					<div class="col-md-4">
						<input type="text" size="1">
					</div>
				</div>
				<div class="row row-margin">
					<div class="col-md-8">Focus on the Subject</div>
					<div class="col-md-4">
						<input type="text" size="1">
					</div>
				</div>
				<div class="row row-margin">
					<div class="col-md-8">Average of the above Rating</div>
					<div class="col-md-4">
						<input type="text" size="1">
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
		<br /> <br /> <br /> <br /> <br />

		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<strong>Overall comments:</strong>
			</div>
			<div class="col-md-3"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<textarea rows="4" cols="100" name="comment"></textarea>
			</div>

			<div class="col-md-1"></div>
		</div>
		<br />
		<div class="row ">
			<div class="col-md-4"></div>
			<div class="col-md-2">
				<input Class="btn btn-primary btn-md btn-size" type="submit" value="Submit" />
			</div>
			<div class="col-md-2">
				<input Class="btn btn-warning btn-md btn-size" type="reset" value="Reset" />
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>