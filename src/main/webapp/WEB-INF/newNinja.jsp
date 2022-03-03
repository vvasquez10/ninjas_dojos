<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formato (fechas) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>New Ninja</title>
	</head>
	<body>
		<h1>New Ninja</h1>
		<form:form action="/ninjas/createNinja" method="POST" modelAttribute="ninja">
			<div>
			<form:label path="dojo" for="dojo">Pick a dojo:</form:label>
            <form:select class="custom-select" path="dojo" name="dojo" id="dojo">
             	<c:forEach items="${allDojos}" var="variable">
					<option value="${variable.dojo_id}">${variable.name}</option>          
				</c:forEach>
             </form:select>
             <form:errors path="dojo"/>             
            </div>
            
			<form:label path="first_name" for="first_name">First Name:</form:label>
			<form:input path="first_name" class="form-control" type="text" name="first_name" id="first_name" required="True"/>
			<form:errors path="first_name"/>
			
			<form:label path="last_name" for="last_name">Last Name:</form:label>
			<form:input path="last_name" class="form-control" type="text" name="last_name" id="last_name" required="True"/>
			<form:errors path="last_name"/>
			
			<form:label path="age" for="age">Age:</form:label>
			<form:input path="age" class="form-control" type="number" name="age" id="age" required="True"/>
			<form:errors path="age"/>
			
			<button type="submit">Create Ninja</button>		
		</form:form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</body>
</html>