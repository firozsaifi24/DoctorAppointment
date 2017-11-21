<%-- 
    Document   : timing
    Created on : Sep 1, 2017, 1:01:36 PM
    Author     : Firoz Saifi
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="DoctorProfile.*"%>
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
        <script type="text/javascript" src="js/jqueryDoctorTime.js"></script>
        
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
        DoctorProfilesDAO dpdao=new DoctorProfilesDAOImpl();
        List<DoctorProfiles> list=dpdao.getProfiles();
        
        request.setAttribute("DoctorProTime", list);
        
        Gson gson = new Gson();
        
        request.setAttribute("myList", gson.toJson(list));

    %>
    
        <%
            String updateID=request.getParameter("id");  
        %>
    
    <body id="myPage">
        <c:import url="header.jsp"></c:import>
        <br>
        <h3 style="margin: auto; text-align: center;">Doctor Time Update</h3>
        <br>
        <form id="timeForm" method="post" action="DoctorProTime" style="margin: auto; text-align: center; width: 60%">
            <div class="row">
                <div  class="col-md-12 form-group" >
                    <label for="doctorname">Name</label>
                    <select class="form-control" id="doctorname" name="DoctorName">
                <option value="" selected="selected">--Choose Doctor--</option>
                  <c:forEach items="${DoctorProTime}" var="x">
               <option value="${x.getName()}" >${x.getName()}</option>
                </c:forEach>
                
                </select>
                </div>
            <br>
            
            <input type="hidden" id="doctorid" name="DoctorId" value="">  
            
            <div  class="col-md-12 form-group" >
                <label for="starttime">Start Time</label>
                <select class="form-control" id="starttime" name="DoctorStartTime">
                <option value="" selected="selected">--Choose Start Time--</option>
                
                <option value="08:00 AM">08:00</option>
                <option value="09:00 AM">09:00</option>
                <option value="10:00 AM">10:00</option>
                <option value="11:00 AM">11:00</option>
                
                
                </select>
            </div>
            <br>
            
            <div  class="col-md-12 form-group" >
                <label for="endtime">End Time</label>
                <select class="form-control" id="endtime" name="DoctorEndTime">
                <option value="" selected="selected">--Choose End Time--</option>
                
                <option value="05:00 PM">17:00</option>
                <option value="06:00 PM">18:00</option>
                <option value="07:00 PM">19:00</option>
                <option value="08:00 PM">20:00</option>
                
                
                </select>
            </div>
            <br>
            <input type="submit" class="btn btn-primary" value="Go"/>   
            </div>
        </form>
        
        <br>
        <br>
        <br>
        <jsp:include page="footer.jsp" />  
    </body>
</html>

<script>
    $(document).ready(function(){
        
        //insert all the doctor data to the variable
        var listOfDoctors =  ${myList};
        console.log(listOfDoctors);
       // Detect specialization change
        $("#doctorname").on('change', function(){
           // update doctors list
           console.log('spec changed');
           
           
           //filter doctor speicalization and return the data those are equal to specialization value
           var filteredList = listOfDoctors.filter((val, index) => {
               console.log(val.specialization);
               return val.name == $("#doctorname").val();
           });
           
           console.log(filteredList);
           filteredList.forEach(function(val){
               console.log(val);
                     $('#doctorid').attr("value",val.id);
                     console.log('val id '+val.id);
           });
           
        });
            
        
    });
    </script>
