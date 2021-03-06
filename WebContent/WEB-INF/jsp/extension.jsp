<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout  userName="liu">
	<div id="page-wrapper">
<h1 class="form-header">Extension table</h1>
	
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
				                                <th width="20%">会员名</th>
				                                <th width="10%">性别</th>
				                                <th width="20%">联系电话</th>
				                                <th width="20%">Email</th>
				                                <th width="10%">禁用</th>
				                                <th width="20%">注册日期</th>
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

<script src="<c:url value="/resources/js/user-extension.js" />"></script>
<script src="<c:url value="/resources/extensions/ColReorder/js/dataTables.colReorder.min.js" />"></script>
<script src="<c:url value="/resources/extensions/FixedColumns/js/dataTables.fixedColumns.js" />"></script>
<script src="<c:url value="/resources/extensions/ColVis/js/dataTables.colVis.min.js" />"></script>
<script src="<c:url value="/resources/extensions/Responsive/js/dataTables.responsive.min.js" />"></script>
<script src="<c:url value="/resources/extensions/TableTools/js/dataTables.tableTools.min.js" />"></script>