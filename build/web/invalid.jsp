<%-- 
    Document   : invalid
    Created on : Sep 15, 2017, 11:27:35 AM
    Author     : Firoz Saifi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/background.css">
        
    </head>
    <body>
                <c:import url="header.jsp"></c:import>     
        <br>
        <br>
        <br>
    
    <center>
    <div id="dvCountDown" style="display: none">
        <h3>Sorry! You are not Authorised for this action or page.</h3>
        <h3>You will be redirected to Homepage after <span id="lblCount"></span>&nbsp;seconds.</h3>
    </div>
    </center>
    <script type="text/javascript">

            $(document).ready(function () {
                var seconds = 5;
                $("#dvCountDown").show();
                $("#lblCount").html(seconds);
                setInterval(function () {
                    seconds--;
                    $("#lblCount").html(seconds);
                    if (seconds == 0) {
                        $("#dvCountDown").hide();
                        window.location = "http://localhost:31066/DoctorAppointment/index.jsp";
                    }
                }, 1000);
            });
    </script>

</body>
</html>
