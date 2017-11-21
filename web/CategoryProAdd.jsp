<%-- 
    Document   : CategoryProAdd
    Created on : Aug 21, 2017, 2:55:04 PM
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
    <script type="text/javascript" src="js/jqueryCategory.js"></script>
    
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
        
        <h3 style="margin:auto; text-align: center">Add Specialization</h3>
         <br/>
         <form id="categoryForm" action="CategoryProSignUp" method="POST" enctype="multipart/form-data" style="margin:auto; text-align: center; width:50%;">
            <div class="row">
             
            <div class="col-md-12 form-group" >
            <label for="specialist">Specialization</label>
            <input class="form-control" id="specialist" type="text" placeholder="Specialization" name="CategoryName"/>
            </div>
            <br/>
            <div class="col-md-12 form-group" >
            <label for="description">Description </label>
            <textarea class="form-control" id="description" placeholder="Description" name="CategoryDescription"></textarea>
            </div>
            <br>
            <div class="col-md-12 form-group" >
                <label for="image">Upload Image </label> <br> <br>
                <input type="file" id="image" name="CategoryPhoto" style=" float: left;">
            </div>
            <br>
            <br>
            <br>
            <br>
            <input class="btn btn-primary" type="submit" value="Add"/>
            </div>
        </form>
         
        <br>
        <br>
        <br>
        <jsp:include page="footer.jsp" />  
    </body>
</html>
