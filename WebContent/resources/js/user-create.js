(function ($) {
    $.fn.extend({
    	create:function(){
    		$("#txtUsername").attr('required', '');
    		$("#txtMobile").attr('required', ''); 
    		$("#txtEmail").attr('required', ''); 
    	}
    });
})(jQuery);

$(document).ready(function () {
       $("#body").create();
});