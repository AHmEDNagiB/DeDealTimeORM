<%-- 
    Document   : logintry
    Created on : Feb 28, 2018, 10:41:48 AM
    Author     : DR Gamal
--%>
<jsp:include page="header.jsp"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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




        <title>JSP Page</title>
    </head>
    <body>
     
    <div id="all">

        <div id="content">
            <div class="container">

                <div class="col-md-12">

                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li>New account / Sign in</li>
                    </ul>

                </div>

                <div class="col-md-12">
                    <div class="box">
                        <h1>New account</h1>

                        <p class="lead">Not our registered customer yet?</p>
                        <p>With registration with us new world of fashion, fantastic discounts and much more opens to you! The whole process will not take you more than a minute!</p>
                        <p class="text-muted">If you have any questions, please feel free to <a href="contact.html">contact us</a>, our customer service center is working for you 24/7.</p>

                        <hr>

                        <form action="register" method="post">
                            <div class="form-group">
                                <label for="name">First Name</label>
                                <input name="userfirstnameregister" type="text" class="form-control" id="name" required="true" maxlength="40">
                            </div>
                            <div class="form-group">
                                <label for="name">Last Name</label>
                                <input name="userlastnameregister" type="text" class="form-control" id="name" required="true" maxlength="40">
                            </div>
                            <div class="form-group">
                                <label for="name">Phone Number</label>
                                <input name="phonenumregister" type="text" class="form-control" id="name" required="true" maxlength="100">
                            </div>
                            <div class="form-group">
                                <label for="name">Credit Limit</label>
                                <input name="usercreditlimitregister" type="text" class="form-control" id="name" required="true" maxlength="40">

                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input name="emailregister" type="text" class="form-control" id="email" required="true" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" >
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input name="passwordregister" type="password" class="form-control" id="password" required="true" maxlength="40">
                            </div>

                            <div class="form-group">
                                <label for="name">Address</label>
                                <input name="addressregister" type="text" class="form-control" id="name" required="true" maxlength="60">
                            </div>
                            <div class="form-group">

                                <label for="name">Wish List</label>
                                <input name="interestregister" type="text" class="form-control" id="name" required="true" maxlength="100">
                            </div>
                            <div class="form-group">
                                <label for="name">Job</label>
                                <select name="job">
                                       <option value="engineer">Engineer</option>
                                        <option value="Doctor">Doctor</option>
                                        <option value="Pilot">Pilot</option>
                                        <option value="Teacher">Teacher</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="name">Birthday</label>
                                <input name="birthdayregister" type="date" value="" class="form-control input-lg" required="true">
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary"><i class="fa fa-user-md"></i> Register</button>
                            </div>
                            
                        </form>
                    </div>
                </div>
            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->
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

                        <h4>User section</h4>

                        <ul>
                            <li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                            </li>
                            <li><a href="register">Register</a>

                            </li>
                        </ul>

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
