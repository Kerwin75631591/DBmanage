<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
OUTBREAK BOOK STORE
Please input
<form action = "/SearchServlet" method="post">
	<span><input id="bookname" class="form-control" name="BookName"></span>
	<span><input id="author" class="form-control" name="Author"></span>
	<span><input id="isbn" class="form-control" name="ISBN"></span>
	<input type="button" id="LoginInput" value="search" onclick="search()">
</form>
</body>
</html>