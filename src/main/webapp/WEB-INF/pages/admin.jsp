<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <h1>Title : ${title}</h1>
    <p class="lead">Message : ${message}</p>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>Welcome : ${pageContext.request.userPrincipal.name}
        <%--| <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>--%>
    </h2>
</c:if>
</body>
</html>