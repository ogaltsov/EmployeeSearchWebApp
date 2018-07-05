<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />

    <title>Main Page</title>

    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" media="screen">


    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/ajaxRequestNews.js" />"></script>
    <script src="<c:url value="/resources/js/custom.js"/>"></script>

</head>

<body>
<div id="wrapper">
    <div id="top">
        <header id="header">
            <div class="one-fourth">
                <div class="logo"><a href="index.html"><img src="images/logo.png" alt="" /></a></div>
            </div><!--end one-fourth-->

            <div class="three-fourth column-last">
                <nav id="navigation">
                    <ul id="mainnav">
                        <li><a href="/corpsite.com/">MAIN</a></li>
                        <li><a href="">NEWS</a></li>
                        <li><a href="/corpsite.com/search/">EMPLOYEES</a></li>
                        <li><a href="">REQUESTS</a></li>
                        <li><a href="">CONTACTS</a></li>
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
                    <a href="index.html">Home</a>
                </div>

                <div class="one-half column-last alignright">

                </div>
            </div><!--end breadcrumbs-->
            <div class="double-separator"></div>
        </section>
    </div><!--end top-->

    <div class="centered-wrapper">
        <%--==================      NEWS START      ========================================--%>
        <%--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++--%>
        <div class="three-fourth column-last">
            <ul id="team">

                <!---->
                <li class="team-member">
                    <div class="team-text">
                        <h3 id="newsTitle0"></h3>
                        <p id="newsText0" style="font-size: 10pt"></p>
                    </div>
                </li><!--end team-member-->
                <!---->

                <li class="team-member">
                    <div class="team-text">
                        <h3 id="newsTitle1"></h3>
                        <p id="newsText1" style="font-size: 10pt"></p>
                    </div>
                </li><!--end team-member-->

                <li class="team-member">
                <div class="team-text">
                    <h3 id="newsTitle2"></h3>
                    <p id="newsText2" style="font-size: 10pt"></p>
                </div>
                </li><!--end team-member-->

                <li class="team-member">
                    <div class="team-text">
                        <h3 id="newsTitle3"></h3>
                        <p id="newsText3" style="font-size: 10pt"></p>
                    </div>
                </li><!--end team-member-->

                <li class="team-member">
                    <div class="team-text">
                        <h3 id="newsTitle4"></h3>
                        <p id="newsText4" style="font-size: 10pt"></p>
                    </div>
                </li><!--end team-member-->
                <!---->

            </ul>
        </div>
        <%--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++--%>
    </div><!--end centered-wrapper-->

    <div class="centered-wrapper">

        <footer id="footer">
            <div class="double-separator"></div>
        </footer>



    </div><!--end centered-wrapper-->
</div>
</body>
</html>