<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<body>

	<div class="container">

		<h1>Error Page</h1>

		<p>${exception.message}</p>
		<!-- Exception: ${exception.message}.
		  	<c:forEach items="${exception.stackTrace}" var="stackTrace"> 
				${stackTrace} 
			</c:forEach>
	  	-->

	</div>

	<%@ include file="common/footer.jspf"%>

</body>
</html>