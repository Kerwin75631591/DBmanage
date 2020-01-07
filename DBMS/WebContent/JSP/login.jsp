<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../CSS/login.css">
<title>login</title>
<script></script>
</head>
<body>
   <div id="JumpBox" style="width: 800px;height:50px;border: 1px solid #E2E3E5;box-shadow: 10px 10px 30px #888888;
                         background:#FFFFFF;opacity:0.85;">
   <span style="margin-left:20px;margin-top:5%;font-size:20px;">Jump:</span>
   <input type="button" class="rbutton" value="Search" onclick="subForm()">
   <input type="button" class="rbutton" value="ShoppingCar" onclick="subForm()">
   <input type="button" class="rbutton" value="Help" onclick="subForm()">
   <input type="button" class="rbutton" value="Logout" onclick="subForm()">
   </div>
     <div id="LoginSTitle">OUTBREAK</div>
     <div id="LoginBox">
		<span><input type="email" id="IDInput" class="form-control" style="border:1px solid #999999;" placeholder="e-mail" name="LoginEmail"></span>
		<span><input type="password" id="PasswordInput" class="form-control" style="border:1px solid #999999;" placeholder="Password" name="LoginPassword"></span>
		<input type="button" id="LoginInput" class="logbutton ripple" data-ripple-color="white" value="Login"  onclick="checkL()">			
		<div style="position:relative;top:7%;margin-left:25%"><text id="JumpText" style="color:#808080;width:15%">No ID?Please~</text><a id="RegistText" href="../JSP/Register.jsp">register</a></div>
	 </div>

</body>

</html>