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
	<title>Dojo Details</title>
	</head>
	<body>
		<h1><c:out value="${foundedDojo.name}"></c:out> Ninjas:</h1>
		<div class="table">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">First Name</th>
			      <th scope="col">Last Name</th>
			      <th scope="col">Age</th>
			    </tr>
			  </thead>
			  <tbody>
				  <c:forEach items="${foundedDojo.ninjas}" var="ninja">
						 <tr>
						      <td><c:out value="${ninja.first_name}"></c:out></td>
						      <td><c:out value="${ninja.last_name}"></c:out></td>
						      <td><c:out value="${ninja.age}"></c:out></td>
					    </tr>
				  </c:forEach>					    
			  </tbody>
			</table>		
		</div>			
		
	</body>
</html>