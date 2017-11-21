<%-- 
    Document   : UserLogin
    Created on : Sep 3, 2017, 4:07:35 PM
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
    <script type="text/javascript" src="js/jqueryLogin.js"></script>
    
    
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
        <br>
        <h1 style="margin: auto; text-align: center;">Login</h1>
        <br>
        
        <form id="loginForm" method="post" action="Login" style="margin: auto; text-align: center; width: 30%">
            <div class="row">
                
                <div  class="col-md-12 form-group" >
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" placeholder="Email" name="Email"/>
                </div>
        <br>
            <div  class="col-md-12 form-group" >
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Password" name="Password" />
            </div>
        <center>
        <%
        String err=(String)request.getAttribute("error");
        if(err!=null)
        {
        out.println("<b style='color:red;'>"+err+"</b>");
        }
        %>
        </center>
        
        <div class="col-md-12">
            <a href="ForgotPassword.jsp"><p style="text-align: left; color: blue; font-size: 13px;">Forgot Password?</p></a>
        </div>
        <input type="submit" value="Login"/>
            </div>
        </form>
        
        <br>
        <br>
        <br>
        <jsp:include page="footer.jsp" />  
    </body>
</html>
