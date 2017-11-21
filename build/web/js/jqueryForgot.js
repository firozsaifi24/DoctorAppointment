$.validator.addMethod(
    "regex",
    function(value, element, regexp) {
        var check = false;
        return this.optional(element) || regexp.test(value);
    },
    "Please check your input."
);



$().ready(function(){
   $("#ForgotPass").validate({
       
       
       
       errorElement: 'div',
       errorClass: 'error', /*This line is not necessary*/
      rules : {

          EmailReset : {
              required : true,
              email : true,
              regex : /\S+@\S+\.\S+/
              
          }
          
          
      },
      
      messages: {

  
          EmailReset : {
              required : "This field is required*",
              email : "Please enter valid email address*",
              regex: "Please enter valid email address*"
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

