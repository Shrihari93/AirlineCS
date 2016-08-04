<%@page import="java.util.ArrayList"%>
<%@page import="Entry.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title></title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.4.2.js" ></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script> 
<script type="text/javascript" src="js/Myriad_Pro_italic_600.font.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_italic_400.font.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_400.font.js"></script>
<!--[if lt IE 9]>
	<script type="text/javascript" src="http://info.template-help.com/files/ie6_warning/ie6_script_other.js"></script>
	<script type="text/javascript" src="js/html5.js"></script>
<![endif]-->
</head>
<body id="page1">
<div class="body1">
	<div class="main">
<!-- header -->
		<header>
			<div class="wrapper">
				<h1>
					<a href="index.html" id="logo">Air Lines</a><span id="slogan">International Travel</span>
				</h1>
				<div class="right">
					
					<nav>
						<ul id="menu">
							<li><a href="index.html">Home</a></li>
							<li><a href="modifybooking.html">Modify Booking</a></li>
							<li id="menu_active" ><a href="flightdetail.html">Flight Details</a></li>
							<li><a href="editprofile.html">Edit Profile</a></li>
							<li><a href="homeindex.html">Logout</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
	</div>
</div>
<div class="main">
	<div id="banner">
		<div class="text1">
			COMFORT<span>Guaranteed</span><p>Air Lines is built for people with things to do, places to be, people to see - who don't want to waste time, money or energy in the process.</p>
		</div>
		<!-- <a href="#" class="button_top">Order Tickets Online</a>-->
	</div>
</div>
<!-- / header -->
<div class="main">
<!-- content -->
	<section id="content">
		<article class="col1">
			</article>
		<article class="col2 pad_left1">
			Your bookings :
		
		<%
			HttpSession s = request.getSession(true);
			String username = (String)s.getAttribute("CurrentUser");
			ArrayList<Ticket> tickets = (new DAOMaster()).SearchTicket(username);  // return all the tickets of the user
			
		%>
		
			<form action="ViewServlet" method="post">
				<table>
					<tr>
						<td>PNR</td><td>Flight</td><td>Date</td><td>View</td>
					</tr>
					<c:foreach items = "${tickets}" var="flight">
						<tr>
							<td>${flight.getPNR()}</td>
							<td>${flight.getFlightID()}</td>
							<td>${flight.getFlightDate()}</td>
			    			<td><input type="radio" name="view" value="${flight.getPNR()}"></td>
						</tr>	
					</c:foreach>
					<input type="submit" name="Ok">
				</table>
			</form>
		
		</article>
	</section>
<!-- / content -->
</div>
<div class="body2">
	<div class="main">
<!-- footer -->
		<footer>
			Website template designed by <a href="http://www.oracle.com/" target="_blank" rel="nofollow">www.oracle.com</a><br>
			
		</footer>
<!-- / footer -->
	</div>
</div>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>
