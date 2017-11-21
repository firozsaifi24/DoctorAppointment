<%-- 
    Document   : AppointmentView
    Created on : Sep 12, 2017, 8:12:22 PM
    Author     : Firoz Saifi
--%>

<%@page import="DoctorProCRUD.LoginTemplate"%>
<%@page import="java.util.List"%>
<%@page import="AppointmentProfile.*"%>
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
        LoginTemplate sessionId;
        int userid=0;
        if(session.getAttribute("loginTemplate")!=null)
        {
        sessionId=(LoginTemplate)session.getAttribute("loginTemplate");
        userid=sessionId.getId();
        } 
    %>
    <%
        AppointProfilesDAO apdao=new AppointProfilesDAOImpl();
        List<AppointProfiles> list=apdao.userProfiles(userid);
        
        request.setAttribute("AppointView", list);
    %>
    
    <body id="myPage">
        <c:import url="header.jsp"></c:import>
        
        <h1 style="margin: auto; width: 80%; text-align: center">My Appointments</h1>
        <br>
        
        <table class="table table-striped" style="margin: auto; text-align: center; width: 95%">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Phone</th>
                    <th>Specialization</th>
                    <th>Doctor Name</th>
                    <th>Available Time</th>
                    <th>Appointment Date</th>
                    <th>Appointment Time</th>
                    <th>Delete</th>
                   
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${AppointView}" var="x">
                <tr>                   
                    <th>${x.getName()}</th>
                    <th>${x.getAge()}</th>
                    <th>${x.getGender()}</th>
                    <th>${x.getPhone()}</th>
                    <th>${x.getSpecialization()}</th>
                    <th>${x.getDoctorname()}</th>
                    <th>${x.getAvailabletime()}</th>
                    <th>${x.getDate()}</th>
                    <th>${x.getTime()}</th>
                    <th><a href="DeleteAppoint?id=${x.getId()}" class="btn btn-danger">Delete</a></th>
                    
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
