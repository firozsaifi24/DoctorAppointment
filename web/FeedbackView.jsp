<%-- 
    Document   : FeedbackView
    Created on : Sep 16, 2017, 4:32:17 PM
    Author     : Firoz Saifi
--%>

<%@page import="java.util.List"%>
<%@page import="FeedbackProfile.*"%>
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
        
    </head>
    
    <%
        FeedbackProfilesDAO fpdao=new FeedbackProfilesDAOImpl();
        List<FeedbackProfiles> list=fpdao.getProfiles();
        
        request.setAttribute("FeedbackView", list);
    %>
    
    <body id="myPage">
        <c:import url="header.jsp"></c:import>
        <h1 style="margin: auto; width: 80%; text-align: center">Feedback View</h1>
         <br>
         
         <table class="table table-striped" style="margin: auto; text-align: center; width: 80%">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Comment</th>
                    <th>Feedback Date</th>
                    <th>Feedback Time</th>
                    <th>Delete</th>
                   
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${FeedbackView}" var="x">
                <tr>                   
                    <th>${x.getName()}</th>
                    <th>${x.getEmail()}</th>
                    <th>${x.getComment()}</th>
                    <th>${x.getFeedbackdate()}</th>
                    <th>${x.getFeedbacktime()}</th>
                    <th><a href="FeedbackDelete?id=${x.getId()}" class="btn btn-danger">Delete</a></th>
                    
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
