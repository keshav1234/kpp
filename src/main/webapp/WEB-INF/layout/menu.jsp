<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/ddlevelsmenu-base.css" />
<link rel="stylesheet" type="text/css" href="css/ddlevelsmenu-topbar.css" />
<link rel="stylesheet" type="text/css" href="css/ddlevelsmenu-sidebar.css" />
<script type="text/javascript" src="js/ddlevelsmenu.js"></script>
</head>
<body>
	<table>
					<tr>
						<td valign="top" class="inner_leftlink_main">
							<div id="ddsidemenubar" class="markermenu">
								<ul>
									<li><a href="#" rel="ddsubmenuside1"  class="selected">
									<img src="../images/arrow-right.gif"
											class="rightarrowpointer"
											style="width: 12px; height: 12px; left: 214px;" />Add Info</a>
									</li>
									<li><a href="#" rel="ddsubmenuside1"  class="selected">
									<img src="../images/arrow-right.gif"
											class="rightarrowpointer"
											style="width: 12px; height: 12px; left: 214px;" />
									Tracking</a>
									</li>
									<li><a href="#" rel="ddsubmenuside1"  class="selected">
									<img src="../images/arrow-right.gif"
											class="rightarrowpointer"
											style="width: 12px; height: 12px; left: 214px;" />
									Report</a>
									</li>

								</ul>
							</div> <script type="text/javascript">
								ddlevelsmenu.setup("ddsidemenubar", "sidebar") //ddlevelsmenu.setup("mainmenuid", "topbar|sidebar")
							</script>
							<ul id="ddsubmenuside1" class="ddsubmenustyle blackwhite">
							<li><a href="channel.do">Channel</a>
								</li>
								<li><a href="country.do">Country</a>
								</li>
								<li><a href="state.do">State</a>
								</li>
								<li><a href="city.do">City</a>
								</li>
								<li><a href="sector.do">Sector</a>
								</li>
								<li><a href="subsector.do">Sub Sector</a>
								</li>
								<li><a href="client.do">Client</a>
								</li>
								<li><a href="publication.do">Publication</a>
								</li>
								<li><a href="party.do">Party</a>
								</li>
								<li><a href="advtype.do">Advertisement Type</a>
								</li>
								<li><a href="popupentry.do">Pop Up Massage </a>
								</li>								
							</ul>
							<ul id="ddsubmenuside1" class="ddsubmenustyle blackwhite">
								<li><a href="savetracking.do">Electronic Media
										Tracking(EMT)</a>
								</li>
								<li><a href="advertisement.do">Electronic Media Advertisement Tracking(EAT)</a>
								</li>
								<li><a href="saveprinttracking.do">Print Media Tracking(PMT)</a>
								</li>					
							</ul>							
							<ul id="ddsubmenuside1" class="ddsubmenustyle blackwhite">								
								<li><a href="#"><img
										src="../images/arrow-right.gif" class="rightarrowpointer"
										style="width: 0px; height: 12px; left: 198px;" />Electronic
										Media Report </a>
									<ul id="ddsubmenuside1" class="ddsubmenustyle blackwhite">
										<li><a href="piechart.do?param=AllChannel">All Channel Negative Positive Report</a>
										</li>
										<li><a href="piechart.do?param=AllChannelNegativePositive">Channel Wise Negative Positive Report</a>
										</li>
										<li><a href="piechart.do?param=Sector">Sector Wise
												All Channel Negative Positive Report</a>
										</li>
										<li><a href="piechart.do?param=Channel">Individual Channel
												Wise Negative Positive Report</a>
										</li>
										<li><a href ="generateBarChart.do">View Channel Image </a></li>
										
										<li><a href="PDFReport.do">PDF Report for Channel(Excel Report)</a></li>
										<li><a href="piechart.do?param=ChannelSector">Sector Wise
												Negative Positive Report Based On Channel</a>
										</li>										
									</ul></li>
								<li><a href="#"><img
										src="../images/arrow-right.gif" class="rightarrowpointer"
										style="width: 0px; height: 12px; left: 198px;" />Advertisement Report</a>
								<ul id="ddsubmenuside1" class="ddsubmenustyle blackwhite">
								<li><a href="AdvertPieChart.jsp?param=AllChennal">All Channel Wise Advertisement Ratio Report</a></li>
								<li><a href="AdvertPieChart.jsp?param=Channel">Individual Channel Wise Advertisement Ratio Report</a></li>
										<li><a href="AdvertisementPDFReport genrate.jsp">Pdf Report(Excel Report)</a>
										</ul>
										</li>																	
								
								<li><a href="#"><img
										src="../images/arrow-right.gif" class="rightarrowpointer"
										style="width: 0px; height: 12px; left: 198px;" />Print Media
										Report</a>
									<ul id="ddsubmenuside1" class="ddsubmenustyle blackwhite">
										<li><a href="printPieChart.do?param=AllPaper">All
												Publication Negative Positive Report</a>
										</li>
										<li><a href="printPieChart.do?param=Paper"> Publication
												Wise Negative Positive Report</a>
										</li>
										<li><a href="printPieChart.do?param=Sector">Sector
												Wise All Publication Negative Positive Report</a>
										</li>
										
										<li><a href="printPieChart.do?param=PaperSector">Sector Wise
												Negative Positive Report Based On Publication</a>
										</li>
										<li><a href="generatePrintPDFReport.do">Pdf Report(Excel Report)</a>
										</li>

									</ul>
							</li>
							</ul>
							
							</td>
					</tr>
	</table>
</body>
</html>