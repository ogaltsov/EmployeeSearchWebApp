<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport"    content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author"      content="Oleg Galtsov">

    <title>Search for company employees</title>

    <!-- Bootstrap itself -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="page" align="center">
    <h1>Search for company employees</h1>
    <p class="lead">Enter information about employee and the search returns matches</p>
    <div align="center" class="form-inline">
        <spring:form modelAttribute="searchQuery" method="get" action="/HibernateStudy-1.0-SNAPSHOT/search/check">
            <p><spring:input path="firstName" placeholder="First name"
                             type="text" class="form-control input-lg" size="45"/></p>
            <p><spring:input path="secondName" placeholder="Second name"
                             type="text" class="form-control input-lg" size="45"/></p>
            <p><spring:input path="position" placeholder="Position"
                             type="text" class="form-control input-lg" size="45"/></p>
            <p><spring:input path="department" placeholder="Department"
                             type="text" class="form-control input-lg" size="45"/></p>
            <p><spring:button class="btn btn-lg btn-default">Check</spring:button></p>
        </spring:form>
    </div>
</div>
</body>
</html>