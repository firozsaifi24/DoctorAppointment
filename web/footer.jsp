<%-- 
    Document   : footer
    Created on : Sep 13, 2017, 6:39:38 PM
    Author     : Firoz Saifi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
             footer {
        background-color: #2d2d30;
        color: #f5f5f5;
        padding: 32px;
    }

    footer a {
        color: #ccffff;
    }

    footer a:hover {
        color: #777;
        text-decoration: none;
    }
        </style>
    </head>
    <body>
       <footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="Go to Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p>Copyright &copy; 2017-2018 <a href="index.jsp" data-toggle="tooltip" >National Hospital</a></p> 
</footer>
        
        
         <script>
    $(document).ready(function(){
    // Initialize Tooltip
    $('[data-toggle="tooltip"]').tooltip(); 
    });
        </script>

    </body>
</html>
