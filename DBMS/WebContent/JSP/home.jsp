<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../CSS/home.css">
<title>home</title>
</head>
<body>
<div id="JumpBox" style="width: 800px;height:50px;border: 1px solid #E2E3E5;box-shadow: 10px 10px 30px #888888;
                         background:#FFFFFF;opacity:0.85;">
   <span style="margin-left:20px;margin-top:5%;font-size:20px;">Jump:</span>
   <input type="button" class="sendbutton" value="Search" onclick="subForm()">
   <input type="button" class="sendbutton" value="ShoppingCar" onclick="subForm()">
   <input type="button" class="sendbutton" value="Help" onclick="subForm()">
   <input type="button" class="sendbutton" value="Logout" onclick="subForm()">
</div>
<div style="position:relative;border: 1px solid #E2E3E5;width: 47%;height: 300px;min-width:300px;
	        box-shadow: 10px 10px 30px #888888;background:#FFFFFF;margin-left:28%;margin-top:10%;opacity:0.85;">
   <div style="font-size:50px;margin-left:20px;">OUTBREAK BOOK STORE</div>
   <div style="font-size:30px;margin-left:250px;">Welcome</div>
   <div style="font-size:20px;margin-left:110px;margin-top:20px;">Have ID?</div>
   <input type="button" class="rbutton" value="Login" onclick="subForm">
   <div style="font-size:20px;margin-left:110px;margin-top:10px;">Register?</div>
   <input type="button" class="rbutton" value="Register" onclick="subForm">
   <div style="font-size:20px;margin-left:110px;margin-top:10px;">Passer-by?</div>
   <input type="button" class="rbutton" value="Shopping" onclick="subForm">
</div>
</body>
</html>