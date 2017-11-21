$.validator.addMethod(
    "regex",
    function(value, element, regexp) {
        var check = false;
        return this.optional(element) || regexp.test(value);
    },
    "Please check your input."
);

$.validator.addMethod(
    "doblessthandays",
    function(value, element, externaldata) {
        var check = false;
        
        var today, someday;
        var somedate= $( "#dob" ).val();
        
        console.log(somedate);
        
        today = new Date();
        today.setFullYear(today.getFullYear()-18);
        today.setHours(23,59,59);
        someday = new Date(somedate);
        
        
        console.log(today + " == "+ someday);
        
        return this.optional(element) || someday<=today;  
        
        
    },
    "Please check your input."
);



$().ready(function(){
   $("#doctorForm").validate({
       
       
       
       errorElement: 'div',
       errorClass: 'error', /*This line is not necessary*/
      rules : {
          
          DoctorName : {
              required: true,
              regex : /^[A-Za-z\s]+$/,
              minlength:3,
              maxlength:20

          },
          DoctorEmail : {
              required : true,
              email : true,
              regex : /\S+@\S+\.\S+/,
              remote: {
                  url: "http://localhost:31066/DoctorAppointment/EmailExistValid",
                  type: "get",
                  data: {
                            email: function() {
                            return $( "#email" ).val();
                                                 }
                            }
                  
              }
              
          },
          DoctorPassword : {
              required : true,
              minlength : 6,
              maxlength: 15
          },
          DoctorConfirmPassword : {
              required : true,
              equalTo : "#password"
          },
          DoctorGender : "required",
          DoctorDOB : {
              required : true,
              doblessthandays: true
          },
          DoctorSpecialist : "required",
          DoctorExperience : "required",
          DoctorPhone : {
              required : true,
              regex: /[789][0-9]{9}/,
              maxlength: 10
          },
          DoctorAddress: "required",
          DoctorPhoto: "required"
          
          
      },
      
      messages: {

          DoctorName : {
              required: "This field is required*",
              regex : "Only letters allowed* e.g. Firoz",
              minlength: "It must be atleast 3 characters long*",
              maxlength: "It must not exceed 20 character*"

          },
          DoctorEmail : {
              required : "This field is required*",
              email : "Please enter valid email address*",
              regex: "Please enter valid email address*",
              remote: "Email already Exist!"
          },
          DoctorPassword : {
              required : "This field is required*",
              minlength : "Password must be atleast 6 characters long*",
              maxlength: "Password must not exceed 15 characters*"
          },
          DoctorConfirmPassword : {
              required : "This field is required*",
              equalTo : "Password do not match*"
          },
          DoctorGender : "This field is required*",
          DoctorDOB : {
              required: "This field is required*",
              doblessthandays: "Age must be above 18*"
                  },
          DoctorSpecialist : "This field is required*",
          DoctorExperience : "This field is required*",
          DoctorPhone : {
              required : "This field is required",
              regex: "Please Enter 10 digit valid number",
              maxlength: "Please Enter 10 digit valid number"
          },
          DoctorAddress: "This field is required*",
          DoctorPhoto: "This field is required*"
      },
      
       highlight: function (element) {
                $(element).find().addClass('error');
            },
            unhighlight: function (element) {
                $(element).find().removeClass('error');
            }
       
        
   });
    
});

