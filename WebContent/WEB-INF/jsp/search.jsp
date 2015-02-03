<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout  userName="liu">
	<div id="page-wrapper">
<h1 class="form-header">Search Test</h1>

	<div class="form-group">
	    <label for="search-category-select" class="col-sm-1 control-label">性别</label>
	    <div class="col-sm-3">
	    	<select class="form-control" id="search-gender-select" style="margin-bottom:10px;">
	    	  <option value="" selected></option>
	    	  <option value="0">男</option>
	    	  <option value="1">女</option>
			</select>
	     </div>
	  </div>
	  
	  <div>
	     <input type="button" id="search-button" class="btn btn-success" value="检索"> </input>
	  </div>
	 </div>
	
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">会员一览</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="table-responsive">
							<div class="dataTables_wrapper form-inline" role="grid">
								<table id="dataTables-users" class="table table-striped table-bordered table-hover dataTable no-footer"
								       cellspacing="0" width="100%">
								        <thead>
								            <tr>
				                                <th>会员名</th>
				                                <th>性别</th>
				                                <th>联系电话</th>
				                                <th>Email</th>
				                                <th>注册时间</th>
				                                <th>禁用</th>	                                
								            </tr>
								        </thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<!--Order detail Modal -->
<div class="modal fade" style="text-align: left;" id="user-modal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">用户详细</h4>
      </div>
      <div class="modal-body">
        <table class="table table-striped">
	        <tr><td>ID&nbsp;&nbsp;</td><td><label id="lblUserId"></label></td>
	           <td>GUID </td><td><label id="lblUserGuid"></label></td></tr>
	        <tr><td>会员名</td><td><label id="lblUsername"></label></td>
	            <td>性别</td><td><label id="lblGender"></label></td></tr>
	        <tr><td>电话</td><td><label id="lblMobile"></label></td>
	            <td>Email</td><td><label id="lblEmail"></label></td></tr>
	        <tr><td>注册时间&nbsp;</td><td><label id="lblCreateTime"></label></td>
	            <td>禁用</td><td> <label id="lblDisabled"></label></td></tr>
        </table>
          
		</div> <!-- /.modal-body -->
		
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	      </div>
    </div> <!-- /.modal-content -->
  </div> <!-- /.modal-dialog -->
</div> <!-- /.modal -->
</t:layout>

<script src="<c:url value="/resources/js/user-search.js" />"></script>