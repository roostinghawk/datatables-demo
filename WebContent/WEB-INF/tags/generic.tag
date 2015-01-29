<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/dataTables.bootstrap.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
</head>   

  <body data-context-path= "<c:url value="/" />">
    <div id="pageheader">
      <jsp:invoke fragment="header"/>
    </div>
    <div id="body" class="background-color margin-content">
      <jsp:doBody/>
    </div>
    <div id="pagefooter">
      <jsp:invoke fragment="footer"/>
    </div>
    
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/dataTables/jquery.dataTables.js" />"></script>
    <script src="<c:url value="/resources/js/dataTables/dataTables.bootstrap.js" />"></script>
    <script src="<c:url value="/resources/js/common.js" />"></script>
	<script src="<c:url value="/resources/js/angular.min.js" />"></script>
    
  </body>
</html>