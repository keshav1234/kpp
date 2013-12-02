<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="js/amcharts.js" type="text/javascript"></script>
<!-- Carousal -->
<script type="text/javascript" language="javascript" src="js/jquery.carouFredSel-6.2.0-packed.js"></script>
<script type="text/javascript" language="javascript" src="js/helper-plugins/jquery.mousewheel.min.js"></script>
<script type="text/javascript" language="javascript" src="js/helper-plugins/js/jquery.touchSwipe.min.js"></script>
<script type="text/javascript" language="javascript" src="js/helper-plugins/jquery.transit.min.js"></script>
<script type="text/javascript" language="javascript" src="js/helper-plugins/jquery.ba-throttle-debounce.min.js"></script>
<!-- Carousal -->
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<script type="text/javascript">

<!-- fire plugin onDocumentReady -->
$(function() {
		//	Scrolled by user interaction
	$('#foo2').carouFredSel({
		auto: false,
		responsive: false,
		prev: '#prev2',
		next: '#next2',
		mousewheel: true,
		items       : 4,
		swipe: {
			onMouse: true,
			onTouch: false
				
		}
	});
});


var size=${ChannelPositiveList.size()};
var i=0;
/* using this url create pie chart
http://jsfiddle.net/gh/get/jquery/1.9.1/highslide-software/highcharts.com/tree/master/samples/highcharts/demo/pie-basic/ */
if(i<size)
	{
var chart;
var legend;

var chartData = [{
    country: "Positive",
    value:Math.abs(${ChannelPositiveList.get(0)[1]})},
 {
    country: "Negative",
    value:Math.abs(${ChannelNegativeList.get(0)[1]})
  }];

AmCharts.ready(function() {
    // PIE CHART
    // colour at line no 6572 inside amcharts.js
    // height and weigth on line no - 7423
    chart = new AmCharts.AmPieChart();
   
    chart.dataProvider = chartData; 
    
    chart.titleField = "country";
    chart.valueField = "value";
    //chart.labelText = "[[value]]";
    chart.outlineColor = "#FFFFFF";
    chart.outlineAlpha = 0.8;
    chart.outlineThickness = 1;
    // this makes the chart 3D
    chart.depth3D = 10;
    chart.angle = 55;
    
    //chart.labelText = "[[percents]]%";
    //chart.balloonText = "[[value]] ([[percents]]%)";
    
/*     
    chart.autoMargins = false;
    chart.marginLeft = 0;
    chart.marginRight = 0;
    chart.marginTop = 30;
    chart.marginBottom = 40; */
    
   <%--  chart.addTitle("${ChannelList.getChannelName(0)}");
    chart.addTitle("Total No Of  News:<%=(Integer)noOfPositiveNewsIterator.next()+(Integer)noOfNegativeNewsIterator.next()%>"); --%>

    // this line makes the chart to show image in the background
    chart.backgroundImage = "../images/logo_inner_vertical.png";    
    
    // LEGEND
    legend = new AmCharts.AmLegend();
    legend.align = "center";
    // Amcharts.js line no 1853
    /*  legend.switchType = "v"; */
    legend.markerType = "circle";
    chart.addLegend(legend);
    
    // WRITE
    chart.write("chartdiv");
   
}   );
i++;
alert(i);
	}

