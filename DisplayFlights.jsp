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
							<li id="menu_active"><a href="index.html">Home</a></li>
							<li><a href="modifybooking.html">Modify Booking</a></li>
							<li><a href="flightdetail.html">Flight Details</a></li>
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
			<div class="pad_1">
				<h2>Your Flight Planner</h2>
				<form id="form_1" action="" method="post">
					<div class="wrapper pad_bot1">
						<div class="radio marg_right1">
							<input type="radio" name="name1">Round Trip<br>
							<input type="radio" name="name1">One Way
						</div>
						<div class="radio">
							
						</div>
					</div>
					<div class="wrapper">
						Leaving From:
						<div class="bg"><input type="text" class="input input1" value="Enter City or Airport Code" onblur="if(this.value=='') this.value='Enter City or Airport Code'" onFocus="if(this.value =='Enter City or Airport Code' ) this.value=''"></div>
					</div>
					<div class="wrapper">
						Going To:
						<div class="bg"><input type="text" class="input input1" value="Enter City or Airport Code" onblur="if(this.value=='') this.value='Enter City or Airport Code'" onFocus="if(this.value =='Enter City or Airport Code' ) this.value=''"></div>
					</div>
					<div class="wrapper">
						Departure Date and Time:
						<div class="wrapper">
							<div class="bg left"><input type="text" class="input input2" value="mm/dd/yyyy " onblur="if(this.value=='') this.value='mm/dd/yyyy '" onFocus="if(this.value =='mm/dd/yyyy ' ) this.value=''"></div>
							<div class="bg right"><input type="text" class="input input2" value="12:00am" onblur="if(this.value=='') this.value='12:00am'" onFocus="if(this.value =='12:00am' ) this.value=''"></div>
						</div>
					</div>
					<div class="wrapper">
						Return Date and Time:
						<div class="wrapper">
							<div class="bg left"><input type="text" class="input input2" value="mm/dd/yyyy " onblur="if(this.value=='') this.value='mm/dd/yyyy '" onFocus="if(this.value =='mm/dd/yyyy ' ) this.value=''"></div>
							<div class="bg right"><input type="text" class="input input2" value="12:00am" onblur="if(this.value=='') this.value='12:00am'" onFocus="if(this.value =='12:00am' ) this.value=''"></div>
						</div>
					</div>
					<div class="wrapper">
						<p>Passenger(s):</p>
						<div class="bg left"><input type="text" class="input input2" value="# passengers" onblur="if(this.value=='') this.value='# passengers'" onFocus="if(this.value =='# passengers' ) this.value=''"></div>
						<a href="#" class="button2" onClick="document.getElementById('form_1').submit()">go!</a>
					</div>
				</form>
				
				
			</div>
		</article>
		<article class="col2 pad_left1">
		
				<form action="BookServlet" method="post">
				<table>
					<tr>
						<td>Flight</td><td>Departure</td><td>Arrival</td><td>Price</td><td>Book</td>
					</tr>
					<c:foreach items = "${sessionScope.AvailableFlights}" var="flight">
						<tr>
							<td>${flight.getID()}</td>
							<td>${flight.getDepartureTime()}</td>
							<td>${flight.getArrivalTime()}</td>
							<td>${flight.getPrice()}</td>
			    			<td><input type="radio" name="book" value="${flight.getID()}"></td>
						</tr>	
					</c:foreach>
					<input type="submit" name="Ok" value="${flight.getID()}">
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
