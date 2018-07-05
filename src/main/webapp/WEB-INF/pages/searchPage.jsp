<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: galtsowoleg--%>
  <%--Date: 24.06.18--%>
  <%--Time: 16:14--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
    <%--<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">--%>
    <%--<link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">--%>
    <%--<script src="<c:url value="/resources/js/ajaxRequestTableConstructor.js" />"></script>--%>

<%--</head>--%>

<%--<body>--%>

<%--<div class="page" align="center">--%>
    <%--<h1>Search for company employee</h1>--%>
    <%--<p class="lead">Enter information about employee and the search returns matches</p>--%>
    <%--<div align="center" class="form-inline">--%>
        <%--<form class="form" id="form">--%>
            <%--<input type=text class="form-control input-lg" id="firstName" placeholder="First name">--%>
            <%--<input type="text" class="form-control input-lg" id="secondName" placeholder="Second name">--%>
            <%--<input type="text" class="form-control input-lg" id="position" placeholder="Position">--%>
            <%--<input type="text" class="form-control input-lg" id="department" placeholder="Department">--%>

            <%--<button type="button" id="bth-search"--%>
                    <%--class="btn btn-lg btn-default"--%>
                    <%--onclick="return ajaxRequest('#tableBody')">Search</button>--%>
        <%--</form>--%>
    <%--</div>--%>

    <%--<div >--%>
        <%--<label id="msgInput" class="msgInput">You entered nothing!</label>--%>
    <%--</div>--%>
    <%--<div class="resultTableDiv" id="resultTableDiv">--%>
        <%--<table id="excelDataTable" class="table" border="0">--%>
            <%--<tbody id="tableBody">--%>
            <%--</tbody>--%>
        <%--</table>--%>
    <%--</div>--%>

<%--</div>--%>
<%--</body>--%>
<%--</html>--%>







<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />

    <title>Main Page</title>

    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" media="screen">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/ajaxRequestTableConstructor.js" />"></script>
    <script src="<c:url value="/resources/js/custom.js"/>"></script>

    <style>
        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
            display: none;
        }
    </style>
</head>

<body>
<div class="pageContainer" id="wrapper">
    <div id="top">
        <header id="header">
            <div class="one-fourth">
                <div class="logo"><a href="/corpsite.com/"><img src="/resources/images/logo.png" alt="" /></a></div>
            </div><!--end one-fourth-->

            <div class="three-fourth column-last">
                <nav id="navigation">
                    <ul id="mainnav">
                        <li><a href="/corpsite.com/">MAIN</a></li>
                        <li><a href="/corpsite.com/">NEWS</a></li>
                        <li><a href="/corpsite.com/search/">EMPLOYEES</a></li>
                        <li><a href="/corpsite.com/">REQUESTS</a></li>
                        <li><a href="/corpsite.com/">CONTACTS</a></li>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <li><a class="current" href="/corpsite.com/user/">LOGIN</a></li>
                        </c:if>

                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li><a class="current" href="/corpsite.com/user/">
                                    ${pageContext.request.userPrincipal.name}
                            </a></li>
                        </c:if>
                    </ul>
                </nav><!--end navigation-->
            </div><!--end three-fourth-->
        </header>

        <section class="page-title">
            <div class="double-separator"></div>
            <div class="breadcrumbs">
                <div class="one-half alignleft">
                    <a href="/corpsite.com/">Home</a>
                </div>

                <div class="one-half column-last alignright">

                </div>
            </div><!--end breadcrumbs-->
            <div class="double-separator"></div>
        </section>
    </div><!--end top-->

    <div align="center" class="centered-wrapper">


        <div align="center" class="column-last">
            <div id="login-box" align="center">
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
                        <%--<label id="msgInput" class="msgInput">You entered nothing!</label>--%>
                        <div id="msgInput" class="error">You entered nothing!</div>
                    </div>
                    <div class="resultTableDiv" id="resultTableDiv">
                        <table id="excelDataTable" class="table" border="0">
                            <tbody id="tableBody">
                            </tbody>
                        </table>
                    </div>

                </div>



            </div>
        </div>

    </div><!--end centered-wrapper-->

    <div class="centered-wrapper">

        <footer id="footer">
            <div class="double-separator"></div>
        </footer><!--end footer-->

    </div><!--end centered-wrapper-->
</div>
</body>
</html>

