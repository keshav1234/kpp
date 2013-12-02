<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<script type="text/javascript" src="js/selectLang.js"></script>
<script type="text/javascript" src="js/newHindi.js"></script> 
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript" src="js/show_ads.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<script type="text/javascript">
$(function () {
	$('#time').timeEntry();
	
});
google.load("elements", "1", {
    packages: "transliteration"
  });
function onLoad() {
var currValue = document.getElementById("transliterateDiv2"); 
var options =
{
    sourceLanguage:
        google.elements.transliteration.LanguageCode.ENGLISH,
    destinationLanguage:
        [google.elements.transliteration.LanguageCode.HINDI],
    shortcutKey: 'ctrl+g',
    transliterationEnabled: true
};

var control =
    new google.elements.transliteration.TransliterationControl(options);

control.makeTransliteratable(['slug']);
control.makeTransliteratable(['transliterateDiv2']);
}
google.setOnLoadCallback(onLoad);
</script>
<script type="text/javascript">
 function codeAddress() {
   show1();
 }
  window.onload = codeAddress;
 </script>
  <script type="text/javascript">
 function hindivalue() 
 {
 	   var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-12196237-3']);
      _gaq.push(['_trackPageview']);

      (function() {
      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      })();
 }
</script>
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST"  action="PrintTrackAdd.do" modelAttribute="PrintTracking" autocomplete="off" name="form1" >
		<table align="center">
		<tr>
	 <td><font size="5"><b>Print Media Tracking</b></font></td>
		</tr>
		<tr>
		</table>
		<table width="100%" border="0" cellspacing="1" cellpadding="1" class="form_tbl">
		<tr>
				<td>Client Name</td>
				<form:hidden  path="isRepeat" />
				<form:hidden  path="printTrackingId" />
				<td>
				<form:select path="client.clientId">
				<form:option value="0" label="Select"/>
						<c:forEach items="${client}" var="refClient">
						<form:option value="${refClient.clientId}" label="${refClient.clientName}" />
						</c:forEach>
				</form:select>
				<form:errors path="client.clientId" cssClass="error"></form:errors>	
				</td>
				<td>Date</td>
				<td>
			 	<!-- <input type="text" id="datepicker" /> -->
				<form:input path="date" />
				<form:errors path="date" cssClass="error"></form:errors>
				</td>
				
			</tr>
			<tr>
				<td>State</td>
				<td><form:select path="state.stateId">
						<form:option value="0" label="Select"/>
						<c:forEach items="${state}" var="refState">
						<form:option value="${refState.stateId}" label="${refState.stateName}" />
						</c:forEach>
					</form:select>	
					<form:errors path="state.stateId" cssClass="error"></form:errors>	
				</td>
				
				<td>Publication</td>
				<td><form:select path="publication.publicationId">
				<form:option value="0" label="Select"/>
						<c:forEach items="${publication}" var="refPublication">
						<form:option value="${refPublication.publicationId}" label="${refPublication.publicationName}" />
						</c:forEach>
					</form:select>	
					<form:errors path="publication.publicationId" cssClass="error"></form:errors>
					</td>	
			</tr> 
			<tr>
			<td>Slug</td>
			<td><form:textarea onkeyup="changeVal()" path="textArea" rows="4" cols="30" id="area" />
				<form:textarea path="textArea" rows="4" cols="30" id="slug" />
				<form:textarea path="textArea" rows="4" cols="30" id="area2" />
				<form:errors path="textArea" rows="4" cols="30" cssClass="error"></form:errors>
				</td>
				<td width="25%">
				<INPUT TYPE=RADIO NAME="X" VALUE="L" checked="checked" onclick="show1();">Hinglish
				<INPUT TYPE=RADIO NAME="X" VALUE="H"   onclick="show();" >Hindi
				<INPUT TYPE=RADIO NAME="X" 	VALUE="LL"  onclick="show2();">English
				<%-- <form:radiobutton path="slugRadio" NAME="X" VALUE="L" checked="checked" onclick="show1();" />Hinglish
				<form:radiobutton path="slugRadio" NAME="X" VALUE="H"   onclick="show();" />Hindi
				<form:radiobutton path="slugRadio" NAME="X" VALUE="LL"  onclick="show2();" />English </td> --%>
			</tr>
			  <tr>
				<td>Page</td>
				<td><form:input path="pageNumber" /></td>
				 
				<td>News Size</td>
				<td width="40%">Column NO.&nbsp;&nbsp;<form:input path="newsColumn" name="newsColumn" id="newsColumn" style="width:30px;" />				
				<form:radiobutton path="photo" name="photo" id="rad1" onclick="this.form.photoColumn.disabled = this.checked"  value= "No" />WithOutPhoto 
				<form:radiobutton path="photo" name="photo"  onclick="this.form.photoColumn.disabled = this.form.rad1.checked" value= "Yes" />WithPhoto 
				<form:input path="photoColumn" style="width:30px;" disabled="true" />
				</td>
			</tr>   
			<tr>
				<td>City</td>
				<td><form:select path="city.cityId">
					<form:option value="0" label="Select"/>
						<c:forEach items="${city}" var="refCity">
							<form:option value="${refCity.cityId}" label="${refCity.cityName}" />
						</c:forEach>
					</form:select>
					<form:errors path="city.cityId" cssClass="error"></form:errors>
				</td>
				 <td>Sector</td>
				<td><form:select path="sector.sectorId">
				<form:option value="0" label="Select"/>
						<c:forEach items="${sector}" var="refSector">
							<form:option value="${refSector.sectorId}" label="${refSector.sectorName}" />
						</c:forEach>
				</form:select>
				<form:errors path="sector.sectorId" cssClass="error"></form:errors>
			</td>
			</tr>
			<tr>
				<td>News Trend</td>
				<td><form:select path="newsTrend">
				<form:option value="0" label="Select"/>
				<form:option value="Positive" label="Positive"/>
				<form:option value="Negative" label="Negative"/>
				</form:select>
				</td>
				<td>Sub Sector</td>
				<td><form:select path="subSector.subSectorId">
				<form:option value="0" label="Select"/>
						<c:forEach items="${subsector}" var="refSubSector">
							<form:option value="${refSubSector.subSectorId}" label="${refSubSector.subSectorName}" />
						</c:forEach>
				</form:select>
				<form:errors path="subSector.subSectorId" cssClass="error"></form:errors>
				</td> 
			</tr> 
		<tr>
		<td colspan="2">
		<input type="submit" value="Save" />	 
		<input type="button" name="Cancel"	value="Cancel" onclick="window.location ='cancel.do'"/>
		</td>
		</tr>
		</table>
	<table border="0" cellspacing="1" cellpadding="1" class="mid_tbl" width="100%">
	<tr>
	<th>S.NO</th>
	<th>Slug</th>
	<th>Page</th>
	<th>City</th>
	<th>News Size(in Column)</th>
	<th>With photo</th>
	<th>Sector</th>
	<th>Sub Sector</th>
	<th>News Trend</th>
	<th>Story Code</th>
	<th>Edit</th>
	<th>Repeat</th>
	<th>Delete</th>
	</tr>
	<c:forEach items="${prinTrackingContent}" var="content">
	<tr>
	<td>${content.printTrackingId}</td>
	<td>${content.textArea}</td>
	<td>${content.pageNumber}</td>
	<td>${content.city.cityName}</td>
	<td>${content.newsColumn}</td>
	<td>${content.photo}</td>
	<td>${content.sector.sectorName}</td>
	<td>${content.subSector.subSectorName}</td>
	<td>${content.newsTrend}</td>
	<td>${content.storyCode}</td>
	<td><a href="PrintTrackAdd.do?printTrackingId=${content.printTrackingId}">Edit</a></td>
	<td><a href="PrintTrackAdd.do?printTrackingId=${content.printTrackingId}&isRepeat=Y">Repeat</a></td>
	<td><a href="prinTrackingContent/${content.printTrackingId}.do" onclick="return confirm('Are you sure !!! you want to delete?');">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
	</form:form>
</body>
</html>