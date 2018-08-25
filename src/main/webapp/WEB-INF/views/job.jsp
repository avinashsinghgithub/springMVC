<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Page</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	<script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
</head>
<body>
<h1>
	Add a Job
</h1>
<c:url var="addAction" value="/job/add" ></c:url>
<form:form action="${addAction}" commandName="job">
<table>
<c:if test="${!empty job.jobName }">
	<tr>
	<td> <form:label path="jobId"><spring:message text="ID"/></form:label></td>
	<td> <form:input path="jobId" readonly="true" disabled="true" /> </td>
	</tr>
</c:if>
	<tr>
	<td> <form:label path="jobName"><spring:message text="Job Name"/></form:label> </td>
	<td> <form:input path="jobName" />
	</tr>
	<tr>
	<td><form:label path="description"><spring:message text="Job Description"/></form:label></td>
	<td><form:input path="description"/></td>
	</tr>
	<tr>
	<td><form:label  path="creationDate"><spring:message text="Job creation date"/></form:label></td>
	<td><form:input id="datepicker" path="creationDate"/></td>
	</tr>
	<tr> <td colspan="2"><input value="<spring:message text="add job"/>" type="submit" /></td> </tr>


</table>
</form:form>
<br>
<h3>jobs List</h3>
	
	<c:if test="${!empty listJobs}">
	<table  class="tg">
	<tr>
	<th>Job ID</th>
	<th>Job Name</th>
	<th>Job description</th>
	<th>Job Date</th>
	<th>Edit</th>
	<th>Delete</th>
	 </tr>
	 
	 <c:forEach items="${listJobs}" var="job">
	 <tr> 
	 <td>${job.jobId}</td>
	 <td>${job.jobName}</td>
	 <td>${job.description}</td>
	 <td>${job.creationDate}</td>
	 <td><a href="<c:url  value='/job/edit/${job.jobId}'/>">Edit</a></td>
	 <td><a href="<c:url  value='/job/delete/${job.jobId}'/>">Delete</a></td>
	 </tr>
	 </c:forEach>
	 
	</table>
	
	</c:if>
</body>
</html>