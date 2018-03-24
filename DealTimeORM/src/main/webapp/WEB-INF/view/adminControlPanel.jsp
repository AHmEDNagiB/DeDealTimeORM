<jsp:include page="adminheader.jsp"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        
        <title>DealTime Admin</title>

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

        <!-- *** SCRIPTS TO INCLUDE ***
_________________________________________________________ -->
        <script src="res/script/jquery-3.3.1.min.js"></script>
        <script src="res/js/bootstrap.min.js"></script>
        <script src="res/js/jquery.cookie.js"></script>
        <script src="res/js/waypoints.min.js"></script>
        <script src="res/js/modernizr.js"></script>
        <script src="res/js/bootstrap-hover-dropdown.js"></script>
        <script src="res/js/owl.carousel.min.js"></script>
        <script src="res/js/front.js"></script>

        <!-- *** TOPBAR ***

        <!-- /#navbar -->

        <!-- *** NAVBAR END *** -->

        <div id="all">

            <div id="content">
                <div class="container">
                    <div class="col-md-12">
                        <ul class="breadcrumb">
<!--                            <li><a href="#">Home</a>
                            </li>-->
                            <li>Admin control panel</li>
                        </ul>
                    </div>
                    <div class="col-md-3">
                        <!-- *** ADMIN MENU *** -->
                        <div class="panel panel-default sidebar-menu">

                            <div class="panel-heading">
                                <h3 class="panel-title">Admin section</h3>
                            </div>

                            <div class="panel-body">
                                <ul class="nav nav-pills nav-stacked">
                                    <li name="option" id="profile_option" class="active">
                                        <a href="#" onclick="getAdminProfile()"><i class="fa fa-user"></i> My profile</a>
                                    </li>
                                    <li name="option" id="products_option">
                                        <a href="#" onclick="getAllProducts()"><i class="fa fa-list"></i> Products</a>
                                    </li>
                                    <li name="option" id="customers_option">
                                        <a href="#" onclick="getAllCustomers()"><i class="fa fa-list"></i> Customers</a>
                                    </li>
                                    <li name="option" id="logout_option">
                                        <a href="adminLogout"><i class="fa fa-sign-out"></i> Logout</a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                        <!-- /.col-md-3 -->

                        <!-- *** CUSTOMER MENU END *** -->
                    </div>

                    <div id="panel_content_container" class="col-md-9">
                        <div id="panel_content" class="box">

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

                            <h4>User section</h4>

                            <ul>
                                <li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                                </li>
                                <li><a href="register.html">Regiter</a>
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



                        <div class="col-md-3 col-sm-6">

                            <h4>Get the news</h4>

                            <p class="text-muted">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>

                            <form>
                                <div class="input-group">

                                    <input type="text" class="form-control">

                                    <span class="input-group-btn">

                                        <button class="btn btn-default" type="button">Subscribe!</button>

                                    </span>

                                </div>
                                <!-- /input-group -->
                            </form>

                            <hr>

                            <h4>Stay in touch</h4>

                            <p class="social">
                                <a href="#" class="facebook external" data-animate-hover="shake"><i class="fa fa-facebook"></i></a>
                                <a href="#" class="twitter external" data-animate-hover="shake"><i class="fa fa-twitter"></i></a>
                                <a href="#" class="instagram external" data-animate-hover="shake"><i class="fa fa-instagram"></i></a>
                                <a href="#" class="gplus external" data-animate-hover="shake"><i class="fa fa-google-plus"></i></a>
                                <a href="#" class="email external" data-animate-hover="shake"><i class="fa fa-envelope"></i></a>
                            </p>


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
            <div id="copyright">
                <div class="container">
                    <div class="col-md-6">
                        <p class="pull-left">© 2015 Your name goes here.</p>

                    </div>
                    <div class="col-md-6">
                        <p class="pull-right">Template by <a href="https://bootstrapious.com/e-commerce-templates">Bootstrapious</a> & <a href="https://fity.cz">Fity</a>
                            <!-- Not removing these links is part of the license conditions of the template. Thanks for understanding :) If you want to use the template without the attribution links, you can do so after supporting further themes development at https://bootstrapious.com/donate  -->
                        </p>
                    </div>
                </div>
            </div>
            <!-- *** COPYRIGHT END *** -->

        </div>
        <!-- /#all -->

        <script type="text/javascript">
            getAdminProfile();

            function setOptionActive(optionId) {
                var options = document.getElementsByName("option");
                for (var i = 0; i < options.length; ++i) {
                    options[i].className = "";
                }
                document.getElementById(optionId).className = "active";
            }

            $.ajaxSetup({
                type: 'POST',
                headers: {"cache-control": "no-cache"}
            });

            function ajaxCallBack(responseTxt, statusTxt, xhr) {
                if (statusTxt == "success") {
                    $("#panel_content_container").html('<div id="panel_content" class="box"></div>');
                    $("#panel_content").html(responseTxt);
                }
            }

            function getAdminProfile() {
                $.get("admin", ajaxCallBack);
                setOptionActive('profile_option');
            }

            function getAllProducts() {
                $.get("administration/products", ajaxCallBack);
                setOptionActive('products_option');
            }

            function getCategoryProducts(catgId) {
                
                $.ajax({
                    url: 'administration/products',
                    type: 'POST',
                    cache: false,
                    data: {oper: "categories", catId: catgId},
                    success: function (result) {
                        $("#panel_content_container").html('<div id="panel_content" class="box"></div>');
                        $("#panel_content").html(result);
                        // alert(result);
                        $("#categoriesList").val(catgId);
                    }
                });
            }
            
            function getAllCustomers() {
                $.get("administration/customers", function (responseTxt, statusTxt, xhr) {
                    if (statusTxt == "success") {
                        $("#panel_content").html('');
                        $("#panel_content_container").html(responseTxt);
                    }
                });
                setOptionActive('customers_option');
            }

            function removeProduct(productId) {
                $.ajax({
                    url: 'administration/products',
                    type: 'POST',
                    cache: false,
                    data: {oper: "delete", pId: productId},
                    success: function (result) {
                        alert(result);
                    }
                });
                setTimeout(function(){
                    getAllProducts();
                }, 250);
            }
            
            function deleteCategory() {
                var catId = $("#categoriesList").val();
                $.ajax({
                    url: 'categoryControl',
                    type: 'POST',
                    cache: false,
                    data: {categoryId: catId},
                    success: function (result) {
                        alert(result);
                        getAllProducts();
                    }
                });
            }
            
        </script>

    </body>
</html>

