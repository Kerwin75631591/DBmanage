<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../CSS/register.css">
<title>register</title>
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
   <div id="RstTitle">OUTBREAK</div>
   <div id="RegistBox">
      <div>
		 <span><input type="email" id="em" class="form-control" style="border:1px solid #999999;" placeholder="Enter e-mail" name="Email"></span>
      </div>
	  <div><input id="pw" type="password" class="form-control" style="border:1px solid #999999;" placeholder="Password" name="Password"></div>
	  <div><input id="rpw" type="password" class="form-control" style="border:1px solid #999999;" placeholder="Password Again" name="RePassword"></div>
	  <a id="RegistBack" href="Login.jsp">return</a>
      <input id="RegistBtn" type="button" class="sendbutton" value="Register" onclick="subForm()">
   </div>
</body>

</html>