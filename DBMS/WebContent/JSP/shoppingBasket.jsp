<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../CSS/shoppingbasket.css">
<title>Shopping Basket</title>
</head>
<body>
<div id="JumpBox" style="width: 800px;height:50px;border: 1px solid #E2E3E5;box-shadow: 10px 10px 30px #888888;
                         background:#FFFFFF;opacity:0.85;">
   <span style="margin-left:20px;margin-top:5%;font-size:20px;">Jump:</span>
    <input type="button" class="sendbutton" value="Search" onclick="window.location.href='search.jsp'">
    <input type="button" class="sendbutton" value="ShoppingCar" onclick="window.location.href='shoppingBasket.jsp'">
    <input type="button" class="sendbutton" value="Help" onclick="window.location.href='help.jsp'">
    <input type="button" class="sendbutton" value="Logout" onclick="Logout()">
</div>
<div style="position:relative;border: 1px solid #E2E3E5;width: 650px;height: 400px;
	        box-shadow: 10px 10px 30px #888888;background:#FFFFFF;margin-left:35%;margin-top:10%;opacity:0.85;">
   <span style="font-size:30px;margin-right:20px">1</span>
   <span style="font-size:30px;margin-right:20px">SQL</span>
   <span style="font-size:30px;margin-right:20px">Xv</span>
   <span style="font-size:30px;margin-right:20px">5763149425</span>
   <span style="font-size:30px;margin-right:20px">45</span>
   <span style="font-size:30px;margin-right:20px">1</span>
   <span style="font-size:30px;margin-right:20px"><input type="text" value="" /></span>
<input id="OrderBtn" type="button" class="rbutton" value="Checkout" onclick="subForm()">
</div>
</body>
</html>