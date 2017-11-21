$.validator.addMethod(
    "regex",
    function(value, element, regexp) {
        var check = false;
        return this.optional(element) || regexp.test(value);
    },
    "Please check your input."
);



$().ready(function(){
   $("#feedbackForm").validate({
       
       
       
       errorElement: 'div',
       errorClass: 'error', /*This line is not necessary*/
      rules : {
          
          CommenterName : {
              required: true,
              regex : /^[A-Za-z\s]+$/,
              minlength:3,
              maxlength:20

          },
          CommenterEmail : {
              required : true,
              email : true,
              regex : /\S+@\S+\.\S+/
              
          },
          CommenterComment : {
              required : true,
              minlength : 6,
              maxlength : 100
          }
          
          
      },
      
      messages: {

          CommenterName : {
              required: "This field is required*",
              regex : "Only letters allowed* e.g. Firoz",
              minlength: "It must be atleast 3 characters long*",
              maxlength: "It must not exceed 20 character*"

          },
          CommenterEmail : {
              required : "This field is required*",
              email : "Please enter valid email address*",
              regex: "Please enter valid email address*"
          },
          CommenterComment : {
              required : "This field is required*",
              minlength : "It must be atleast 6 characters long*",
              maxlength : "It must not exceed 100 characters*"
          }
      },
      
       highlight: function (element) {
                $(element).find().addClass('error');
            },
            unhighlight: function (element) {
                $(element).find().removeClass('error');
            }
       
        
   });
    
});

