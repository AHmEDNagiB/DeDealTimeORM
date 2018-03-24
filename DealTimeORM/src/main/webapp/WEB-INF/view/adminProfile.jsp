<%@page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

        <title>Admin Profile</title>

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

        <style>
            #container input {
                height: 3.2em;
            }
        </style>
    </head>

    <body>
        <div id="container">
            <h1>My account</h1>
            <p class="lead">Change your personal details here.</p>

            <hr>

            <h3>Personal details</h3>

            <form id="adminProfileInfo">

                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="firstname">First name</label>
                            <input type="text" class="form-control" name="firstname" pattern="^[A-Za-z]+$" value="${requestScope.admin.adminFirstName}" required="true" oninvalid="setCustomValidity('Characters only!')" disabled="true">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="lastname">Last name</label>
                            <input type="text" class="form-control" name="lastname" pattern="^[A-Za-z]+$" value="${requestScope.admin.adminLastName}" required="true" oninvalid="setCustomValidity('Characters only!')" disabled="true">
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="text" class="form-control" name="email" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" value="${requestScope.admin.adminEmail}" required="true" oninvalid="setCustomValidity('Enter a valid email!')" disabled="true">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="dateOfBirth">Date of birth</label>
                            <input type="date" class="form-control" name="dateOfBirth" value="${requestScope.admin.adminDateOfBirth}" required="true" disabled="true">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" name="password" pattern="?=.{8,}" value="${requestScope.admin.adminPassword}" required="true"  oninvalid="setCustomValidity('Must be at least 8 characters!')" disabled="true">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="confirmPassword">Confirm password</label>
                            <input type="password" class="form-control" name="confirmPassword" pattern="?=.{8,}" value="${requestScope.admin.adminPassword}" required="true" oninvalid="setCustomValidity('Must be at least 8 characters!')" disabled="true">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="company">Job</label>
                            <input type="text" class="form-control" name="job" pattern="[a-zA-Z][a-zA-Z][a-zA-Z]" value="${requestScope.admin.adminJob}" required="true" oninvalid="setCustomValidity('Characters only!')" disabled="true">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="street">Address</label>
                            <input type="text" class="form-control" name="address" value="${requestScope.admin.adminAddress}" required="true" disabled="true">
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="phone">Phone number</label>
                            <input type="text" class="form-control" name="phoneNo" value="${requestScope.admin.adminPhoneNo}" required="true" oninvalid="setCustomValidity('Phone number must match 01xxxxxxxxx')" disabled="true">
                        </div>
                    </div>

                    <div class="col-sm-12 text-center">
                        <button type="button" onclick="edit(false)" class="btn btn-primary" id="edit_profile_btn" 
                                style="margin-right: 0.5em; padding-left: 2em; padding-right: 2.5em;"
                                ><i class="fa fa-user"></i> Edit profile</button>
                        <button type="submit" class="btn btn-primary" id="save_changes_btn" 
                                disabled="true" style="margin-left: 0.5em; padding-left: 1.3em; padding-right: 1.8em;"
                                ><i class="fa fa-save"></i> Save changes</button>
                    </div>
                </div>
            </form>
        </div>

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
        <script src="res/js/admin_profile.js"></script>

        <script type="text/javascript">
            var infoEdited = false;
            
            $(document).ready(function(){
                $('input[type="text"]').blur(function(){
                    infoEdited = true;
                });
            });
            
            $("#adminProfileInfo").submit(function (e) {
                var url = "admin";
                $.ajax({
                    type: "POST",
                    url: url,
                    data: $("#adminProfileInfo").serialize(), // serializes the form's elements.
                    success: function (data)
                    {
                        if (infoEdited) {
                            alert(data);
                            infoEdited = false;
                        }
                    }
                });
                e.preventDefault(); // avoid to execute the actual submit of the form.
                edit(true);
            });
        </script>
    </body>

</html>

