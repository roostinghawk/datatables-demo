(function ($) {
    $.fn.extend({
    	search:function(){
    		var contextPath = $('body').data('context-path');
    		var $tblUsers = $('#dataTables-users');
    		var $genderSelect = $('#search-gender-select');
    		var $searchBtn = $('#search-button');
    		var $userModal = $('#user-modal');
    		
    		var getUserUrl = contextPath + "search/getUsers";
    		var getUserDetailUrl = contextPath + "search/getUser";
    		var updateUserUrl = contextPath + "search/updateUser";	
 
     	    var dataTable = $tblUsers.DataTable( {
     	    	"search" :{
     	    		//"regex": true,
     	    		//"caseInsensitive": false,
     	    	},
			     "language": {
			         "url": contextPath + "/resources/js/dataTables/lang/dataTables.cn.lang"
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
			    	    	  var id = data[i].id;
			    	    	  data[i].DT_RowId = id;
			    	    	  
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
     	   
    	   // process after talbe init
     	  $tblUsers.on("draw.dt",function (){
    		 // bind event - show order detail
     		 $tblUsers.find('a').off('click').on('click',function(){
    			   bindShowUserDetailEvent($(this));
    		 });
     		 
     		 // bind event - disable or enable user
     		 $tblUsers.find('button.btn').off('click').on('click',function(){
  			       bindUpdateUserEvent($(this));
  		     });
     		 
		   });  
    	   
    	   // customize order modal
    	   $userModal.on('show.bs.modal', function () {
    		   var $body = $userModal.find('.modal-body');
    		   $body.css('overflow-y', 'auto'); 
    		   $body.css('max-height', $(window).height() * 0.7);
			 });
    	   
		   // modal- show order detail
		   var bindShowUserDetailEvent = function($link){
			   var $tr = $link.parents('tr');
   			   var id = $tr.attr('id');
			   var url = getUserDetailUrl + "?id="  + id
			   
			   $.ajax({
				   type: 'get',
				   url: url,
				   success: function(user){
					   // oid
					   $('#lblUserId').text(user.id);
					   $('#lblUserGuid').text(user.uid);
					   $('#lblUsername').text(user.username);

					   $('#lblMobile').text(user.mobile);
					   $('#lblEmail').text(user.email);
					   $('#lblCreateTime').text(user.createDatetime);

					   
					   var gender = user.gender;
					   if(gender == 0){
						   $('#lblGender').text('男');
					   } else if(gender = 1){
						   $('#lblGender').text('女');
					   }

	    	           var disabled = user.disabled;
	    	           if(disabled == 0){
	    	        	   $('#lblDisabled').text('否');
	    	           } else if(disabled == 1){
	    	        	   $('#lblDisabled').text('是');
	    	           } 

					   $userModal.modal('show');
				   }
			   }); 
    	   };
    	   
    	   var bindUpdateUserEvent = function($btn){
			   var $tr = $btn.parents('tr');
   			   var id = $tr.attr('id');
   			   var toStatus = 1; // to disable
   			   // if the button is "enable" now
   			   if($btn.hasClass('btn-success')){
   				  toStatus = 0; //
   			   }
   			   
   			   var updateUrl = updateUserUrl + "/" + id + "/" + toStatus;
   			   $.ajax({
   				   type: "get",
   				   url: updateUrl,
   				   success: function(result){
   					  if(result == 1){
   						  if($btn.hasClass('btn-success')){
   							$btn.removeClass('btn-success').addClass('btn-danger');
   							$btn.html('禁止');
   						  } else{
   							$btn.removeClass('btn-danger').addClass('btn-success');
   							$btn.html('启用');
   						  }
   					  } else{
                          alertMessage("更新失败", "Fail");
                          $("#FailalertDiv").modal("show");
   					  }
   				   },
   				   fail: function(){
   					  alertMessage("更新失败", "Fail");
   					  $("#FailalertDiv").modal("show");
   				   }
   			   });
   			   
   			   
    	   };
     	    
    	}
    });
})(jQuery);

$(document).ready(function () {
       $("#body").search();
});