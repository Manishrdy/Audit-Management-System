<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<title>Project Details</title>
<style>
body {
	background-color:#D8D8D8;
}

</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Audit Management System.</a>

		<div class="collapse navbar-collapse" id="navbarText"></div>
        <ul class="nav navbar-nav my-2 my-lg-0">
            <li class="nav-item"><a class="nav-link" href="/logout"><i class="fas fa-user"></i>Logout</a></li>
       </ul>
	</nav>
	<div class="container">
       
		<h1 class="m-5 text-center display-4">Project Details</h1>

		<form id="projectDetails" class="px-5 py-4 border rounded" action="/AuditCheckListQuestions" method="post">

			<div class="form-group">
				<label for="projectName">Project Name</label>
				<input id="ProjectName" name="projectName" class="form-control" required="required" type="text" value=""/>

			</div>
			<div class="form-group">
				<label for="projectManagerName">Project Manager Name</label>
				<input id="ProjectManagerName" name="projectManagerName" class="form-control" required="required" type="text" value=""/>
			</div>
			<div class="form-group">
				<label for="applicationOwnerName">Application Owner</label>
				<input id="ApplicationOwnerName" name="applicationOwnerName" class="form-control" required="required" type="text" value=""/>
			</div>

			<div class="form-group">
				<label for="AuditType">Audit Type</label>
				<form id="auditType" action="/home" method="post">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<input id="internal" name="auditType" name="audittype" required="required" aria-label="Radio button for following text input" type="radio" value="Internal"/>
							</div>
						</div>
						<label for="Internal" class="form-control"> Internal</label>
						<div class="input-group-prepend">
							<div class="input-group-text">
								<input id="sox" name="auditType" name="audittype" aria-label="Radio button for following text input" type="radio" value="SOX"/>
							</div>
						</div>
						<label for="SOX" class="form-control"> SOX</label>
					</div>
					<input type="submit" class="btn btn-primary btn-block mt-3"
						value="Submit">
				</form>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
		integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
		crossorigin="anonymous"></script>
</body>
</html>