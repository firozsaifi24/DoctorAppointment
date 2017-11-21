<%-- 
    Document   : index
    Created on : Aug 25, 2017, 8:23:10 PM
    Author     : Firoz Saifi
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@page import="java.util.List"%>
<%@page import="CategoryProfile.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" type="text/css" href="css/background.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/background.css">
        
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/jqueryFeedback.js"></script>

        <style>  
            
        .carousel-inner, img {
        width: 100%; /* Set width to 100% */
        height: 450px;
        margin: auto;
        }
        
        #myCarousel
        {
            width: 80%;
            height: 450px;  
            margin: auto;
        }
        
        .carousel-caption h3 {
            color: #fff !important;
        }
        
        @media (max-width: 600px) {
            .carousel-caption {
                display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
                            }
        } 
        
        
        .person {
            border: 10px solid transparent;
            margin-bottom: 25px;
            width: 50%;
            height: 50%;

        }
        .person:hover {
            border-color: #f1f1f1;
        }
        
        
        .navbar {
      margin-bottom: 0;
      
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
        
        request.setAttribute("CategoryProData", list);
    %>
    
    <body id="myPage">
        
        <c:import url="header.jsp"></c:import>  
        
        
        <div>
        <marquee width="100%" behavior="scroll">  
            <mark style="color:red;background-color: lightyellow;" >Note: You must be a valid user to book an Appointment.</mark>
</marquee>
        </div>
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
    <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
     <c:forEach var="j" begin="1" end="${fn:length(CategoryProData)}">
        <li data-target="#myCarousel" data-slide-to="${j}"></li>
    </c:forEach>
    </ol>

  <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
    <div class="item active">
<!--        <img src="images/cardiology.jpg" alt="Cardiology" width="1200" height="450px" style="width:100%; height: 450px;">-->
<img src="images/hospital.jpg" alt="Hospital" width="1200" height="450px" style="width:100%; height: 450px;">
      <div class="carousel-caption">
        <h3>Welcome to National Hospital</h3>
      </div> 
    </div>

        <c:forEach items="${CategoryProData}" var="x">
    <div class="item">
        <a href="doctorcarousel.jsp?category=${x.getSpecialization()}">
        <img src="${x.getImage()}" alt="Hospital Department" width="1200" height="450px" style="width:100%; height: 450px;">
        </a>
        <div class="carousel-caption">
        <h3>${x.getSpecialization()}</h3>
        <p>${x.getDescription()}</p>
      </div> 
    </div>
     </c:forEach>
        
   
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
    </a>
    
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
    </a>
  
    </div>
        
        <br>
        <!-- end of Carousel -->

        <div class="container" style="text-align: justify">
            <h2 class="text-center">National Hostpital </h2>
            <p>A hospital is a health care institution providing patient treatment with specialized medical and nursing staff and medical equipment. The best-known type of hospital is the general hospital, which typically has an emergency department to treat urgent health problems ranging from fire and accident victims to a heart attack. A district hospital typically is the major health care facility in its region, with large numbers of beds for intensive care and additional beds for patients who need long-term care. Specialised hospitals include trauma centres, rehabilitation hospitals, children's hospitals, seniors' (geriatric) hospitals, and hospitals for dealing with specific medical needs such as psychiatric treatment (see psychiatric hospital) and certain disease categories. Specialised hospitals can help reduce health care costs compared to general hospitals.</p>
        </div>
        
        <br>
        <br>
        
        <!-- end of content -->
        
        <div class="row text-center" style="width:80%; margin: auto">
         <h4 class="text-center"><strong>Top Experienced Doctors</strong></h4>
    <div class="col-sm-4">
      <a href="#demo" data-toggle="collapse">
        <img src="images/doctor.jpg" class="person" alt="Random Name" width="255" height="255">
        <p class="text-center"><strong>Dr. Firoz</strong></p>
      </a>
      <div id="demo" class="collapse">
        <p>Surgery Specilist</p>
        <p>MBBS</p>
        <p>Member since 1988</p>
      </div>
    </div>
    <div class="col-sm-4">
      <a href="#demo2" data-toggle="collapse">
        <img src="images/doctor.jpg" class="person" alt="Random Name" width="255" height="255">
        <p class="text-center"><strong>Dr. Pradeep</strong></p>
      </a>
      <div id="demo2" class="collapse">
        <p>Heart Specialist</p>
        <p>MBBS, PHD</p>
        <p>Member since 1988</p>
      </div>
    </div>
    <div class="col-sm-4">
      <a href="#demo3" data-toggle="collapse">
          <img src="images/doctor.jpg" class="person" alt="Random Name" width="255" height="255">
          <p class="text-center"><strong>Dr. Abhishek</strong></p>
      </a>
      <div id="demo3" class="collapse">
        <p>Cancer Specialist</p>
        <p>MBBS</p>
        <p>Member since 2005</p>
      </div>
    </div>
  </div>
        
        <br>
        <br>
        
        <!-- end of profile -->
   
        <div class="container" style="border-top: 1px solid black; background-color: #fffaeb; width: 100%;">
            <h3 class="text-center">Contact Us</h3> <br>
    <div class="row test">
    <div class="col-md-4">
      <p>Contact:</p>
      <p><span class="glyphicon glyphicon-map-marker"></span>&nbsp; Delhi, India</p>
      <p><span class="glyphicon glyphicon-phone"></span>&nbsp; Phone: +11-99999</p>
      <p><span class="glyphicon glyphicon-envelope"></span>&nbsp; Email: mail@mail.com</p> 
    </div>
    <div class="col-md-8">
        <p>Any queries? Write us.</p>
        <form id="feedbackForm" action="Feedback" method="post">
      <div class="row">
        <div class="col-sm-6 form-group">
            <input class="form-control" id="name" placeholder="Name" name="CommenterName" type="text">
        </div>
        <div class="col-sm-6 form-group">
            <input class="form-control" id="email" placeholder="Email" name="CommenterEmail" type="email">
        </div>
      </div>
      <textarea class="form-control" id="comments"  name="CommenterComment" placeholder="Comment" rows="5"></textarea>
      <div class="row">
        <div class="col-md-12 form-group">
          <button class="btn pull-right" type="submit">Submit</button>
        </div>
      </div> 
        </form>
    </div>
  </div>
</div>
        
        
        <!-- end of contact -->
        
        <jsp:include page="footer.jsp" />  
        
        
    </body>
</html>
