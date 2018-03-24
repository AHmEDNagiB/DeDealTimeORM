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
                                    <li class="active">
                                        <a href="userCartControl"><i class="fa fa-list"></i> My orders</a>
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
                            <h1>My History</h1>

                            <hr>

                            <div class="table-responsive">
                                <table  id="cartItemTable" class="table">
                                    <thead>
                                        <tr>
                                            <th colspan="2">Product</th>
                                            <th>Available Quantity</th>
                                            <th>Quantity</th>
                                            <th>Unit price</th>
                                            <th>Discount</th>
                                            <th colspan="2">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sessionScope.HistoryLines}" var="order">
                                            <!--<tr class="{(${order.orderProduct.availableQuantity}  ${order.quantity}) ? danger  :active}">-->

                                            <tr>

                                                <td>
                                                    <a href="#">
                                                        <img src="res/img/basketsquare.jpg" alt="Black Blouse Armani">
                                                    </a>
                                                </td>
                                                <td><a href="#">${order.orderProduct.productName}</a>
                                                </td>
                                                <td>
                                                    ${order.orderProduct.availableQuantity}
                                                </td>
                                                <td>
                                                    value=${order.quantity} 
                                                    <!--<input type="number"  value="5" min="1" max="10" class="form-control mynumber">-->
                                                </td>
                                                <td>${order.orderProduct.productPrice}</td>
                                                <td>$0.00</td>
                                                <td id="orderPrice${order.orderId}">${order.orderProduct.productPrice*order.quantity}</td>
                                                <c:set var="totalprice" value="${totalprice+(order.orderProduct.productPrice*order.quantity)}"/>
                                                <td>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                </table>

                            </div>



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
