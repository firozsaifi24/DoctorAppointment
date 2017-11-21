<%-- 
    Document   : header
    Created on : Aug 25, 2017, 11:37:19 AM
    Author     : Firoz Saifi
--%>
<%@page import="DoctorProCRUD.LoginTemplate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    LoginTemplate sessionName;
    String name=null;
    String role=null;
    if(session.getAttribute("loginTemplate")!=null)
    {
    sessionName=(LoginTemplate)session.getAttribute("loginTemplate");
    name=sessionName.getName();
    role=sessionName.getRole();
    } 
%>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      <a class="navbar-brand" href="#">National Hospital</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
       <li class="active"><a href="index.jsp">Home</a></li>
        <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Doctor
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
            
            <c:set var="sessionrole" scope="session" value="<%=role%>"/>  
            
             <c:choose>  
                <c:when test="${sessionrole == 'USER'}">  
          <li><a href="DoctorProView.jsp">View List</a></li>
                </c:when>  
                <c:when test="${sessionrole == 'DOCTOR'}">  
          <li><a href="DoctorProView.jsp">View List</a></li>
                </c:when>
                <c:when test="${sessionrole == 'ADMIN'}">  
          <li><a href="DoctorProView.jsp">View List</a></li>
          <li><a href="DoctorProTiming.jsp">Fix Time</a></li>
                </c:when>  
                <c:otherwise>  
          <li><a href="DoctorProAdd.jsp">SignUp</a></li>
          <li><a href="DoctorProView.jsp">View List</a></li>
                </c:otherwise>  
            </c:choose>  
            
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Patient
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
            
     
            <c:choose>  
                <c:when test="${sessionrole == 'USER'}">  
          <li><a href="AppointmentBook.jsp">Book Appointment</a></li>
          <li><a href="AppointmentUserView.jsp">View Appointment List</a></li> 
                </c:when>  
                <c:when test="${sessionrole == 'DOCTOR'}">  
          <li><a href="AppointmentDoctorView.jsp">View Appointment List</a></li> 
                </c:when>
                <c:when test="${sessionrole == 'ADMIN'}">  
          <li><a href="UserProView.jsp">View User List</a></li> 
          <li><a href="AppointmentView.jsp">View Appointment List</a></li> 
                </c:when>  
                <c:otherwise>  
          <li><a href="AppointmentBook.jsp">Book Appointment</a></li>
                </c:otherwise>  
            </c:choose>  
        </ul>
      </li>
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Specialization
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
            
             <c:choose>  
                 
                <c:when test="${sessionrole == 'ADMIN'}">  
          <li><a href="CategoryProAdd.jsp">Add Specialization</a></li>
          <li><a href="CategoryProView.jsp">View List</a></li>
          
                </c:when>  
                <c:otherwise>  
          <li><a href="CategoryProView.jsp">View List</a></li>
                </c:otherwise>  
            </c:choose>  
            
          
          
        </ul>
       </li>
   
           
            
                
            
        <c:if test="${sessionrole == 'ADMIN'}">
                
        <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Feedback
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="FeedbackView.jsp">View Feedback</a></li>
        </ul>
       </li>
       
       </c:if>
       
      </ul>
      <ul class="nav navbar-nav navbar-right">

              <c:set var="sessionname" scope="session" value="<%=name%>"/>  
            <c:if test="${sessionname != null}">
                <c:choose>  
                 
                <c:when test="${sessionrole == 'ADMIN'}">  
                <li><a href="UserSelfEdit.jsp"><span class="glyphicon glyphicon-user"></span>&nbsp; Welcome ${sessionname}</a></li>
                <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
          
                </c:when>  
                <c:when test="${sessionrole == 'USER'}">  
                <li><a href="UserSelfEdit.jsp"><span class="glyphicon glyphicon-user"></span>&nbsp; Welcome ${sessionname}</a></li>
                <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
          
                </c:when>
                <c:when test="${sessionrole == 'DOCTOR'}">  
                <li><a href="DoctorSelfEdit.jsp"><span class="glyphicon glyphicon-user"></span>&nbsp; Welcome ${sessionname}</a></li>
                <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
          
                </c:when> 
                <c:otherwise>  
                <li><a href=""><span class="glyphicon glyphicon-user"></span>&nbsp; Welcome ${sessionname}</a></li>
                <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </c:otherwise>  
            </c:choose>  
            </c:if>
            <c:if test="${sessionname == null}">
                <li><a href="UserProAdd.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:if>
          
      </ul>
    </div>
  </div>
</nav>

          

            