(function ($) {
    $.fn.extend({
    	simple:function(){
    		var contextPath = $('body').data('context-path');
    		var $tblUsers = $('#dataTables-users');
    		var getUserUrl = contextPath + "/simple/getUsers";
 
     	    $tblUsers.dataTable( {
     	    	 "paging" : false, // disable pagination
     	    	 "ordering" : false, // disable sorting
     	    	 "lengthChange" : false, // remove paging length control
     	    	 "info" : false, // remove information (record number)
     	    	 "searching" : false, // remove search function
			     "serverSide": true,
			     "ajax": getUserUrl,
			     "columns" : [
			                    { "data": "username" },           
			                    { "data": "gender" },
			                    { "data": "mobile" },
			                    { "data": "email" },
			                    { "data": "disabled" },
			                    { "data": "createDatetime" }
						     ]
			   } );	
    	}
    });
})(jQuery);

$(document).ready(function () {
       $("#body").simple();
});