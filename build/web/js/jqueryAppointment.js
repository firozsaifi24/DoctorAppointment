$.validator.addMethod(
    "regex",
    function(value, element, regexp) {
        var check = false;
        return this.optional(element) || regexp.test(value);
    },
    "Please check your input."
);

$.validator.addMethod(
    "dategreaterthantoday",
    function(value, element, externaldata) {
        var check = false;
        
        var today, someday;
        var somedate= $( "#date" ).val();
        
        console.log(somedate);
        
        today = new Date();
        today.setHours(00,00,00);
        someday = new Date(somedate);
        
        
        console.log(today + " == "+ someday);
        
        var a=new Date();
        a.setDate(a.getDate()+30);
        console.log(a);
        
        return this.optional(element) || someday>=today;  
        
        
    },
    "Please check your input."
);

$.validator.addMethod(
    "datelessthandays",
    function(value, element, externaldata) {
        var check = false;
        
        var today, someday;
        var somedate= $( "#date" ).val();
        
        console.log(somedate);
        
        today = new Date();
        today.setDate(today.getDate()+30);
        today.setHours(23,59,59);
        someday = new Date(somedate);
        
        
        console.log(today + " == "+ someday);
        
        return this.optional(element) || someday<=today;  
        
        
    },
    "Please check your input."
);



$().ready(function(){
   $("#appointForm").validate({
       
       
       
       errorElement: 'div',
       errorClass: 'error', /*This line is not necessary*/
      rules : {
          
          UserName : {
              required: true,
              regex : /^[A-Za-z\s]+$/,
              minlength:3,
              maxlength:20

          },
          UserAge : {
              required : true,
              regex: /^[0-9]+$/,
              max: 100
              
          },
          UserGender : "required",
          UserPhone : {
              required : true,
              regex: /[789][0-9]{9}/,
              maxlength: 10
          },
          DoctorSpec: "required",
          DoctorName: "required",
          UserDate: {
              required:true,
              dategreaterthantoday: true,
              datelessthandays: true
          },
          UserTime:  {
              required : true,
              min: function() {
                            return $( "#availstarttime" ).val();
                                             },
              max: function() {
                            return $( "#availendtime" ).val();
                                             },
              remote: {
                  url: "http://localhost:31066/DoctorAppointment/AppointmentDateTimeExist",
                  type: "get",
                  data: {
                      
                            doctor: function() {
                            return $( "#doctorname" ).val();
                                             },
                      
                            date: function() {
                            return $( "#date" ).val();
                                             },
                                             
                            time: function() {
                            return $( "#time" ).val();
                                                 }                 
                        
                        }
                  
              }
              
          }
                  
          
      },
      
      messages: {

          UserName : {
              required: "This field is required*",
              regex : "Only letters allowed* e.g. Firoz",
              minlength: "It must be atleast 3 characters long*",
              maxlength: "It must not exceed 20 character*"

          },
          UserAge : {
              required : "This field is required*",
              regex: "Only numbers allowed* e.g 12",
              max: "Please enter valid Age*"
          },
          UserGender : "This field is required*",
          UserPhone : {
              required : "This field is required",
              regex: "Please Enter 10 digit valid number",
              maxlength: "Please Enter 10 digit valid number"
          },
          DoctorSpec: "This field is required*",
          DoctorName: "This field is required*",
          UserDate: {
              required: "This field is required*",
              dategreaterthantoday : "Date must not less than today*",
              datelessthandays: "Date must not exceed 30 days from today*"
                  },
          UserTime: {
              required : "This field is required*",
              min: "Please choose time between the available time",
              max: "Please choose time between the available time",
              remote: "This time is already booked*"
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

