<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
</head>   

<body data-context-path= "<c:url value="/" />" data-resource-path = "<c:url value="/resources" />" >


<c:set var="headerTitle" value = "RSTO Corporate Membership Booking System"/>

<div id="divHome">

<!-- Define Header part -->
<%@ include file="common/header.jsp"%>

<div class="content background-color margin-content">
    <div class="row background-color margin-content">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-6">
                    <h3>
                        Current Booking Record</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-bordered tableHeader" id="tblMyBooks">
                        <thead>
                            <tr>
                                <th>
                                    Pass Type
                                </th>
                                <th>
                                    Visit Date
                                </th>
                                <th>
                                    Application status
                                </th>
                                <th>
                                    Slot Type
                                </th>
                                <th>
                                    Application Date
                                </th>
                                <th>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="entity" items="${Users}"  >
                              <tr>
                                <td>${entity.username} </td>
                                <td>${entity.gender} </td>
                                <td>${entity.mobile} </td>
                                <td>${entity.email} </td>
                                <td>${entity.disabled}</td>
                                <td>                             
                                </td>
                              </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</div>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/common.js" />"></script>
	<script src="<c:url value="/resources/js/home.js" />"></script>
</body>
</html>