if(i<size)
	{
	alert("if stat"+i);
var chart1;
var legend1;

var chartData1 = [{
    country: "Positive",
    value:Math.abs(${ChannelPositiveList.get(1)[1]})},
 {
    country: "Negative",
    value:Math.abs(${ChannelNegativeList.get(1)[1]})
  }];

AmCharts.ready(function() {
    // PIE CHART
    // colour at line no 6572 inside amcharts.js
    // height and weigth on line no - 7423
    chart1 = new AmCharts.AmPieChart();
   
    chart1.dataProvider = chartData1; 
    
    chart1.titleField = "country";
    chart1.valueField = "value";
    //chart.labelText = "[[value]]";
    chart1.outlineColor = "#FFFFFF";
    chart1.outlineAlpha = 0.8;
    chart1.outlineThickness = 1;
    // this makes the chart 3D
    chart1.depth3D = 10;
    chart1.angle = 55;
    
    //chart.labelText = "[[percents]]%";
    //chart.balloonText = "[[value]] ([[percents]]%)";
    
/*     
    chart.autoMargins = false;
    chart.marginLeft = 0;
    chart.marginRight = 0;
    chart.marginTop = 30;
    chart.marginBottom = 40; */
    
   <%--  chart.addTitle("${ChannelList.getChannelName(0)}");
    chart.addTitle("Total No Of  News:<%=(Integer)noOfPositiveNewsIterator.next()+(Integer)noOfNegativeNewsIterator.next()%>"); --%>

    // this line makes the chart to show image in the background
    chart1.backgroundImage = "../images/logo_inner_vertical.png";    
    
    // LEGEND
    legend1 = new AmCharts.AmLegend();
    legend1.align = "center";
    // Amcharts.js line no 1853
    /*  legend.switchType = "v"; */
    legend1.markerType = "circle";
    chart1.addLegend(legend1);
    
    // WRITE
    chart1.write("chartdiv1");
   
}   );
i++;
alert(i);
	}
if(i<size)
	{
var chart2;
var legend2;

var chartData2 = [{
    country: "Positive",
    value:Math.abs(${ChannelPositiveList.get(2)[1]})},
 {
    country: "Negative",
    value:Math.abs(${ChannelNegativeList.get(2)[1]})
  }];

AmCharts.ready(function() {
    // PIE CHART
    // colour at line no 6572 inside amcharts.js
    // height and weigth on line no - 7423
    chart2 = new AmCharts.AmPieChart();
   
    chart2.dataProvider = chartData2; 
    
    chart2.titleField = "country";
    chart2.valueField = "value";
    //chart.labelText = "[[value]]";
    chart2.outlineColor = "#FFFFFF";
    chart2.outlineAlpha = 0.8;
    chart2.outlineThickness = 1;
    // this makes the chart 3D
    chart2.depth3D = 10;
    chart2.angle = 55;
    
    //chart.labelText = "[[percents]]%";
    //chart.balloonText = "[[value]] ([[percents]]%)";
    
/*     
    chart.autoMargins = false;
    chart.marginLeft = 0;
    chart.marginRight = 0;
    chart.marginTop = 30;
    chart.marginBottom = 40; */
    
   <%--  chart.addTitle("${ChannelList.getChannelName(0)}");
    chart.addTitle("Total No Of  News:<%=(Integer)noOfPositiveNewsIterator.next()+(Integer)noOfNegativeNewsIterator.next()%>"); --%>

    // this line makes the chart to show image in the background
    chart2.backgroundImage = "../images/logo_inner_vertical.png";    
    
    // LEGEND
    legend2 = new AmCharts.AmLegend();
    legend2.align = "center";
    // Amcharts.js line no 1853
    /*  legend.switchType = "v"; */
    legend2.markerType = "circle";
    chart2.addLegend(legend2);
    
    // WRITE
    chart2.write("chartdiv2");
   
}   );
i++;
alert(i);
	}
