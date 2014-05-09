<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>List of employees</title>
</head>
<body>
	<h3>List of employees</h3>

	<table border="1">
		<tr>
			<th></th>
			<th>Name</th>
			<th>Location</th>
		</tr>

		<c:forEach var="employee" items="${departmentList}" varStatus="status">
				<c:choose>
					<c:when test="${status.last}">
						<tr bgcolor="#0000FF">
					</c:when>
					
					<c:otherwise>
						<c:choose>	
							<c:when test="${status.index % 2 == 0}">
								<tr bgcolor="#00FF00">
							</c:when>
							
							<c:otherwise>
								<tr>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			


				<td>${status.index + 1}</td>
				<td>${employee.name}</td>
				<td>${employee.location}</td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>
