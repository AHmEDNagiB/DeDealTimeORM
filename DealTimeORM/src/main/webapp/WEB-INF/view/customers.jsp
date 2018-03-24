<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>DealTime Customers</title>
        <!-- MetisMenu CSS -->
        <link href="res/css/metisMenu.min.css" rel="stylesheet">
        <!-- DataTables CSS -->
        <link href="res/css/dataTables/dataTables.bootstrap.css" rel="stylesheet">
        <!-- DataTables Responsive CSS -->
        <link href="res/css/dataTables/dataTables.responsive.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="res/css/startmin.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link href="res/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead style="font-size: 0.97em; white-space: nowrap; overflow: hidden; text-overflow:ellipsis;">
                                    <tr>
                                        <th style="text-align: center;">Email</th>
                                        <th style="text-align: center;">Name</th>
                                        <th style="text-align: center;">Address</th>
                                        <th style="text-align: center;">Phone Number</th>
                                        <th style="text-align: center;">Birth Date</th>
                                        <th style="text-align: center;">Job</th>
                                        <th style="text-align: center;">Credit</th>
                                    </tr>
                                </thead>
                                <tbody style="font-size: 0.97em;">
                                    <c:forEach items="${requestScope.allCustomers}" var="customer">
                                        <tr id="${customer.getCustId()}">
                                            <td>${customer.getCustEmail()}</td>
                                            <td>${customer.getCustFirstName()} ${customer.getCustLastName()}</td>
                                            <td>${customer.getCustAddress()}</td>
                                            <td style="text-align: center;">${customer.getCustMobileNumber()}</td>
                                            <td style="text-align: center;">${customer.getCustDateOfBirth()}</td>
                                            <td style="text-align: center;">${customer.getCustJob()}</td>
                                            <td style="text-align: center;">${customer.getCustCreditLimit()}</td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->

        <!-- jQuery -->
        <script src="res/js/jquery.min.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="res/js/bootstrap.min.js"></script>
        <!-- Metis Menu Plugin JavaScript -->
        <script src="res/js/metisMenu.min.js"></script>
        <!-- DataTables JavaScript -->
        <script src="res/js/dataTables/jquery.dataTables.min.js"></script>
        <script src="res/js/dataTables/dataTables.bootstrap.min.js"></script>
        <!-- Custom Theme JavaScript -->
        <script src="res/js/startmin.js"></script>

        <!-- Page-Level Demo Scripts - Tables - Use for reference -->
        <script>
            $(document).ready(function () {
                $('#dataTables-example').DataTable({
                    responsive: true
                });
            });
        </script>

    </body>
</html>

