// -----------common functions

// error message
function alertMessage(message, icon, title) {
	var webURL = $("body").attr("data-website");
	if ($("body #" + icon + "alertDiv").length > 0) {
		$("body #" + icon + "alertDiv").remove();
		$(".modal-backdrop").remove();
	}
	if(!title){
		title = "Message";
	}
	var popDiv = "<div id='"
			+ icon
			+ "alertDiv' class='modal fade modal-alert'  tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>"
			+ "<div class='modal-dialog' style='width: 400px;'><div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button><h4 class='modal-title'>"
			+ title
			+ "</h4></div>"
			+ "<div class='modal-body modal-message'>"
			+ message
			+ "</div><div id='modal-footer' class='modal-footer'> <button  type='button' class='btn btn-default modal-btn' data-dismiss='modal'>"
			+ "OK</button></div></div></div> </div>";
	$("body").append(popDiv);
	$("#" + icon + "alertDiv").modal("show");
}

// confirm dialog
function alertConfirm(message, title, icon) {
	//var webURL = $("body").attr("data-website");
	if ($("body #" + icon + "confirmDiv").length > 0) {
		$("body #" + icon + "confirmDiv").remove();
		$(".modal-backdrop").remove();
	}
	var popDiv = "<div class='modal fade' id="
			+ icon
			+ "confirmDiv  tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>"
			+ "<div class='modal-dialog' style='width: 400px;'><div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button><h4 class='modal-title'>"
			+ title
			+ "</h4></div><div class='modal-body'><p>"
			+ message
			+ "</p></div>"
			+ "<div class='modal-footer'>"
			+ "<button id='"
			+ icon
			+ "_ok_btn' type='button' class='btn btn-primary sure-btn' data-dismiss='modal'>Yes</button>"
			+ "<button id='"
			+ icon
			+ "_cancel_btn' type='button' class='btn btn-default cancel-btn' data-dismiss='modal'>No</button></div></div></div></div>";
	$("body").append(popDiv);
	$("#" + icon + "confirmDiv").modal("show");
}
