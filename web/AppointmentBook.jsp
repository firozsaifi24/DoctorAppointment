<%-- 
    Document   : UserAppointment
    Created on : Sep 3, 2017, 5:00:49 PM
    Author     : Firoz Saifi
--%>


<%@page import="UserProfile.*"%>
<%@page import="DoctorProCRUD.LoginTemplate"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="CategoryProfile.*"%>
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
        <script type="text/javascript" src="js/jqueryAppointment.js"></script>
        
        
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
    
    <%
        DoctorProfilesDAO dpdao=new DoctorProfilesDAOImpl();
        List<DoctorProfiles> list2=dpdao.getProfiles();
        
        request.setAttribute("DoctorGetAdd", list2);
        
        Gson gson = new Gson();
        
        request.setAttribute("myList", gson.toJson(list2));
    %>
    
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
        //fetch user profile
         UserProfilesDAO updao=new UserProfilesDAOImpl();
         UserProfiles up= updao.getProfiles(userid);

    %>
    
    <% 
         //fetch Doctor profile
         DoctorProfiles dp=null;
         String doctor=null;
         String starttime=null;
         String endtime=null;
         if(request.getParameter("id")!=null)
         {
             doctor= request.getParameter("id");
             dp= dpdao.getProfiles(Integer.parseInt(doctor));
             starttime=dp.getStarttime();
             endtime=dp.getEndtime();
             //time=dp.getStarttime()+ " - "+dp.getEndtime();
         }
         
    %>
    
    
    <body id="myPage">
        <c:import url="header.jsp"></c:import>
        <br>
        <h1 style="margin: auto; text-align: center;">Book Appointment</h1>
        <br>
        
        <form id="appointForm" method="post" action="BookAppoint" style="margin: auto; text-align: center; width: 60%">
            <div class="row">
                <div  class="col-md-6 form-group" >
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" placeholder="Full Name" name="UserName" value="<%=up.getName()%>"/>
                </div>

            <div  class="col-md-6 form-group" >
                <label for="age">Age</label>
                <input type="number" class="form-control" id="age" placeholder="Age" name="UserAge" />
            </div>

                
                <br>
                
             <div class="col-md-6 form-group" >

                <label for="gender" >Gender: </label> 
                
                 <select id="gender" class="form-control" name="UserGender">
                    <option value="<%=up.getGender()%>" selected="selected" hidden="hidden"><%=up.getGender()%></option>
                    <option value="Male" >Male</option>
                    <option value="Female" >Female</option>
                </select>           
                
                        </div>   
                
        
            <div  class="col-md-6 form-group" >
                <label for="phone">Phone</label>
                <input type="tel" class="form-control" id="phone" placeholder="Phone" name="UserPhone" value="<%=up.getPhone()%>" />
            </div>
        <br>
        
        <div>
        <div  class="col-md-6 form-group">
            <label for="doctorspec">Select Specialization</label>
            
            <select class="form-control" id="doctorspec" name="DoctorSpec">
                 
                
          <c:set var="doctorsp" scope="session" value="<%=doctor%>"/>  
            <c:if test="${doctorsp != null}">
<option value="" >--Choose Specilization--</option>
<option value="<%=dp.getSpecialization()%>" selected="selected" hidden="hidden"><%=dp.getSpecialization()%></option>
<c:forEach items="${CategoryGetAdd}" var="x">                   
                    <option value="${x.getSpecialization()}" title="${x.getDescription()}">${x.getSpecialization()}</option>
                    
                </c:forEach>
                
            </c:if>
            <c:if test="${doctorsp == null}">
                <option value="" selected="selected" >--Choose Specilization--</option>
                 <c:forEach items="${CategoryGetAdd}" var="x">                   
                    <option value="${x.getSpecialization()}" title="${x.getDescription()}">${x.getSpecialization()}</option>
                    
                </c:forEach>
            </c:if>
                
              
            </select>
        </div>
        
        
                
        <div  class="col-md-6 form-group" >
            <label for="doctorname">Select Doctor</label>
            
            <select class="form-control" id="doctorname" name="DoctorName">
                                
            <c:set var="doctor" scope="session" value="<%=doctor%>"/>  
            <c:if test="${doctor != null}">
                <option value="">--Choose Doctor--</option>
