<%-- 
    Document   : userCart
    Created on : Mar 1, 2018, 4:35:15 AM
    Author     : nagib
--%>

<%
//    response.setHeader("Cache-Control", "no-cache");
//    response.setHeader("Pragma", "no-cache");
//    response.setDateHeader("Expires", -1);
%>

<jsp:include page="header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>

        <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

        <!-- styles -->
        <link href="res/css/font-awesome.css" rel="stylesheet">
        <link href="res/css/bootstrap.min.css" rel="stylesheet">
        <link href="res/css/animate.min.css" rel="stylesheet">
        <link href="res/css/owl.carousel.css" rel="stylesheet">
        <link href="res/css/owl.theme.css" rel="stylesheet">
        <style>
            .myItem { 
                color:#4fbfa8;
            }
            .myItem:hover{cursor: pointer;}
            .mynumber{
                width: 30em;
            }
        </style>

        <!-- theme stylesheet -->
        <link href="res/css/style.default.css" rel="stylesheet" id="theme-stylesheet">

        <!-- your stylesheet with modifications -->
        <link href="res/css/custom.css" rel="stylesheet">

        <script src="res/js/respond.min.js"></script>
        <script>
            var changedOrders = {"changedOrders": []};
            var updateCartReq = null;
            var rowsCounter = ${Items.size()};
            function updateCart(btn) {
                var jsonData = {"name": "name", "pass": "password"};
                console.log(changedOrders);
                $.ajax({
                    type: 'POST',
                    url: 'UpdateCart', //calling servlet      
                    cache: false,
                    data: changedOrders,
                    success: function () {
                        sessionStorage.removeItem('Items');
                        console.log("success:");
                        document.getElementById("updateCartBtn").disabled = true;
                        document.getElementById("checkoutBtn").disabled = false;
                    },
                    error: function (xhr, ajaxOptions) {
                        console.log("error:")
                    },

                });
            }

            function  updateQuantity(btn, orderProductPrice, availableQuantity) {
                if (btn.value < 0 || btn.value > availableQuantity) {
                    btn.value = 1;

                } else {
                    allchangedOrders = changedOrders.changedOrders;
                    orderIndex = allchangedOrders.findIndex(order => order.orderId == btn.getAttribute('id'));
                    window.console.log(orderIndex);
                    if (orderIndex == -1) {
                        allchangedOrders.push({"orderId": btn.getAttribute('id'), "quantity": btn.value});
                    } else {
                        allchangedOrders[orderIndex].quantity = btn.value;
                    }
                    document.getElementById("updateCartBtn").disabled = false;
                    document.getElementById("checkoutBtn").disabled = true;
                    priceelementid = "orderPrice" + btn.getAttribute('id')
                    oldprice = document.getElementById(priceelementid).innerHTML;
                    newprice = btn.value * orderProductPrice
                    diffPrice = parseFloat(newprice) - parseFloat(oldprice);
                    totalPrice = document.getElementById("cartTotalPrice1").innerHTML;
                    newTotalPrice = parseFloat(diffPrice) + parseFloat(totalPrice) + 0.0;
                    document.getElementById(priceelementid).innerHTML = newprice;
                    document.getElementById("cartTotalPrice1").innerHTML = newTotalPrice;
                    document.getElementById("cartTotalPrice2").innerHTML = newTotalPrice;
                    document.getElementById("cartTotalPrice3").innerHTML = newTotalPrice;
                    window.console.log(allchangedOrders);
                    console.log("Quantity : " + btn.value + "   id is : " + btn.getAttribute('id'));
                }
            }

            function  deleteRow(btn, orderId1) {
                var row = btn.parentNode.parentNode;
                document.getElementById("updateCartBtn").disabled = false;
                document.getElementById("checkoutBtn").disabled = true;
                var priceelementid = "orderPrice" + orderId1;
                var oldprice = document.getElementById("cartTotalPrice1").innerHTML;
                var newprice = document.getElementById(priceelementid).innerHTML;
                var diffPrice = parseFloat(oldprice) - parseFloat(newprice) + 0.0;
                document.getElementById("cartTotalPrice1").innerHTML = diffPrice;
                document.getElementById("cartTotalPrice2").innerHTML = diffPrice;
                document.getElementById("cartTotalPrice3").innerHTML = diffPrice;
                row.parentNode.removeChild(row);
                allchangedOrders = changedOrders.changedOrders;
                orderIndex = allchangedOrders.findIndex(order => order.orderId == orderId1);
                if (orderIndex == -1) {
                    allchangedOrders.push({"orderId": orderId1, "quantity": 0});
                } else {
                    allchangedOrders[orderIndex].quantity = 0;
                }
                rowsCounter = rowsCounter - 1;
                document.getElementById("noOfOrders").innerHTML = " You currently have " + rowsCounter + " item(s) in your cart ."
            }
            function checkOutCart(btn) {
                var table = document.getElementById("cartItemTable");
                var flag = true;
                var flag2 = true;
                for (var i = 1, row; row = table.rows[i]; i++) {
                    //iterate through rows
                    //rows would be accessed using the "row" variable assigned in the for loop
                    if (row.cells[2]) {
                        console.log(row.cells[2]);
                        console.log(row.cells[3]);
                        if (parseInt(row.cells[2].innerHTML) < parseInt(row.cells[3].childNodes[1].value)) {
                            flag = false;
                            alert("Row Number : " + i + " Has No Enough Available Quantity !!");
                            break;
                        }
                    }
                }
                if (parseInt($("#custCreditLimitSpan").html()) < parseInt($("#cartTotalPrice2").html())) {
                    flag2 = false;
                    alert("Sorry you Do Not have Enough Credit !!");
                }

                if (flag && flag2) {
                    newCridet = parseInt($("#custCreditLimitSpan").html()) - parseInt($("#cartTotalPrice2").html());
                    $.ajax({
                        type: 'POST',
                        url: 'CheckOutCart', //calling servlet  
                        data: {newCridet},
                        cache: false,
                        success: function () {
                            console.log("success:")
                            var table = document.getElementById("cartItemTable");
                            while (table.firstChild) {
                                table.removeChild(table.firstChild);
                            }
                            $("#custCreditLimitSpan").html(newCridet);
                            $("#cartItemsSpan").html(0);
                            $("#cartTotalPrice2").html("$0.00");
                            $("#cartTotalPrice3").html("$0.00");
                            $("#noOfOrders").html("You currently have 0 item(s) in your cart .");

                            document.getElementById("checkoutBtn").disabled = true;




                        },
                        error: function (xhr, ajaxOptions) {
                            console.log("error:")
                            alert("Sorry There Is Product That Does Not Has Enough Available Quantity !!");
                        },

                    });
                }

            }


        </script>

        <link rel="shortcut icon" href="res/img/favicon.png">


    </head>
    <body>

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">
                        <ul class="breadcrumb">
                            <li><a href="dealTime">Home</a>
                            </li>
                            <li>Shopping cart</li>
                        </ul>
                    </div>

                    <div class="col-md-9" id="basket">

                        <div class="box">

                            <!--<form method="post" action="">-->

                            <c:set var = "totalprice" scope = "session" value = "${0}"/>
                            <c:set var = "varNoOfOrders" scope = "session" value ="${Items.size()}"/>
                            <h1>Shopping cart</h1>
                            <p id="noOfOrders" class="text-muted">You currently have ${Items.size()} item(s) in your cart .</p>
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
                                        <c:forEach items="${sessionScope.Items}" var="order">
                                            <!--<tr class="{(${order.orderProduct.availableQuantity}  ${order.quantity}) ? danger  :active}">-->
                                            <c:if test="${order.orderProduct.availableQuantity lt order.quantity}">
                                                <tr class="danger">
                                                </c:if>
                                                <c:if test="${order.orderProduct.availableQuantity gt order.quantity}">

                                                <tr>
                                                </c:if>

                                                <td>
                                                    <a href="#">
                                                        <img src="res/products_images/${order.orderProduct.getImageFilename()}" alt="Black Blouse Armani">
                                                    </a>
                                                </td>
                                                <td><a href="#">${order.orderProduct.productName}</a>
                                                </td>
                                                <td>
                                                    ${order.orderProduct.availableQuantity}
                                                </td>
                                                <td>
                                                    <input type="number" id="${order.orderId}" onchange="updateQuantity(this,${order.orderProduct.productPrice},${order.orderProduct.availableQuantity})" value=${order.quantity} min="1" max=${order.orderProduct.availableQuantity} class="form-control mynumber">
                                                           <!--<input type="number"  value="5" min="1" max="10" class="form-control mynumber">-->
                                                </td>
                                                <td>${order.orderProduct.productPrice}</td>
                                                <td>$0.00</td>
                                                <td id="orderPrice${order.orderId}">${order.orderProduct.productPrice*order.quantity}</td>
                                                <c:set var="totalprice" value="${totalprice+(order.orderProduct.productPrice*order.quantity)}"/>
                                                <td><i class="fa fa-trash-o myItem" onclick="deleteRow(this,${order.orderId})"></i>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th colspan="5">Total</th>
                                            <th id="cartTotalPrice1" colspan="2"><c:out value = "${totalprice}"/></th>
                                        </tr>
                                    </tfoot>
                                </table>

                            </div>
                            <!-- /.table-responsive -->

                            <div class="box-footer row">
                                <div class="pull-left">
                                    <a href="dealTime" class="btn btn-default"><i class="fa fa-chevron-left"></i> Continue shopping</a>
                                </div>
                                <div class="pull-right">

                                    <div   class="col-md-5">
                                        <button id="updateCartBtn" class="btn btn-default" onclick="updateCart(this)" disabled="true"><i class="fa fa-refresh" ></i> Update basket</button>
                                    </div>
                                    <div class="col-md-5">
                                        <button id="checkoutBtn" onclick="checkOutCart(this)" class="btn btn-primary">Proceed to checkout <i class="fa fa-chevron-right"></i>
                                        </button>
                                    </div>     
                                </div>
                            </div>


                        </div>
                        <!-- /.box -->



                    </div>  
                    <!-- /.col-md-9 -->

                    <div class="col-md-3">
                        <div class="box" id="order-summary">
                            <div class="box-header">
                                <h3>Order summary</h3>
                            </div>
                            <p class="text-muted">Shipping and additional costs are calculated based on the values you have entered.</p>

                            <div class="table-responsive">
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <td>Order subtotal</td>
                                            <th id="cartTotalPrice2"><c:out value = "${totalprice}"/></th>
                                        </tr>
                                        <tr>
                                            <td>Shipping and handling</td>
                                            <th>$0.00</th>
                                        </tr>
                                        <tr>
                                            <td>Tax</td>
                                            <th>$0.00</th>
                                        </tr>
                                        <tr class="total">
                                            <td>Total</td>
                                            <th id="cartTotalPrice3"><c:out value = "${totalprice}"/></th>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>


                    </div>
                    <!-- /.col-md-3 -->

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

<jsp:include page="footer.jsp"/>

