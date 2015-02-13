(function ($) {
    $.fn.extend({
    	extension:function(){
    		var contextPath = $('body').data('context-path');
    		var $tblUsers = $('#dataTables-users');
    		var getUserUrl = contextPath + "/order/getUsers";
 
     	    var table = $tblUsers.DataTable( {
     	    	// "sPaginationType": "extStyle", // extjs style
     	    	'sPaginationType': 'ellipses',
			     "serverSide": true,
			     "ajax": getUserUrl,
			     "columns" : [
			                    { "data": "username" },           
			                    { "data": "gender" },
			                    { "data": "mobile", type: 'phoneNumber'},
			                    { "data": "email" },
			                    { "data": "disabled" },
			                    { "data": "createDatetime" },
						     ]
			   } );	
     	    
//     	    $('#txtJump').on('input',function(){
//     	    	var text = $('#txtJump').val();
//     	    	table.page.jumpToData(text, 0 );
//     	    });
    	}
    });
})(jQuery);

$(document).ready(function () {
       $("#body").extension();
});