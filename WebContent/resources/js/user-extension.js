(function ($) {
    $.fn.extend({
    	extension:function(){
    		var contextPath = $('body').data('context-path');
    		var $tblUsers = $('#dataTables-users');
    		var getUserUrl = contextPath + "/home/getUsers";
 
     	    var table = $tblUsers.DataTable( {
     	    	 //"dom" : "Rlfrtip", // Column reorder
     			 "scrollY": "300px",
     			 "scrollX":  true,
     			 "scrollCollapse": true,
     			 "paging" : false,
     			 "ordering" : false,
     			 "searching" : false,
			     "serverSide": true,
			     "ajax": getUserUrl,
			     "columns" : [
			                    { "data": "username" },           
			                    { "data": "gender" },
			                    { "data": "mobile" },
			                    { "data": "email" },
			                    { "data": "disabled" },
			                    { "data": "createDatetime" },
						     ]
			   } );	
     	    
     	   new $.fn.dataTable.FixedColumns(table, {
     		   leftColumns: 1,
     	   });
    	}
    });
})(jQuery);

$(document).ready(function () {
       $("#body").extension();
});