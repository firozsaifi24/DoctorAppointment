<%-- 
    Document   : UserEdit
    Created on : Aug 18, 2017, 1:41:27 PM
    Author     : Firoz Saifi
--%>

<%@page import="DoctorProCRUD.LoginTemplate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="UserProfile.*"%>
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
    <script type="text/javascript" src="js/jqueryUserUp.js"></script>
    
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
        LoginTemplate sessionId;
        int userid=0;
        if(session.getAttribute("loginTemplate")!=null)
        {
        sessionId=(LoginTemplate)session.getAttribute("loginTemplate");
        userid=sessionId.getId();
        } 
    %>
        
        <% 
            UserProfilesDAO updao=new UserProfilesDAOImpl();
            UserProfiles up= updao.getProfiles(userid);
        %>
    
    <body id="myPage">
        
        <c:import url="header.jsp"></c:import>
        
        <h3 style="margin: auto; text-align: center;">My Profile</h3>
        <br>
        
        <form id="userFormUp" action="UserProUpdate?id=<%=userid%>" method="post" style="margin: auto; text-align: center; width: 60%" >
        <div class="row">
                        <div  class="col-md-6 form-group" >
                            <label for="username">Name </label>
                            <input readonly="readonly" type="text" class="form-control" id="username" placeholder="UserName" name="UserName" value="<%=up.getName()%>"/>
                        </div>
                    
                        <div class="col-md-6 form-group">
                            <label for="email">Email </label>
                            <input readonly="readonly" type="email"  class="form-control" id="email" placeholder="Email" name="UserEmail" value="<%=up.getEmail()%>"/>
                        </div>
            <br>
                        <div class="col-md-6 form-group">
                            <label for="password">Password </label>
                            <input type="text" class="form-control" id="password" placeholder="Password" name="UserPassword" value="<%=up.getPassword()%>"/>
                        </div>
                        <div class="col-md-6 form-group">
                            <label for="confirmpass">Confirm Password </label>
                            <input type="text" class="form-control" id="confirmpass" placeholder="Confirm Password" name="UserConfirmPassword" value="<%=up.getConfirmpassword()%>"/>
                        </div>
            <br>
            <div class="col-md-6 form-group" >

            <label for="gender">Gender: </label>
            
                <select readonly="readonly" id="gender" class="form-control" name="UserGender">
                    <option value="<%=up.getGender()%>" selected="selected" hidden="hidden"><%=up.getGender()%></option>
                </select>
            
            
            

                        </div>
                        <div class="col-md-6 form-group">
                            <label for="dob">Date of Birth </label>
                            <input type="date" class="form-control" id="dob" placeholder="Date of Birth" name="UserDOB" value="<%=up.getDateofbirth()%>"/>
                        </div>
            <br>
                      
                        <div class="col-md-12 form-group">
                            <label for="phone">Phone Number </label>
                            <input type="tel" class="form-control" id="phone" placeholder="Phone" name="UserPhone" value="<%=up.getPhone()%>"/>
                        </div>
            <br>
                        <div class="col-md-12 form-group">
                            <label for="address">Address </label>
                            <textarea class="form-control" id="address"  placeholder="Address" name="UserAddress"><%=up.getAddress()%></textarea>
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
