<%--
  Created by IntelliJ IDEA.
  User: galtsowoleg
  Date: 24.06.18
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/ajaxRequestTableConstructor.js" />"></script>

</head>

<body>

<div class="page" align="center">
    <h1>Search for company employee</h1>
    <p class="lead">Enter information about employee and the search returns matches</p>
    <div align="center" class="form-inline">
        <form class="form" id="form">
            <input type=text class="form-control input-lg" id="firstName" placeholder="First name">
            <input type="text" class="form-control input-lg" id="secondName" placeholder="Second name">
            <input type="text" class="form-control input-lg" id="position" placeholder="Position">
            <input type="text" class="form-control input-lg" id="department" placeholder="Department">

            <button type="button" id="bth-search"
                    class="btn btn-lg btn-default"
                    onclick="return ajaxRequest('#tableBody')">Search</button>
        </form>
    </div>

    <div >
        <label id="msgInput" class="msgInput">You entered nothing!</label>
    </div>
    <div class="resultTableDiv" id="resultTableDiv">
        <table id="excelDataTable" class="table" border="0">
            <tbody id="tableBody">
            </tbody>
        </table>
    </div>

</div>
</body>
</html>

