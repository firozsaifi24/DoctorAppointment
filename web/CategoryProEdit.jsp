<%-- 
    Document   : EditProfiles
    Created on : Aug 17, 2017, 5:29:00 PM
    Author     : Firoz Saifi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="CategoryProfile.*"%>

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
    <script type="text/javascript" src="js/jqueryCategoryUp.js"></script>
    
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
    
        <%
            String updateID=request.getParameter("id");  
        %>
        
        <% CategoryProfilesDAO pdao=new CategoryProfilesDAOImpl(); 
           CategoryProfiles p= pdao.getProfiles(Integer.parseInt(updateID));
        %>
    
    <body id="myPage">

        
        <c:import url="header.jsp"></c:import>
        
        <h3 style="margin:auto; text-align: center">Specialization Update</h3>
        <form id="categoryFormUp" action="CategoryProUpdate?id=<%=updateID %>" method="POST" enctype="multipart/form-data" style="margin:auto; text-align: center; width:60%;">
            <br/>
            <label for="specialistup">Specialization</label>
            <input class="form-control" id="specialist" type="text" placeholder="Specialization" name="CategoryName" value="<%=p.getSpecialization()%>"/>
            <br/>
            <label for="descriptionup">Description</label>
            <textarea class="form-control" id="description" placeholder="Description" name="CategoryDescription"><%=p.getDescription()%></textarea>
            <br/>
            
             <div class="col-md-12 form-group" >
                <label for="image">Upload Image </label> <br> <br>
                <input type="file" id="image" name="CategoryPhoto" style="position: absolute; float: left;">
            </div>
            
            <br>
            <br>
            
            <div>
                <h5><b>Image Preview</b></h5>                
                <img src="<%=p.getImage()%>" width="150px" height="100px">
                
            </div>
            <br>
            <input class="btn btn-primary" type="submit" value="Update"/>
            
        </form>
          
        <br>
        <br>
        <br>
        <jsp:include page="footer.jsp" />  
    </body>
</html>
