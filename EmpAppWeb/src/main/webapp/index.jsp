<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Employee Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Employee
</h1>

<c:url var="addAction" value="/emp/add" ></c:url>

<form:form action="${addAction}" commandName="employee">
<table>
	<c:if test="${!empty employee.Name}">
	<tr>
		<td>
			<form:label path="eId">
				<spring:message text="eId"/>
			</form:label>
		</td>
		<td>
			<form:input path="eId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="eId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="Name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="Name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="city">
				<spring:message text="city"/>
			</form:label>
		</td>
		<td>
			<form:input path="city" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="salary">
				<spring:message text="salary"/>
			</form:label>
		</td>
		<td>
			<form:input path="salary" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty emp.Name}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty emp.Name}">
				<input type="submit"
					value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>employees List</h3>
<c:if test="${!empty listemployees}">
	<table class="tg">
	<tr>
		<th width="80">emp eId</th>
		<th width="120">emp Name</th>
		<th width="120">emp city</th>
		<th width="120">emp salary</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listemployees}" var="person">
		<tr>
			<td>${emp.eId}</td>
			<td>${emp.Name}</td>
			<td>${emp.city}</td>
			<td>${emp.salary}</td>
			<td><a href="<c:url value='/edit/${emp.eId}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${emp.eId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
