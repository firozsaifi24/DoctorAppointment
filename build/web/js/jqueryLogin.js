$.validator.addMethod(
    "regex",
    function(value, element, regexp) {
        var check = false;
        return this.optional(element) || regexp.test(value);
    },
    "Please check your input."
);



$().ready(function(){
   $("#loginForm").validate({
       
       
       
       errorElement: 'div',
       errorClass: 'error', /*This line is not necessary*/
      rules : {

          Email : {
              required : true,
              email : true,
              regex : /\S+@\S+\.\S+/
              
          },

          Password: "required"
          
          
      },
      
      messages: {

  
          Email : {
              required : "This field is required*",
              email : "Please enter valid email address*",
              regex: "Please enter valid email address*"
          },
 
          Password: "This field is required*"
      },
      
       highlight: function (element) {
                $(element).find().addClass('error');
            },
            unhighlight: function (element) {
                $(element).find().removeClass('error');
            }
       
        
   });
    
});

