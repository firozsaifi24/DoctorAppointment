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
   $("#userFormUp").validate({
       
       
       
       errorElement: 'div',
       errorClass: 'error', /*This line is not necessary*/
      rules : {
          
          UserName : {
              required: true,
              regex : /^[A-Za-z\s]+$/,
              minlength:3,
              maxlength:20

          },
          UserEmail : {
              required : true,
              email : true,
              regex : /\S+@\S+\.\S+/
              
          },
          UserPassword : {
              required : true,
              minlength : 6,
              maxlength: 15
          },
          UserConfirmPassword : {
              required : true,
              equalTo : "#password"
          },
          UserGender : "required",
          UserDOB : {
              required : true,
              doblessthandays: true
          },
          UserPhone : {
              required : true,
              regex: /[789][0-9]{9}/,
              maxlength: 10
          },
          UserAddress: "required"
          
          
      },
      
      messages: {

          UserName : {
              required: "This field is required*",
              regex : "Only letters allowed* e.g. Firoz",
              minlength: "It must be atleast 3 characters long*",
              maxlength: "It must not exceed 20 character*"

          },
          UserEmail : {
              required : "This field is required*",
              email : "Please enter valid email address*",
              regex: "Please enter valid email address*"
          },
          UserPassword : {
              required : "This field is required*",
              minlength : "Password must be atleast 6 characters long*",
              maxlength : "Password must not exceed 15 characters*"
          },
          UserConfirmPassword : {
              required : "This field is required*",
              equalTo : "Password do not match*"
          },
          UserGender : "This field is required*",
          UserDOB : {
              required: "This field is required*",
              doblessthandays: "Age must be above 18*"
                  },
          UserPhone : {
              required : "This field is required",
              regex: "Please Enter 10 digit valid number",
              maxlength: "Please Enter 10 digit valid number"
          },
          UserAddress: "This field is required*"
      },
      
       highlight: function (element) {
                $(element).find().addClass('error');
            },
            unhighlight: function (element) {
                $(element).find().removeClass('error');
            }
       
        
   });
    
});

