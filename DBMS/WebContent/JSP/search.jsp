<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../CSS/search.css">
<title>search</title>
	<script>
		function search() {
			var bn = document.getElementById("bookname").value;
			var au = document.getElementById("author").value;
			var is = document.getElementById("isbn").value;
			if (bn.length == 0 && au.length == 0 && is.length == 0) {
				alert("Pleast input some information of the book you want to search!")
			} else {
				document.forms[0].submit();
			}
		}
	</script>
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
<div style="position:relative;border: 1px solid #E2E3E5;width: 30%;height: 250px;min-width:300px;
	        box-shadow: 10px 10px 30px #888888;background:#FFFFFF;margin-left:35%;margin-top:10%;opacity:0.85;">
   <div style="font-size:50px;margin-left:20px;">OUTBREAK BOOK STORE</div>
   <div style="font-size:30px;margin-left:20px;">Please input</div>
   <form action = "<%=path %>/SearchServlet" method="post" style="magin-left:100px">
	<div><input id="bookname" class="form-control" placeholder="bookname" name="BookName"  style="font-size:30px"></div>
	<div><input id="author" class="form-control" placeholder="author" name="Author" style="font-size:30px"><input type="button" id="LoginInput" value="search" onclick="search()" style="font-size:30px;margin-left:100px;"></div>
	<div><input id="isbn" class="form-control" placeholder="ISBN" name="ISBN" style="font-size:30px"></div>

</form>
	
</div>
</body>

</html>