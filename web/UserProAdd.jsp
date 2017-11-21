<%-- 
    Document   : UserDetails
    Created on : Aug 18, 2017, 1:40:29 PM
    Author     : Firoz Saifi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/background.css">

    <script type="text/javascript" src="js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/jqueryUser.js"></script>
    
    <style>
        label
        {
            float:left;
        }
        div.error{
        color: red;
        display: block;
        float:left;
        text-align: left;
        width: 100%;
        }
    </style>
    </head>
    <body id="myPage">
        
        <c:import url="header.jsp"></c:import>
        
        <h3 style="margin: auto; text-align: center;">User Registration</h3>
        <br>
        
        <form id="userForm" action="UserProSignUp" method="post" style="margin: auto; text-align: center; width: 60%" >
        <div class="row">
                        <div  class="col-md-6 form-group" >
                            <label for="username">Name </label>
                            <input type="text" class="form-control" id="username" placeholder="UserName" name="UserName"/>
                        </div>
                    
                        <div class="col-md-6 form-group">
                            <label for="email">Email </label>
                            <input type="email"  class="form-control" id="email" placeholder="Email" name="UserEmail"/>
                        </div>
            <br>
                        <div class="col-md-6 form-group">
                            <label for="password">Password </label>
                            <input type="password" class="form-control" id="password" placeholder="Password" name="UserPassword"/>
                        </div>
                        <div class="col-md-6 form-group">
                            <label for="confirmpass">Confirm Password </label>
                            <input type="password" class="form-control" id="confirmpass" placeholder="Confirm Password" name="UserConfirmPassword"/>
                        </div>
            <br>
            <div class="col-md-6 form-group">
                <label for="gender" >Gender: </label>
                <select id="gender" class="form-control" name="UserGender">
                    
                    <option value="" selected="selected">--Choose Gender--</option>
                    <option value="Male" >Male</option>
                    <option value="Female" >Female</option>
                </select>
                        </div>
                        <div class="col-md-6 form-group">
                            <label for="dob">Date of Birth </label>
                            <input type="date" class="form-control" id="dob" placeholder="Date of Birth" name="UserDOB"/>
                        </div>
            <br>
                        <div class="col-md-12 form-group">
                            <label for="phone">Phone Number </label>
                            <input type="tel" class="form-control" id="phone" placeholder="Phone" name="UserPhone"/>
                        </div>
            <br>
                        <div class="col-md-12 form-group">
                            <label for="address">Address </label>
                            <textarea class="form-control" id="address"  placeholder="Address" name="UserAddress"></textarea>
                        </div>
            <br>
            <div class="col-md-12">
            <input type="Submit" id="sub" class="btn btn-primary" value="SignUp"/>
            </div>
        </div>
        </form>
            
        <br>
        <br>
        <br>
        <jsp:include page="footer.jsp" />  
    </body>
</html>
