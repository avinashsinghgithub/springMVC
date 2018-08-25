<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script>var base = "${pageContext.request.contextPath}";</script>
<a href="<c:url  value='${base}/jobs/'/>">Jobs</a>
<br>
<a href="<c:url  value='${base}/persons/'/>">Persons</a>