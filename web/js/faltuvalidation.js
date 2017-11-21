function validateUsername()
        {
            var name=document.getElementById("username").value;
            var vpattern=/^[A-Za-z]+$/;
                if(name == null || name =="")
                {
                    alert("Username Cannot be blank!");
                    return false;
                }
                if(name.length<6)
                {
                    alert("Username must be at least 6 characters long!");
                    return false;
                }
                if(name.match(vpattern))
                {
                    return true;
                }
                else
                {
                    alert("Username must contain alphabets only!");
                    return false;
                }
                
        };
        
        function validateEmail()
        {
            var email=document.getElementById("email").value;
            if(email==null || email=="")
            {
                alert("Email cannot be blank!");
                return false;
            }
 
            if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))  
            {  
            return true; 
            }
            else{
            alert("You have entered an invalid email address!")  
            return false; 
            }
 
            
         }
        
        function validatePassword(){
            var firstPassword=document.getElementById("password").value;
            var secondPassword=document.getElementById("confirmpass").value;
            
            if(firstPassword==null || firstPassword=="")
            {
                alert("Password cannot be blank");
                return false;
            }
            
            if(firstPassword<6)
            {
                alert("Password must be at least 6 characters long!");
                return false;
            }                      
            
            if(secondPassword==null || secondPassword=="")
            {
                alert("Confirm Password cannot be blank");
                return false;
            }
            
            if(firstPassword!=secondPassword)
            {
                alert("Password do not match!");
                return false;
            }
            
        };
        
       /* function validateGender()
        {
            var gender=document.getElementById("gender").value;
            if(gender.equals(""))
            {
                alert("Gender cannot be blank!");
                return false;
            }
            alert("Gender did not get");
            return false
        }*/
        function validateDOB()
        {
            var dob=document.getElementById("dob").value;
            if(dob==null || dob=="")
            {
                alert("Date of Birth cannot be blank!");
                return false;
            }            
            
            
        }
        function validateSpeicalist()
        {
            var specialist=document.getElementById("specialist").value;
            if(specialist=="")
            {
                alert("Please choose the specialization!");
                return false;
            }              
        }
        function validatePhone()
        {
            var phone=document.getElementById("phone").value;
            if(phone==null || phone=="")
            {
                alert("Phone cannot be blank!");
                return false;
            }       
        }
        function validateAddress()
        {
            var address=document.getElementById("address").value;
            if(address==null || address=="")
            {
                alert("Address cannot be blank!");
                return false;
            }   
        }
        

         $(document).ready(function(){  
            $("#sub").click(function(){
                
                var username=validateUsername();
                if(username==false)
                {
                    return false;
                }             
                var email=validateEmail();
                if(email==false)
                {
                    return false;
                }
                var password=validatePassword();
                if(password==false)
                {
                    return false;
                }
                /*var gender=validateGender();
                if(gender==false)
                {
                    return false;
                }*/
                var dob=validateDOB();
                if(dob==false)
                {
                    return false;
                }
                var specialist=validateSpeicalist();
                if(specialist==false)
                {
                    return false;
                }  
                var phone=validatePhone();
                if(phone==false)
                {
                    return false;
                }    
                var address=validateAddress();
                if(address==false)
                {
                    return false;
                }                  
                               
            alert("Form Submitted Successfully!");
            return true;
                    });  
            });


