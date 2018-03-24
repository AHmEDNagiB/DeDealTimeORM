<%-- 
    Document   : userProfileControlPanel
    Created on : Feb 27, 2018, 6:13:03 PM
    Author     : Ahmed_Mokhtar
--%>

<%@page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="robots" content="all,follow">
        <meta name="googlebot" content="index,follow,snippet,archive">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Obaju e-commerce template">
        <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
        <meta name="keywords" content="">

        <title>
            User Profile Control
        </title>

        <meta name="keywords" content="">

        <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

        <!-- styles -->
        <link href="res/css/font-awesome.css" rel="stylesheet">
        <link href="res/css/bootstrap.min.css" rel="stylesheet">
        <link href="res/css/animate.min.css" rel="stylesheet">
        <link href="res/css/owl.carousel.css" rel="stylesheet">
        <link href="res/css/owl.theme.css" rel="stylesheet">

        <!-- theme stylesheet -->
        <link href="res/css/style.default.css" rel="stylesheet" id="theme-stylesheet">

        <!-- your stylesheet with modifications -->
        <link href="res/css/custom.css" rel="stylesheet">

        <script src="res/js/respond.min.js"></script>

        <link rel="shortcut icon" href="favicon.png">

    </head>

    <body>
        <!-- *** TOPBAR ***
     _________________________________________________________ -->
        <div id="top">
            <div class="container">
                <div class="col-md-6 offer" data-animate="fadeInDown">
                    <!--<a href="#" class="btn btn-success btn-sm" data-animate-hover="shake">Offer of the day</a>  <a href="#">Get flat 35% off on orders over $50!</a>-->
                </div>
                <div class="col-md-6" >
                    <c:if test="${not empty sessionScope.loggedInUser}">
                        <ul class="menu">
                            <li><a href="userProfile" ><c:out value="${sessionScope.loggedInUser.getAdminFirstName()}"/></a>
                            </li>
                            
                        </ul>                    </c:if>
                    <c:if test="${empty sessionScope.loggedInUser}">
                        <ul class="menu">
                            <li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                            </li>
                            <li><a href="register">Register</a>
                            </li>
                        </ul>
                    </c:if>

                </div>
            </div>
<!--            <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
                <div class="modal-dialog modal-sm">

                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="Login">Customer login</h4>
                        </div>
                        <div class="modal-body">
                            <form action="login" method="post">
                                <div class="form-group">
                                    <input name="email" type="text" class="form-control" id="email-modal" placeholder="email">
                                </div>
                                <div class="form-group">
                                    <input name="password" type="password" class="form-control" id="password-modal" placeholder="password">
                                </div>

                                <p class="text-center">
                                    <button class="btn btn-primary"><i class="fa fa-sign-in"></i> Log in</button>
                                </p>

                            </form>

                            <p class="text-center text-muted">Not registered yet?</p>
                            <p class="text-center text-muted"><a href="register.html"><strong>Register now</strong></a>! It is easy and done in 1&nbsp;minute and gives you access to special discounts and much more!</p>

                        </div>
                    </div>
                </div>
            </div>-->
        </div>

        <!-- *** TOP BAR END *** -->

        <!-- *** NAVBAR ***
     _________________________________________________________ -->

        <div class="navbar navbar-default yamm" role="navigation" id="navbar">
            <div class="container">
                <div class="navbar-header">

                    <a class="navbar-brand home"  data-animate-hover="bounce">
                        <img src="res/img/dealtime_logo.png" alt="Obaju logo" class="hidden-xs">
                        <img src="res/img/dealtime_logo-small.png" alt="Obaju logo" class="visible-xs"><span class="sr-only">DealTime homepage</span>
                    </a>
<!--                    <div class="navbar-buttons">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation">
                            <span class="sr-only">Toggle navigation</span>
                            <i class="fa fa-align-justify"></i>
                        </button>
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#search">
                            <span class="sr-only">Toggle search</span>
                            <i class="fa fa-search"></i>
                        </button>
                        <%--<c:if test="${not empty sessionScope.loggedInUser}">--%>
                            <a class="btn btn-default navbar-toggle" href="basket.html">
                                <i class="fa fa-shopping-cart"></i>  <span class="hidden-xs"> items in cart</span>
                            </a>

                        <%--</c:if>--%>
                    </div>-->
                </div>
                <!--/.navbar-header -->

<!--                <div class="navbar-collapse collapse" id="navigation">

                    <ul class="nav navbar-nav navbar-left">
                        <li class="active"><a href="dealTime?page=1">Home</a>
                        </li>
                        <li class="dropdown yamm-fw">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">Categories <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <div class="yamm-content">
                                        <div class="row">
                                            <h5>All Categories</h5>
                                            <%--<c:forEach begin="1" end="${AllproductsNumber}" step="5" varStatus="loop">--%>
                                            <div >
                                                <ul>
                                                    <c:forEach items="${Allcategories}" var="categories">
                                                        <li class="col-sm-3"><a href="category?cat=${categories.categoryName}">${categories.categoryName}</a>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                     /.yamm-content 
                                </li>
                            </ul>
                        </li>

                    </ul>

                </div>
                /.nav-collapse -->

                <div class="navbar-buttons">
                    
                    <!--/.nav-collapse -->

                   
                </div>

                <div class="collapse clearfix" id="search">

                    <form class="navbar-form" role="search" action="productSearch" method="get">
                        <div class="input-group">
                            <input type="text" id="searchInput" name="searchInput" class="form-control" placeholder="Search">
                            <span class="input-group-btn">

                                <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>

                            </span>
                        </div>
                    </form>

                </div>
                <!--/.nav-collapse -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#navbar -->

        <!-- *** NAVBAR END *** -->

        <!-- *** SCRIPTS TO INCLUDE ***
     _________________________________________________________ -->
        <script src="res/js/jquery-1.11.0.min.js"></script>
        <script src="res/js/bootstrap.min.js"></script>
        <script src="res/js/jquery.cookie.js"></script>
        <script src="res/js/waypoints.min.js"></script>
        <script src="res/js/modernizr.js"></script>
        <script src="res/js/bootstrap-hover-dropdown.js"></script>
        <script src="res/js/owl.carousel.min.js"></script>
        <script src="res/js/front.js"></script>

        <!-- project script -->

    </body>

</html>

