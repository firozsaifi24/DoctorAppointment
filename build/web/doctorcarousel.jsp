<%-- 
    Document   : DoctorView
    Created on : Aug 18, 2017, 1:43:02 PM
    Author     : Firoz Saifi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DoctorProfile.DoctorProfiles"%>
<%@page import="java.util.List"%>
<%@page import="DoctorProfile.DoctorProfilesDAOImpl"%>
<%@page import="DoctorProfile.DoctorProfilesDAO"%>
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
        String cat=request.getParameter("category");
    %>
    
    <%
        DoctorProfilesDAO dpdao=new DoctorProfilesDAOImpl();
        List<DoctorProfiles> list=dpdao.fetchDoctors(cat);
        
        request.setAttribute("DoctorPro", list);
    %>
    
    <body id="myPage">
        
        <c:import url="header.jsp"></c:import>
        
        <h3 style="margin: auto; width: 80%; text-align: center">Availabe Doctors</h3>
        <br>
        
         <div class="row" style="width:80%; text-align: left; margin: auto;">
            
            <c:forEach items="${DoctorPro}" var="x">
                <div style="border: 1px solid black; width: 100%; height: 300px; float: left;">
            <div class="col-md-4" style="height: inherit;">
                    <br>
                    <img src="${x.getPhoto()}" width="200" height="250" />

            </div>
            <div class="col-md-5" style="height: inherit;">
                    Name: ${x.getName()}
                    <br>
                    Email: ${x.getEmail()}
                    <br>
                    Gender: ${x.getGender()}
                    <br>
                    Date of Birth: ${x.getDateofbirth()}
                    <br>
                    Specialization: ${x.getSpecialization()}
                    <br>
                    Experience: ${x.getExperience()}
                    <br>
                    Phone: ${x.getPhone()}
                    <br>
                    Address: ${x.getAddress()}
                    <br>
                    <p>Time:  ${x.getStarttime()} to  ${x.getEndtime()} </p>
                    Appointment: <a href="AppointmentBook.jsp?id=${x.getId()}" class="btn btn-primary">Book Now</a>

                    

            </div>
                    <div class="col-md-3" style="height: inherit; text-align: center;">
                        
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        
                    <a href="DoctorProDelete?id=${x.getId()}" class="btn btn-danger">Delete</a>
                    <a href="DoctorProEdit.jsp?id=${x.getId()}" class="btn btn-success">Update</a>

            </div>
            
                                        <br>
                    <br>
                    </div>
                    </c:forEach>
                    
        

                    
        </div>
        
        <br>
        <br>
        <br>
        <jsp:include page="footer.jsp" />  
        
    </body>
</html>
