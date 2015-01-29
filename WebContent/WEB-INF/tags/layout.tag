<%@tag description="User Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="userName" required="true"%>

<t:generic>
    <jsp:attribute name="header">
      <!-- <h1>Welcome ${userName}</h1> -->
      <%@ include file="../jsp/common/header.jsp"%>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <!--<p id="copyright">Copyright 2015, Innocellence.</p>-->
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody/>
    </jsp:body>
</t:generic>