<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<%--For HttpOnly CSRF --%>
<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

<%-- For CookieCsrfTokenRepository.withHttpOnlyFalse() --%>
<input type="hidden" name="_csrf" value="${cookie['XSRF-TOKEN'].getValue()}" />

<%--For delete POST request --%>
<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<!-- ... -->

<body>

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>All Users</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>framework</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="user" items="${users}">
				<tr>
					<td>
						${user.id}
					</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td><c:forEach var="framework" items="${user.framework}" varStatus="loop">
						${framework}
    					<c:if test="${not loop.last}">,</c:if>
						</c:forEach></td>
					<td>
						<spring:url value="/users/${user.id}" var="userUrl" />
						<spring:url value="/users/${user.id}/delete" var="deleteUrl" /> 
						<spring:url value="/users/${user.id}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${userUrl}'">View</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<%@ include file="../common/footer.jspf"%>

</body>
<script>
    function post(path, params, method) {
        method = method || "post";

        var form = document.createElement("form");
        form.setAttribute("method", method);
        form.setAttribute("action", path);

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");


        for ( var key in params) {
            if (params.hasOwnProperty(key)) {
                var hiddenField = document.createElement("input");
                hiddenField.setAttribute("type", "hidden");
                hiddenField.setAttribute("name", key);
                hiddenField.setAttribute("value", params[key]);
                hiddenField.setAttribute("_csrf",token);
                form.appendChild(hiddenField);
            }
        }
        debugger
        document.body.appendChild(form);
        form.submit();
    }
</script>
</html>