<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="js/amcharts.js" type="text/javascript"></script>
<script type="text/javascript">

/* using this url create pie chart
http://jsfiddle.net/gh/get/jquery/1.9.1/highslide-software/highcharts.com/tree/master/samples/highcharts/demo/pie-basic/ */
<%-- <% if(param.equals("AllChannel")){%> --%>
var chart;
var legend;
var chartData = [{
    country: "Positive",
    value:Math.abs(${obj2.get(1)})},
 {
    country: "Negative",
    value:Math.abs(${obj1.get(1)}) }];
    
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
    
   <%--  chart.addTitle("<%=positiveChannelNameIterator.next()%>");
    chart.addTitle("Total No Of  News:<%=(Integer)noOfPositiveNewsIterator.next()+(Integer)noOfNegativeNewsIterator.next()%>");
 --%>
    // this line makes the chart to show image in the background
  	chart.backgroundImage = "images/logo_inner_vertical.png";    
  
    // LEGEND
    legend = new AmCharts.AmLegend();
    legend.align = "center";
    // Amcharts.js line no 1853
    /*  legend.switchType = "v"; */
    legend.markerType = "circle";
    chart.addLegend(legend);
    
    // WRITE
    chart.write("chartdiv");
   
});
</script>
</head>
<body>
<form:form method="POST"  >
<table align="center">
	<tr>
	<%-- <tr>
	   <td><c:forEach var="obj" items="${obj1}"></td>
	   <td> Key: ${obj1.get(1)}  - Value: ${obj2.get(1)}</td></c:forEach>
	   <td><c:forEach var="obj" items="${obj2}" >
	   <td> Key: ${obj}  - Value: ${obj}</td>
	   
      </c:forEach>
    </td>
	</tr> --%>
	<div id="chartdiv" style="width: 100%; height: 300px;float:left "></div>
	</tr>
	</table>
	</form:form>
</body>
</html>
