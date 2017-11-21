<%-- 
    Document   : ViewProfiles
    Created on : Aug 17, 2017, 3:36:56 PM
    Author     : Firoz Saifi
--%>

<%@page import="DoctorProCRUD.LoginTemplate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="CategoryProfile.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
        
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    
    </head>
    
    <% 
        CategoryProfilesDAO pdao=new CategoryProfilesDAOImpl(); 
        List<CategoryProfiles> list= pdao.getProfiles();
        
        request.setAttribute("CategoryPro", list);
    %>
    
    <% 
    LoginTemplate sessionName;
    String role=null;
    if(session.getAttribute("loginTemplate")!=null)
    {
    sessionName=(LoginTemplate)session.getAttribute("loginTemplate");
    role=sessionName.getRole();
    } 
    %>
    
    <body id="myPage">
        
        <c:import url="header.jsp"></c:import>
        
        <h3 style="margin: auto; width: 80%; text-align: center">Available Specialization</h3>
        <br/>
        
        <table class="table table-striped" style="margin: auto; width: 80%; text-align: center">
            <thead>
                <tr>
                    <th>Specialization</th>
                    <th>Description</th>
                    <th>Image</th>
                    
             <c:set var="catrole" scope="session" value="<%=role%>"/>  
            
             <c:if test="${catrole == 'ADMIN'}">
                    <th>Delete</th>
                    <th>Update</th>
             </c:if>    
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${CategoryPro}" var="x">
                <tr>
                    <th>${x.getSpecialization()}</th>
                    <th>${x.getDescription()}</th>      
                    <th><img src="${x.getImage()}" alt="Hospital Department" width="150" height="100"> </th>
                <c:if test="${catrole == 'ADMIN'}">
                    <th><a href="CategoryProDelete?id=${x.getId()}" class="btn btn-danger">Delete</a></th>
                    <th><a href="CategoryProEdit.jsp?id=${x.getId()}" class="btn btn-success">Update</a></th>
                </c:if>  
                    
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
