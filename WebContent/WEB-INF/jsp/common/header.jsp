
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<div id="header_bar" class="header-bar show-grid" data-logout = "<c:url value="/logout" />">
	    <div class="row background-color header-color header-content">
	        <div class="col-md-12">
	            <div class="pull-left navbar-default header-color dropdown-btn" role="navigation" style="margin-bottom: 0;
	                border: 0;">
	                <div class="navbar-header">
	                    <button type="button" class="navbar-toggle background-color" data-toggle="dropdown">
	                        <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span><span
	                            class="icon-bar"></span><span class="icon-bar"></span>
	                    </button>
	                    <ul class="dropdown-menu nav navbar-nav pull-left" role="menu">
	                        <li class="nav-li"><a href="<c:url value="/home" />"><span class=''><span class='nav-menu-item'>
	                            Home</span></span></a></li>
	                        <li class="nav-li"><a href="<c:url value="/order" />"><span class=''><span class='nav-menu-item'>
	                            Order</span></span></a></li>
	                        <li class="nav-li"><a href="<c:url value="/search" />"><span class=''><span class='nav-menu-item'>
	                            Search</span></span></a></li>
	                        <li class="nav-li"><a href="<c:url value="/create" />"><span class=''><span class='nav-menu-item'>
	                            Create User</span></span></a></li>
	                    </ul>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>