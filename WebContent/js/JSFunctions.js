/*$(document).ready(function(){
	getAllStudents();
});*/

/* window.onload = function(){ getAllStudents(); } */

	
	  
	// var name = document.getElementById("name").value;
	  // var dept = document.getElementById("dept").value;
	  // var prof_id = document.getElementById("prof_id").value;
function fromUser(){

	 var user=[];
	 var fieldStatus=true;
	  var id = document.getElementById("id").value;
	  var name = document.getElementById("name").value;
	  var dept = document.getElementById("dept").value;
	  var prof_id = document.getElementById("prof_id").value;
	  if(id==="" || prof_id===""){
		  fieldStatus=false;
		  return fieldStatus;
	  }
	  else{
		  user = {id,name , dept , prof_id};
		  return user; 
	  }
	}

function insertStudent(){
// Add Student to Data Base with Connecting to Server
	 
	  var check=checkStudentExists();
	  var user = fromUser();
	  if(!(user===false)){
		 if(check===false){
			 
	      $.ajax({
	    	  
	        crossDomain:true,
	        type:"POST",
	        url:"http://localhost:8080/WebApplication/api/students",
	        data: JSON.stringify(user),
	        async:true,
	        cache:false,
	        contentType: "application/json",
	        success:function(response){
	        	
	        	getAllStudents();
	        	setEmpty();
	       
	        },
	      
	      });
		 }else
			 alert("The record Exists!!");

	  }else{
		  alert("Please Fill id fields!!");
	  }
  }
var existsStudent=[]
function checkStudentExists(){
// Check if Student does Exists
	var user=fromUser();
	if((user===false));
		
	else{
		var id = document.getElementById("id").value;
	check=false;
	for(var i=0;i< existsStudent.length;i++){
		if(existsStudent[i]==id)
			check=true;
	}
	return check;
		}
	}
function getAllStudents(){
// Load Student Data into Table From Server
    $.ajax({
      type:"GET",
      contentType:"application/json; charset=UTF-8",
      url:"http://localhost:8080/WebApplication/api/students",
      dataType:'json',
      success: function (response) {
    	 
    	var trHTML='';
    	    for(var f=0;f<response.length;f++) {
    	     trHTML += '<tr><td>' + '<input type="checkbox" onchange="selectStudent('+response[f]['id']+')" />' +'</td><td>' + response[f]['id']+'</td><td>'+response[f]['name'] +'</td><td>'+response[f]['dept']+'</td>'+'<td>'+response[f]['prof_id']+'</td></tr>';
    	   var check=existsStudent.indexOf(response[f]['id']);
    	   if (check == -1) {
    		   existsStudent.push(response[f]['id']);
		}
    	     
    	     
}
    	     
    	    $('#datatable').html(trHTML);
    	    // Insert Table row data into the Input (text box)
    	    $("#datatable tr").each(function(){
    	    	$(this).click(function(){
    	    		$("#datatable tr").removeClass('hover');
    	    		$(this).addClass('hover');
    	    		values = $("td", $(this));
    	    		$("#id").val(values[1].innerHTML);
    	    		$("#name").val(values[2].innerHTML);
    	    		$("#dept").val(values[3].innerHTML);
    	    		$("#prof_id").val(values[4].innerHTML);
    	    		
    	    	});
    	    });
    	    
            $( ".spin-grid" ).removeClass( "fa-spin" );
    	    
    	  }
    	});
      
    
    
  }


var studentsSelected = []
function selectStudent(id){
	i = studentsSelected.indexOf(id);
	if(i == -1){
		studentsSelected.push(id);

	}
	else{
		studentsSelected.splice(i, 1);
		
	}
}

function removeStudent(){
	// Sent an ID of a Teacher to Server for deleting a Teacher in Database
	  var user = studentsSelected
	  existsStudent= $.grep(existsStudent, function(value) {
		    return $.inArray(value, studentsSelected) < 0;
		});
	  $.ajax({
	    crossDomain:true,
	    type:"DELETE",
	    url:"http://localhost:8080/WebApplication/api/students",
	    data: JSON.stringify(user),  
	    async:true,
	    cache:false,
	    contentType:"application/json; charset=UTF-8",
	    success:function(response){
	    	existsStudent.splice(i, 1);
	    	getAllStudents();
	    	setEmpty();
	    },
	  });
	}
function updateStudent(){
	// Send a JSON to server for updating user record
	var user = fromUser();
	if(!(user===false)){
	 $.ajax({
		    crossDomain:true,
		    type:"PUT",
		    url:"http://localhost:8080/WebApplication/api/students",
		    data: JSON.stringify(user),  
		    async:true,
		    cache:false,
		    contentType:"application/json; charset=UTF-8",
		    success:function(response){
		      	getAllStudents();
		    	setEmpty();
		    },
		  });
	}else{
		alert("Please Fill ID Fields")
	}
}
function setEmpty(){
	$("#id").val("");
	$("#name").val("");
	$("#dept").val("");
	$("#prof_id").val("");
	
}
