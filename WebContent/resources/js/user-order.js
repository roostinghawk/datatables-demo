(function ($) {
    $.fn.extend({
    	order:function(){
    		var contextPath = $('body').data('context-path');
    		var $tblUsers = $('#dataTables-users');
    		var getUserUrl = contextPath + "/order/getUsers";
 
     	    $tblUsers.dataTable( {
     	    	//"ordering" : false,    // -- disable ordering
     	    	//"orderMulti" : false,  // -- disable multiple  order
			    "serverSide": true,
			    "ajax": getUserUrl,
			    "columns" : [
			                    { "data": "username", "orderable": false },           
			                    { "data": "gender" },
			                    { "data": "mobile",  },
			                    { "data": "email", },
			                    { "data": "disabled" },
			                    { "data": "createDatetime" },
						    ],
				 "orderFixed": [ 1, 'asc' ]
			   } );	
    	}
    });
})(jQuery);

$(document).ready(function () {
       $("#body").order();
});