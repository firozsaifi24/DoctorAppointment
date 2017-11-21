<%-- 
    Document   : ForgotPassword
    Created on : Oct 9, 2017, 6:39:15 PM
    Author     : Firoz Saifi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/background.css">
        
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/jqueryForgot.js"></script>
        
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
        <h3 style="margin:auto; text-align: center">Password Recovery</h3>
        <br>
        <br>
        <br>
        
        <form id="ForgotPass" action="ForgotPassword" method="post" style="margin:auto; text-align: center; width:50%;">
            <div class="row">
                <div class="col-md-12 form-group" >
                <label for="email">Enter Email to reset your Password</label>
                <input class="form-control" id="email" type="text" placeholder="Email" name="EmailReset"/>
                </div>
                <div class="col-md-12">
                    <p style="text-align: left;">
                <%
                String err=(String)request.getAttribute("error");
                if(err!=null)
                {
                out.println("<b style='color:red;'>"+err+"</b>");
                }
                %>
                 </p>
                </div>
                <input class="btn btn-primary" type="submit" value="Reset Password"/>
                
                
            </div>
        </form>
        
        <br>
        <br>
        <br>
        <jsp:include page="footer.jsp" />  
    </body>
</html>
