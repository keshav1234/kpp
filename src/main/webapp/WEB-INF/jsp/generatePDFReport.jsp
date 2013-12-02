<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<table width="100%" border="0" cellspacing="1" cellpadding="1">
<tr>
<td>
<img border="0" src="images/logo_inner_horizantel.png" alt="Pulpit rock" width="250" height="55" >
 <td>Client Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td> 
<td>Channel Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<b></b></td> 

<td>Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>
</tr>
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
</table>
<body>
	<display:table name="pdfTracking" pagesize="3" class="mid_tbl" export="true" requestURI="EMTorPDFReport.do" >
		<display:column property="trackingId" title="S.NO" sortable="true" />
		<display:column property="textArea" title="Slug" />
		<!-- Check for Reference values -->
		 <display:column property="city.cityName" title="City" /> 
		<display:column property="time" title="Time" />
		<display:column property="newsType.newsTypeName" title="News Type" /> 
		 <display:column property="sector.sectorName" title="Sector" />
		 <display:column property="subSector.subSectorName" title="Sub Sector" />
		<display:column property="newsTrend" title="News Trend" />
		<display:column property="storyCode" title="Story Code" />
		<display:setProperty name="export.pdf" value="true" />
	</display:table>
</body>
</html>