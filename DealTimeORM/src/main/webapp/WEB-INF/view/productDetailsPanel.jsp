<%-- 
    Document   : productControlPanel
    Created on : Mar 3, 2018, 9:35:14 AM
    Author     : ElsOoObkey
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

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
        <title>
            Deal Time
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
        <script>
            function addToCart(productDetailsId) {
                console.log(productDetailsId);
                $.ajax({
                    type: 'POST',
                    url: 'AddToCart', //calling servlet      
                    cache: false,
                    data: {productDetailsId},
                    success: function () {
                        console.log("success:");
                        $("#cartItemsSpan").html(parseInt($("#cartItemsSpan").html()) + 1)
                    },
                    error: function (xhr, ajaxOptions) {
                        console.log($("#cartItemsSpan").html())
                        console.log("error:")
                    },

                });
            };
        </script>
    </head>
    <body>
        <div id="all">
            <div id="content">
                <div class="container">

                    <div class="col-md-12">
                        <ul class="breadcrumb">
                            <li><a  href="dealTime?page=1">Home</a>
                            </li>
                            <li>${requestScope.product.productName}</li>
                        </ul>

                    </div>

                    <div class="col-md-3">
                        <!-- *** MENUS AND FILTERS ***
     _________________________________________________________ -->
                        <div class="panel panel-default sidebar-menu">

                            <div class="panel-heading">
                                <h3 class="panel-title">Categories</h3>
                            </div>

                            <div class="panel-body">
                                <ul class="nav nav-pills nav-stacked category-menu">
                                    <c:forEach items="${Allcategories}" var="categories">
                                        <li>
                                            <a href="category?cat=${categories.categoryName}">${categories.categoryName}</a>     
                                            <!--<a href="#">Men</a>-->

                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="row" id="productMain">
                            <div class="col-sm-6">
                                <div id="mainImage">
                                    <img src="res/products_images/${requestScope.product.getImageFilename()}" alt="" class="img-responsive">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="box">
                                    <h1 class="text-center">${requestScope.product.productName}</h1>

                                    <p class="price">$ ${requestScope.product.productPrice}</p>
                                    <c:if test="${not empty sessionScope.loggedInUser}">
                                        <p class="text-center buttons">
                                            <a onclick="addToCart(${requestScope.product.productId})" class="btn btn-primary"><i class="fa fa-shopping-cart"></i> Add to cart</a> 
                                            <a class="btn btn-default"><i class="fa fa-heart"></i> Add to wishlist</a>
                                        </p>
                                    </c:if>
                                </div>

                                <div class="row" id="thumbs">
                                    <div class="col-xs-4">
                                        <a href="res/products_images/${requestScope.product.getImageFilename()}" class="thumb">
                                            <img src="res/products_images/${requestScope.product.getImageFilename()}" alt="" class="img-responsive">
                                        </a>
                                    </div>
                                    <div class="col-xs-4">
                                        <a href="res/products_images/${requestScope.product.getImageFilename()}" class="thumb">
                                            <img src="res/products_images/${requestScope.product.getImageFilename()}" alt="" class="img-responsive">
                                        </a>
                                    </div>
                                    <div class="col-xs-4">
                                        <a href="res/products_images/${requestScope.product.getImageFilename()}" class="thumb">
                                            <img src="res/products_images/${requestScope.product.getImageFilename()}" alt="" class="img-responsive">
                                        </a>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="box" id="details">
                            <p>
                            <h4>Product details</h4>
                            <p>${requestScope.product.productDescription}</p>
                            <h4>Material & care</h4>
                            <ul>
                                <li>ultricies</li>
                                <li>Machine wash</li>
                            </ul>
                            <h4>Size & Fit</h4>
                            <ul>
                                <li>Regular fit</li>
                                <li>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo </li>
                            </ul>

                            <blockquote>
                                <p><em> Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi .</em>
                                </p>
                            </blockquote>

                            <hr>
                            <div class="social">
                                <h4>Show it to your friends</h4>
                                <p>
                                    <a href="https://www.facebook.com" class="external facebook" data-animate-hover="pulse"><i class="fa fa-facebook"></i></a>
                                    <a href="https://www.google.com" class="external gplus" data-animate-hover="pulse"><i class="fa fa-google-plus"></i></a>
                                    <a href="https://www.twitter.com" class="external twitter" data-animate-hover="pulse"><i class="fa fa-twitter"></i></a>
                                </p>
                            </div>
                        </div>


                        <div class="row same-height-row">
                            <div class="col-md-3 col-sm-6">
                                <div class="box same-height">
                                    <h3>You may also like these products</h3>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.col-md-9 -->
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






    </body>


</html>

<jsp:include page="footer.jsp" />