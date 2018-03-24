<%-- 
    Document   : userProfileControlPanel
    Created on : Feb 27, 2018, 6:13:03 PM
    Author     : Ahmed_Mokhtar
--%>

<jsp:include page="header.jsp"/>

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

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="dealTime">Home</a>
                            </li>
                            <li>My account</li>
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
                                    <li>
                                        <a href="userProfile"><i class="fa fa-user"></i> My account</a>
                                    </li>
                                    <li>
                                        <a href="history"><i class="fa fa-list"></i> My orders</a>
                                    </li>
                                    <li>
                                        <a href="customer-wishlist.html"><i class="fa fa-heart"></i> My wishlist</a>
                                    </li>
                                   
                                </ul>
                            </div>

                        </div>
                        <!-- /.col-md-3 -->

                        <!-- *** CUSTOMER MENU END *** -->
                    </div>

                    <div class="col-md-9">
                        <div class="box">
                            <h1>My account</h1>
                            <p class="lead">Change your personal details here.</p>

                            <hr>

                            <h3>Personal details</h3>

                            <form method="POST" action="userProfile">

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="firstname">First name</label>
                                            <input type="text" class="form-control" name="firstname" pattern="^[A-Za-z]+$" value="${requestScope.currentCustomer.custFirstName}" required="required" oninvalid="setCustomValidity('Characters only!')" oninput="setCustomValidity('')" disabled="true">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="lastname">Last name</label>
                                            <input type="text" class="form-control" name="lastname" pattern="^[A-Za-z]+$" value="${requestScope.currentCustomer.custLastName}" required="true" oninvalid="setCustomValidity('Characters only!')" oninput="setCustomValidity('')" disabled="true">
                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="email">Email</label>

                                            <input type="email" class="form-control" name="email" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" value="${requestScope.currentCustomer.custEmail}" required="true" oninvalid="setCustomValidity('Enter a valid email!')" oninput="setCustomValidity('')" disabled="true">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="email">Date of birth</label>
                                            <input type="date" class="form-control" name="dateOfBirth" value="${requestScope.currentCustomer.custDateOfBirth}" required="true" oninput="setCustomValidity('')" disabled="true">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="email">Password</label>
                                            <input type="password" class="form-control" name="password" id="password" value="${requestScope.currentCustomer.custPassword}" required="true" disabled="true">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="email">Confirm password</label>
                                            <input type="password" class="form-control" name="confirmPassword" id="confirm_password"  value="${requestScope.currentCustomer.custPassword}" required="true" disabled="true">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="company">Job</label>
                                            <input type="text" class="form-control" name="job" pattern="^[A-Za-z]+$" value="${requestScope.currentCustomer.custJob}" required="true" oninvalid="setCustomValidity('Characters only!')" oninput="setCustomValidity('')" disabled="true">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="street">Address</label>
                                            <input type="text" class="form-control" name="address" value="${requestScope.currentCustomer.custAddress}" required="true" oninput="setCustomValidity('')" disabled="true">
                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="zip">Credit</label>
                                            <input type="text" class="form-control" name="credit" pattern="\d+(\.\d{2})?" value="${requestScope.currentCustomer.custCreditLimit}" required="true" oninvalid="setCustomValidity('Please match 1.00 format')" oninput="setCustomValidity('')" disabled="true">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="phone">Phone number</label>
                                            <input type="text" class="form-control" name="mobileNumber" pattern="01\d{9}" value="${requestScope.currentCustomer.custMobileNumber}" required="true" oninvalid="setCustomValidity('Please match 01xxxxxxxxx format')" oninput="setCustomValidity('')" disabled="true">
                                        </div>
                                    </div>

                                    <div class="col-sm-12 text-center">
                                        <button type="button" class="btn btn-primary" id="edit_profile_btn"><i class="fa fa-user"></i> Edit profile</button>
                                        <button type="submit" class="btn btn-primary" id="save_changes_btn" disabled="true"><i class="fa fa-save"></i> Save changes</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->

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

        <!-- project script -->
        <script src="res/js/customer.profile.js"></script>

    </body>

</html>

<jsp:include page="footer.jsp"/>
