package DoctorProCRUD;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MasterFilter implements Filter{
LoginTemplate loginTemplate;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

                    
        
        
        
        //start check
        HttpSession session=req.getSession();
        
        
        if(session.getAttribute("loginTemplate")!= null)
            {
                
                switch(req.getRequestURI())
                {
                    case "/DoctorAppointment/css/background.css":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/images/doctor.jpg":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;   
                    
                    case "/DoctorAppointment/images/hospital.jpg":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/images/nglogo.jpg":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;
                    
                    case "/DoctorAppointment/js/jquery.validate.min.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/js/jqueryAppointment.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/js/jqueryCategory.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/js/jqueryCategoryUp.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    
                    case "/DoctorAppointment/js/jqueryDoctorUp.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/js/jqueryDoctorTime.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/js/jqueryFeedback.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/js/jqueryLogin.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/js/jqueryUser.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return; 
                    
                    case "/DoctorAppointment/js/jqueryUserUp.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/EmailExistValid":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return; 
                    
                }
                
                
                loginTemplate = (LoginTemplate)req.getSession().getAttribute("loginTemplate");
        if( loginTemplate.getRole().equals("ADMIN") )
        {

            switch( req.getRequestURI() )
            {
                     case "/DoctorAppointment/index.jsp":
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
            case "/DoctorAppointment/":
                                                        chain.doFilter(request, response);
                                                        return;                                            
                                                        
            case "/DoctorAppointment/Logout.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;       
                                                        
            case "/DoctorAppointment/Logout":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                            
                                                        
            case "/DoctorAppointment/DoctorProView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return; 
                                                        
            case "/DoctorAppointment/DoctorProEdit.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;  
            case "/DoctorAppointment/DoctorProDelete":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;  
                                                        
            case "/DoctorAppointment/DoctorProUpdate":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                              
                                                        
                                                        
                                                        
            case "/DoctorAppointment/UserProView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
            case "/DoctorAppointment/UserProEdit.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
            case "/DoctorAppointment/UserSelfEdit.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                           
                                                        
            case "/DoctorAppointment/UserProDelete":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;  
                                                        
            case "/DoctorAppointment/UserProUpdate":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                             
                                                        
            case "/DoctorAppointment/CategoryProView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
            case "/DoctorAppointment/CategoryProEdit.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;   
                                                        
            case "/DoctorAppointment/CategoryProUpdate":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
            case "/DoctorAppointment/CategoryProDelete":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;  
                                                        
            case "/DoctorAppointment/CategoryProAdd.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;    
                                                        
            case "/DoctorAppointment/CategoryProSignUp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                              
                                                        
                                                        
            case "/DoctorAppointment/DoctorProTiming.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return; 
                                                        
            case "/DoctorAppointment/DoctorProTime":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return; 
                                                        
            case "/DoctorAppointment/doctorcarousel.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;    
                                                        
            case "/DoctorAppointment/AppointmentView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return; 
                                                        
            case "/DoctorAppointment/DeleteAppoint":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                            
                                                         
                                                        
            case "/DoctorAppointment/FeedbackView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;  
                                                        
            case "/DoctorAppointment/FeedbackDelete":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                              
                                                        
            case "/DoctorAppointment/success.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;  
                                                        
            case "/DoctorAppointment/invalid.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                            
                                                        
                default:
                    resp.sendRedirect("invalid.jsp");
                    break;
                
                
            }
        }
        else if(loginTemplate.getRole().equals("DOCTOR"))
        {
             switch( req.getRequestURI() )
            {
                   case "/DoctorAppointment/index.jsp":
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
            case "/DoctorAppointment/":
                                                        chain.doFilter(request, response);
                                                        return;                                           
                                                        
            case "/DoctorAppointment/Logout.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;       
                                                        
            case "/DoctorAppointment/Logout":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                            
                                                        
            case "/DoctorAppointment/DoctorProView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
                                                        
            case "/DoctorAppointment/CategoryProView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;   
                                                        
            case "/DoctorAppointment/AppointmentDoctorView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;   
                                                        
            case "/DoctorAppointment/DoctorProUpdate":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;  
                                                        
            case "/DoctorAppointment/DoctorSelfEdit.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                                
                                                        

                                                        
            case "/DoctorAppointment/doctorcarousel.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;  
                                                        
            case "/DoctorAppointment/Feedback":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                             
                                                        
            case "/DoctorAppointment/success.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
            case "/DoctorAppointment/invalid.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                           
                                                        
                                                        
                default:
                    resp.sendRedirect("invalid.jsp");
                    break;                                
                                                        
            }
        }
        else if(loginTemplate.getRole().equals("USER"))
        {
             switch( req.getRequestURI() )
            {
                      case "/DoctorAppointment/index.jsp":
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
            case "/DoctorAppointment/":
                                                        chain.doFilter(request, response);
                                                        return;                                           
                                                        
            case "/DoctorAppointment/Logout.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;       
                                                        
            case "/DoctorAppointment/Logout":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                            
                                                        
            case "/DoctorAppointment/DoctorProView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;    
                                                        
            case "/DoctorAppointment/CategoryProView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                            
                                                        
                                                        
            case "/DoctorAppointment/UserProAdd.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return; 
                                                                                                  
                                                        
                                                                    
            case "/DoctorAppointment/UserProSignUp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;   
                                                                                                 
                                                        
            case "/DoctorAppointment/AppointmentBook.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return; 
                                                        
            case "/DoctorAppointment/BookAppoint":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
            case "/DoctorAppointment/AppointmentDateTimeExist":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                            
                                                        
            case "/DoctorAppointment/AppointmentUserView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;  
                                                        
            case "/DoctorAppointment/UserSelfEdit.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
            case "/DoctorAppointment/UserProUpdate":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                              
                                                                                                   
                                                        
            case "/DoctorAppointment/doctorcarousel.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;   
                                                        
                                                        
            case "/DoctorAppointment/Feedback":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                              
                                                        
            case "/DoctorAppointment/success.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;      
                                                        
            case "/DoctorAppointment/invalid.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                             
                                                        
                                                        
                 default:
                    resp.sendRedirect("invalid.jsp");
                    break;                                                                                        
            }
        }        
        
        
              
        
            }
        else
        {
             switch( req.getRequestURI() )
            {
            case "/DoctorAppointment/index.jsp":
                                                        chain.doFilter(request, response);
                                                        return;                                         
            
            case "/DoctorAppointment/":
                                                        chain.doFilter(request, response);
                                                        return;
            
            case "/DoctorAppointment/Login.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
            case "/DoctorAppointment/Login":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return; 
            
            case "/DoctorAppointment/Logout.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;       
                                                        
            case "/DoctorAppointment/Logout":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;    
                                                        
                                                        
                                                        
                                                        
            case "/DoctorAppointment/UserProAdd.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;  
                                                        
            case "/DoctorAppointment/doctorcarousel.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;     
                                                        
            case "/DoctorAppointment/UserProSignUp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;  
                                                        
            case "/DoctorAppointment/CategoryProView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;
                                                        
            case "/DoctorAppointment/DoctorProView.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                               
                                                        
            case "/DoctorAppointment/DoctorProAdd.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;   
                                                        
            case "/DoctorAppointment/DoctorProSignUp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                              
                                                        
            case "/DoctorAppointment/Feedback":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;                                              
                                                        
            case "/DoctorAppointment/success.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return;    
             
            case "/DoctorAppointment/invalid.jsp":
                                                        System.out.println("Reached");
                                                        chain.doFilter(request, response);
                                                        return; 
                                                        
            case "/DoctorAppointment/EmailExistValid":
                                                        System.out.println("Reached");
                                                        System.out.println(req.getRequestURI());
                                                        chain.doFilter(request, response);
                                                        return;                                            
                                                        
            case "/DoctorAppointment/ForgotPassword.jsp":
                                                        System.out.println("Reached");
                                                        System.out.println(req.getRequestURI());
                                                        chain.doFilter(request, response);
                                                        return; 
                                                                                                    
                                                        
            case "/DoctorAppointment/ForgotPassword":
                                                        System.out.println("Reached");
                                                        System.out.println(req.getRequestURI());
                                                        chain.doFilter(request, response);
                                                        return; 
                                                        
            case "/DoctorAppointment/successResetPass.jsp":
                                                        System.out.println("Reached");
                                                        System.out.println(req.getRequestURI());
                                                        chain.doFilter(request, response);
                                                        return;   
                                                        
            case "/DoctorAppointment/successResetFail.jsp":
                                                        System.out.println("Reached");
                                                        System.out.println(req.getRequestURI());
                                                        chain.doFilter(request, response);
                                                        return;                                              
                                                        
                    case "/DoctorAppointment/css/background.css":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/images/doctor.jpg":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;   
                    
                    case "/DoctorAppointment/images/hospital.jpg":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/images/nglogo.jpg":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;
                    
                    case "/DoctorAppointment/js/jquery.validate.min.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/js/jqueryUser.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return; 
                    
                    case "/DoctorAppointment/js/jqueryDoctor.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/js/jqueryFeedback.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;  
                    
                    case "/DoctorAppointment/js/jqueryLogin.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;
                    
                    case "/DoctorAppointment/js/jqueryForgot.js":
                    System.out.println("Reached");
                    System.out.println(req.getRequestURI());
                    chain.doFilter(request, response);
                    return;
                                                        
                                                        
                                                        
                 default:
                    resp.sendRedirect("invalid.jsp");
                    break;                  
            }     
        }

        
        
        

    }

    @Override
    public void destroy() {
    }
    
}