<option value="<%=dp.getName()%>" selected="selected" hidden="hidden"><%=dp.getName()%></option>
                
            </c:if>
            <c:if test="${doctor == null}">
                <option value="" selected="selected">--Choose Doctor--</option>
            </c:if>

                
                
            </select>
            
        </div>
            
        </div>
        
        <div class="col-md-12 form-group">
            <label for="doctortime">Available Time</label>
            <select class="form-control" id="doctortime" name="DoctorTime">
 
            <c:if test="${doctorsp != null}">
        <option value="<%=dp.getStarttime()+ " - "+dp.getEndtime()%>" selected="selected" hidden="hidden"><%=dp.getStarttime()+ " - "+dp.getEndtime()%></option>
                
            </c:if>
                    
           <c:if test="${doctorsp == null}">
                <option value="" selected="selected">--Available Time--</option>
                
            </c:if>
                                
                
                
                
            </select>
            
        </div>
        
        <input type="hidden" id="userid" name="UserId" value="<%=userid%>">  
        <input type="hidden" id="doctorid" name="DoctorId" value="<%=doctor%>">  
        <input type="hidden" id="availstarttime" name="AvailStartTime" value="<%=starttime%>"> 
        <input type="hidden" id="availendtime" name="AvailEndTime" value="<%=endtime%>">
        <br>
        
        <div  class="col-md-6 form-group" > 
        <label for="date">Select Date</label>
        <input type="date" class="form-control" id="date" name="UserDate"/>
        
        </div>
        
        <div  class="col-md-6 form-group" > 
        <label for="time">Select Time</label>
        <input type="time" class="form-control" id="time" name="UserTime"/>
        
        </div>
        
        
        <br>
        
        <div  class="col-md-12 form-group" > 
        <input type="submit" class="btn btn-primary" value="Book Appointment"/>
        </div>
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
        $("#doctorspec").on('change', function(){
           // update doctors list
           console.log('spec changed');
           
           
           //take the first option value in the variable
          var firstOption = $("#doctorname option:first-child");
          //emply the doctor name option list and append first child

           $("#doctorname").empty().append(firstOption); 
           $("#doctortime").empty().append($("<option></option>").attr("value","").text("--Available Time--"));
           $("#doctorid").attr("value","");
           $('#availstarttime').attr("value","");
           $('#availendtime').attr("value","");
           
           
           
           //filter doctor speicalization and return the data those are equal to specialization value
           var filteredList = listOfDoctors.filter((val, index) => {
               console.log(val.specialization);
               return val.specialization == $("#doctorspec").val();
           });
           
           console.log(filteredList);
           filteredList.forEach(function(val){
               console.log(val);
                     $('#doctorname').append($("<option></option>").attr("value",val.name).text(val.name));
           });
           
        });
        
        //detect doctor change
        
         $("#doctorname").on('change', function(){
           // update doctors list
           console.log('doctor name changed');
           
           
           $("#doctortime").empty().append($("<option></option>").attr("value","").text("--Available Time--"));
           $('#doctorid').attr("value","");
           $('#availstarttime').attr("value","");
           $('#availendtime').attr("value","");
           
           //filter doctor speicalization and return the data those are equal to specialization value
           var filteredList = listOfDoctors.filter((val, index) => {
               console.log(val.specialization);
               return val.name == $("#doctorname").val();
           });
           
           console.log(filteredList);
           filteredList.forEach(function(val){
               console.log(val);
                     $("#doctortime").empty();
                     $('#doctortime').append($("<option></option>").attr("value",val.starttime+" - "+val.endtime).text(val.starttime+" - "+val.endtime));
                     $('#doctorid').attr("value",val.id);
                     $('#availstarttime').attr("value",val.starttime);
                     $('#availendtime').attr("value",val.endtime);
                     
                     console.log('doctor id '+val.id);
           });
           
        });
        
        
        
        
    });
    
    </script>