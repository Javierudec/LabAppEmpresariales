<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Add a new employee</title>
	</head>
	<body>
		<h3>Add a new employee</h3>
		
		<form:form action="addDepartment" modelAttribute="department">
			<div><form:input path="name"/></div>
			<div><form:input path="location"/></div>
			<div><input type="submit" value="Add"/></div>
		</form:form>		
		
	</body>
</html>
