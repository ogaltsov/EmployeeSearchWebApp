<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page session="false"%>
<html>
<body>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <h1>${title}</h1>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <p class="lead">${message}, Guest</p>
        <div align="center" class="form-inline">
            <form class="form" id="form" action="/corpsite.com/auth">
                <button button id="bth-search"
                        class="btn btn-lg btn-default">Log In</button>
            </form>
        </div>
    </c:if>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <p class="lead">${message}, ${pageContext.request.userPrincipal.name}</p>
    </c:if>


</body>
</html>
