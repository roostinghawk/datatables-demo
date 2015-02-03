(function ($) {
    $.fn.extend({
    	home:function(){
    		var contextPath = $('body').data('context-path');
    		var $tblUsers = $('#dataTables-users');
    		var getUserUrl = contextPath + "/home/getUsers";
 
     	    $tblUsers.dataTable( {
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
       $("#body").home();
});