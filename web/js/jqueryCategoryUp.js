$.validator.addMethod(
    "regex",
    function(value, element, regexp) {
        var check = false;
        return this.optional(element) || regexp.test(value);
    },
    "Please check your input."
);



$().ready(function(){
   $("#categoryFormUp").validate({
       
       
       
       errorElement: 'div',
       errorClass: 'error', /*This line is not necessary*/
      rules : {
          
          CategoryName : {
              required: true,
              regex : /^[A-Za-z]+$/,
              minlength:5,
              maxlength:30

          },
          CategoryDescription : {
              required : true,
              maxlength : 100
              
          }        
          
      },
      
      messages: {

          CategoryName : {
              required: "This field is required*",
              regex : "Only letters allowed* e.g. Firoz",
              minlength: "It must be atleast 5 characters long*",
              maxlength: "It must not exceed 30 characters*"

          },
          CategoryDescription : {
              required : "This field is required*",
              maxlength : "It must not exceed 100 character*"
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

