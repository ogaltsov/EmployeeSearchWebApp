<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />

    <title>Main Page</title>

    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" media="screen">


    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
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
                </div>

                <div class="one-half column-last alignright">

                </div>
            </div><!--end breadcrumbs-->
            <div class="double-separator"></div>
        </section>
    </div><!--end top-->

    <div class="centered-wrapper">


        <div class="three-fourth column-last">
            <ul id="team">
                <!---->
                <li class="team-member">
                    <div class="team-text">
                        <h3>Patrick Smith </h3>
                        <p style="font-size: 10pt">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Concordi fabricata ait regem Ardalio nos comitem in deinde cepit roseo ruens sed dominum oculos. Hanc nec caecatus dum est Apollonius.</p>
                    </div>
                </li><!--end team-member-->
                <!---->

                <li class="team-member">
                    <div class="team-text">
                        <h3>John Doe </h3>
                        <p style="font-size: 10pt">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Concordi fabricata ait regem Ardalio nos comitem in deinde cepit roseo ruens sed dominum oculos. Hanc nec caecatus dum est Apollonius.</p>
                    </div>
                </li><!--end team-member-->

                <li class="team-member">
                    <div class="team-text">
                        <h3>Kate Taylor </h3>
                        <p style="font-size: 10pt">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Concordi fabricata ait regem Ardalio nos comitem in deinde cepit roseo ruens sed dominum oculos. Hanc nec caecatus dum est Apollonius.</p>
                    </div>
                </li><!--end team-member-->

                <li class="team-member">
                    <div class="team-text">
                        <h3>Patrick Smith </h3>
                        <p style="font-size: 10pt">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Concordi fabricata ait regem Ardalio nos comitem in deinde cepit roseo ruens sed dominum oculos. Hanc nec caecatus dum est Apollonius.</p>
                    </div>
                </li><!--end team-member-->
                <!---->

            </ul>
        </div>

    </div><!--end centered-wrapper-->

    <div class="centered-wrapper">

        <footer id="footer">
            <div class="double-separator"></div>
            <div id="topfooter">
                <div class="one-fourth">
                    <h3>A Few Words About Us</h3>
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                </div><!--end one-fourth-->
                <div class="one-fourth">
                    <h3>Twitter Updates</h3>
                    <div class="tweet"></div>
                </div><!--end one-fourth-->
                <div class="one-fourth">
                    <h3>Flickr Inspiration</h3>
                    <ul id="flickr" class="thumbs"></ul>
                </div><!--end one-fourth-->
                <div class="one-fourth column-last">
                    <h3>Get in Touch with Us</h3>
                    <p>Address:
                        1600 Amphitheatre Parkway <br />
                        Mountain View, CA 94043</p>
                    <p>Phone: +321 123 456 7 </p>
                    <p>E-mail: <a href="mailto:">johndoe@ipsum.com</a><br />
                </div><!--end one-fourth-->
            </div><!--end topfooter-->

            <div id="bottomfooter">
                <div class="one-half">
                    <p>Copyright &copy; 2012 - Haze | All Rights Reserved</p>
                </div><!--end one-half-->

                <div class="one-half column-last">
                    <ul id="social">
                        <li><a class="rss" href="#">RSS Feed</a></li>
                        <li><a class="facebook" href="#">Facebook</a></li>
                        <li><a class="twitter" href="#">Twitter</a></li>
                        <li><a class="flickr" href="#">Flickr</a></li>
                        <li><a class="google" href="#">Google</a></li>

                        <!-- You can add social icons for forrst, dribbble, vimeo, linkedin and skype. Take the ones you need from the list and paste them above

                            <li><a class="forrst" href="#">Forrst</a></li>
                            <li><a class="dribbble" href="#">Dribbble</a></li>
                            <li><a class="vimeo" href="#">Vimeo</a></li>
                            <li><a class="linkedin" href="#">LinkedIn</a></li>
                            <li><a class="skype" href="#">Skype</a></li>
                        -->
                    </ul>
                </div><!--end one-half-->
                <a href="#" class="totop">scroll to top</a>
            </div><!--end bottomfooter-->
        </footer><!--end footer-->

    </div><!--end centered-wrapper-->
</div>
</body>
</html>