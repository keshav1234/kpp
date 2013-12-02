<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<script type="text/javascript" src="js/selectLang.js"></script>
<script type="text/javascript" src="js/newHindi.js"></script> 
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript" src="js/show_ads.js"></script>
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
</head>
<body>
<form:form method="POST" action="popupAdd.do" modelAttribute="PopUp" name="form1" autocomplete="off" >
	<table>
		<tr>
		<td><font size="5"><b>Add Message</b></font></td>
		</tr>
		<tr><td><b>${message}</b></td></tr>
	</table>
		<table width="100%" border="0" cellspacing="1" cellpadding="1"
			class="form_tbl">
		<tr>
		<td><b> Message</b></td>
		<td><form:textarea onkeyup="changeVal()" path="textArea" rows="10" cols="30" id="area" />
				<form:textarea path="textArea" rows="10" cols="30" id="slug" />
				<form:textarea path="textArea" rows="10" cols="30" id="area2" />
				<form:errors path="textArea" rows="10" cols="30" cssClass="error"></form:errors>
				</td><td>
				<INPUT TYPE=RADIO NAME="X" VALUE="L" checked="checked" onclick="show1();">Hinglish
				<INPUT TYPE=RADIO NAME="X" VALUE="H"  onclick="show();" >Hindi
				<INPUT TYPE=RADIO NAME="X" 	VALUE="LL"  onclick="show2();">English
				</td>
		</tr>	
		<tr>
		<td><b> Date</b></td>
		<td><form:input path="date" /></td>
		</tr>	
		<tr>
		<td colspan="2">
		<input type="submit" value="Save" />	 
		<input type="button" name="Cancel"	value="Cancel" onclick="window.location ='cancel.do'"/>
		</td>
		</tr>
		</table>	
	</form:form>
</body>
</html>
