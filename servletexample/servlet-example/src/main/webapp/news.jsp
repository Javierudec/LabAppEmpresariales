<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Ejemplo 2</title></head>
<body>
	<form method="GET" action="latestnews">
		<div class="field">
			<label for="keywords">Title</label>
			<span class="entry">
				<input type="text" id="keywords" name="keywords"
					   value="<c:out value=""/>"
					   size="20" maxlength="255"/>
			</span>
		</div>
		<div class="button">
			<input type="submit" value="Search" />
		</div>
	</form>

	<c:if test="${!empty titles}">
		<table border="1">
		<tr><td>Title</td><td>Description</td></tr>
		<c:forEach var="title" items="${titles}" varStatus="loop">
			<tr><td><c:out value="${title}"/></td><td>${texts[loop.index]}</td></tr>
		</c:forEach>
		</table>
	</c:if>
</body>
</html>