<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../CSS/contact.css">
<title>contact</title>
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
<div style="position:relative;border: 1px solid #E2E3E5;width: 30%;height: 300px;min-width:300px;
	        box-shadow: 10px 10px 30px #888888;background:#FFFFFF;margin-left:35%;margin-top:10%;opacity:0.85;">
   <div style="font-size:50px;margin-left:20px;">OUTBREAK BOOK STORE</div>
   <div style="font-size:30px;margin-top:20px;margin-left:250px;">contact us</div>
   <div style="font-size:20px;margin-top:20px;margin-left:185px;">email: outbreak@seu.edu.cn</div>
   <div style="font-size:20px;margin-top:20px;margin-left:130px;">address: SEU Software Engineering, Nanjing</div>
   <div style="font-size:20px;margin-top:20px;margin-left:235px;">tel: (025)52090110</div>
</div>
</body>
</html>