if(i<size)
{
var chart2;
var legend2;

var chartData3 = [{
country: "Positive",
value:Math.abs(${ChannelPositiveList.get(3)[1]})},
{
country: "Negative",
value:Math.abs(${ChannelNegativeList.get(3)[1]})
}];

AmCharts.ready(function() {
// PIE CHART
// colour at line no 6572 inside amcharts.js
// height and weigth on line no - 7423
chart2 = new AmCharts.AmPieChart();

chart2.dataProvider = chartData3; 

chart2.titleField = "country";
chart2.valueField = "value";
//chart.labelText = "[[value]]";
chart2.outlineColor = "#FFFFFF";
chart2.outlineAlpha = 0.8;
chart2.outlineThickness = 1;
// this makes the chart 3D
chart2.depth3D = 10;
chart2.angle = 55;

//chart.labelText = "[[percents]]%";
//chart.balloonText = "[[value]] ([[percents]]%)";

/*     
chart.autoMargins = false;
chart.marginLeft = 0;
chart.marginRight = 0;
chart.marginTop = 30;
chart.marginBottom = 40; */

<%--  chart.addTitle("${ChannelList.getChannelName(0)}");
chart.addTitle("Total No Of  News:<%=(Integer)noOfPositiveNewsIterator.next()+(Integer)noOfNegativeNewsIterator.next()%>"); --%>

// this line makes the chart to show image in the background
chart2.backgroundImage = "../images/logo_inner_vertical.png";    

// LEGEND
legend2 = new AmCharts.AmLegend();
legend2.align = "center";
// Amcharts.js line no 1853
/*  legend.switchType = "v"; */
legend2.markerType = "circle";
chart2.addLegend(legend2);

// WRITE
chart2.write("chartdiv3");

}   );
i++;
alert(i);
}
</script>		
</head>
<body>
<form:form method="POST" >
<table align="center">
<tr>
<td align="center">
<font size="6"><b>Channel Wise Negative Positive Report</b></font>
</td>
</tr>
<tr>
 <td align="center"><font size="4"><b>Client Name</b></font>&nbsp;&nbsp;&nbsp;
 <%--  <font size="4"><%=session.getAttribute("clientName")%></font>&nbsp;&nbsp;&nbsp; --%>
 <font size="4"><b>From :</b></font>&nbsp;&nbsp;&nbsp;
      <%--  <font size="4"><%=session.getAttribute("fromDate")%></font>&nbsp;&nbsp;&nbsp; --%>
  <font size="4"><b>To :</b></font>&nbsp;&nbsp;&nbsp;
      <%--  <font size="4"><%=session.getAttribute("toDate")%></font> --%></td>
  </tr>
  <tr></tr>
  <tr></tr>
   <tr></tr>
  <tr></tr>
</table>
		<div>
			<a id="prev2" class="prev" href="#"> <img class="slideLeft"
				src="images/slideLeft.png" alt="">
			</a>
			<ul id="foo2">
				<table>
					<tr>
						<li id="chartdiv" style="width: 50%; height: 300px; float: left"></li>
						<li id="chartdiv1" style="width: 50%; height: 300px; float: left"></li>
					</tr>
					<tr>
						<li id="chartdiv2" style="width: 50%; height: 300px; float: left"></li>
						<li id="chartdiv3" style="width: 50%; height: 300px; float: left"></li>
					</tr>
				</table>
			</ul>
			<a id="next2" class="next" href="#"> <img class="slideRight"
				src="images/slideRight.png" alt="">
			</a>
			<!-- <div class="clearfix"></div> -->
		</div>
 <table>
<tr>
	<%-- <c:forEach var="ChannelPositiveList" items="${ChannelPositiveList}">
   	 New Trend ${ChannelPositiveList[0]}
     Marking ${ChannelPositiveList[1]}    
    </c:forEach>
    <c:forEach var="ChannelNegativeList" items="${ChannelNegativeList}">
   	New Trend ${ChannelNegativeList[0]}
     Marking ${ChannelNegativeList[1]}    
    </c:forEach>
    <c:forEach var="ChannelList" items="${ChannelList}">
	Channel name ${ChannelList.getChannelName()}
    </c:forEach>
   	
     <c:forEach var="i" begin="0" end="${ChannelList.size()}" >
     
     Channel name ${ChannelPositiveList.get(i)}
    
    </c:forEach> --%>
    <c:forEach var="i" begin="0" end="${fn:length(ChannelList)-1}" >
  
         <br> N<c:out value="${ChannelNegativeList.get(i)[1]}" />
    
           <br> P<c:out value="${ChannelPositiveList.get(i)[1]}" />
    </c:forEach>
    -----
   
   
     
	</tr>
	</table>
	</form:form>
</body>
</html>
