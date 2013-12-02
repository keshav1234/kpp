<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.timeentry.js"></script>
<script type="text/javascript" src="js/demo.js"></script>
<script type="text/javascript" src="js/jquery.timer.js"></script>
<script type="text/javascript" src="js/selectLang.js"></script>
<script type="text/javascript" src="js/newHindi.js"></script>
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript" src="js/show_ads.js"></script>
<script type="text/javascript">
	$(function() {
		$('#startTime').timeEntry();
		$('#time').timeEntry();

	});
	google.load("elements", "1", {
		packages : "transliteration"
	});
	function onLoad() {
		var currValue = document.getElementById("transliterateDiv2");
		var options = {
			sourceLanguage : google.elements.transliteration.LanguageCode.ENGLISH,
			destinationLanguage : [ google.elements.transliteration.LanguageCode.HINDI ],
			shortcutKey : 'ctrl+g',
			transliterationEnabled : true
		};

		var control = new google.elements.transliteration.TransliterationControl(
				options);

		control.makeTransliteratable([ 'slug' ]);
		control.makeTransliteratable([ 'transliterateDiv2' ]);
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
	function hindivalue() {
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-12196237-3' ]);
		_gaq.push([ '_trackPageview' ]);

		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	}
</script>
<script type="text/javascript">
	function Timer() {
		var time = document.getElementById("startTime").value;
		var ary1 = time.split(':');
		var total1 = (parseInt(ary1[0], 10) * 3600 + parseInt(ary1[1], 10) * 60 + parseInt(
				ary1[2], 10));
		var stop = document.getElementById("stopwatch").innerHTML;
		var ary2 = stop.split(':');
		var total2 = (parseInt(ary2[0], 10) * 60 + parseInt(ary2[1], 10));
		var total3 = total1 + total2;
		var hour = Math.floor(total3 / 3600);
		var hours = hour % 12;
		var minutes = Math.floor((total3 - (hour * 3600)) / 60);
		var seconds = total3 - (hour * 3600) - (minutes * 60);
		if (hours < 10) {
			hours = "0" + hours;
		}
		if (minutes < 10) {
			minutes = "0" + minutes;
		}
		if (seconds < 10) {
			seconds = "0" + seconds;
		}
		var format = hours + ':' + minutes + ':' + seconds;
		document.getElementById("time").value = format;
		Example1.Timer.stop();
		var ary2 = time.split(':');
		var minsdiff = (parseInt(ary2[0], 10) * 3600 + parseInt(ary2[1], 10)
				* 60 + parseInt(ary2[2], 10))
				- (parseInt(hour, 10) * 3600 + parseInt(minutes, 10) * 60 + parseInt(
						seconds, 10));
		document.getElementById("duration").value = Math.abs(minsdiff);
	}
</script>
</head>
<body>
	<form:form method="POST" action="AdvTrackingAdd.do"
		modelAttribute="AdvertisementTracking" name="form1" autocomplete="off">
		<table align="center">
			<tr>
				<td><font size="5"><b>Electronic Media Advertisement Tracking</b></font></td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="1" cellpadding="1"
			class="form_tbl">
			<tr>
				<td>Client Name</td>
				<form:hidden path="isRepeat" />
				<form:hidden path="advertismentId" />
				<td><form:select path="client.clientId">
						<form:option value="0" label="Select" />
						<c:forEach items="${client}" var="refClient">
							<form:option value="${refClient.clientId}"
								label="${refClient.clientName}" />
						</c:forEach>
					</form:select> <form:errors path="client.clientId" cssClass="error"></form:errors>
				</td>
				<td>Date</td>
				<td><form:input path="date" /> <form:errors path="date"
						cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>State</td>
				<td><form:select path="state.stateId">
						<form:option value="0" label="Select" />
						<c:forEach items="${state}" var="refState">
							<form:option value="${refState.stateId}"
								label="${refState.stateName}" />
						</c:forEach>
					</form:select> <form:errors path="state.stateId" cssClass="error"></form:errors>
				</td>
				<td>Channel</td>
				<td><form:select path="chanel.channelId">
						<form:option value="0" label="Select" />
						<c:forEach items="${chanel}" var="refChanel">
							<form:option value="${refChanel.channelId}"
								label="${refChanel.channelName}" />
						</c:forEach>
					</form:select> <form:errors path="chanel.channelId" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Slug</td>
				<td><form:textarea onkeyup="changeVal()" path="textArea" rows="4" cols="30" id="area" /> 
				<form:textarea path="textArea" rows="4" cols="30" id="slug" />
				 <form:textarea path="textArea" rows="4" cols="30" id="area2" />
				  <form:errors path="textArea" rows="4" cols="30" cssClass="error"></form:errors></td>
				<td width="25%">
				<INPUT TYPE=RADIO NAME="X" VALUE="L" checked="checked" onclick="show1();">Hinglish
				<INPUT TYPE=RADIO NAME="X" VALUE="H"   onclick="show();" >Hindi
				<INPUT TYPE=RADIO NAME="X" 	VALUE="LL"  onclick="show2();">English </td>
				<%-- <form:radiobutton path="slugRadio" NAME="X" VALUE="L" checked="checked" onclick="show1();" />Hinglish 
				<form:radiobutton path="slugRadio" NAME="X" VALUE="H" onclick="show();" />Hindi 
				<form:radiobutton path="slugRadio" NAME="X" VALUE="LL" onclick="show2();" />English --%>
				<td><h2>
						<span id="stopwatch">00:00</span>
					</h2>
				</td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:select path="city.cityId">
						<form:option value="0" label="Select" />
						<c:forEach items="${city}" var="refCity">
							<form:option value="${refCity.cityId}"
								label="${refCity.cityName}" />
						</c:forEach>
					</form:select> <form:errors path="city.cityId" cssClass="error"></form:errors></td>
				<td>Start Time</td>
				<td><form:input path="startTime" id="startTime"
						name="startTime" value="" onfocus='Example1.resetStopwatch();'
						onblur='Example1.Timer.toggle();' /> (HH:MM:SS:AM/PM) <form:errors
						path="startTime" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Advertisement Type</td>
				<td><form:select path="advType.advTypeId">
						<form:option value="0" label="Select" />
						<c:forEach items="${advType}" var="refadvType">
							<form:option value="${refadvType.advTypeId}"
								label="${refadvType.advtypeName}" />
						</c:forEach>
					</form:select> <form:errors path="advType.advTypeId" cssClass="error"></form:errors>
				</td>
				<td>End Time</td>
				<td><form:input path="endTime" id="time" name="time"
						onfocus="Timer();" />(HH:MM:SS:AM/PM) <form:errors path="endTime"
						cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Party</td>
				<td><form:select path="party.partyId">
						<form:option value="0" label="Select" />
						<c:forEach items="${party}" var="refParty">
							<form:option value="${refParty.partyId}"
								label="${refParty.partyName}" />
						</c:forEach>
					</form:select> <form:errors path="party.partyId" cssClass="error"></form:errors>
				</td>
				<td>Duration</td>
				<td><form:input path="duration" id="duration" name="duration" />Second
					<form:errors path="duration" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /> <input
					type="button" name="Cancel" value="Cancel"
					onclick="window.location ='cancel.do'" /></td>
			</tr>
		</table>
		<table border="0" cellspacing="1" cellpadding="1" class="mid_tbl"
			width="100%">
			<tr>
				<th>S.NO</th>
				<th>Slug</th>
				<th>Advertisement Type Name</th>
				<th>Party</th>
				<th>City</th>
				<th>Start Time</th>
				<th>End Time</th>
				<th>Duration</th>
				<th>Edit</th>
				<th>Repeat</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${advTrackingContent}" var="content">
				<tr>
					<td>${content.advertismentId}</td>
					<td>${content.textArea}</td>
					<td>${content.advType.advtypeName}</td>
					<td>${content.party.partyName}</td>
					<td>${content.city.cityName}</td>
					<td>${content.startTime}</td>
					<td>${content.endTime}</td>
					<td>${content.duration}</td>
					<td><a
						href="AdvTrackingAdd.do?advertismentId=${content.advertismentId}">Edit</a>
					</td>
					<td><a
						href="AdvTrackingAdd.do?advertismentId=${content.advertismentId}&isRepeat=Y">Repeat</a>
					</td>
					<td><a href="advTrackingContent/${content.advertismentId}.do"
						onclick="return confirm('Are you sure !!! you want to delete?');">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form:form> 
</body>
</html>