<%-- 
    Document   : DoctorDetails
    Created on : Aug 18, 2017, 1:40:29 PM
    Author     : Firoz Saifi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
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
    <script type="text/javascript" src="js/jqueryDoctor.js"></script>

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
        CategoryProfilesDAO pdao=new CategoryProfilesDAOImpl(); 
        List<CategoryProfiles> list= pdao.getProfiles();
        
        request.setAttribute("CategoryGetAdd", list);
    %>
    <body id="myPage">
            
        <c:import url="header.jsp"></c:import>
        
        <h3 style="margin: auto; text-align: center;">Doctor Registration</h3>
        <br>
        
        <form id="doctorForm" action="DoctorProSignUp" method="post" enctype="multipart/form-data" style="margin: auto; text-align: center; width: 60%" >
        <div class="row">
             
             <br>
                        <div  class="col-md-6 form-group" >
                           <label for="username">Name </label>
                            <input type="text" class="form-control" id="username" placeholder="UserName" name="DoctorName"/>
                        </div>
                    
                        <div class="col-md-6 form-group">
                            <label for="email">Email </label>
                            <input type="email"  class="form-control" id="email" placeholder="Email" name="DoctorEmail"/>
                        </div>
            <br>
                        <div class="col-md-6 form-group">
                            <label for="password">Password </label>
                            <input type="password" class="form-control" id="password" placeholder="Password" name="DoctorPassword"/>
                        </div>
                        <div class="col-md-6 form-group">
                            <label for="confirmpass">Confirm Password </label>
                            <input type="password" class="form-control" id="confirmpass" placeholder="Confirm Password" name="DoctorConfirmPassword"/>
                        </div>
            <br>
            <div>
            <div class="col-md-6 form-group" >

                <label for="gender" >Gender: </label>
                
                <select id="gender" class="form-control" name="DoctorGender">
                    
                    <option value="" selected="selected">--Choose Gender--</option>
                    <option value="Male" >Male</option>
                    <option value="Female" >Female</option>
                </select>
                
                        </div>
                        <div class="col-md-6 form-group">
                            <label for="dob">Date of Birth </label>
                            <input type="date" class="form-control" id="dob" placeholder="Date of Birth" name="DoctorDOB"/>
                        </div>
            </div>
            <br>
                        <div class="col-md-6 form-group">
                            <label for="specialist">Select Specialization </label>
                            <select class="form-control" id="specialist" name="DoctorSpecialist">
                                
                                
                <option value="" selected="selected">--Choose Specilization--</option>
                
                <c:forEach items="${CategoryGetAdd}" var="x">
                    <option value="${x.getSpecialization()}" title="${x.getDescription()}">${x.getSpecialization()}</option>
                </c:forEach>
               
            </select>
                        </div>
            
             <div class="col-md-6 form-group">
                            <label for="experience">Select Experience </label>
                            <select class="form-control" id="experience" name="DoctorExperience">
                                
                                
                <option value="" selected="selected">--Choose Experience--</option>
                
                <option value="Fresher">Fresher</option>
                <option value="0-1 Year">0-1 Year</option>
                <option value="2-5 Years">2-5 Years</option>
                <option value="6-10 Years">6-10 Years</option>
                <option value="11-15 Years">11-15 Years</option>
                <option value="More than 15 Years">More than 15 Years</option>
               
            </select>
                        </div>
            
                        <div class="col-md-12 form-group">
                            <label for="phone">Phone Number </label>
                            <input type="tel" class="form-control" id="phone" placeholder="Phone" name="DoctorPhone"/>
                        </div>
            <br>
                        <div class="col-md-12 form-group">
                            <label for="address">Address </label>
                            <textarea class="form-control" id="address"  placeholder="Address" name="DoctorAddress"></textarea>
                        </div>
            <br>      
            
             <div class="col-md-12 form-group" >
                <label for="photo">Upload Photo </label> <br> <br>
                <input type="file" id="photo" name="DoctorPhoto" style="float: left;">
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
