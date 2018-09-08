<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script>var base = "${pageContext.request.contextPath}";</script><html>
<head>

<link rel="stylesheet" href="<c:url value='/resources/style.css' ></c:url>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job assignment</title>
</head>
<body>
<c:url var="addAction" value="/jobassignment" ></c:url>
<form:form commandName="assignment" action="${addAction}">

<form:label path="personName">persons</form:label>
<form:select path="personName" >
<form:option value="" label = "--select--"/>
<c:forEach items="${persons}" var="person">
<form:option value="${person.name}" label = "${person.name}"/>
</c:forEach>
</form:select>
<br>
<form:label path="jobName">jobs</form:label>
<form:select path="jobName">
<form:option value="" label="--select--"/>
<c:forEach items="${jobs}" var="job">
<form:option value="${job.jobName}" label="${job.jobName}"></form:option>
</c:forEach>
<form:option value=""></form:option>
</form:select>
<br>
<input type="submit" value="submit">

</form:form>
</body>
</html>