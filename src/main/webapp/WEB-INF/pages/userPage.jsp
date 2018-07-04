<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />

    <title>Our Team- Haze</title>

    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css" media="screen">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <c:url value="/logout" var="logoutUrl" />
</head>

<body>
<div id="wrapper">
    <div id="top">
        <header id="header">
            <div class="one-fourth">
                <div class="logo"><a href="index.html"><img src="<c:url value="/resources/images/logo.png"/>" alt="" /></a></div>
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
                    <a href="index.html">Home</a>
                    <img src="images/breadcrumb-arrow.png" alt="" />
                    Our Team
                </div>

                <div class="one-half column-last alignright">

                </div>
            </div><!--end breadcrumbs-->
            <div class="double-separator"></div>
        </section>
    </div><!--end top-->

    <!-- csrt for log out-->
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>

    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>




    <div class="centered-wrapper">

        <div class="one-fourth">
            <aside>
                <div class="widget">
                    <ul>
                        <li><a href="javascript:formSubmit()">
                                LogOut
                            </a>
                        </li>
                        <%--<li><a href="team.html">Our Team</a></li>--%>
                        <%--<li><a href="pricing.html">Pricing Options</a></li>--%>
                        <%--<li><a href="faqs.html">FAQs</a></li>--%>
                    </ul>
                </div><!--end widget-->
            </aside><!--end aside-->
        </div><!--end one-third-->

        <div class="three-fourth column-last">
            <ul id="team">
                <li class="team-member">
                    <div class="team-details">
                        <img class="team-avatar" src="<c:url value="/resources/images/member.jpg"/>" alt="${pageContext.request.userPrincipal.name}" />
                    </div>
                    <div class="team-text">
                        <h2>${pageContext.request.userPrincipal.name}</h2>
                    </div>
                </li><!--end team-member-->



            </ul>

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