<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
    
    <head>
        <meta charset="utf-8">
        <meta name="robots" content="all,follow">
        <meta name="googlebot" content="index,follow,snippet,archive">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta name="keywords" content="">

        <title>Products</title>

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
         <script src="res/js/admin_profile.js"></script>

        <link rel="shortcut icon" href="favicon.png">
    </head>

    <body>
        <style type="text/css">
            html, body {
                max-width: 100%;
                overflow-x: hidden;
            }
            
            #categoriesList option{
                font-size: 20;
            }
            img{
                 max-width: 180px;
                 max-height: 180px;
            }
            input[type=file]{
                padding:10px;
            }
            .modal-header{
                background-color: #4fbfa8;
                color:white !important;
                text-align: center;
                font-size: 30px;
                
            }
            .modal-content{
                width: 750px;
                margin: auto;
                right:  60%;
            }
            
        </style>

        <div class="container">
            <div class="col-md-9" id="customer-order">
                <div style="margin-top: 1.75em;">
                    <div class="form-group" style="display: inline-block; width: 67%;">
                        <label for="category" style="font-weight: bold; font-size: 1.1em;">Category </label>
                        <select id="categoriesList" class="form-control" style="font-size: medium; 
                                margin-bottom: 1.5em; margin-top: 0.25em; float: top; text-align: center;"
                                onchange="getCategoryProducts(this.value)">
                            <option value="0" selected="default" disabled>Select Category ...</option>
                            
                            <c:forEach items="${requestScope.categories}" var="category">
                                <option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div style="display: inline-block;">
                        <button class="btn btn-success" style="margin-bottom: 0.45em; margin-left: 2.9em;">
                            <i class="fa fa-plus-square-o" data-toggle="modal" data-target="#category-modal"></i>
                        </button>
                        <button class="btn btn-danger" style="margin-bottom: 0.45em; margin-left: 0.7em;" onclick="deleteCategory()">
                            <i class="fa fa-trash-o"></i>
                        </button>
                    </div>
                    <div class="modal fade" id="category-modal" tabindex="-1" role="dialog" aria-labelledby="AddCategory" aria-hidden="true">
                <div id="categoryManageModal" class="modal-dialog modal-sm">

                <div id="categoryManageModalContent" class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="Login">Add Category</h4>
                    </div>
                    <div class="modal-body">
                        <form id="categoryAdditionForm" method="GET" action="categoryControl">
                            <div class="form-group">
                                <input name="categoryName" type="text" class="form-control" id="category_name_modal" placeholder="Name" maxlength="80" required="true" >
                            </div>
                            <button type="submit" class="btn btn-primary" style="width: 100%">
                                    <i class="fa fa-save"></i>Add</button>
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div> 
                </div>
                <div class="table-responsive" style="width: 88%; text-align: center;">
                    <table class="table">
                        <thead style="display:table; width:100%; table-layout:fixed;">
                            <tr>
                                <th colspan="2" style="width: 35%">Product</th>
                                <th style="text-align: center; width: 10%">Quantity</th>
                                <th style="text-align: center; width: 15%">Unit price</th>
                                <th style="text-align: center; width: 18%">Category</th>
                                <th style="text-align: center; width: 11%"></th>
                                <th style="text-align: center; width: 11%"></th>
                            </tr>
                        </thead>
                        <tbody id="products_table_body" style="display: block; overflow-y:scroll; max-height:45em; overflow: auto;">
                            <c:forEach items="${requestScope.products}" var="product">
                                <tr style="display:table; width:100%; table-layout:fixed;" id="${product.getProductId()}" >
                                    <td id="${product.getImageFilename()}" style="text-align: left; width: 14%;">
                                        <img src="res/products_images/${product.getImageFilename()}" alt="No Image">
                                    </td>
                                    <td style="text-align: left; text-overflow: ellipsis; overflow: hidden; 
                                        white-space: nowrap; padding-left: 0;  width: 21%;" id="${product.getProductName()}">
                                        <a title="${product.getProductName()}">${product.getProductName()}</a>
                                    </td>
                                    <td id="${product.getProductDesc()}" hidden/>
                                    <td id="${product.getAvailableQuantity()}" 
                                        style="width: 10%">${product.getAvailableQuantity()}</td>
                                    <td id="${product.getProductPrice()}" 
                                        style="width: 15%">$${product.getProductPrice()}</td>
                                    <td id="${product.getProductCategory().getCategoryId()}" 
                                        style="width: 18%">${product.getProductCategory().getCategoryName()}</td>
                                    <td style="text-align: right; padding-right: 0; width: 11%;">
                                        <button class="btn btn-primary" data-toggle="modal" data-target="#edit-modal"
                                                onclick="editProduct($(this).parent().parent().attr('id'), 
                                                            $(this).parent().parent().children().eq(1).attr('id'), 
                                                            $(this).parent().parent().children().eq(2).attr('id'), 
                                                            $(this).parent().parent().children().eq(4).attr('id'), 
                                                            $(this).parent().parent().children().eq(3).attr('id'), 
                                                            $(this).parent().parent().children().eq(5).attr('id'))">
                                            <i class="fa fa-edit"></i>
                                        </button>
                                    </td>
                                    <td style="padding-left: 0; width: 11%;">
                                        <button class="btn btn-danger" 
                                                onclick="removeProduct($(this).parent().parent().attr('id'))">
                                            <i class="fa fa-trash-o"></i>
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>    
                        </tbody>
                    </table>
                    <button class="btn btn-success" style="width: 100%; font-size: medium; 
                            margin-bottom: 1em; margin-top: 0.5em; float: bottom;" data-toggle="modal" data-target="#add-modal"
                            onclick="openAddProductWindow()">
                        <i class="fa fa-plus-circle"></i> Add new product
                    </button>
                </div>
                <!-- /.table-responsive -->
                
            </div>
            
            <div class="modal fade" id="edit-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
                <div id="productEditModal" class="modal-dialog modal-sm">
                    <div id="productEditModalContent" class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="Login">Edit Product</h4>
                        </div>
                        <div class="modal-body">
                            <form id="productEditForm" method="POST" action="productEdit">
                            <!--
                            <form id="productEditForm" ENCTYPE="MULTIPART/FORM-DATA" method="POST" action="productEdit">
                                <div class="form-group">
                                   <img src="res/img/default.jpg" alt="No image" id="productEditImage">
                                   <input id="productEditFile" type="file" name="pic" accept="image/*">
                                </div>
                                -->
                                <div class="form-group">
                                    <input id="prodNameField" name="productNameForEdit" type="text" class="form-control" placeholder="Name" maxlength="60" required="true" >
                                </div>
                                <div class="form-group">
                                    <input id="prodDescField" name="productDescriptionForEdit" type="text" class="form-control" placeholder="Description" maxlength="320" required="true">
                                </div>
                                <div class="form-group">
                                    <input id="prodPriceField" name="productPriceForEdit" type="text" class="form-control" placeholder="Price" maxlength="30" required="true">
                                </div>
                                <div class="form-group">
                                    <input id="prodQuantityField"  name="productQuantityForEdit" type="text" class="form-control" placeholder="Quantity" maxlength="30" required="true">
                                </div>
                                <div class="form-group" style="display: inline-block; width: 100%">
                                    <select id="categoryToEditProductIn" name="productCategory" 
                                            class="form-control" style="margin-bottom: 1.5em; margin-top: 0.25em; float: top; 
                                            text-align: center;">
                                        <option selected="selected" disabled>Select Category ...</option>
                                        <c:forEach items="${requestScope.categories}" var="category">
                                            <option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <input id="categoryToEditProductInField" name="productCategoryFieldForEdit" type="hidden"/>
                                <input id="productIdHiddenField" name="productIdField" type="hidden"/>
                                <p class="text-center">
                                    <button type="submit" class="btn btn-primary" style="width: 50%">
                                        <i class="fa fa-save"></i> Done</button>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="modal fade" id="add-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
                <div id="productManageModal" class="modal-dialog modal-sm">

                <div id="productManageModalContent" class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="Login">Add new Product</h4>
                    </div>
                    <div class="modal-body">
                        <form id="productAdditionForm" ENCTYPE="MULTIPART/FORM-DATA" method="POST" action="manageProduct">
                            <div class="form-group">
                               <img src="res/img/default.jpg" alt="Smiley face" id="productAdditionImage">
                               <input id="productAdditionFile" type="file" name="pic" accept="image/*">
                            </div>
                            <div class="form-group">
                                <input name="productName" type="text" class="form-control" id="naame-modal" placeholder="Name" maxlength="60" required="true" >
                            </div>
                            <div class="form-group">
                                <input name="productDescription" type="text" class="form-control" id="desc-modal" placeholder="Description" maxlength="320" required="true">
                            </div>
                            <div class="form-group">
                                <input name="productPrice" type="text" class="form-control" id="price-modal" placeholder="Price" maxlength="30" required="true">
                            </div>
                            <div class="form-group">
                                <input name="productQuantity" type="text" class="form-control" id="quantiy-modal" placeholder="Quantity" maxlength="30" required="true">
                            </div>
                            <div class="form-group" style="display: inline-block; width: 100%">
                                <select id="categoryToAddProductIn" name="productCategory" 
                                        class="form-control" style="margin-bottom: 1.5em; margin-top: 0.25em; float: top; 
                                        text-align: center;">
                                    <option selected="selected" disabled>Select Category ...</option>
                                    <c:forEach items="${requestScope.categories}" var="category">
                                        <option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <input id="categoryToAddProductInField" name="productCategoryField" type="hidden"/>
                            <p class="text-center">
                                <button type="submit" class="btn btn-primary" style="width: 50%">
                                    <i class="fa fa-save"></i> Done</button>
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <!-- /.container -->

        <!-- *** SCRIPTS TO INCLUDE *** 
        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
            <div class="modal-dialog modal-sm">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="Login">Customer login</h4>
                    </div>
                    <div class="modal-body">
                        <form action="login" method="post">
                            <div class="form-group">
                                <input name="email" type="text" class="form-control" id="email-modal" placeholder="email" maxlength="40" required="true" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$">
                            </div>
                            <div class="form-group">
                                <input name="password" type="password" class="form-control" id="password-modal" placeholder="password" maxlength="30" required="true">
                            </div>

                            <p class="text-center">
                                <button  class="btn btn-primary"><i class="fa fa-sign-in"></i> Log in</button>
                            </p>

                        </form>

                        <p class="text-center text-muted">Not registered yet?</p>
                        <p class="text-center text-muted"><a href="register"><strong>Register now</strong></a>! It is easy and done in 1&nbsp;minute and gives you access to special discounts and much more!</p>

                    </div>
                </div>
            </div>
        </div>
     _________________________________________________________ -->
        <script src="res/js/jquery-1.11.0.min.js"></script>
        <script src="res/js/bootstrap.min.js"></script>
        <script src="res/js/jquery.cookie.js"></script>
        <script src="res/js/waypoints.min.js"></script>
        <script src="res/js/modernizr.js"></script>
        <script src="res/js/bootstrap-hover-dropdown.js"></script>
        <script src="res/js/owl.carousel.min.js"></script>
        <script src="res/js/front.js"></script>
        
        <script type="text/javascript">
            /*
            $("#productAdditionForm").submit(function(e) {
                var category = $('#categoryToAddProductIn').val();
                if (category !== null) {
                    $('#categoryToAddProductInField').val(category);
                } else {
                    $('#categoryToAddProductInField').val(0);
                }
                $.ajax({
                    type: "POST",
                    url: "manageProduct",
                    data: $("#productAdditionForm").serialize(), // serializes the form's elements.
                    success: function(data)
                    {   
                        closeProductManageWindow();
                        setTimeout(function (){
                            location.reload();
                            //window.location = window.location.hash+"/DealTime/administration/products";
                            alert("product has been added successfully");
                        }, 250);
                    }
                });
                e.preventDefault(); // avoid to execute the actual submit of the form.
            });
            
            function closeProductManageWindow() {
                // clear all form fields
                $("#productManageModalContent .close").click();
                $("#productManageModal .close").click();
                $("#add-modal .close").click();
            }
            */
           
            function openAddProductWindow() {
                var category = $('#categoriesList').val();
                if (category !== null) {
                    $('#categoryToAddProductIn').val(category);
                    $('#categoryToAddProductInField').val(category);
                } else {
                    $('#categoryToAddProductIn').val(0);
                    $('#categoryToAddProductInField').val(0);
                }
                $('#categoryToAddProductIn').prop('disabled', true);
            }
    
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function(e) {
                        $('#productAdditionImage').attr('src', e.target.result);
                    };
                   reader.readAsDataURL(input.files[0]);
                }
            }

            $("#productAdditionFile").change(function() {
               readURL(this);
            });
            
            function readURL_ForEdit(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function(e) {
                        $('#productEditImage').attr('src', e.target.result);
                    };
                   reader.readAsDataURL(input.files[0]);
                }
            }

            $("#productEditFile").change(function() {
               readURL_ForEdit(this);
            });
            
            function editProduct(prodId, prodName, prodDesc, prodPrice, prodQuantity, prodCatId) {
                $("#productIdHiddenField").val(prodId);
                $("#prodNameField").val(prodName);
                $("#prodDescField").val(prodDesc);
                $("#prodPriceField").val(prodPrice);
                $("#prodQuantityField").val(prodQuantity);
                $("#categoryToEditProductIn").val(prodCatId);
                $("#categoryToEditProductInField").val(prodCatId);
                /*
                $("#productEditFile").val(prodImageFileName);
                $("#productEditImage").attr('src', "res/products_images/" + prodImageFileName);
                */
            }
        </script>
    </body>

</html>
