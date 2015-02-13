<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout  userName="liu">
	<div id="page-wrapper">
<h1 class="form-header">Plugin table</h1>

<!-- 	
	<div class="form-group">
	    <label for="search-category-select" class="col-sm-1 control-label">Jump</label>
	    <div class="col-sm-3">
	    	<input type="text" id="txtJump" />
	     </div>
	  </div>
 -->	  
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">会员一览</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="table-responsive">
							<div class="dataTables_wrapper form-inline" role="grid">
								<table id="dataTables-users" class="table table-striped table-bordered table-hover dataTable no-footer"
								       cellspacing="0">
								        <thead>
								            <tr>
				                                <th>会员名</th>
				                                <th>性别</th>
				                                <th>联系电话</th>
				                                <th>Email</th>
				                                <th>禁用</th>
				                                <th>注册日期</th>
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
</t:layout>

<script src="<c:url value="/resources/plugin/extjs.js" />"></script>
<script src="<c:url value="/resources/plugin/chinese.js" />"></script>
<script src="<c:url value="/resources/plugin/phone.number.js" />"></script>
<script src="<c:url value="/resources/plugin/four_button.js" />"></script>
<script src="<c:url value="/resources/plugin/jump.js" />"></script>
<script src="<c:url value="/resources/plugin/eclipse.js" />"></script>
<script src="<c:url value="/resources/js/user-plugin.js" />"></script>