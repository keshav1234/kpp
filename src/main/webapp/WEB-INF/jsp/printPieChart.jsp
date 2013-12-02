<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<form:form method="POST" action="PrintPieChartReport.do?param=${param}"  modelAttribute="PieChart" >
	<table>
		<tr>
		<c:out value="${param}"></c:out>
		<td><font size="5"><b></b></font></td>
		</tr>
		</table>
		<table width="100%" border="0" cellspacing="1" cellpadding="1" class="form_tbl" >
		<tr>
		
		<td><b>Date From</b></td>
		<td><form:input path="fromDate" />
			<form:errors path="fromDate" cssClass="error"></form:errors>
			
		</td>
		<td><b>To</b></td>
		<td><form:input path="toDate" />
			<form:errors path="fromDate" cssClass="error"></form:errors>
		</td>
		</tr>
		<tr>
				<td>Client Name</td>
				<td>
				<form:select path="clientId">
				<form:option value="0" label="Select"/>
						<c:forEach items="${client}" var="refClient">
						<form:option value="${refClient.clientId}" label="${refClient.clientName}" />
						</c:forEach>
				</form:select>
				</td>
				</tr>
				<%if(request.getParameter("param").equals("Paper")||request.getParameter("param").equals("PaperSector")) {%>
              <tr>
              <td>Publication</td>
				<td><form:select path="publicationId">
				<form:option value="0" label="Select"/>
						<c:forEach items="${publication}" var="refPublication">
						<form:option value="${refPublication.publicationId}" label="${refPublication.publicationName}" />
						</c:forEach>
					</form:select>	
					</td>
              </tr>
              <%} %>
		<tr>
		<td colspan="2">
		<input type="submit" value="Generate Pie Chart" />	 
		<input type="button" name="Cancel"	value="Cancel" onclick="window.location ='cancel.do'"/>
		</td>
		</tr>
		</table>
	</form:form>
</body>
</html>
