/*$(document).ready(function(){
	getAllTeachers();
});*/
/*
 * window.onload = function(){ getAllTeachers(); }
 */

function fromUser(){

	 var user=[];
	 var fieldStatus=true;
	  var id = document.getElementById("id").value;
	  var name = document.getElementById("name").value;
	  var dept = document.getElementById("dept").value;
	  var address= document.getElementById("address").value;
	  if(id===""){
		  fieldStatus=false;
		  return fieldStatus;
	  }
	  else{
		  user = {id,name , dept ,address};
		  return user; 
	  }
	}

function insertTeacher(){
// Add Student to Data Base with Connecting to Server
	 
	  var check=checkStudentExists();
	  var add = fromUser();
	  if(!(add===false)){
		 if(check===false){
			 
	      $.ajax({
	    	  
	        crossDomain:true,
	        type:"POST",
	        url:"http://localhost:8080/WebApplication/api/teachers",
	        data: JSON.stringify(add),
	        async:true,
	        cache:false,
	        contentType: "application/json",
	        success:function(response){      	
	        	getAllTeachers();
	        	setEmpty();
	       
	        },
	      
	      });
		 }else
			 alert("The record Exists!!");

	  }else{
		  alert("Please Fill id field!!");
	  }
  }
var existsTeacher=[]
function checkStudentExists(){
// Check if Teacher does Exists
	var user=fromUser();
	if((user===false));
		
	else{
		var id = document.getElementById("id").value;
	check=false;
	for(var i=0;i< existsTeacher.length;i++){
		if(existsTeacher[i]==id)
			check=true;
	}
	return check;
		}
	}
function getAllTeachers(){
// Load Teachers Data into Table From Server
    $.ajax({
      type:"GET",
      contentType:"application/json; charset=UTF-8",
      url:"http://localhost:8080/WebApplication/api/teachers",
      dataType:'json',
      success: function (response) {
    	 
    	var trHTML='';
    	    for(var f=0;f<response.length;f++) {
    	     trHTML += '<tr><td>' + '<input type="checkbox" onchange="selectTeacher('+response[f]['id']+')" />' +'</td><td>' + response[f]['id']+'</td><td>'+response[f]['name'] +'</td><td>'+response[f]['dept']+'</td>'+'<td>'+response[f]['address']+'</td></tr>';
    	     var check=existsTeacher.indexOf(response[f]['id']);
      	   if (check == -1) {
      		   existsTeacher.push(response[f]['id']);
  		}
    	    }
    	     
    	    $('#datatable').html(trHTML);
    	    //Insert Table row data into the Input (text box)
    	    $("#datatable tr").each(function(){
    	    	$(this).click(function(){
    	    		$("#datatable tr").removeClass('hover');
    	    		$(this).addClass('hover');
    	    		values = $("td", $(this));
    	    		$("#id").val(values[1].innerHTML);
    	    		$("#name").val(values[2].innerHTML);
    	    		$("#dept").val(values[3].innerHTML);
    	    		$("#address").val(values[4].innerHTML);
    	    		
    	    	});
    	    });
    	    
            $( ".spin-grid" ).removeClass( "fa-spin" );
    	    
    	  }
    	});
      
    
    
  }


var teachersSelected = []
function selectTeacher(id){
	i = teachersSelected.indexOf(id);
	if(i == -1)
		teachersSelected.push(id);
	else
		teachersSelected.splice(i, 1);
}

function removeTeacher(){
	// Sent an ID of a Teacher to Server for deleting a Teacher in Database
	  var user = teachersSelected
	  existsTeacher= $.grep(existsTeacher, function(value) {
		    return $.inArray(value, teachersSelected) < 0;
		});
	  $.ajax({
	    crossDomain:true,
	    type:"DELETE",
	    url:"http://localhost:8080/WebApplication/api/teachers",
	    data: JSON.stringify(user),  
	    async:true,
        cache:false,
	    contentType:"application/json; charset=UTF-8",
	    success:function(response){
	    	getAllTeachers();
	     	setEmpty();
	    },
	  });
	}
function updateTeacher(){
	//Send a JSON to server for updating user record
	var update = fromUser();
	if(!(update===false)){
	$.ajax({
		crossDomain:true,
		type:"PUT",
		url:"http://localhost:8080/WebApplication/api/teachers",
		data:JSON.stringify(update),
		async:true,
        cache:false,
		contentType:"application/json; charset=UTF-8",
		success:function(response){      	
        	getAllTeachers();
        	setEmpty();
       
        },
		
	});
	}else{
		alert("Please Fill id field!!");
	}
	
}
function setEmpty(){
	$("#id").val("");
	$("#name").val("");
	$("#dept").val("");
	$("#address").val("");
}
