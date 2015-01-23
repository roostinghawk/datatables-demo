/**
 * Copyright (C) 2014-2015  Roche 
 */  

(function ($) {
    $.fn.extend({
    	home:function(){
    		var contextPath = $('body').data('context-path');
    		var resourcePath = $('body').data('resource-path');
    		var $tblMyBooks = $('#tblMyBooks');
    		var $delIcons = $tblMyBooks.find('.delete-icon');
    		var $delIconClicked = null;
    		var $pdfBtns = $tblMyBooks.find('input[type=button][value=PDF]');

    		//balloting
    		$("#btnBookingMore").click(function(){
    			window.location = "MyBookingForBalloting.html";
    		});


    		//Post-Balloting
    		$("#btnPostBookingMore").click(function(){
    			window.location = "MyBookingForPostBalloting.html";
    		});
    		
    		// delete event
    		$delIcons.on('click', function () { clickDelIcon(this); });
    		
    		// get the clicked object
            var clickDelIcon = function(obj) {
            	$delIconClicked = $(obj);
              };
            
            // bind delete popover
              $delIcons.popover({
                html: true,
                placement: "left",
                offset: 5,
                delay: { show: 100, hide: 100 },
                title: function () {
                    var header_html = '<img src="'+ resourcePath + '/img/close_button_white_50.png" class="close"/>Delete Confirm';
                    return header_html;
                },
                content: function () {
                    return $("#popoverDel").html();
                },
                container: 'body'
            });
              
            $delIcons.on('show.bs.popover', function () {
            	$delIcons.not($delIconClicked).popover('hide');
            });
            
            // trigger after popover has been shown
            $delIcons.on('shown.bs.popover', function () {
                $('.btn-yes').on('click', function() {
                	$delIconClicked.popover('hide');
                    delBook();
                });
            
                $('.btn-no').on('click', function() {
                	$delIconClicked.popover('hide');
                });
                 $('.close').on('click', function () {
                	 $delIconClicked.popover('hide');
                });
            });
              
            var delBook = function(){
            	var delTr = $delIconClicked.parents('tr').eq('0');
            	var passId = delTr.data('id');

            	$.ajax({
                    type:"get",
                    url: contextPath + "home/deletebook/" + passId,
                    dataType:"json",
                    async: true,
                    timeout: Const_Ajax_Timeout,
                    cache: false,
                    headers: { "Cache-Control": "no-cache" },
                    success: function(data) {
                    	// 1 record deleted
                        if (data.result) {
                        	delTr.remove();
                        } else{
                        	alertMessage(data.errorMessage, "Fail");
                        	
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) { 
                    	alertMessage(MSG_INTERNET_CONNECTION_FAILURE, "Fail");
                    }
                });
            };
            
            
            
            // bind pdf event
            $pdfBtns.on('click', function(){
            	var clickTr = $(this).parents('tr').eq('0');
            	var passId = clickTr.data('id');
            	window.open(contextPath + "home/pdf/" + passId);
            });

    	}
    });
})(jQuery);

$(document).ready(function () {
       $("#divHome").home();
});
