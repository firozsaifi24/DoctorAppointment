<%-- 
    Document   : UserView
    Created on : Aug 18, 2017, 1:43:02 PM
    Author     : Firoz Saifi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="UserProfile.*"%>
<%@page import="java.util.List"%>
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
    
    </head>
    
    <%
        UserProfilesDAO updao=new UserProfilesDAOImpl();
        List<UserProfiles> list=updao.getProfiles();
        
        request.setAttribute("UserPro", list);
    %>
    
    <body id="myPage">
        
        <c:import url="header.jsp"></c:import>
        
        <h3 style="margin: auto; width: 80%; text-align: center">User List</h3>
        <br>
        
        <table class="table table-striped" style="margin: auto; text-align: center; width: 95%">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Gender</th>
                    <th>Date of Birth</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${UserPro}" var="x">
                <tr>                   
                    <th>${x.getName()}</th>
                    <th>${x.getEmail()}</th>
                    <th>${x.getGender()}</th>
                    <th>${x.getDateofbirth()}</th>
                    <th>${x.getPhone()}</th>
                    <th>${x.getAddress()}</th>
                    <th><a href="UserProDelete?id=${x.getId()}" class="btn btn-danger">Delete</a></th>
                    <th><a href="UserProEdit.jsp?id=${x.getId()}" class="btn btn-success">Update</a></th>
                    
                </tr>
                </c:forEach>
            </tbody>           
        </table>
        
        <br>
        <br>
        <br>
        <jsp:include page="footer.jsp" />  
        
    </body>
</html>
