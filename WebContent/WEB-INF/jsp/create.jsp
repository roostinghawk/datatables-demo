<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout  userName="liu">
<h1 class="form-header">Create User</h1>

<form:form id="createForm" action="create" method="post" modelAttribute="userModel">
	<div class="announcementmsg">
		<form:errors path="*"/>
	</div>
	<div class="form-center">
		<div class="form-group">
			<form:input id="txtUsername" path="username" type="text" class="form-control" placeholder="User name" maxlength="30" />
			<form:radiobutton path="gender" value="0" />Male
			<form:radiobutton path="gender" value="1" />Female
			
			<form:input id="txtMobile" path="mobile" type="text" class="form-control" placeholder="Please input mobile phone number" maxlength="11"/>
			
			<form:input id="txtEmail" path="email" type="email" class="form-control" placeholder="Please input email" maxlength="30"/>
			
			<div class="form-button">
				<button type="submit" class="btn btn-lg btn-primary center">Create</button>
			</div>
		</div>
	</div>
</form:form>
</t:layout>

<script src="<c:url value="/resources/js/user-create.js" />"></script>