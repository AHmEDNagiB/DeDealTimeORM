<%-- 
    Document   : userOrdersControlPanel
    Created on : Mar 7, 2018, 7:46:27 AM
    Author     : DR Gamal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="robots" content="all,follow">
        <meta name="googlebot" content="index,follow,snippet,archive">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Obaju e-commerce template">
        <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
        <meta name="keywords" content="">

        <title>
            DealTime
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
        <!--        <div id="top">
                    <div class="container">
                        <div class="col-md-6 offer" data-animate="fadeInDown">
                            <a href="#" class="btn btn-success btn-sm" data-animate-hover="shake">Offer of the day</a>  <a href="#">Get flat 35% off on orders over $50!</a>
                        </div>
                        <div class="col-md-6" data-animate="fadeInDown">
                            <ul class="menu">
                                <li><a href="userProfile" ><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><c:out value="${sessionScope.loggedInUser.custFirstName}"/></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>-->

        <!-- *** TOP BAR END *** -->

        <!-- *** NAVBAR ***
     _________________________________________________________ -->


        <!-- /#navbar -->

        <!-- *** NAVBAR END *** -->

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Home</a>
                            </li>
                            <li>My orders</li>
                        </ul>

                    </div>

                    <div class="col-md-3">
                        <!-- *** CUSTOMER MENU ***
     _________________________________________________________ -->
                        <div class="panel panel-default sidebar-menu">

                            <div class="panel-heading">
                                <h3 class="panel-title">Customer section</h3>
                            </div>

                            <div class="panel-body">

                                <ul class="nav nav-pills nav-stacked">
                                    <li class="active">
                                        <a href="customer-orders.html"><i class="fa fa-list"></i> My orders</a>
                                    </li>
                                    <li>
                                        <a href="customer-wishlist.html"><i class="fa fa-heart"></i> My wishlist</a>
                                    </li>
                                    <li>
                                        <a href="userProfile"><i class="fa fa-user"></i> My account</a>
                                    </li>
                                    <li>
                                        <a href="logOut"><i class="fa fa-sign-out"></i> Logout</a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                        <!-- /.col-md-3 -->

                        <!-- *** CUSTOMER MENU END *** -->
                    </div>

                    <div class="col-md-9" id="customer-orders">
                        <div class="box">
                            <h1>My orders</h1>

                            <p class="lead">Your orders on one place.</p>
                            <p class="text-muted">If you have any questions, please feel free to <a href="contact.html">contact us</a>, our customer service center is working for you 24/7.</p>

                            <hr>

                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Order</th>
                                            <th>Date</th>
                                            <th>Total</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th># 1735</th>
                                            <td>22/06/2013</td>
                                            <td>$ 150.00</td>
                                            <td><span class="label label-info">Being prepared</span>
                                            </td>
                                            <td><a href="userOrderView" class="btn btn-primary btn-sm">View</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th># 1735</th>
                                            <td>22/06/2013</td>
                                            <td>$ 150.00</td>
                                            <td><span class="label label-info">Being prepared</span>
                                            </td>
                                            <td><a href="userOrderView" class="btn btn-primary btn-sm">View</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th># 1735</th>
                                            <td>22/06/2013</td>
                                            <td>$ 150.00</td>
                                            <td><span class="label label-success">Received</span>
                                            </td>
                                            <td><a href="userOrderView" class="btn btn-primary btn-sm">View</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th># 1735</th>
                                            <td>22/06/2013</td>
                                            <td>$ 150.00</td>
                                            <td><span class="label label-danger">Cancelled</span>
                                            </td>
                                            <td><a href="userOrderView" class="btn btn-primary btn-sm">View</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th># 1735</th>
                                            <td>22/06/2013</td>
                                            <td>$ 150.00</td>
                                            <td><span class="label label-warning">On hold</span>
                                            </td>
                                            <td><a href="userOrderView" class="btn btn-primary btn-sm">View</a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->


            <!-- *** FOOTER ***
     _________________________________________________________ -->
            <div id="footer" data-animate="fadeInUp">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-sm-6">
                            <h4>Pages</h4>

                            <ul>
                                <li><a href="text.html">About us</a>
                                </li>
                                <li><a href="text.html">Terms and conditions</a>
                                </li>
                                <li><a href="faq.html">FAQ</a>
                                </li>
                                <li><a href="contact.html">Contact us</a>
                                </li>
                            </ul>

                            <hr>

                            <hr class="hidden-md hidden-lg hidden-sm">

                        </div>
                        <!-- /.col-md-3 -->

                        <div class="col-md-3 col-sm-6">

                            <h4>Top categories</h4>

                            <h5>Men</h5>

                            <ul>
                                <li><a href="category.html">T-shirts</a>
                                </li>
                                <li><a href="category.html">Shirts</a>
                                </li>
                                <li><a href="category.html">Accessories</a>
                                </li>
                            </ul>

                            <h5>Ladies</h5>
                            <ul>
                                <li><a href="category.html">T-shirts</a>
                                </li>
                                <li><a href="category.html">Skirts</a>
                                </li>
                                <li><a href="category.html">Pants</a>
                                </li>
                                <li><a href="category.html">Accessories</a>
                                </li>
                            </ul>

                            <hr class="hidden-md hidden-lg">

                        </div>
                        <!-- /.col-md-3 -->

                        <div class="col-md-3 col-sm-6">

                            <h4>Where to find us</h4>

                            <p><strong>Obaju Ltd.</strong>
                                <br>13/25 New Avenue
                                <br>New Heaven
                                <br>45Y 73J
                                <br>England
                                <br>
                                <strong>Great Britain</strong>
                            </p>

                            <a href="contact.html">Go to contact page</a>

                            <hr class="hidden-md hidden-lg">

                        </div>
                        <!-- /.col-md-3 -->

                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.container -->
            </div>
            <!-- /#footer -->

            <!-- *** FOOTER END *** -->




            <!-- *** COPYRIGHT ***
     _________________________________________________________ -->

            <!-- *** COPYRIGHT END *** -->



        </div>
        <!-- /#all -->




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

    </body>
</html>