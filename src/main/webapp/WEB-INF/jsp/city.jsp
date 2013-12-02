<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<form:form method="POST"  action="CityAdd.do" modelAttribute="City" autocomplete="off" >
	<table>
		<tr>
		<td><font size="5"><b>Add City</b></font></td>
		</tr>
		<tr><td><b>${message}</b></td></tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="left" class="form_tbl" >
		
		<tr>
		<td><b>Country Name</b></td>
		<td><form:select path="state.country.countryId">
			<form:option value="0" label="Select"/>
						<c:forEach items="${country}" var="refCountry">
							<form:option value="${refCountry.countryId}" label="${refCountry.countryName}" />
						</c:forEach>
			</form:select>			
			<form:errors path="state.country.countryId" cssClass="error"></form:errors>
		</td>
		<td><b>State Name</b></td>
		<td><form:select path="state.stateId">
			<form:option value="0" label="Select"/>
						<c:forEach items="${state}" var="refState">
							<form:option value="${refState.stateId}" label="${refState.stateName}" />
						</c:forEach>
			</form:select>			
			<form:errors path="state.stateId" cssClass="error"></form:errors>
		</td>
		</tr>
		<tr>
		<td><b>City Name</b></td>
		<form:hidden  path="cityId"  />
		<td><form:input path="cityName" maxlength="20"/>
		    <form:errors path="cityName" cssClass="error"></form:errors>
		</td>
		</tr>
		<tr>
		<td colspan="2">
		<input type="submit" value="Save" />	 
		<input type="button" name="Cancel"	value="Cancel" onclick="window.location ='cancel.do'"/>
		</td>
		</tr>
		</table>
	<table border="0" cellspacing="1"
					cellpadding="1" class="mid_tbl" width="100%">
	<tr>
	<th>S.NO</th>
	<th>Country Name</th>
	<th>State Name</th>
	<th>City Name</th>
	<th>Edit</th>
	<th>Delete</th>
	</tr>
	<c:forEach items="${cityContent}" var="content">
	<tr><td>${content.cityId}</td>
	<td>${content.state.country.countryName}</td>
	<td>${content.state.stateName}</td>
	<td>${content.cityName}</td>
	<td><a href="CityAdd.do?cityId=${content.cityId}">Edit</a></td>
	<td><a href="cityContent/${content.cityId}.do" onclick="return confirm('Are you sure !!! you want to delete?');">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
	</form:form>
</body>
</html>
