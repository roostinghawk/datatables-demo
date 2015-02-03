(function ($) {
    $.fn.extend({
    	search:function(){
    		var contextPath = $('body').data('context-path');
    		var $tblUsers = $('#dataTables-users');
    		var getUserUrl = contextPath + "/search/getUsers";
    		var $genderSelect = $('#search-gender-select');
    		var $searchBtn = $('#search-button');
    		
 
     	    var dataTable = $tblUsers.DataTable( {
     	    	"search" :{
     	    		//"regex": true,
     	    		//"caseInsensitive": false,
     	    	},
			    "serverSide": true,
			    "ajax":  {
			    	"url" : getUserUrl,
			    	"data" : function(d){
			    		// search condition
			    		d.gender = $genderSelect.val();
			    	},
				    "dataSrc": function ( json ) {
	    		          var data = json.data;
			    	      for ( var i=0, ien=data.length ; i<ien ; i++ ) {
			    	    	  // user id
			    	    	  var id = data[i].username;
			    	    	  
			    	    	  // user name
			    	    	  var username = data[i].username;
			    	    	  data[i].username = "<a>" + username + "</a>";
			    	    	  
			    	    	  // gender
			    	          var gender = data[i].gender;
			    	          if(gender == "0"){
			    	        		data[i].gender = "男";
			    	          } else if(gender == "1"){
			    	        	  data[i].gender = "女";
			    	          }
			    	          
			    	          // disable
			    	          var disabled = data[i].disabled;
			    	          if(disabled == "0"){
			    	        	  data[i].disabled = "<button class='btn btn-danger'>禁止</button>";
			    	          } else if(disabled == "1"){
			    	        	  data[i].disabled = "<button class='btn btn-success'>启用</button>";
			    	          }
			    	      }
			    	      
			    	      return data;
			       }	
			     },	     
			    "columns" : [
			                    { "data": "username"},           
			                    { "data": "gender" },
			                    { "data": "mobile",  },
			                    { "data": "email", },
			                    { "data": "createDatetime" },
			                    { "data": "disabled" },
						    ]
			   } );	
     	    
     	   $searchBtn.on('click', function(){
     		   // get the draw
     		   dataTable.draw();
     		   // or reload datatable
     		   // dataTable.ajax.reload();
     	   });
     	    
    	}
    });
})(jQuery);

$(document).ready(function () {
       $("#body").search();
});