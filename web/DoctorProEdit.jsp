<%-- 
    Document   : DoctorEdit
    Created on : Aug 18, 2017, 1:41:27 PM
    Author     : Firoz Saifi
--%>

<%@page import="DoctorProfile.DoctorProfiles"%>
<%@page import="DoctorProfile.DoctorProfilesDAOImpl"%>
<%@page import="DoctorProfile.DoctorProfilesDAO"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="CategoryProfile.*"%>
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
  
    <script type="text/javascript" src="js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/jqueryDoctorUp.js"></script>
    
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
        
        <% 
            DoctorProfilesDAO dpdao=new DoctorProfilesDAOImpl();
            DoctorProfiles dp= dpdao.getProfiles(Integer.parseInt(updateID));
        %>
        
        <% 
        CategoryProfilesDAO pdao=new CategoryProfilesDAOImpl(); 
        List<CategoryProfiles> list= pdao.getProfiles();
        
        request.setAttribute("CategoryGetEdit", list);
        %>
    
    
    <body id="myPage">
        
        
        <c:import url="header.jsp"></c:import>
        
        <h3 style="margin: auto; text-align: center;">Doctor Profile Update</h3>
        <br>
        
        <form id="doctorFormUp" action="DoctorProUpdate?id=<%=updateID %>" method="post" enctype="multipart/form-data" style="margin: auto; text-align: center; width: 60%" >
        <div class="row">
                        <div  class="col-md-6 form-group" >
                            <label for="username">Name </label>
                            <input type="text" class="form-control" id="username" placeholder="UserName" name="DoctorName" value="<%=dp.getName()%>"/>
                        </div>
                    
                        <div class="col-md-6 form-group">
                            <label for="email">Email </label>
                            <input type="email"  class="form-control" id="email" placeholder="Email" name="DoctorEmail" value="<%=dp.getEmail()%>"/>
                        </div>
            <br>
                        <div class="col-md-6 form-group">
                            <label for="password">Password </label>
                            <input type="text" class="form-control" id="password" placeholder="Password" name="DoctorPassword" value="<%=dp.getPassword()%>"/>
                        </div>
                        <div class="col-md-6 form-group">
                            <label for="confirmpass">Confirm Password </label>
                            <input type="text" class="form-control" id="confirmpass" placeholder="Confirm Password" name="DoctorConfirmPassword" value="<%=dp.getConfirmpassword()%>"/>
                        </div>
            <br>
            <div class="col-md-6 form-group" >

            <label for="gender">Gender: </label>
            
            <select id="gender" class="form-control" name="DoctorGender">
                    
                    <option value="<%=dp.getGender()%>" selected="selected" hidden="hidden"><%=dp.getGender()%></option>
                    <option value="Male" >Male</option>
                    <option value="Female" >Female</option>
                </select>

                        </div>
                        <div class="col-md-6 form-group">
                            <label for="dob">Date of Birth </label>
                            <input type="date" class="form-control" id="dob" placeholder="Date of Birth" name="DoctorDOB" value="<%=dp.getDateofbirth()%>"/>
                        </div>
            <br>
                        <div class="col-md-6 form-group">
                            <label for="specialist">Select Specialization </label>
                            <select class="form-control" id="specialist" name="DoctorSpecialist">
               <option value="<%=dp.getSpecialization()%>" selected="selected" hidden="hidden"><%=dp.getSpecialization()%></option>
                
                <c:forEach items="${CategoryGetEdit}" var="x">
                    <option value="${x.getSpecialization()}" title="${x.getDescription()}">${x.getSpecialization()}</option>
                </c:forEach>
                                
            </select>
                        </div>
                                
                         <div class="col-md-6 form-group">
                            <label for="experience">Select Experience </label>
                            <select class="form-control" id="experience" name="DoctorExperience">
                                
                                
                <option value="<%=dp.getExperience()%>" selected="selected" hidden="hidden"><%=dp.getExperience()%></option>
                
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
                            <input type="tel" class="form-control" id="phone" placeholder="Phone" name="DoctorPhone" value="<%=dp.getPhone()%>"/>
                        </div>
            <br>
                        <div class="col-md-12 form-group">
                            <label for="address">Address </label>
                            <textarea class="form-control" id="address"  placeholder="Address" name="DoctorAddress"><%=dp.getAddress()%></textarea>
                        </div>
                        
                        <br>      
            
             <div class="col-md-12 form-group" >
                <label for="photo">Upload Photo </label> <br> <br>
                <input type="file" id="photo" name="DoctorPhoto" style="float: left;">
            </div>
                        
            <br>
            <br>
            <br>
            
             <div>
                <h5><b>Image Preview</b></h5>                
                <img src="<%=dp.getPhoto()%>" width="100px" height="100px">
                
            </div>
            <br>

            <div class="col-md-12">
            <input type="Submit" class="btn btn-primary" value="Update"/>
            </div>
        </div>
        </form>
        
        <br>
        <br>
        <br>
        <jsp:include page="footer.jsp" />  
        
    </body>
</html>
