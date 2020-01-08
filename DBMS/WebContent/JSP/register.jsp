<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../CSS/register.css">
<title>register</title>
	<script>
	
		var CHECK;
		/*
		author：马康耀
		功能：提交表单以注册
		参数：void
		返回值：void
		 */
		function subForm() {
			var pw = document.getElementById("pw").value;
			var rpw = document.getElementById("rpw").value;
			var email = document.getElementById("em").value;
			var check = document.getElementById("chk").value;
			var name = document.getElementById("nm").value;
			if (email.length == 0) {
				alert("请输入邮箱");
			} else {
				if (check.length == 0) {
					alert("请输入验证码");
				} else {
					if (CHECK != check) {
						alert("验证码错误！");
					} else {
						if (name.length == 0) {
							alert("请输入名字");
						} else {
							if (pw == rpw) {
								//alert("提交表单");
								document.forms[0].submit();
							} else {
								alert("两次密码输入不一致！");
							}
						}
					}
				}
			}
		}
		/*
		author：马康耀
		功能：生成随机数并将相应信息发送给RegCheckCL.jsp
		参数：void
		返回值：void
		 */
		function postEmail() {
			while (true) {
				CHECK = Math.floor(Math.random() * 1000000);
				if (CHECK > 99999)
					break;
			}
			var email = document.getElementById("em").value;
			//document.getElementById("show_check").innerHTML=CHECK;
			document.getElementById("email_button").disabled = true;
			var e = encrypt();
			//alert(e);
			window.open("./RegCheckCL.jsp?Email=" + email + "&check=" + e);
		}

		/*
		author：马康耀
		功能：对验证码进行加密
		参数：void
		返回值：String
		 */
		function encrypt() {
			//alert(typeof CHECK);
			var enc = CHECK;
			return enc;
		}
	</script>
</head>
<body>
<div id="JumpBox" style="width: 800px;height:50px;border: 1px solid #E2E3E5;box-shadow: 10px 10px 30px #888888;
                         background:#FFFFFF;opacity:0.85;">
   <span style="margin-left:20px;margin-top:5%;font-size:20px;">Jump:</span>
   <input type="button" class="rbutton" value="Search" onclick="window.location.href='search.jsp'">
   <input type="button" class="rbutton" value="ShoppingCar" onclick="window.location.href=''">
   <input type="button" class="rbutton" value="Help" onclick="window.location.href='help.jsp'">
   <input type="button" class="rbutton" value="Logout" onclick="Logout()">
</div>
   <div id="RstTitle">OUTBREAK</div>
   <div id="RegistBox">
      <div>
		 <span><input type="email" id="em" class="form-control" style="border:1px solid #999999;" placeholder="Enter e-mail" name="Email"></span>
      </div>
	  <div><input id="pw" type="password" class="form-control" style="border:1px solid #999999;" placeholder="Password" name="Password"></div>
	  <div><input id="rpw" type="password" class="form-control" style="border:1px solid #999999;" placeholder="Password Again" name="RePassword"></div>
	  <a id="RegistBack" href="login.jsp">return</a>
      <input id="RegistBtn" type="button" class="sendbutton" value="Register" onclick="subForm()">
   </div>
</body>

</html>