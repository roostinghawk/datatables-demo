(function ($) {
    $.fn.extend({
    	extension:function(){
    		var contextPath = $('body').data('context-path');
    		var $tblUsers = $('#dataTables-users');
    		var getUserUrl = contextPath + "/order/getUsers";
 
     	    $tblUsers.dataTable( {
     	    	// "sPaginationType": "extStyle", // extjs style
			     "serverSide": true,
			     "ajax": getUserUrl,
			     "columns" : [
			                    { "data": "username" },           
			                    { "data": "gender" },
			                    { "data": "mobile" },
			                    { "data": "email" },
			                    { "data": "disabled" },
			                    { "data": "createDatetime" },
						     ],
						     columnDefs: [
						                  { type: 'chinese-string', targets: 0 }
						                ]
			   } );	
    	}
    });
})(jQuery);

$(document).ready(function () {
       $("#body").extension();
});