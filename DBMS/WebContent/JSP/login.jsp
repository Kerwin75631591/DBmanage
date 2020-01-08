<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../CSS/login.css"/>
<title>login</title>
	<script>
		function checkL() {
			var em = document.getElementById("IDInput").value;
			var pw = document.getElementById("PasswordInput").value;
			if(em.length == 0) {
				alert("Please input ID!");
			} else if (pw.length == 0) {
				alert("Please input Password!");
			} else {
				document.forms[0].submit();
			}
		}	
	</script>
</head>
<body>
	<form action="<%=path %>/LoginServlet" method="post">
   	<div id="JumpBox" style="width: 800px;height:50px;border: 1px solid #E2E3E5;box-shadow: 10px 10px 30px #888888;
                         background:#FFFFFF;opacity:0.85;">
   	<span style="margin-left:20px;margin-top:5%;font-size:20px;">Jump:</span>
    <input type="button" class="rbutton" value="Search" onclick="window.location.href='search.jsp'">
    <input type="button" class="rbutton" value="ShoppingCar" onclick="window.location.href='shoppingBasket.jsp'">
    <input type="button" class="rbutton" value="Help" onclick="window.location.href='help.jsp'">
    <input type="button" class="rbutton" value="Logout" onclick="Logout()">
   	</div>
     <div id="LoginSTitle">OUTBREAK</div>
     <div id="LoginBox">
		<span><input type="email" id="IDInput" class="form-control" style="border:1px solid #999999;" placeholder="e-mail" name="LoginEmail"></span>
		<span><input type="password" id="PasswordInput" class="form-control" style="border:1px solid #999999;" placeholder="Password" name="LoginPassword"></span>
		<input type="button" id="LoginInput" class="logbutton ripple" data-ripple-color="white" value="Login"  onclick="checkL()">			
		<div style="position:relative;top:7%;margin-left:25%">No ID?Please~<a id="RegistText" href="../JSP/register.jsp">register</a></div>
	 </div>
	</form>
</body>

</html>