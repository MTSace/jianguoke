<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>后台登录</title>
<link rel="icon" type="image/png" href="images/favicon.png" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="./back/css/pintuer.css" type="text/css">
<link rel="stylesheet" href="./back/css/admin.css" type="text/css">
<script type="text/javascript" src="./back/js/jquery.js"></script>
<script type="text/javascript" src="./back/js/pintuer.js"></script>

</head>
<body onload="createCode();">
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height:150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<form action="adLogin.action" method="post">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>后台管理中心</h1>
						</div>
						<div class="panel-body"
							style="padding:30px; padding-bottom:10px; padding-top:10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big"
										name="admin.admin_phone" placeholder="登录账号"
										data-validate="required:请填写账号" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big"
										name="admin.admin_password" placeholder="登录密码"
										data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field">
									<input type="text" class="input input-big" name="code"
										id="checkNum" placeholder="填写右侧的验证码"
										data-validate="required:请填写右侧的验证码" />
									<div id="checkCode" onclick="createCode()" class="passcode"
										style="cursor:pointer;height:43px;width:100px;"></div>
								</div>
							</div>
						</div>
						<div style="padding:30px;">
							<input type="submit"
								class="button button-block bg-main text-big input-big"
								value="登录" onclick="return validate()">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	var code = ""; //在全局 定义验证码
	function createCode() {
		code = "";
		var codeLength = 4;//验证码的长度
		var checkCode = document.getElementById("checkCode");
		checkCode.value = "";
		var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C',
				'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'q', 'w', 'e',
				'r', 't', 'y', 'u', 'i', 'o', 'p', 'l', 'k', 'j', 'h', 'g',
				'f', 'd', 's', 'a', 'z', 'x', 'c', 'v', 'b', 'n', 'm');

		for (var i = 0; i < codeLength; i++) {
			var charIndex = Math.floor(Math.random() * 60);
			code += selectChar[charIndex];
		}
		if (code.length != codeLength) {
			createCode();
		}
		document.getElementById("checkCode").innerHTML = code;
	}

	function validate() {
		var inputCode = document.getElementById("checkNum").value.toLowerCase();
		var inputCode2 = document.getElementById("checkNum").value
				.toUpperCase();
		var inputCode3 = document.getElementById("checkNum").value;
		if ((inputCode == code.toLowerCase() || inputCode2 == code
				.toUpperCase())
				|| (inputCode3 == code)) {
			return true;
		} else {
			alert("验证码输入错误！");
			createCode();
			return false;
		}
	}
</script>
</html>
